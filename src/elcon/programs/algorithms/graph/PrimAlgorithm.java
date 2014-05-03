package elcon.programs.algorithms.graph;

import java.util.List;

public class PrimAlgorithm<N> {

	public Object result;
	
	public PrimAlgorithm(IGraph<N> graph) {
		Graph<N> minimumGraph = new Graph<N>();
		minimumGraph.addNode(graph.getNodes().get(0));
		while(!minimumGraph.getNodes().containsAll(graph.getNodes())) {
			List<Edge<N>> edges = graph.edgesFrom(minimumGraph.getNodes().toArray((N[]) new Object[minimumGraph.getNodes().size()]));
			for(Edge<N> edge : edges) {
				if(!minimumGraph.containsNode(edge.to)) {
					minimumGraph.addNode(edge.to);
					minimumGraph.addEdge(edge.from, edge.to);
					break;
				}
			}
		}
		result = minimumGraph;
	}
	
	public PrimAlgorithm(IWeightedGraph<N, Number> graph) {
		WeightedGraph<N, Number> minimumGraph = new WeightedGraph<N, Number>();
		minimumGraph.addNode(graph.getNodes().get(0));
		while(!minimumGraph.getNodes().containsAll(graph.getNodes())) {
			List<WeightedEdge<N, Number>> edges = graph.edgesFrom(minimumGraph.getNodes().toArray((N[]) new Object[minimumGraph.getNodes().size()]));
			double best = Double.POSITIVE_INFINITY;
			WeightedEdge<N, Number> bestEdge = null;
			for(WeightedEdge<N, Number> edge : edges) {
				if(edge.weight.doubleValue() < best && !minimumGraph.containsNode(edge.to)) {
					best = edge.weight.doubleValue();
					bestEdge = edge;
				}
			}
			if(bestEdge != null) {
				minimumGraph.addNode(bestEdge.to);
				minimumGraph.addEdge(bestEdge.from, bestEdge.to, bestEdge.weight);
			}
		}
		result = minimumGraph;
	}
	
	public IGraph<N> getMinimumGraph() {
		return result instanceof IGraph<?> ? (IGraph<N>) result : null;
	}
	
	public IWeightedGraph<N, Number> getMinimumWeightedGraph() {
		return result instanceof IWeightedGraph<?, ?> ? (IWeightedGraph<N, Number>) result : null;
	}
}
