package GraphAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * 
 */

/**
 * @author Jason
 * Graph class implemented by ArrayList
 * randomly simulate graph
 *
 */
public class DiGraph {
	//private double prob;										//probability of existing edge between nodes 
	//private int n; 												//maximun number of node
	private Map<Node, List<Edge> > neighbors; 	//bag to store nodes
	private ArrayList<Node> bag;
	
	
	/**
	 * Constructor:
	 * @param prob, probability of a edge existing
	 * @param n: maximum number of vertices 
	 */
	/**
	public Graph (double prob, int n){
		this.prob = prob;
		this.n = n;
		Random rand = new Random();
		int num = rand.nextInt(this.n) + 1;
		
		for (int i =0; i<num; i++){
			ArrayList <Edge> adj = new ArrayList <Edge>();
			Node node = new Node(i, Integer.MAX_VALUE, adj);
			this.vertices.add(node);
		}
		
		for (Node node: this.vertices){
			for (Node target: this.vertices){
				if (target.getId() != node.getId() && target.getId()!=0){
					if (Math.random() < this.prob){
						int weight = rand.nextInt(100) + 1;
						node.addEdge(target, weight);
					}
				}
			}
		}
	}
	**/
	public DiGraph(){
		this.neighbors = new HashMap<Node, List<Edge>>();
		this.bag = new ArrayList<Node> ();
	}
	
	
	public Set <Node>vertices(){
		return this.neighbors.keySet();
	}
	
	public boolean isVertice(Node node){
		for (Node v: this.bag){
			if (node.getId() == v.getId()) return true;
		}
		return false;
	}

	/**
	 * Adding Vertice to the graph
	 * @param node
	 */
	public void addNode(Node node){
		if (!isVertice(node)){
			//System.out.println(node.getId());
			this.neighbors.put(node, new ArrayList<Edge>());	
			//System.out.println(this.neighbors);
			this.bag.add(node);
		}
	}
	
	public void addWeightedDiEdge(Node current, Node target, double weight){
		System.out.println(this.neighbors);
		ArrayList <Edge> adjcent = getNeighbor(current);
		//System.out.println(current.toString() + getNeighbor(current));
		Edge edge = new Edge(target, weight);
		adjcent.add(edge);
		this.neighbors.put(current, adjcent);
	}
	
	/**
	 * Get neighbors of current node
	 * @param current
	 * @return
	 */
	public ArrayList <Edge> getNeighbor(Node current){
		//System.out.println(this.neighbors);
		return (ArrayList<Edge>) this.neighbors.get(current);
	}
	
	
	
	/**
	 * Modify the distance value of node
	 * @param node
	 * @param dist
	 */
	public void modifyNode(Node node, double dist){
		for (Node target: this.neighbors.keySet()){
			if (target == node){
				target.modify(dist);
			}
		} 
	}
	
	/**
	 * String representatino of Graph
	 * @return list of [a, [(b,c)]] represent an edge between a and b with weigts c
	 */
	public String toString(){
		StringBuilder str = new StringBuilder("");
		Iterator<Node> iterator = this.neighbors.keySet().iterator();
		
		while(iterator.hasNext()){
			Node node = iterator.next();
			str.append(node.toString());
			  for (Edge edge: getNeighbor(node)){
				  str.append("("+ Double.toString(edge.getWeights()) 
				  + "," + edge.getNeighbor().toString() + ")");
			  }
			  str.append("\n");
		}
		return str.toString();
	}

	 public static void main(String []args){
		 DiGraph graph = new DiGraph();
		 Node node1 = new Node (1, 1);
		 Node node2 = new Node (2, 10);
		 Node node3 = new Node (3, 2);
		 Node node4 = new Node (4, 3);
		 graph.addNode(node1);
		 graph.addNode(node2);
		 graph.addNode(node3);
		 graph.addNode(node4);
		 graph.addWeightedDiEdge(node2, node4, 3);
		 graph.addWeightedDiEdge(node3, node1, 10);
		 graph.addWeightedDiEdge(node3, node2, 11);
		 System.out.println(graph.toString());
	 }
}
