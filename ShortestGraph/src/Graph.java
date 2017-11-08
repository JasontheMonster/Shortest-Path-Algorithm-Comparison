import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author Jason
 * Graph class implemented by ArrayList
 * randomly simulate graph
 *
 */
public class Graph {
	private double prob;										//probability of existing edge between nodes 
	private int n; 												//maximun number of node
	private ArrayList <Node>vertices = new ArrayList <Node>(); 	//bag to store nodes
	
	
	/**
	 * Constructor:
	 * @param prob, probability of a edge existing
	 * @param n: maximum number of vertices 
	 */
	public Graph (double prob, int n){
		this.prob = prob;
		this.n = n;
	}
	
	/**
	 * randomly generate a graph
	 */
	public void randomGraph(){
		Random rand = new Random();
		int num = rand.nextInt(this.n) + 1;
		
		for (int i =0; i<num; i++){
			ArrayList <Edge> adj = new ArrayList <Edge>();
			Node node = new Node(i, Integer.MAX_VALUE, adj);
			this.vertices.add(node);
		}
		
		for (int i =0; i<this.vertices.size(); i++){
			Node node = this.vertices.get(i);
			for (int j=i+1; j<this.vertices.size(); j++){
				Node target = this.vertices.get(j);
				if (Math.random() < prob){
					int weight = rand.nextInt(100) + 1;
					node.addEdge(target, weight);
				}
			}
		}	
	}
	
	/**
	 * String representatino of Graph
	 * @return list of [a, [(b,c)]] represent an edge between a and b with weigts c
	 */
	public String toString(){
		StringBuilder str = new StringBuilder("");
		for(int i = 0; i < this.vertices.size(); i++) {   
			  str.append(vertices.get(i).toString());
		} 
		return str.toString();
	}

	 public static void main(String []args){
		 Graph graph = new Graph(0.5, 10);
		 graph.randomGraph();
		 System.out.println(graph.toString());
	 }
}
