/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributed_practicals.TokenRing;

/**
 *
 * @author Rashmi Kabra
 */
import java.util.Scanner; 
    
class Process { 

    int processId; 
    boolean active; 

    public Process(int processId) { 
        this.processId = processId; 
        active = true; 
    } 
} 

public class RingElection { 
     
     Scanner consoleInput =new Scanner(System.in); 
     Process[] process; 
     int NosOfProcess; 


    public void getInput() { 
        System.out.println("Enter number of process in ring: "); 
        NosOfProcess = consoleInput.nextInt(); 
        process = new Process[NosOfProcess]; 

        for (int i = 0; i < NosOfProcess; i++) { 
            System.out.print("Enter Process ID of p" + i + ": "); 
            int pid = consoleInput.nextInt(); 
            process[i] = new Process(pid);
        } 
        sortProcess(); 
        putOutput(); 
    } 

   
    public void conductElection() { 
                 
        try{ 
            Thread.sleep(2000); 
        }catch(Exception e ){ 
            System.out.println(e); 
        } 
        System.out.println("process "+ process[getMax()].processId +" Fail"); 
        process[NosOfProcess-1].active = false; 
         
        while(true){ 
            System.out.print("Conduct Election?\nyes or exit: "); 
            String choice = consoleInput.next(); 
            if("yes".equals(choice) || "Yes".equals(choice) || "y".equals(choice) || "Y".equals(choice)){ 
                System.out.println("Election initiated by: "); 
                int initiatorProcess = consoleInput.nextInt(); 
                for(int i = 0; i< NosOfProcess; i++){ 
                    if(process[i].processId == initiatorProcess){ 
                        initiatorProcess = i; 
                        break; 
                    } 
                } 
                int prev = initiatorProcess; 
                int next = prev+1; 
                
                while(true){ 
                    if(process[next].active) { 
                        System.out.println("Process "+ process[prev].processId +" pass message to process "+process[next].processId ); 
                        prev = next; 
                    } 
                    next = (next+1) % NosOfProcess; 
                     
                    if(next == initiatorProcess) { 
                        break; 
                    } 
                } 
                System.out.println("Process "+ process[getMax()].processId +" becomes coordinator"); 
            } else { 
                System.exit(0);             
            } 
        } 
    } 
     
    public void putOutput(){ 
        System.out.println("Processes in the ring: ");    
        for(int i = 0; i < NosOfProcess; i++){ 
            System.out.print(process[i].processId +", active: "+ process[i].active); 
            if(i == getMax()){ 
                System.out.print(", Coordinator\n"); 
            }else { 
                System.out.print("\n"); 
            } 
             
        } 
    } 
     
    public void sortProcess() { 
        for (int i = 0; i < NosOfProcess ; i++) { 
            for (int j = 0; j <i; j++) { 
                if (process[j].processId > process[j + 1].processId) { 
                    int temp = process[j].processId; 
                    process[j].processId = process[j + 1].processId; 
                    process[j + 1].processId = temp; 

                } 
            } 
        } 
    } 
     
    public int getMax(){ 
        int max = 0, indexOfMax = 0; 
        for(int i = 0; i < NosOfProcess; i++){ 
            if(process[i].active && max <= process[i].processId ) { 
                max = process[i].processId; 
                indexOfMax = i; 
            } 
        } 
        return indexOfMax; 
    } 

    public static void main(String arg[]) { 
        RingElection ringElection = new RingElection();
        ringElection.getInput(); 
        ringElection.conductElection(); 
        
                
     
    } 
} 