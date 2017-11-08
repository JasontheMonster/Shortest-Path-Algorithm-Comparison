/**
 * 
 */
package ShortestPah;

import GraphAPI.Edge;
import GraphAPI.Graph;
import GraphAPI.Node;

/**
 * @author Jason
 *
 */
public class BellmanFord {
	private Graph graph;
	
	/**
	 * Constructor
	 * @param graph
	 */
	public BellmanFord(Graph graph){
		this.graph = graph;
	}
	
	
	public void solve(Node node){
		this.graph.modifyNode(node, 0);	
		
		for (int k=0; k<this.graph.numberofNodes()-1;k++){
			for (Node vertice: this.graph.vertices){
				for (Edge edge: vertice.getNeighbors()){
					Node neighbor = edge.getNeighbor();
					int relax = Math.min(neighbor.getDistance(), vertice.getDistance() + edge.getWeights());
					neighbor.modify(relax);
				}
			}
			
		}
		for (Node vertice: this.graph.vertices){
			for (Edge edge: vertice.getNeighbors()){
				if (edge.getNeighbor().getDistance()>vertice.getDistance()+ edge.getWeights()){
					System.out.println("Negative");
				}
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
