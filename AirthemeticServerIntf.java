/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rashmi Kabra
 */
public interface AirthemeticServerIntf extends Remote {
    
     double add(double d1,double d2) throws RemoteException;
     double sub(double d1,double d2) throws RemoteException;
     double mul(double d1,double d2) throws RemoteException;
     double div(double d1,double d2) throws RemoteException;  

}
