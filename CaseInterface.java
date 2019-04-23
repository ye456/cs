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
public interface CaseInterface extends Remote{
    
    public String upper_to_lower(String sentence)throws RemoteException; 
    
}
