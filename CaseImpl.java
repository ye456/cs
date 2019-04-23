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
public class CaseImpl extends UnicastRemoteObject implements CaseInterface{  

    protected CaseImpl()throws RemoteException{  
    super();  
    }  
    public String upper_to_lower(String sentence){return sentence.toLowerCase();}  
} 
