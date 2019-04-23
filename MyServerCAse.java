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
public class MyServer{  
    public static void main(String args[]){  
        try{  
            //Adder stub=new AdderRemote();  
            //Naming.rebind("rmi://localhost:5000/sonoo",stub); 
		 CaseImpl obj = new CaseImpl();
		 Naming.rebind("CASE",obj);
		 System.out.println("Server Started");
        }
        catch(Exception e){
            System.out.println(e);
        }  
    }  
}  
