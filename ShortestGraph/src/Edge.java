
public class Edge {
	private int weights;
	private Node target;
	
	public Edge (Node target, int weights){
		this.target = target;
		this.weights = weights;
	}
	
	public Node getNeighbor (){
		return this.target;
	}
	
	public int getWeigths (){
		return this.weights;
	}
	 
	
}
