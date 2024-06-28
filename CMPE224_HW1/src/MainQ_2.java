//-----------------------------------------------------
//Title: Main class
//Author: Arda Baran
//Description: This class runs the commands and sorts the path in an ascending order.
//-----------------------------------------------------
import java.util.Scanner;
public class MainQ_2 {
   public static int [] insertionSortForLexicographicallyPrinting(int [] arr){
   	//--------------------------------------------------------
	 // Summary: sorts the path in an ascending order. 
	 //return type is an array.
	 // Precondition: arr is an integer array.
	 // Postcondition: duration 1 smaller than duration2 
	 //--------------------------------------------------------     
        int arrSize = arr.length;
        for (int i = 1; i < arrSize; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
      return arr;
   }
    public static void main(String[] args) {
    	 //case 1 :
		UndirectedG g = new UndirectedG(6, 6);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 3);
	        g.addEdge(2, 3);
	        g.addEdge(2, 4);
	        g.addEdge(4, 5);

	        
	        DfsTravel dfs = new DfsTravel(g);
	        dfs.dfs(0, 3);

	        
	        System.out.println("DFS Path:");
	        int[] path = dfs.getPath();
	        for (int node : path) {
	            System.out.print(node + " ");
	        }
	        System.out.println();
	  
	 //case 2 :       
	        UndirectedG g1 = new UndirectedG(4, 5);
	        g1.addEdge(0, 1);
	        g1.addEdge(0, 3);
	        g1.addEdge(1, 2);
	        g1.addEdge(1, 3);
	        g1.addEdge(2,3);
	        g1.addEdge(0, 3);

	        DfsTravel dfs1 = new DfsTravel(g1);
	        dfs1.dfs(0, 3);

	      
	        System.out.println("DFS Path:");
	        int[] path1 = dfs1.getPath();
	        for (int node : path1) {
	            System.out.print(node + " ");
	        }
	        System.out.println();
	      //case 3 :  
	        UndirectedG g2 = new UndirectedG(6, 7);
	        g2.addEdge(0, 1);
	        g2.addEdge(0, 4);
	        g2.addEdge(1, 2);
	        g2.addEdge(1, 3);
	        g2.addEdge(2,3);
	        g2.addEdge(2, 5);
	        g2.addEdge(4, 5);
	        DfsTravel dfs2 = new DfsTravel(g2);
	        dfs2.dfs(0, 2);

	       
	        System.out.println("DFS Path:");
	        int[] path2 = dfs2.getPath();
	        for (int node : path2) {
	            System.out.print(node + " ");
	        }
	        System.out.println();
    }
}
