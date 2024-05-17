//-----------------------------------------------------
// Title: BFS and Shortest Path class
// Author: Arda Baran
// Description: this class finds the shortest path and minimum required time to travel island x to y by get helping from bfs 
//algorithm.
//-----------------------------------------------------
public class BfsAndShortestPath {
// in order to build bfs and shortest path algorithm , a graph data structure instance , boolean visited array which is for track status of the islands visited or not visited , 
//two dimensional adjacency matrix array which is initialized as same as undirected graph data structure thanks to getter and setter methods of UndirectedGraph class,
//Queue data structure for bfs ,number of visited islands to calculate minimum taken time to travel island X to Y and parentIsland array for shortest path
	int numberOfVisitedIsland;
UndirectedGraph g;
boolean visited[];
int[][]adjMatrix;
int parentIsland[];
QueueArrayImplementation queue;
public BfsAndShortestPath(UndirectedGraph g) {
	//constructor
	this.g=g;
this.numberOfVisitedIsland=0;//at the beggining we didint visit an island.
this.adjMatrix=g.getAdjacencyMatrix();//initialized with same as adjacencyMatrix of undirected graph with getter method.	
this.queue=new QueueArrayImplementation(g.getNumberOfVertices());//queue structure assigned with the total number of islands.
this.parentIsland=new int[g.getNumberOfVertices()];//initialized with its default value which is 0.
this.visited=new boolean[g.getNumberOfVertices()];//initialized with its default value which is false.
//parent array is now initialized to -1 at the beggining with this loop
for (int i = 0; i < parentIsland.length; i++) {
    parentIsland[i] = -1;
}
}
public int getNumberOfVisitedIsland() {
	return numberOfVisitedIsland;
}
public void setNumberOfTravelledIsland(int numberOfVisitedIsland) {
	this.numberOfVisitedIsland = numberOfVisitedIsland;
}
public void IncrementNumberOfVisitedIsland() {
	//--------------------------------------------------------
		 // Summary: increments number of visited islands.It is used in 
		 //printShortestPath(int,int) method.when an island is visited 
		 //on path ,then number of visited island increments by 1 .
		 //--------------------------------------------------------
	int islandCounter=getNumberOfVisitedIsland();
	islandCounter=islandCounter+1;
	setNumberOfTravelledIsland(islandCounter);
}
public void bfs(UndirectedGraph g , int root) {
	//--------------------------------------------------------
		 // Summary: adds road between to islands
		 // Precondition: g is an UndirectedGraph and root is an
		 // starting index of bfs algorithm
		 // Postcondition: queue is not empty, and there is connection between neighbors.
		 //--------------------------------------------------------	
	queue.addIslandToQueue(root);//add source island route to queue.
    visited[root]=true;//mark root as visited
while(!queue.isEmpty()) {//loop works until queue of islands is empty.
	root = queue.getFrontElementOfQueue();//root is not stay constant thanks to these delete and peek operations.
    queue.deleteIslandFromQueue();
for(int i = 0;i<g.getNumberOfVertices();i++) {//this loop is for find neigbours.
	if(adjMatrix[root][i]==1 && !visited[i]) {//find neighbors.
		queue.addIslandToQueue(i);//adds neighbour to queue
	    visited[i]=true;//marks after visit.
	    parentIsland[i]=root;//assings changed root to parent array 
	}
}
}
}
public void printShortestPath(int sourceIsland, int destinationIsland) {
	//--------------------------------------------------------
	 // Summary: prints shortest path recursively.	 
	 // Precondition:all parameters(2 parameter) are integers	 	 
	 //--------------------------------------------------------
	if (sourceIsland == destinationIsland) {
        System.out.print((sourceIsland + 1) + " "); // Print island number instead of index
    } else if (parentIsland[destinationIsland] == -1) {//if destination island is not exist,this function does not do anything.
        return;
    } else {
        printShortestPath(sourceIsland, parentIsland[destinationIsland]);
        System.out.print((destinationIsland + 1) + " "); // Print island number instead of index
    }
}
public int getNumberOfVisitedIslandsOnShortestPath(int sourceIsland,int destinationIsland) {
	// Summary: returns number of islands on shortest path recursively.
	if(sourceIsland==destinationIsland) {
		IncrementNumberOfVisitedIsland();
	return getNumberOfVisitedIsland();
	}else if(parentIsland[destinationIsland]==-1) {
		return 0;
	}else {
		return 1 + getNumberOfVisitedIslandsOnShortestPath(sourceIsland,parentIsland[destinationIsland]);
	}
}
int NumberOfEdgesBetweenTwoIslands(int sourceIsland, int destinationIsland) {
//returns number of roads between two islands.For example if there are 5 islands between x and y islands,then there are 4 edges between x and y islands for this question.
	return getNumberOfVisitedIslandsOnShortestPath(sourceIsland, parentIsland[destinationIsland]) -1;
}
public void programOutput(int sourceIsland,int destinationIsland) {
//prints desired output by taking sourceIsland and destinationIsland indexes.	
	System.out.println(getNumberOfVisitedIslandsOnShortestPath(sourceIsland,destinationIsland));
	printShortestPath(sourceIsland,destinationIsland);
	System.out.println("");
    System.out.println(g.ShortestDistanceBetweenTwoIslands(NumberOfEdgesBetweenTwoIslands(sourceIsland,destinationIsland)));
}
}