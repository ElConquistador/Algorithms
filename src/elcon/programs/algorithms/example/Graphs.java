package elcon.programs.algorithms.example;

import elcon.programs.algorithms.graph.Graph;
import elcon.programs.algorithms.graph.WeightedDirectedGraph;
import elcon.programs.algorithms.graph.WeightedGraph;

public class Graphs {

	public static void main(String[] args) {
		Graph<Character> graph = new Graph<Character>();
		graph.addNode('A');
		graph.addNode('B');
		graph.addEdge('A', 'B');
		System.out.println(graph.containsEdge('A', 'B'));
		System.out.println(graph.containsEdge('B', 'A'));
		System.out.println();
		
		WeightedGraph<Character, Integer> weightedGraph = new WeightedGraph<Character, Integer>();
		weightedGraph.addNode('A');
		weightedGraph.addNode('B');
		weightedGraph.addNode('C');
		weightedGraph.addEdge('A', 'B', 4);
		weightedGraph.addEdge('B', 'C', 3);
		weightedGraph.addEdge('C', 'A', 5);
		
		System.out.println(weightedGraph.containsEdge('A', 'B'));
		System.out.println(weightedGraph.containsEdge('A', 'B', 3));
		System.out.println(weightedGraph.edgesTo('C'));
		System.out.println();
		
		WeightedDirectedGraph<Character, Integer> weightedDirectedGraph = new WeightedDirectedGraph<Character, Integer>();
		weightedDirectedGraph.addNode('A');
		weightedDirectedGraph.addNode('B');
		weightedDirectedGraph.addNode('C');
		weightedDirectedGraph.addEdge('A', 'B', 4);
		weightedDirectedGraph.addEdge('B', 'C', 3);
		weightedDirectedGraph.addEdge('C', 'A', 5);
		
		System.out.println(weightedDirectedGraph.containsEdge('A', 'B', 3));
		System.out.println(weightedDirectedGraph.containsEdge('A', 'B', 4));
		System.out.println(weightedDirectedGraph.edgesTo('C'));
		System.out.println();
	}
}
