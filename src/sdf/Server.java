package sdf;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Server {

    public static final Integer DEFAULT_PORT = 3000;
    
    public static void main(String args[])throws Exception{
        int port = DEFAULT_PORT;
        ServerSocket server = new ServerSocket(port);
        ExecutorService thrpool = Executors.newFixedThreadPool(3); //3 additional workers

        while (true){
            Socket client = server.accept();
            System.out.println("New client connection.");
            Runnable handler = new ClientHandler();
            thrpool.submit(handler);
        }
    }
    
}
