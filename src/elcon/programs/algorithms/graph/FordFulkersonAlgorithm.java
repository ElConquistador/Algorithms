package elcon.programs.algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FordFulkersonAlgorithm<N> {

	public HashMap<WeightedEdge<N, ? extends Number>, Double> flow = new HashMap<WeightedEdge<N, ? extends Number>, Double>();
	public double maxFlow;
	
	public FordFulkersonAlgorithm(IWeightedGraph<N, Number> originalGraph, N source, N sink) {		
		WeightedGraph<N, Number> graph = new WeightedGraph<N, Number>(true);	
		
		List<WeightedEdge<N, Number>> edges = originalGraph.getEdges();
		for(WeightedEdge<N, Number> edge : edges) {
			graph.addNode(edge.from);
			graph.addNode(edge.to);
			graph.addEdge(edge.from, edge.to, edge.weight);
			graph.addEdge(edge.to, edge.from, 0.0);
			flow.put(graph.edgesBetween(edge.from, edge.to).get(0), 0.0);
			flow.put(graph.edgesBetween(edge.to, edge.from).get(0), 0.0);
		}
		List<WeightedEdge<N, Number>> path = null;
		while((path = findPath(graph, source, sink, source, new LinkedList<WeightedEdge<N, Number>>())) != null) {
			double minCapacity = Double.MAX_VALUE;
			for(WeightedEdge<N, Number> edge : path) {
				minCapacity = Math.min(minCapacity, edge.weight.doubleValue() - flow.get(edge));
			}
			for(WeightedEdge<N, Number> edge : path) {
				flow.put(graph.edgesBetween(edge.from, edge.to).get(0), (flow.containsKey(graph.edgesBetween(edge.from, edge.to).get(0)) ? flow.get(graph.edgesBetween(edge.from, edge.to).get(0)) : 0) + minCapacity);
				flow.put(graph.edgesBetween(edge.to, edge.from).get(0), (flow.containsKey(graph.edgesBetween(edge.to, edge.from).get(0)) ? flow.get(graph.edgesBetween(edge.to, edge.from).get(0)) : 0) - minCapacity);
			}
		}
		maxFlow = 0.0;
		edges = originalGraph.edgesFrom(source);
		for(WeightedEdge<N, Number> edge : edges) {
			maxFlow += flow.get(graph.edgesBetween(edge.from, edge.to).get(0));
		}
	}
		
	public List<WeightedEdge<N, Number>> findPath(IWeightedGraph<N, Number> graph, N source, N target, N current, LinkedList<WeightedEdge<N, Number>> path) {
		if(current == target) {
			return path;
		} else {
			List<WeightedEdge<N, Number>> edges = graph.edgesFrom(current);
			for(WeightedEdge<N, Number> edge : edges) {
				if(edge.weight.doubleValue() - flow.get(edge) > 0 && !path.contains(edge)) {
					path.add(edge);
					List<WeightedEdge<N, Number>> newPath = findPath(graph, source, target, edge.to, path);
					if(newPath != null) {
						return newPath;
					}
					path.remove(edge);
				}
			}
			return null;
		}
	}
	
	public double getMaxFlow() {
		return maxFlow;
	}
}
