package GraphAPI;




/**
 * 
 */

/**
 * @author Jason
 * Node Class
 * A node can store information about distance, its adjacent list and id
 */

public class Node {
	private double dist; 				//shortest path
	private int id;						//id 
	
	/**
	 * Constructor
	 * @param id
	 * @param dist
	 * Initialize id, dist, adjList
	 */
	public Node (int id, double dist){
		this.dist = dist;
		this.id = id;
	}
	
	
	/**
	 * getDistance
	 * @return current shortest path
	 */
	public double getDistance(){
		return this.dist;
	}
	
	public void modify(double d){
		this.dist =d;
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
		StringBuilder str = new StringBuilder("[");
		str.append("ID: " + Integer.toString(this.id)+",");
		str.append("Dist: " +Double.toString(this.dist)+ "]");
		
		return str.toString();
	}

	
}
