package elcon.programs.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm<N> {

	public List<?> result;
	
	public KruskalAlgorithm(IGraph<N> graph) {
		List<Edge<N>> edges = graph.getEdges();
		ArrayList<Graph<N>> trees = new ArrayList<Graph<N>>();
		for(N node : graph.getNodes()) {
			Graph<N> tree = new Graph<N>();
			tree.addNode(node);
			trees.add(tree);
		}
		while(edges.size() > 0) {
			Edge<N> edge = edges.get(0);
			int from = -1;
			int to = -1;
			for(int i = 0; i < trees.size(); i++) {
				if(trees.get(i) != null) {
					if(from == -1 && trees.get(i).containsNode(edge.from)) {
						from = i;
					}
					if(to == -1 && trees.get(i).containsNode(edge.to)) {
						to = i;
					}
					if(from != -1 && to != -1) {
						break;
					}
				}
			}
			if(from != to) {
				Graph<N> treeFrom = trees.get(from);
				Graph<N> treeTo = trees.get(to);
				for(N node : treeTo) {
					treeFrom.addNode(node);
				}
				for(Edge<N> e : treeTo.getEdges()) {
					treeFrom.addEdge(e.from, e.to);
				}
				treeFrom.addEdge(edge.from, edge.to);
				trees.remove(to);
			}
			edges.remove(0);
		}
		result = trees;
	}
	
	public KruskalAlgorithm(IWeightedGraph<N, Number> graph) {
		List<WeightedEdge<N, Number>> edges = graph.getEdges();
		Collections.sort(edges, new WeightedEdgeComparator<N>());
		ArrayList<WeightedGraph<N, Number>> trees = new ArrayList<WeightedGraph<N, Number>>();
		for(N node : graph.getNodes()) {
			WeightedGraph<N, Number> tree = new WeightedGraph<N, Number>();
			tree.addNode(node);
			trees.add(tree);
		}
		while(edges.size() > 0) {
			WeightedEdge<N, Number> edge = edges.get(0);
			int from = -1;
			int to = -1;
			for(int i = 0; i < trees.size(); i++) {
				if(trees.get(i) != null) {
					if(from == -1 && trees.get(i).containsNode(edge.from)) {
						from = i;
					}
					if(to == -1 && trees.get(i).containsNode(edge.to)) {
						to = i;
					}
					if(from != -1 && to != -1) {
						break;
					}
				}
			}
			if(from != to) {
				WeightedGraph<N, Number> treeFrom = trees.get(from);
				WeightedGraph<N, Number> treeTo = trees.get(to);
				for(N node : treeTo) {
					treeFrom.addNode(node);
				}
				for(WeightedEdge<N, Number> e : treeTo.getEdges()) {
					treeFrom.addEdge(e.from, e.to, e.weight);
				}
				treeFrom.addEdge(edge.from, edge.to, edge.weight);
				trees.remove(to);
			}
			edges.remove(0);
		}
		result = trees;
	}
	
	public List<IGraph<N>> getMinimumGraphs() {
		return result != null && result.size() > 0 && result.get(0) instanceof IGraph<?> ? (List<IGraph<N>>) result : null;
	}
	
	public List<IWeightedGraph<N, Number>> getMinimumWeightedGraphs() {
		return result != null && result.size() > 0 && result.get(0) instanceof IWeightedGraph<?, ?> ? (List<IWeightedGraph<N, Number>>) result : null;
	}
}
