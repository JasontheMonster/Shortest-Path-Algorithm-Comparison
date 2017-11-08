/**
 * @author Jason
 * Edge Class
 * A edge can store information about weights
 */

public class Edge {
	private int weights;			//weights
	private Node target;			//neighbors
	
	/**
	 * Constructor
	 * @param target
	 * @param weights
	 * Initialize neighbor and weight of edge
	 */
	public Edge (Node target, int weights){
		this.target = target;
		this.weights = weights;
	}
	
	
	/**
	 * 
	 * @return neighbor of current node
	 */
	public Node getNeighbor (){
		return this.target;
	}
	
	/**
	 * 
	 * @return weight of edge
	 */
	public int getWeights (){
		return this.weights;
	}
	
	/**
	 * return string representation of weight
	 */
	public String toString(){
		return Integer.toString(this.weights);
	}
	 
	
}
