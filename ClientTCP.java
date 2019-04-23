
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_practicals.Practical1;

/**
 *
 * @author Rashmi Kabra
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    private static Socket socket;
    
    public static void main(String[] args) {
        
        try{
            
            String host = "localhost";
            int port =25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address,port);
            
            //send message to the server
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw =new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            System.out.println("Enter number:");
            Scanner sc = new Scanner(System.in);
            String  number = sc.next();
            
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server :"+sendMessage);
            
            
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message recieved from the server:" + message);
            
        }
        catch( Exception e)
        {
            System.out.println(e);
        }
        
        finally{
            //closing socket
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