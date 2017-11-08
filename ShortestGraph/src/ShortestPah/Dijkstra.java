/**
 * 
 */
package ShortestPah;
import GraphAPI.Graph;
import GraphAPI.Node;
import GraphAPI.NodeComparator;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphAPI.Edge;

/**
 * @author Jason
 *Dijkstra Algorithm Implementatino
 */
public class Dijkstra {
	private Graph graph;
	
	/**
	 * Constructor
	 * @param graph
	 * Initialize graph
	 */
	public Dijkstra(Graph graph){
		this.graph = graph;
	}
	
	public void solve(Node node){
		this.graph.modifyNode(node, 0);	
		
		Comparator<Node> comparator= new NodeComparator();
		PriorityQueue <Node> queue = new PriorityQueue <Node> (this.graph.numberofNodes(), comparator);
		queue.add(node);
		for (int i =0; i< this.graph.numberofNodes(); i++){
			Node current = queue.poll();
			for (Edge edge: current.getNeighbors()){
				Node neighbor = edge.getNeighbor();
				int weight = edge.getWeights();
				int relax = Math.min(neighbor.getDistance(), current.getDistance() + weight);
				this.graph.modifyNode(neighbor, relax);
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
