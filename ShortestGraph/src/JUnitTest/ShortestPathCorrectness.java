package JUnitTest;
import ShortestPath.Dijkstra;

import GraphAPI.Graph;
import GraphAPI.Node;


import static org.junit.Assert.*;

import org.junit.Test;

public class ShortestPathCorrectness {
	protected int n;
	protected double prob;
	
	// assigning the values
	protected void setUp(){
	      n = 15;
	      prob = 0.6;
	 }

	@Test
	public void shortestPaht() {
		
		Graph dijkstra = new Graph(prob, n);
		Dijkstra solver = new Dijkstra(dijkstra);
		Node node = dijkstra.vertices.get(0);
		System.out.println(dijkstra.toString());
			
	}

}
