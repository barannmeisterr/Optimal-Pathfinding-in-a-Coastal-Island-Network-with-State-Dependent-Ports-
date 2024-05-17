//-----------------------------------------------------
// Title: UndirectedGraph class
// Author: Arda Baran
// Description: This class implement undirected graph data structure. This undirected graph consists of islands that can be 
//considered as vertices and routes that can be considered as edges,time taken port loading  running  and time taken travel
//on a road between two islands.
//adjacency is implemented as two dimensional array matrix.
//if adjacencyMatrix[island_X_Index][island_Y_Index] equals to 1 , then there is a connection between island X and island Y.
//else , there is no edge which connects them directly.
//ShortestDistanceBetweenTwoIsland(int) calculates minimum time taken to go from starting island to destination island.
//minimumRequiredCoefficient(int,int) takes two parameters and calculates the minimum required coefficient to make first
//parameter of method greater than second parameter of method.
// For example let parameter1 =3 and parameter2=10 , what makes parameter1 greater than parameter2 ? 
//if we multiply parameter1 with a coefficient,coefficient * parameter1 can be greater than parameter2.
//coefficient must be minimum 4 becase 4 * 3 = 12 > 10 .
//-----------------------------------------------------





public class UndirectedGraph {
//fundamental elements of undirected graph data structure for this question1 .
int numberOfVertices,numberOfEdges,edgeDuration,portLoadingDuration;
int adjacencyMatrix[][];

public UndirectedGraph(int numberOfVertices,int numberOfEdges,int portLoadingDuration,int edgeDuration) {
//Constructor.
//adjanceny matrix is initialized as numberOfVertices * numberOfVertices by using two dimensional array.	
	
this.numberOfVertices=numberOfVertices;	
this.numberOfEdges=numberOfEdges;	
this.portLoadingDuration=portLoadingDuration;	
this.edgeDuration=edgeDuration;
this.adjacencyMatrix=new int [numberOfVertices][numberOfVertices];

}
//getter and setters of variables.
public int getNumberOfVertices() {

	return numberOfVertices;
}

public void setNumberOfVertices(int numberOfVertices) {

	this.numberOfVertices = numberOfVertices;
}

public int getNumberOfEdges() {

	return numberOfEdges;
}

public void setNumberOfEdges(int numberOfEdges) {

	this.numberOfEdges = numberOfEdges;
}

public int getEdgeDuration() {

	return edgeDuration;
}

public void setEdgeDuration(int edgeDuration) {

	this.edgeDuration = edgeDuration;
}

public int getPortLoadingDuration() {

	return portLoadingDuration;
}

public void setPortLoadingDuration(int portLoadingDuration) {

	this.portLoadingDuration = portLoadingDuration;
}

public int[][] getAdjacencyMatrix() {
	
	return adjacencyMatrix;
}

public void setAdjacencyMatrix(int[][] adjacencyMatrix) {

	this.adjacencyMatrix = adjacencyMatrix;
}
public void addEdge(int vertex1,int vertex2) {
	//--------------------------------------------------------
	 // Summary: adds road between  islands
	 
	 // Precondition: vertex1 index is an integer and vertex 2 index is an
	 // integer
	 
	 //--------------------------------------------------------
	adjacencyMatrix[vertex1][vertex2]=1;
    adjacencyMatrix[vertex2][vertex1]=1;
    
}

public int ShortestDistanceBetweenTwoIslands(int numOfEdgesBetweenTwoIslands) {
	//--------------------------------------------------------
	 // Summary: calculates shortest distance in terms of minutes.
	 // it can be said that edge number between two island is number of islans on path -1
	 // Precondition: numOfEdgesBetweenTwoIslans is an integer.
	 // Postcondition: if there is no edge between source islands to destination island ,then shortest distance is not exist.
	 // For example,if source and destinations are directly connected by road or port duration is greater than road (route duration) 
	 //then shortest distance is route duration
	//I provided the name of variables very clear to explain the purpose of this method.
	//--------------------------------------------------------
	int portDuration=getPortLoadingDuration();
	int routeDuration=getEdgeDuration();
	int totalRouteDuration=numOfEdgesBetweenTwoIslands * routeDuration;

	if(numOfEdgesBetweenTwoIslands==0 ) {
	//if there is no connection or there is no way to reach source island to destination island, fewest taken time during travel is zero.
	
		return 0;
	}
	else if(numOfEdgesBetweenTwoIslands==1) {
	//if there is only one road between source and destination islands, its means these two islands are connected directly , since all the ports are running state 
	//at the beggining ,minimum taken time is only the duration of the road.
	
		return totalRouteDuration;
	}else {
	if(portDuration < routeDuration) {
	//if port loading or running state duration greater than travelling on road duration and we know that all the ports are running state at the beggining we need to wait 
	//when we second destination location . for example port duration is 3 and route is 5 .we want to travel from 1 to 5 and path is 1-2-5
	//1------------|----------------------------------------------------------2--------------------------------------------------------------5
    //     port is closed at the third minute  , 2 minutes are wasted on road ,the remaining duration to port is running is 1 ,so we need to wait for 1 minute at island 2.         	
	//we can go directly without waiting from island 2 to 5 because island 5 is last destination.
		int numberOfTimesPortIsInLoadingStateUntilBoatArrives=minimumRequiredCoefficient(portDuration,routeDuration);//to make 3 minutes grater than 5 minutes ,
		//we need to multiply port duration by minimum 2.port becomes 6 and 6%5=1 and this is our waiting duration. 
		int waitingTime= (numberOfTimesPortIsInLoadingStateUntilBoatArrives * portDuration) % routeDuration;//the time for waiting at the port until it states is running. 	
	               
		    return totalRouteDuration+(waitingTime * (numOfEdgesBetweenTwoIslands-1));                                                                                                  //port is running
	}else if(portDuration==routeDuration) {
		return totalRouteDuration+((numOfEdgesBetweenTwoIslands-1) * portDuration) ;//required waiting time to port is running.
	}else {
	//if port duration greater than route duration ,we can pass directly n islands . n is minimum coefficient that makes route duration greater than port duration.
	
	
		int numberOfIslandsVisitedWhenPortIsOpen=minimumRequiredCoefficient(routeDuration,portDuration);
	if(numOfEdgesBetweenTwoIslands <numberOfIslandsVisitedWhenPortIsOpen ||numOfEdgesBetweenTwoIslands ==numberOfIslandsVisitedWhenPortIsOpen ) {
		return totalRouteDuration;
	//if n = 4 and there is less or equal road between source and destination ,then ignore port duration
	    
	}else {
	//if n = 4 and there is more road than 4 , we have to wait until port is running for each 4 edges we passed.
	
		int waitingTimeToPortSwitchRunning=portDuration - ((numberOfIslandsVisitedWhenPortIsOpen * routeDuration) % portDuration);
	int numberOfTimesOfEncounterPortIsClosed = numOfEdgesBetweenTwoIslands / numberOfIslandsVisitedWhenPortIsOpen;
	return (numberOfTimesOfEncounterPortIsClosed * waitingTimeToPortSwitchRunning) + totalRouteDuration;
	}
	}	
	}
}
public int minimumRequiredCoefficient(int duration1,int duration2) {
	//--------------------------------------------------------
	 // Summary: calculates minimum required coefficient to 
	 //make duration1 greater than duration2
	 // Precondition: duration1 is a integer and duration is an
	 // integer
	 // Postcondition: duration 1 smaller than duration2 
	 //--------------------------------------------------------
	int coefficient=1;
	if(duration1<duration2) {
		while((coefficient * duration1) < duration2) {
			coefficient++;
		}
	}
return coefficient;
}
}
