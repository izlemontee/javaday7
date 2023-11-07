package sdf;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Server {
    //the whole point of this project is to be able to have multiple clients interface with the server
    //the server will have multiple threads handled by runnable
    //the threads will then act as a calculator, acting on reverse polish

    public static final Integer DEFAULT_PORT = 3000;
    
    public static void main(String args[])throws Exception{
        int port = DEFAULT_PORT;
        System.out.println("Waiting for client");
        ServerSocket server = new ServerSocket(port);
        //executorservice is an interface
        ExecutorService thrpool = Executors.newFixedThreadPool(3); //3 additional workers


        while (true){
 
            Socket client = server.accept();
            System.out.println("New client connection.");
            //Runnable handler = new ServerSession(client);
            ServerSession handler = new ServerSession(client);
            //submits runnable task
            //thrpool.submit(handler);
            handler.start();
        }
    }
    
}
