/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
import java.rmi.Naming;

/**
 *
 * @author Rashmi Kabra
 */
public class AirthemeticClient {
    
    public static void main(String[] args) {  
      try {
          
         String airthemeticServerURL= "rmi://" + args[0] +"/AirthemeticServer";
         AirthemeticServerIntf airthemeticServerIntf=(AirthemeticServerIntf)Naming.lookup(airthemeticServerURL);
         System.out.println("The first number is:" +args[1]);
         double d1=Double.valueOf(args[1]).doubleValue();
         System.out.println("The first number is:" +args[2]);
         double d2=Double.valueOf(args[2]).doubleValue();
         System.out.println("Addition:"+ airthemeticServerIntf.add(d1, d2));
         System.out.println("Subtraction:"+ airthemeticServerIntf.sub(d1, d2));
         System.out.println("Multiplication:"+ airthemeticServerIntf.mul(d1, d2));
         System.out.println("Division:"+ airthemeticServerIntf.div(d1, d2));
      } 
      catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   }
}
