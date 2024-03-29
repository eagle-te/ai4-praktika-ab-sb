package rn.praktikum2.server;

import rn.praktikum1.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 27.03.13
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class ChatDispatcher {
    ExecutorService threadPool;
    ServerSocket serverSocket;
    int port = 50000;
    int max_connections = 10;
    int current_connections = 0;
    private static ChatDispatcher instance;
    Thread dispatcherThread;
    public ChatDispatcher() {
        instance = this;
        dispatcherThread = Thread.currentThread();
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(7000);
            threadPool = Executors.newCachedThreadPool();

            looper();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static ChatDispatcher getInstance() {
        return instance;
    }

    public void looper() {

        while (true){
            try {
                Socket clientSocket;
                if (current_connections < max_connections) {
                    clientSocket= serverSocket.accept();
                    threadPool.execute(ChatServer.create(clientSocket));
                    current_connections++;
                    System.out.println(current_connections);
                }else{
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {

                    }
                }
            } catch (IOException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public synchronized void clientLeft() {
        if (current_connections < max_connections) {
            current_connections--;
            System.out.println(current_connections);
        }
        else{
            current_connections--;
            dispatcherThread.interrupt();
        }
    }
    public String getInput() {
        String s = "";
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
             s = bufferRead.readLine();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return s;
    }
    public static void main(String[] args) {
        new ChatDispatcher();
    }




}
