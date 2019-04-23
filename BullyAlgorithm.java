/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_practicals.TokenRing;

import java.util.Scanner;

/**
 *
 * @author Rashmi Kabra
 */

class Processes { 

    int processId; 
    boolean active; 

    public Processes(int processId) { 
        this.processId = processId; 
        active = true; 
    } 
} 

public class BullyAlgorithm {
    
    Scanner consoleInput =new Scanner(System.in); 
    Processes[] process; 
    int NosOfProcess; 
    int process_conducting_election;
    
    public void getOutput() { 
        
        for (int i = 0; i < NosOfProcess; i++) { 
          int j=i+1;
          System.out.println("Process"+j+" id and status:"+process[i].processId+" "+process[i].active);
        } 
                
      } 
    
    public void getInput() { 
        System.out.println("Enter number of process in bully algorithm: "); 
        NosOfProcess = consoleInput.nextInt(); 
        process = new Processes[NosOfProcess]; 
        
        int i;
        
        for (i = 0; i < NosOfProcess; i++) { 
            process[i] = new Processes(i+1);
            if(i==NosOfProcess-1)
            {
                process[i].active=false;
            }
        }
        System.out.println("Processes\n:");
        getOutput();
        System.out.println("Coordinator with process id "+i+" got failed");
      } 
    public int getMax(){ 
        int max = 0, indexOfMax = 0; 
        for(int i = 0; i < NosOfProcess; i++){ 
            if(process[i].active && max <= process[i].processId ) { 
                max = process[i].processId; 
                indexOfMax = i+1; 
            } 
        } 
        return indexOfMax; 
    } 
    
    public void conductElection()
    {
        System.out.println("Enter the process noticing that coordinator is failed:");
        process_conducting_election = consoleInput.nextInt();
        int i;
        i=process_conducting_election+1;
        while(true)
        {
            for(i=process_conducting_election+1;i<=NosOfProcess;i++)
            {    
                System.out.println("Process"+process_conducting_election+" sending ELECTION message to process"+i);
               
            }
            if(process_conducting_election==getMax())
            {
                System.out.println("\nNew coordinator:"+process_conducting_election);
                break;
            }
            else
            {
                process_conducting_election=process_conducting_election+1;
                System.out.println();
            }
           
        }
                
       
    }
    
    public static void main (String [] args)
    {
        BullyAlgorithm object =  new BullyAlgorithm();
        object.getInput(); 
        object.conductElection();
        
        
    }
}
