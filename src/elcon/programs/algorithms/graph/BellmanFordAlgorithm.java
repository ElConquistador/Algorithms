package elcon.programs.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BellmanFordAlgorithm<N> {

	public HashMap<N, Node<N>> nodes = new HashMap<N, Node<N>>();
	public N source;
	public HashMap<N, List<Node<N>>> paths = new HashMap<N, List<Node<N>>>();
	
	public BellmanFordAlgorithm(IWeightedGraph<N, Number> graph, N source) {
		for(N node : graph) {
			nodes.put(node, new Node<N>(node, Double.MAX_VALUE));
		}
		nodes.get(source).distance = 0;
		
		List<WeightedEdge<N, Number>> edges = graph.getEdges();
		for(int i = 1; i < graph.size(); i++) {
			for(WeightedEdge<N, Number> edge : edges) {
				if(nodes.get(edge.from).distance + edge.weight.doubleValue() < nodes.get(edge.to).distance) {
					nodes.get(edge.to).distance = nodes.get(edge.from).distance + edge.weight.doubleValue();
					nodes.get(edge.to).previousNode = nodes.get(edge.from);
				}
			}
		}
		
		for(WeightedEdge<N, Number> edge : edges) {
			if(nodes.get(edge.from).distance + edge.weight.doubleValue() < nodes.get(edge.to).distance) {
				System.err.println("Graph contains a negative-weight cycle");
				return;
			}
		}
		
		for(N node : graph) {
			ArrayList<Node<N>> tempPath = new ArrayList<Node<N>>();
			Node<N> current = nodes.get(node);
			while(current != null) {
				tempPath.add(current);
				current = current.previousNode;
			}
			Collections.reverse(tempPath);
			paths.put(node, tempPath);
		}
	}
	
	public List<Node<N>> getPath(N target) {
		return paths.get(target);
	}
	
	public String getPathString(N target) {
		List<Node<N>> path = getPath(target);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < path.size(); i++) {
			sb.append(path.get(i));
			if(i < path.size() - 1) {
				sb.append(" --> ");
			}
		}
		return sb.toString();
	}
}
