package rn.praktikum3.file_copy_server;

/* FileCopyServer.java
 Version 1.0
 Praktikum Rechnernetze HAW Hamburg
 Autor: M. H�bner
 */

import rn.praktikum3.file_copy_client.FCpacket;

import java.io.*;

import java.net.*;

import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;

public class FileCopyServer {
    // -------- Constants
    public final static boolean TEST_OUTPUT_MODE = true;
    public final static int SERVER_PORT = 23000;
    public final static int UDP_PACKET_SIZE = 1024;
    public final static int CONNECTION_TIMEOUT = 3000; // milliseconds

    // -------- Parameters (will be adjusted with values in the first packet)
    public int windowSize = 128;
    public String destPath = "";
    public long errorRate = 10000;
    // Each nth (n=ERROR_RATE) packet will be corrupted

    // -------- Socket structures
    private InetAddress clientAdress = null; // connection state
    private int clientPort = -1; // connection state
    private DatagramSocket serverSocket;
    private byte[] receiveData;
    private LinkedList<FCpacket> recBuf;

    // -------- Streams
    private FileOutputStream outToFile;

    // Protocol variables
    public long rcvbase;

    // Test error production
    private long lastCorruptedSeqNum;

    // Constructor
    public FileCopyServer() {
        receiveData = new byte[UDP_PACKET_SIZE];
        recBuf = new LinkedList<FCpacket>();
    }

    public void runFileCopyServer() throws IOException {
        InetAddress receivedIPAddress;
        int receivedPort;
        DatagramPacket udpReceivePacket;
        FCpacket fcReceivePacket;
        boolean connectionEstablished = false;

        serverSocket = new DatagramSocket(SERVER_PORT);
        System.out.println("Waiting for connection using port " + SERVER_PORT);

        while (true) {
            try {
                udpReceivePacket = new DatagramPacket(receiveData,
                        UDP_PACKET_SIZE);
                // Wait for data packet
                serverSocket.receive(udpReceivePacket);
                receivedIPAddress = udpReceivePacket.getAddress();
//                System.out.println("udpReceivePacketAddress: " +receivedIPAddress);
                receivedPort = udpReceivePacket.getPort();
//                System.out.println("udpReceivedPacketProt: " +receivedPort);
//                receivedPort = 23001;
//                System.out.println("#-> UDP udpReceivePacket Port: "+udpReceivePacket.getPort());

                if (connectionEstablished == false) {
                    // Establish new connection
                    clientAdress = receivedIPAddress;
                    clientPort = receivedPort;
                    serverSocket.setSoTimeout(CONNECTION_TIMEOUT);
                    connectionEstablished = true;
                    rcvbase = 0;
                    lastCorruptedSeqNum = 1;
                    System.out.println("New connection established with "
                            + clientAdress.toString());
                }

                // Test if sender is the right one
                if ((clientAdress.equals(receivedIPAddress))
                        && (clientPort == receivedPort)) {
                    // extract sequence number and data
                    fcReceivePacket = new FCpacket(udpReceivePacket.getData(),
                            udpReceivePacket.getLength());

                    long seqNum = fcReceivePacket.getSeqNum();

                    // Test packet checksum
                    if (((seqNum % errorRate) == 0)
                            && (seqNum > lastCorruptedSeqNum)) {
                        lastCorruptedSeqNum = seqNum;
                        testOut("---- Packet " + seqNum
                                + " corrupted! ---------");
                    } else {
                        testOut("Server: Packet "
                                + seqNum
                                + " correctly received! Expected for order delivery (rcvbase): "
                                + rcvbase);

                        // Handle first packet --> read and set parameters
                        if (seqNum == 0) {
                            if (setParameters(fcReceivePacket)) {
                                // open destination file
                                outToFile = new FileOutputStream(destPath);
                            } else {
                                // Wrong parameter packet --> End!
                                break;
                            }
                        }

                        // Eval seq num
                        if ((seqNum >= (rcvbase - windowSize))
                                && (seqNum < (rcvbase + windowSize))) {
                            // ------ send ACK packet
                            sendAck(fcReceivePacket);

                            // Test whether packet is already delivered
                            if (seqNum >= rcvbase) { // to deliver!
                                insertPacketintoBuffer(fcReceivePacket);
                                deliverBufferPackets(); // adjust rcvbase
                            }
                        }
                    }
                }
            } catch (java.net.SocketTimeoutException e) {
                // Copy job successfully finished
                outToFile.close();
                connectionEstablished = false;
                System.out.println("Connection successfully closed, file "
                        + destPath + " saved!");
                System.out.println("FileSize: "+ Files.size(new File(destPath).toPath()));
                // reset connection timeout
                serverSocket.setSoTimeout(0);
                System.out.println("Waiting for connection using port  "
                        + SERVER_PORT);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("XXXXXXXXXXXXXXX File Error: " + destPath);
                break;
            }
        }

        // --------- End ------------------------
        serverSocket.close();
    }

