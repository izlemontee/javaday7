package sdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

public class ServerSession implements Runnable{

    private final Socket socket;

    public ServerSession (Socket client){
        this.socket = client;
    }

    @Override
    public void run(){
        System.out.printf("Starting thread...\n");
        try{
            start();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void start() throws Exception{
        InputStream is = socket.getInputStream(); //takes the input from the client
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr); //use this to process strings
        OutputStream os = socket.getOutputStream(); //sends the output back to the client
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);

        Calculator calc = new Calculator();

        boolean stop = false;

        while(!stop){
            String line = br.readLine();
            line = line.trim(); //removes whitespace
            if(line.length() <=0){
                continue;
            }
            String[] tokens = line.split(" ");//so that now the programme can read the arg
            System.out.println(tokens[0]); //this line works
            //take the first word in tokens as the command
            switch(tokens[0]){
                case Constants.END:
                bw.write("end");
                bw.flush();
                stop = true;
                break;

                default:
                float result = calc.stacks(tokens);
                bw.write("end\n");
                bw.flush();


            }
        }

        is.close();
        os.close();
        socket.close();
    }
    
}
