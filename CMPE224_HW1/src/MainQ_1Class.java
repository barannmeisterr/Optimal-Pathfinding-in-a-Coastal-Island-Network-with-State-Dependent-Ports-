
public class MainQ_1Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraph g = new UndirectedGraph(5,5,3,5);
		   g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 3);
	        g.addEdge(0, 3);
	        g.addEdge(1, 4);
	        BfsAndShortestPath bfs = new BfsAndShortestPath(g);
	bfs.bfs(g, 0);//bfs and programOutput points must be same for running program correctly.
	bfs.programOutput(0,4 );
System.out.println("--------------------------------------------------------------------------");
	//if both port and route durations are equal
	UndirectedGraph g1 = new UndirectedGraph(5,5,5,5);
		   g1.addEdge(0, 1);
	        g1.addEdge(0, 2);
	        g1.addEdge(1, 3);
	        g1.addEdge(0, 3);
	        g1.addEdge(1, 4);
	        BfsAndShortestPath bfs1 = new BfsAndShortestPath(g1);
	bfs1.bfs(g1, 0);
	bfs1.programOutput(0,4);
	//if port duration is greater than route duration 
	System.out.println("--------------------------------------------------------------------------");
	UndirectedGraph g2 = new UndirectedGraph(5,5,5,3);
		   g2.addEdge(0, 1);
	        g2.addEdge(0, 2);
	        g2.addEdge(1, 3);
	        g2.addEdge(0, 3);
	        g2.addEdge(1, 4);	
	        BfsAndShortestPath bfs2 = new BfsAndShortestPath(g2);
	bfs2.bfs(g2, 0);
	bfs2.programOutput(0,4);	    
	}

}
