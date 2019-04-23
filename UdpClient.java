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
import java.net.*;
import java.util.Scanner;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
      byte[] sendData1 = new byte[1024];
      byte[] sendData2 = new byte[1024];
      byte[] receiveData1 = new byte[1024];
      byte[] receiveData2 = new byte[1024];
      byte[] receiveData3 = new byte[1024];
      byte[] receiveData4 = new byte[1024];
      
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      
      System.out.println("Enter first number:");  
      Scanner sc = new Scanner(System.in);
      String  sentence1 = sc.next();
              
      sendData1 = sentence1.getBytes();
      DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, IPAddress, 9876);
      clientSocket.send(sendPacket1);
      
      System.out.println("first number sent");
      
      System.out.println("Enter second number:");  
      String  sentence2 = sc.next();
      
      sendData2 = sentence2.getBytes();
      DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, 9876);
      clientSocket.send(sendPacket2);
      
      System.out.println("second number sent");
      
      DatagramPacket receivePacket1 = new DatagramPacket(receiveData1, receiveData1.length);
      clientSocket.receive(receivePacket1);
      String addition = new String(receivePacket1.getData());
      
      DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
      clientSocket.receive(receivePacket2);
      String subtraction = new String(receivePacket2.getData());
      
      DatagramPacket receivePacket3 = new DatagramPacket(receiveData3, receiveData3.length);
      clientSocket.receive(receivePacket3);
      String multiplication = new String(receivePacket3.getData());
      
      DatagramPacket receivePacket4 = new DatagramPacket(receiveData4, receiveData4.length);
      clientSocket.receive(receivePacket4);
      String division = new String(receivePacket4.getData());
      
      
      System.out.println("FROM SERVER:");
      System.out.println("Addition:"+addition);
      System.out.println("Subtraction:"+subtraction);
      System.out.println("Multiplication:"+multiplication);
      System.out.println("Division:"+division);
      
      clientSocket.close();
   }
}