package rn.praktikum2.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abg667
 * Date: 18.04.13
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class ChatServer implements Runnable {
    private static Map<String, ChatServer> userMap = new HashMap<String, ChatServer>();
    private Socket clientSocket;
    private DataOutputStream outToServer; // Ausgabestream zum Server
    private BufferedReader inFromServer;  // Eingabestream vom Server
    private String username;
    private static String serverHostname = "lab26";

    private ChatServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ChatServer create(Socket clientSocket) {
        return new ChatServer(clientSocket);
    }

    @Override
    public void run() {
        String response = "";
        String[] params;
        ChatCommands command;

        while (!clientSocket.isClosed() && !Thread.interrupted()) {

            response = readFromClient();
            params = response.trim().split(" ");

            try {
                command = ChatCommands.valueOf(params[0]);
                switch (command) {
                    case NEW:
                        final String tempUsername;
                        if (username == null) {
                            tempUsername = params[1];
                            synchronized (userMap) {
                                if (userMap.get(tempUsername) != null) {
                                    writeToClient(ChatCommands.ERROR.name() + " nenenenenennen, den Namen gibt`s schon");

                                } else {
                                    username = tempUsername;
                                    userMap.put(username, this);
                                    writeToClient(ChatCommands.OK.name());
                                }
                            }
                        } else
                            writeToClient(ChatCommands.ERROR.name() + " schon angmeldet DUDUDU, als: " + username);

                        break;
                    case INFO:
                        StringBuilder sb = new StringBuilder(ChatCommands.LIST.name()).append(" ").append(userMap.size()).append(" ");
                        Map<String, ChatServer> userMapCopy = new HashMap<String, ChatServer>(userMap);
                        String tmpfix;
                        for (Map.Entry<String, ChatServer> entry : userMapCopy.entrySet()) {
                            tmpfix = entry.getValue().clientSocket.getInetAddress().getHostAddress();
                            if(tmpfix.equals("127.0.0.1")|tmpfix.equals("localhost"))
                                sb.append(serverHostname).append(" ").append(entry.getKey()).append(" ");
                            else
                                sb.append(entry.getValue().clientSocket.getInetAddress().getHostName()).append(" ").append(entry.getKey()).append(" ");

                        }

                        userMapCopy = null;
                        writeToClient(sb.toString());

                        break;
                    case BYE:
                        if (username != null)
                            if (userMap.get(username) == null) writeToClient(ChatCommands.ERROR.name());
                            else {
                                userMap.remove(username);
                                writeToClient(ChatCommands.BYE.name());
                                clientSocket.close();
                            }
                        else
                            writeToClient(ChatCommands.ERROR.name());
                        break;

                    case SEND:
                        if (username != null) {

                            StringBuilder builder = new StringBuilder(username).append(": ");

                            for (int i = 1; i < params.length; i++) {
                                builder.append(params[i]).append(" ");
                            }

                            Map<String, ChatServer> chatServerMapCopy = new HashMap<String, ChatServer>(userMap);
                            chatServerMapCopy.remove(username);

                            for (ChatServer chatServer : chatServerMapCopy.values()) {
                                chatServer.writeToClient(builder.toString());
                            }


                        } else {
                            writeToClient(ChatCommands.ERROR.name() + " noch nicht angemeldet");
                        }


                        break;

                    default:
                        writeToClient(ChatCommands.ERROR.name() + " Befehl befindet sich nicht im Rahmen des Protokolls");
                        break;
                }

            } catch (IllegalArgumentException e) {
                writeToClient(ChatCommands.ERROR.name() + " Ihr Chat-client bewegt sich außerhalb des Protokolls");
                try {
                    clientSocket.close();
                } catch (IOException e1) {
//                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }

        }
        System.out.println("Serverinstanz :" +clientSocket + " wird beendet.");
        synchronized (userMap) {userMap.remove(username);}
        ChatDispatcher.getInstance().clientLeft();
    }


    private void writeToClient(String request) {
    /* Sende den request-String als eine Zeile (mit newline) zum Server */
        try {
            outToServer.writeBytes(request + "\r\n");
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        System.out.println(((username == null) ? ("unbekannt"): (username)) + ": sent from server: " + request);
    }

    private String readFromClient() {
    /* Liefere die Antwort (reply) vom Server */
        String reply = "";

        try {
            StringBuilder input = new StringBuilder("");
            char[] chars = new char[1];
            inFromServer.read(chars);
            int counter = 0;
            while (chars[0] != '\n' && counter < 25) {
                input.append(chars[0]);
                inFromServer.read(chars);
                counter++;
            }
            reply = input.toString();
//            reply = inFromServer.readLine();
        } catch (IOException e) {
            System.err.println("Connection aborted by server!");
            try {
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        System.out.println(((username == null) ? ("unbekannt"): (username)) +  ": got from Client: " + reply);
        return reply;
    }
}
