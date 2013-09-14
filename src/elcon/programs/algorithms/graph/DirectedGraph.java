package elcon.programs.algorithms.graph;

public class DirectedGraph<N> extends Graph<N> {

	@Override
	public void addEdge(N from, N to) {
		if(containsNode(from) && containsNode(to) && !containsEdge(from, to)) {
			nodes.get(from).add(new Edge<N>(from, to));
		}
	}
}
