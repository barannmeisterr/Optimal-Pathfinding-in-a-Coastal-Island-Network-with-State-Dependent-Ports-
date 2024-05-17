//-----------------------------------------------------
// Title: UndirectedGraph class
// Author: Arda Baran
// Description: This class implement undirected graph data structure. 
//This undirected graph consists of cities and roads that can be vertices and edges.
//adjacency is implemented as two dimensional array matrix.
//if adjacencyMatrix[city_X_Index][city_Y_Index] equals to 1 , then there is a connection between city X and city Y.
//else , there is no edge which connects them directly.
//-----------------------------------------------------
public class UndirectedG {
	//fundamental elements of undirected graph data structure for this question2 .	
	int numOfCities,numOfRoads;
    int[][] adjMatrix;
   public UndirectedG(int numOfCities,int numOfRoads) {
       //Constructor.
//adjanceny matrix is initialized as numOfCities * numOfCities by using two dimensional array.	
        this.numOfCities = numOfCities;
        this.numOfRoads=numOfRoads;
        adjMatrix = new int[numOfCities][numOfCities];
    }
    //getter and setters of cities(vertices)and roads(edges) and adjacency matrix.
public int getNumOfRoads() {
		return numOfRoads;
	}
	public void setNumOfRoads(int numOfRoads) {
		this.numOfRoads = numOfRoads;
	}
public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}
public int getNumOfCities() {
	return numOfCities;
}
public void setNumOfCities(int numOfCities) {
	this.numOfCities=numOfCities;
}
public void addEdge(int city1,int city2) {
	//--------------------------------------------------------
	 // Summary: adds road between cities	 
	 // Precondition: city1 index is an integer and city 2 index is an
	 // integer 
	 //--------------------------------------------------------
	adjMatrix[city1][city2] = 1;
	adjMatrix[city2][city1] = 1;
}
}
