package sdf;

import java.net.Socket;

public class Client {

    //the whole point of this project is to be able to have multiple clients interface with the server
    //the server will have multiple threads handled by runnable
    //the threads will then act as a calculator, acting on reverse polish

    public static void main (String[] args)throws Exception{
        int port = 3000;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        //problem: client was closed before you could do anything. keep it in a while loop
        //in chuk's code, he used cookiesession which kept it in a while loop
        System.out.println("Waiting for server");
        Socket socket = new Socket("localhost",port);
        CalculatorClient calc = new CalculatorClient(socket);
        calc.start();

    }
    
}
