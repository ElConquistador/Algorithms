package elcon.programs.algorithms.example;

import elcon.programs.algorithms.graph.DijkstraAlgorithm;
import elcon.programs.algorithms.graph.Graph;
import elcon.programs.algorithms.graph.IWeightedGraph;
import elcon.programs.algorithms.graph.KruskalAlgorithm;
import elcon.programs.algorithms.graph.PrimAlgorithm;
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
		System.out.println(graph.areConnected('A', 'B'));
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
		System.out.println(weightedGraph.areConnected('A', 'C'));
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
		System.out.println(weightedDirectedGraph.areConnected('A', 'C'));
		System.out.println();
		
		WeightedGraph<Character, Number> weightedGraph2 = new WeightedGraph<Character, Number>();
		weightedGraph2.addNode('A');
		weightedGraph2.addNode('B');
		weightedGraph2.addNode('C');
		weightedGraph2.addNode('D');
		weightedGraph2.addNode('E');
		weightedGraph2.addNode('F');
		weightedGraph2.addEdge('A', 'B', 7);
		weightedGraph2.addEdge('A', 'C', 9);
		weightedGraph2.addEdge('A', 'F', 14);
		weightedGraph2.addEdge('B', 'C', 10);
		weightedGraph2.addEdge('B', 'D', 15);
		weightedGraph2.addEdge('C', 'D', 11);
		weightedGraph2.addEdge('C', 'F', 2);
		weightedGraph2.addEdge('D', 'E', 6);
		weightedGraph2.addEdge('E', 'F', 9);
		
		DijkstraAlgorithm<Character> dijkstra = new DijkstraAlgorithm<Character>(weightedGraph2, 'A', 'E');
		System.out.println(dijkstra.getPathString());
		System.out.println();
		
		PrimAlgorithm<Character> prim = new PrimAlgorithm<Character>(weightedGraph2);
		System.out.println("Edges: " + (weightedGraph2.getEdges().size() / 2));
		System.out.println("Minimum Edges: " + (prim.getMinimumWeightedGraph().getEdges().size() / 2));
		System.out.println();
		
		KruskalAlgorithm<Character> kruskal = new KruskalAlgorithm<Character>(weightedGraph2);		
		System.out.println("Edges: " + (weightedGraph2.getEdges().size() / 2));
		for(IWeightedGraph<Character, Number> tree : kruskal.getMinimumWeightedGraphs()) {
			System.out.println("Minimum Edges: " + (tree.getEdges().size() / 2));
		}
		System.out.println();
	}
}
