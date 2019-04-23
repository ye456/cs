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
public class AirthemeticServer {
    public static void main(String args[])
    {
        try{
            AirthemeticServerImpl airthemeticServerImpl = new AirthemeticServerImpl();
            Naming.rebind("AirthemeticServer", airthemeticServerImpl);
            System.out.println("Server Started");

        }
        
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
            
            
            
}
