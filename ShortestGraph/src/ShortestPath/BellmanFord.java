/**
 * 
 */
package ShortestPath;


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
		for (int k=1; k<this.graph.numberofNodes()-1;k++){
			for (Node vertice: this.graph.vertices){
				if (vertice.hasNeighbor()){
					for (Edge edge: vertice.getNeighbors()){
						Node neighbor = edge.getNeighbor();
						if (neighbor.getId()!=vertice.getId()){
							int weight = edge.getWeights();
							System.out.println(edge.getWeights());
							int relax = Math.min(neighbor.getDistance(), vertice.getDistance() + weight);
							this.graph.modifyNode(neighbor, relax);
					}
					}
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
		Graph graph = new Graph (0.6, 5);
		BellmanFord solver = new BellmanFord(graph);
		Node node = graph.vertices.get(0);
		System.out.println(graph.toString());
		solver.solve(node);
		for (Node v: graph.vertices){
			System.out.println(v.getDistance());
		}

	}

}
