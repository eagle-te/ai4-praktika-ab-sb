package rn.praktikum1.server;

import rn.praktikum1.client.Client;

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
public class Dispatcher {
    ExecutorService threadPool;
    ServerSocket serverSocket;
    int port = 55555;

    public Dispatcher() {

        try {
            serverSocket = new ServerSocket(port);
            threadPool = Executors.newCachedThreadPool();

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Client.main(null);
//                }
//            }).start();

            looper();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
    public void looper() {
        while (true){
            try {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(Server.create(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
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
        new Dispatcher();
    }




}
