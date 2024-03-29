package rn.praktikum3.file_copy_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Sven
 * Date: 12.05.13
 * Time: 15:26
 */
public class ACKReceiver extends Thread {
    private DatagramSocket udpReceiver;
    private DatagramPacket datagramPacket;
    private byte[] dataBuffer;
    private int port;
    private ACKListener callbackListner;
    private ExecutorService threadPool;
    public ACKReceiver(DatagramSocket socket, int udp_packet_size,ACKListener listener) {
        dataBuffer = new byte[8];
        this.port = port;
        callbackListner = listener;
        datagramPacket = new DatagramPacket(dataBuffer,dataBuffer.length);
        udpReceiver = socket;
        threadPool = Executors.newCachedThreadPool();
    }
    public void closeSocket() {
        udpReceiver.close();
    }
    public void run() {
        try {
            FCpacket paket = null;

            do {
                udpReceiver.receive(datagramPacket);
                paket = new FCpacket(datagramPacket.getData(),datagramPacket.getLength());
            }while (paket != null && paket.getSeqNum() != 0);
            callbackListner.ACK_0_received();

        } catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!udpReceiver.isClosed()) {
            try {
                udpReceiver.receive(datagramPacket);
                FCpacket paket = new FCpacket(datagramPacket.getData(), datagramPacket.getLength());
                paket.setTimestamp(System.nanoTime());
                threadPool.execute(new ACKRunnable(paket));

            } catch (IOException e) {
            }
        }
        threadPool.shutdown();
    }

    public interface ACKListener{
        void receivedACK(FCpacket fCpacket);
        void ACK_0_received();
    }

    public class ACKRunnable implements Runnable {
        final FCpacket packet_reference;

        public ACKRunnable(FCpacket packet_reference) {
            this.packet_reference = packet_reference;
        }

        @Override
        public void run() {
            callbackListner.receivedACK(packet_reference);

        }
    }

}
