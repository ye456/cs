/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_practicals.Practical1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rashmi Kabra
 */
public class Server {
    private static Socket socket;
    
    public static void main(String[] args) {
        
        try{
            
            int port =25000;
            ServerSocket serverSocket= new ServerSocket(port);
            System.out.println("Server sarted and is listening to the port");
            
            while(true)
            {
                socket=serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number= br.readLine();
                System.out.println("Message recieved from client is"+ number);
                
                String returnMessage;
                try{
                    int numberInIntFormat = Integer.parseInt(number);
                    int factorial=1;
                    for(int i=2;i<=numberInIntFormat;i++)
                    {
                        factorial*=i;
                        
                    }
                     
                    returnMessage = String.valueOf(factorial) + "\n";
                }
                catch(NumberFormatException e)
                {
                    returnMessage="Please send a proper number\n";
                }
                
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is "+returnMessage);
                bw.flush();
                
                
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        finally{
            try{
                socket.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
    }
    
}
