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
import java.io.*;
import java.math.BigInteger;
import java.net.*;

class UDPServer
{
   public static void main(String args[]) throws Exception
      {
            System.out.println("Server started");
                  
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData1 = new byte[1024];
            byte[] receiveData2 = new byte[1024];
            byte[] sendData1 = new byte[1024];
            byte[] sendData2 = new byte[1024];
            byte[] sendData3 = new byte[1024];
            byte[] sendData4 = new byte[1024];
            
            while(true)
               {
                  
                  DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
                  serverSocket.receive(receivePacket1);
                  String sentence1 = new String(receivePacket1.getData());
                  System.out.println("first number:"+sentence1);
                  
                  DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
                  serverSocket.receive(receivePacket2);
                  String sentence2 = new String(receivePacket2.getData());
                  System.out.println("second number:"+sentence2);
                  
                  
                  
                  String returnMessage1="",returnMessage2="",returnMessage3="",returnMessage4="";
                  try{
                    int m = Integer.parseInt(sentence1.trim());
                    int n = Integer.parseInt(sentence2.trim());
                    int add = m+n;
                    int sub = m-n;
                    int mul = m*n;
                    int div=0;
                    if(n!=0)
                        div = m/n;
                    returnMessage1=String.valueOf(add);
                    returnMessage2=String.valueOf(sub);
                    returnMessage3=String.valueOf(mul);
                    returnMessage4=String.valueOf(div);
                    
                 }
                 catch(NumberFormatException e)
                 {
                    returnMessage1="Please send a proper number\n";
                 }
                
                  InetAddress IPAddress = receivePacket1.getAddress();
                  int port = receivePacket1.getPort();
                  
                  sendData1 = returnMessage1.getBytes();
                  DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, port);
                  serverSocket.send(sendPacket1);
                  
                  sendData2 = returnMessage2.getBytes();
                  DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, port);
                  serverSocket.send(sendPacket2);
                  
                  sendData3 = returnMessage3.getBytes();
                  DatagramPacket sendPacket3 = new DatagramPacket(sendData3, sendData3.length, IPAddress, port);
                  serverSocket.send(sendPacket3);
                  
                  sendData4 = returnMessage4.getBytes();
                  DatagramPacket sendPacket4 = new DatagramPacket(sendData4, sendData4.length, IPAddress, port);
                  serverSocket.send(sendPacket4);
               }
      }
}

