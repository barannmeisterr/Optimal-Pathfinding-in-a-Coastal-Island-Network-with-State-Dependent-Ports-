import java.util.Arrays;
//-----------------------------------------------------
// Title: Dfs Travel class
// Author: Arda Baran
// Description:This DfsTravel class provides traversing a graph by using the DFS algorithm.  
//DFS finds a path from a starting node to a target node. This class takes a matrix representing a 
//graph and determines the starting and target nodes. Then, it employs the DFS algorithm to find 
//the path from the starting node to the target node. 
//the main purpose of this class is to find  different paths while trying to find a cycle.
//-----------------------------------------------------
public class DfsTravel {
//fundamental elements of DfsTravel structure    
    boolean visited[];
    UndirectedG g;
    int adjM[][];
    StackArrayImplementation stack;
    int path[];//holds indexes of visited cities.
    int pathIndex;
    public DfsTravel(UndirectedG g) {
        this.g = g;
        this.adjM = g.getAdjMatrix();//adj matrix is taken from UndirectedG with getter.
        this.visited = new boolean[g.getNumOfCities()];//initialized defaultly false
        this.stack = new StackArrayImplementation(g.getNumOfCities());//stack is initialized with number of cities
        this.path = new int[g.getNumOfCities()];
        this.pathIndex = 0;//path index initialized at 0 at the beggining.
    }
    public void dfs(int root, int target) {
   //--------------------------------------------------------
	 // Summary: it represents each steps of DFS algorithm and allows traversing the graph 
	 // through the depth.
	 // Precondition: root and target are integer
	 //-------------------------------------------------------
        //adds root which is starting city to stack.
        stack.addCityToStack(root);
       //adds the starting node to the path array, which keeps track of visited nodes, 
       //and increments the path index 
        path[pathIndex++] = root;
        //Marks the starting node as visited. 
        visited[root] = true;
       //If the starting node is the same as the target node, the process is terminated.
       //and the DFS operation is completed
        if (root == target){ 
        return;
        }
     //As long as the stack is not empty, the DFS process continues.  
        while (!stack.isEmpty()) {
        //Retrieves the top node from the stack. This represents the current node.    
            int current = stack.getTop();
    // Initiates a loop to iterate through all nodes in the graph.      
            for (int i = 0; i < g.getNumOfCities(); i++) {
     //if there is a connection between the current node and the node in the loop, 
    // and the loop node has not been visited before, this condition is met.         
                if (adjM[current][i] == 1 && !visited[i]) {
                    stack.addCityToStack(i);// Adds the loop node to the stack.
                    path[pathIndex++] = i;//Adds the loop node to the path array and increments the path index
                    visited[i] = true;//Marks the loop node as visited.
                   
    // If the loop node is the same as the target node, the process is terminated, 
    //and the DFS operation is completed.               
                    if (i == target) 
                    return;
                }
            }
        }
    }
    public int[] getPath() {
       //--------------------------------------------------------
	 // Summary: returns the path traversed during the Depth-First Search (DFS) as an array of integers. 
	 //  allows the caller to access the DFS path without modifying the original array.
	 //-------------------------------------------------------
        return Arrays.copyOf(path, pathIndex);
    }
}