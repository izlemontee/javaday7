package sdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class CalculatorClient {
    private final Socket socket;

    public CalculatorClient(Socket socket){
        this.socket = socket;
    }

    public void start() throws Exception{
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter ows = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(ows);

        boolean stop = false;
        Console cons = System.console();
        while(!stop){
            String line = cons.readLine(">> ");
            line = line.trim()+"\n";

            bw.write(line);
            bw.flush();

            while(true){
                String result = br.readLine();
                System.out.printf("Result: %s\n",result);
                result = result.trim();
                if("end".equals(result)){
                    stop = true;
                    //break;
                }
            }
        }
    }
    
}
