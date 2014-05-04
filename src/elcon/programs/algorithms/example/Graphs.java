package elcon.programs.algorithms.example;

import elcon.programs.algorithms.graph.BellmanFordAlgorithm;
import elcon.programs.algorithms.graph.DijkstraAlgorithm;
import elcon.programs.algorithms.graph.FordFulkersonAlgorithm;
import elcon.programs.algorithms.graph.Graph;
import elcon.programs.algorithms.graph.IWeightedGraph;
import elcon.programs.algorithms.graph.KruskalAlgorithm;
import elcon.programs.algorithms.graph.PrimAlgorithm;
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
		
		WeightedGraph<Character, Integer> weightedDirectedGraph = new WeightedGraph<Character, Integer>(true);
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
		
		BellmanFordAlgorithm<Character> bellmanFord = new BellmanFordAlgorithm<Character>(weightedGraph2, 'A');
		System.out.println(bellmanFord.getPathString('E'));
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
		
		WeightedGraph<Character, Number> weightedDirectedGraph2 = new WeightedGraph<Character, Number>(true);
		weightedDirectedGraph2.addNode('A');
		weightedDirectedGraph2.addNode('B');
		weightedDirectedGraph2.addNode('C');
		weightedDirectedGraph2.addNode('D');
		weightedDirectedGraph2.addNode('E');
		weightedDirectedGraph2.addNode('F');
		weightedDirectedGraph2.addEdge('A', 'B', 7);
		weightedDirectedGraph2.addEdge('A', 'C', 9);
		weightedDirectedGraph2.addEdge('A', 'F', 14);
		weightedDirectedGraph2.addEdge('B', 'C', 10);
		weightedDirectedGraph2.addEdge('B', 'D', 15);
		weightedDirectedGraph2.addEdge('C', 'D', 11);
		weightedDirectedGraph2.addEdge('C', 'F', 2);
		weightedDirectedGraph2.addEdge('D', 'E', 6);
		weightedDirectedGraph2.addEdge('E', 'F', 9);
		
		PrimAlgorithm<Character> prim2 = new PrimAlgorithm<Character>(weightedDirectedGraph2);
		System.out.println("Edges: " + weightedDirectedGraph2.getEdges().size());
		System.out.println("Minimum Edges: " + prim2.getMinimumWeightedGraph().getEdges().size());
		System.out.println();
		
		KruskalAlgorithm<Character> kruskal2 = new KruskalAlgorithm<Character>(weightedDirectedGraph2);		
		System.out.println("Edges: " + weightedDirectedGraph2.getEdges().size());
		for(IWeightedGraph<Character, Number> tree : kruskal2.getMinimumWeightedGraphs()) {
			System.out.println("Minimum Edges: " + tree.getEdges().size());
		}
		System.out.println();
		
		WeightedGraph<Character, Number> weightedDirectedGraph3 = new WeightedGraph<Character, Number>(true);
		weightedDirectedGraph3.addNode('O');
		weightedDirectedGraph3.addNode('P');
		weightedDirectedGraph3.addNode('Q');
		weightedDirectedGraph3.addNode('R');
		weightedDirectedGraph3.addNode('S');
		weightedDirectedGraph3.addNode('T');
		weightedDirectedGraph3.addEdge('S', 'O', 3);
		weightedDirectedGraph3.addEdge('S', 'P', 3);
		weightedDirectedGraph3.addEdge('O', 'P', 2);
		weightedDirectedGraph3.addEdge('O', 'Q', 3);
		weightedDirectedGraph3.addEdge('P', 'R', 2);
		weightedDirectedGraph3.addEdge('R', 'T', 3);
		weightedDirectedGraph3.addEdge('Q', 'R', 4);
		weightedDirectedGraph3.addEdge('Q', 'T', 2);
		
		FordFulkersonAlgorithm<Character> fordFulkerson = new FordFulkersonAlgorithm<Character>(weightedDirectedGraph3, 'S', 'T');
		System.out.println(fordFulkerson.getMaxFlow());
		System.out.println();
		
		WeightedGraph<Character, Number> weightedDirectedGraph4 = new WeightedGraph<Character, Number>(true);
		weightedDirectedGraph4.addNode('A');
		weightedDirectedGraph4.addNode('B');
		weightedDirectedGraph4.addNode('C');
		weightedDirectedGraph4.addNode('D');
		weightedDirectedGraph4.addEdge('A', 'B', 1000);
		weightedDirectedGraph4.addEdge('A', 'C', 1000);
		weightedDirectedGraph4.addEdge('B', 'C', 1);
		weightedDirectedGraph4.addEdge('B', 'D', 1000);
		weightedDirectedGraph4.addEdge('C', 'D', 1000);
		
		FordFulkersonAlgorithm<Character> fordFulkerson2 = new FordFulkersonAlgorithm<Character>(weightedDirectedGraph4, 'A', 'D');
		System.out.println(fordFulkerson2.getMaxFlow());
		System.out.println();
	}
}
