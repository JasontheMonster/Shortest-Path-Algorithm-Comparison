import java.util.ArrayList;
import java.util.Random;

/**
 * 
 */

/**
 * @author Jason
 *
 */
public class Graph {
	private double prob;//probability of existing edge between nodes 
	private int n; //maximun number of node
	private ArrayList <Node>vertices;
	
	
	//constructor: randomly create a graph represented by LinkedList
	public Graph (double prob, int n){
		this.prob = prob;
		this.n = n;
	}
	

	public void randomGraph(){
		Random rand = new Random();
		int num = rand.nextInt(this.n) + 1;
		
		for (int i =0; i<num; i++){
			ArrayList <Edge> adj = new ArrayList <Edge>();
			Node node = new Node(Integer.MAX_VALUE, adj);
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
}
