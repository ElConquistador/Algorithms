package elcon.programs.algorithms.graph;

public class WeightedDirectedGraph<N, W> extends WeightedGraph<N, W> {

	@Override
	public void addEdge(N from, N to, W weight) {
		if(containsNode(from) && containsNode(to) && !containsEdge(from, to)) {
			nodes.get(from).add(new WeightedEdge<N, W>(from, to, weight));
		}
	}
}
