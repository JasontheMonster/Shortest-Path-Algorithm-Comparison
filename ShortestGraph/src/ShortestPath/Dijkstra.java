/**
 * 
 */

package ShortestPath;
import GraphAPI.DiGraph;
import GraphAPI.Node;
import GraphAPI.NodeComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

import org.jgrapht.Graphs;
import org.jgrapht.alg.util.IntegerVertexFactory;
import org.jgrapht.generate.GnmRandomGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import GraphAPI.Edge;

/**
 * @author Jason
 *Dijkstra Algorithm Implementatino
 */
public class Dijkstra {
	private DiGraph graph;
	
	/**
	 * Constructor
	 * @param graph
	 * Initialize graph
	 */
	public Dijkstra(DiGraph graph){
		this.graph = graph;
	}
	
	public void solve(Node node, int n){
		this.graph.modifyNode(node, 0);	
		
		Comparator<Node> comparator= new NodeComparator();
		PriorityQueue <Node> queue = new PriorityQueue <Node> (n, comparator);
		queue.add(node);
		ArrayList <Node> visited = new ArrayList <Node> ();
		while (!queue.isEmpty()){
			Node current = queue.poll();
			visited.add(current);
			if (this.graph.getNeighbor(current).size()>0){
				for (Edge edge: this.graph.getNeighbor(current)){
					Node neighbor = edge.getNeighbor();
					if (!visited.contains(neighbor)){
						double weight = edge.getWeights();
						double relax = Math.min(neighbor.getDistance(), current.getDistance() + weight);
						this.graph.modifyNode(neighbor, relax);
						queue.add(neighbor);	
					}
				}
			}
		}
	}
	
	public DiGraph showGraph(){
		return this.graph;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		int m = 3;
		int n = 3;
		GnmRandomGraphGenerator<Integer, DefaultWeightedEdge> random = new GnmRandomGraphGenerator<> (n, m);
		SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> answer = new SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		random.generateGraph(answer, new IntegerVertexFactory(), null);
		
		Iterator<DefaultWeightedEdge> iterator = answer.edgeSet().iterator();
		Random number = new Random();
		DiGraph graph = new DiGraph ();
		while(iterator.hasNext()){
			DefaultWeightedEdge edge = iterator.next();
			answer.setEdgeWeight(edge, 10*number.nextDouble());
		
			Integer source = answer.getEdgeSource(edge);
			Integer target = answer.getEdgeTarget(edge);
			Double weight = answer.getEdgeWeight(edge);
			Node s = new Node (source, Double.MAX_VALUE);
			Node t = new Node (target, Double.MAX_VALUE);
			graph.addNode(s);
			graph.addNode(t);
			graph.addWeightedDiEdge(s, t, weight);
		}
		System.out.println(graph.toString());
		
		int index = 0;
		Node source = new Node(1, 1);
		for (Node start: graph.vertices()){
			//if (index ==1) break;
			source = start;
			index ++;
			System.out.println(start.getId());
		}
		//System.out.println(graph.getNeighbor(source));
		Dijkstra solver = new Dijkstra(graph);
		//System.out.println(graph.toString());
		solver.solve(source, n);
		
		for (Node v: graph.vertices()){
			System.out.println(v.getDistance());
		}
	


	}

}
