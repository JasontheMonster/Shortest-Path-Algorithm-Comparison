package GraphAPI;
import java.util.ArrayList;



/**
 * 
 */

/**
 * @author Jason
 * Node Class
 * A node can store information about distance, its adjacent list and id
 */

public class Node {
	private Integer dist; 				//shortest path
	private ArrayList<Edge> adjList; 	//List of edges to adjacent nodes
	private int id;						//id 
	
	/**
	 * Constructor
	 * @param id
	 * @param dist
	 * @param adjList
	 * Initialize id, dist, adjList
	 */
	public Node (int id, Integer dist, ArrayList<Edge> adjList){
		this.dist = dist;
		this.adjList = adjList;
		this.id = id;
	}
	
	/**
	 * getNeighbors
	 * @return adjacent list of current node
	 */
	public ArrayList<Edge> getNeighbors(){
		return this.adjList;
	}
	
	/**
	 * getDistance
	 * @return current shortest path
	 */
	public int getDistance(){
		return this.dist;
	}
	
	public void modify(int d){
		this.dist =d;
	}
	
	/**
	 * addEdge
	 * @param target
	 * @param weights
	 */
	public void addEdge(Node target, int weights){
		Edge edge = new Edge (target, weights);
		this.adjList.add(edge);
	}
	
	/**
	 * 
	 * @return id of current node
	 */
	public int getId(){
		return this.id;
	}
	
	
	/**
	 * @return [a, [(b,c)]] represent an edge between a and b with weigts c
	 */
	public String toString(){
		StringBuilder str = new StringBuilder("[ ");
		str.append(Integer.toString(this.id)+", [");
		
		for (Edge edge: this.adjList){
			Node neighbor = edge.getNeighbor();
			str.append("(" + Integer.toString(neighbor.getId()) + ",");
			str.append(edge.toString() + ")");
			str.append(",");
		}
		if (this.adjList.size()!=0){
			str.deleteCharAt(str.length()-1);
		}
		str.append("] ]");
		
		return str.toString();
	}

	
}