    public void sendAck(FCpacket fcRcvPacket) {        /* Create and send UDP packet with ACK seqNum */
        DatagramPacket udpAckPacket = new DatagramPacket(
                fcRcvPacket.getSeqNumBytes(), 8, clientAdress, clientPort);

        try {
            serverSocket.send(udpAckPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unexspected Socket Error! " + e.toString());
            System.exit(-1);
        }

        testOut("ACK-Packet " + fcRcvPacket.getSeqNum() + " sent! clientport: " + clientPort);
    }

    public void insertPacketintoBuffer(FCpacket insertPacket) {
		/* Insert the packet into the receive buffer at the right position */
        if (!recBuf.contains(insertPacket)) { // no duplicates!
            recBuf.add(insertPacket);
            // sort in ascending order using the seq num
            Collections.sort(recBuf);
        }
    }

    public void deliverBufferPackets() throws IOException {
		/*
		 * Deliver all packets which are in order, starting with rcvbase, remove
		 * all delivered packets from the recBuffer and adjust the rcvbase
		 * appropriately
		 */
        while (!recBuf.isEmpty() && recBuf.getFirst().getSeqNum() == rcvbase) {
            writePacket(recBuf.getFirst());
            recBuf.removeFirst();
            rcvbase++;
        }
    }

    public void writePacket(FCpacket deliverPacket) throws IOException {
		/* Deliver single FCpacket: append packet data to outfile */

        // Packet 0 is control packet --> don't write to file!
        if (deliverPacket.getSeqNum() > 0) {
            outToFile.write(deliverPacket.getData(), 0, deliverPacket.getLen());

            testOut("Packet " + deliverPacket.getSeqNum()
                    + " delivered! Block of length " + deliverPacket.getLen()
                    + " appended to File " + destPath);
        }
    }

    public boolean setParameters(FCpacket controlPacket) {
		/* Evaluate packet with seqNum 0 */
        String parameters = "";
        String[] parameterArray;

        try {
            parameters = new String(controlPacket.getData(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Extract parameters
        parameterArray = parameters.split(";");

        if (parameterArray.length == 3) {
            // Adjust parameters
            destPath = parameterArray[0];

            try {
                windowSize = Integer.parseInt(parameterArray[1]);
                errorRate = Long.parseLong(parameterArray[2]);
            } catch (NumberFormatException e) {
                System.err
                        .println("Control Packet (seqNum 0): syntax error! No numeric parameter found: "
                                + parameters);
                // Parameter wrong
                return false;
            }

            System.out.println("Server-Parameters set: " + destPath
                    + " - WindowSize: " + windowSize + " - ErrorRate: "
                    + errorRate);
            // Parameter OK!
            return true;
        } else {
            System.err
                    .println("Control Packet (seqNum 0) has wrong number of parameters: "
                            + parameters);
            // Parameter wrong
            return false;
        }
    }

    public void testOut(String out) {
        if (TEST_OUTPUT_MODE) {
            System.err.println("Server: " + out);
        }
    }

    public static void main(String[] argv) throws Exception {
        FileCopyServer myServer = new FileCopyServer();
        myServer.runFileCopyServer();
    }
}
