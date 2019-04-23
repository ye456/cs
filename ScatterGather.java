 import mpi.MPI;
 import java.util.*;

    public class ScatterGather {
   	 public static void main(String args[]){
   	 Scanner scanner = new Scanner(System.in);
   	 
   	 MPI.Init(args);
   	 int rank = MPI.COMM_WORLD.Rank();
	 int size = MPI.COMM_WORLD.Size();
   	 int root=1;
	 int sendbuf[]=null;
     int data =10;
   	 sendbuf= new int[size];
   	 
	 if(rank==root){
	 	for(int i=0;i<size;i++)
	 	{
	 		sendbuf[i] = data;
	 		data=data+10;
	 	}

   		 System.out.print("Processor "+rank+" has data: ");
   		 for(int i = 0; i < size; i++){
   			 System.out.print(sendbuf[i]+" ");
   		 }
   		 System.out.println();
   	 }
	 int recvbuf[] = new int[1];
	
	 MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);
   	 System.out.println("Processor "+rank+" has data: "+recvbuf[0]);
   	 System.out.println("Processor "+rank+" is doubling the data");
   	 recvbuf[0]=recvbuf[0]*2;
	 MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);
	 if(rank==root){
   		System.out.println("Process "+root+" has data: ");
   		 for(int i=0;i<4;i++){
   			 System.out.print(sendbuf[i]+ " ");
   		 }
   	 }
	 MPI.Finalize();
    }
}

