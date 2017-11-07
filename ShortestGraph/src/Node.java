import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Jason
 *
 */


public class Node {
	private int dist;
	private ArrayList<Edge> adjList;
	
	public Node (int dist, ArrayList<Edge> adjList){
		this.dist = dist;
		this.adjList = adjList;
	}
	
	
	public ArrayList<Edge> getNeighbors(){
		return this.adjList;
	}
	
	public int getDist(){
		return this.dist;
	}
	
	public void addEdge(Node target, int weights){
		Edge edge = new Edge (target, weights);
		this.adjList.add(edge);
	}
	
}
