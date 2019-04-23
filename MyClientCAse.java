/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rashmi Kabra
 */
import java.rmi.*;
import java.util.Scanner;  
public class MyClient{  
    public static void main(String args[]){  
        try{  
            CaseInterface obj=(CaseInterface)Naming.lookup("CASE");
            System.out.println("Enter string:");
            Scanner input = new Scanner(System.in);
            String sentence = input.next();
            System.out.println("Original string is:"+sentence);  
            System.out.println("After implementation:"+obj.upper_to_lower(sentence));  
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }  
}  
