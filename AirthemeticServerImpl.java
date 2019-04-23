/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Rashmi Kabra
 */
public class AirthemeticServerImpl extends UnicastRemoteObject implements AirthemeticServerIntf {
    
    public AirthemeticServerImpl() throws RemoteException{
    }
    
    public double add(double d1, double d2) throws RemoteException{
     
         return d1+d2;
     }
     
     public double sub(double d1, double d2) throws RemoteException{
     
         return d1-d2;
     }
     
     public double mul(double d1, double d2) throws RemoteException{
     
         return d1*d2;
     }
     
     public double div(double d1, double d2) throws RemoteException{
     
     	if(d2!=0)
        	return d1/d2;
        else
        	return 0.0;
     }
    
}
