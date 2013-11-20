package elcon.programs.algorithms.graph;

public class DirectedGraph<N> extends Graph<N> {

	@Override
	public void addEdge(N from, N to) {
		if(containsNode(from) && containsNode(to) && !containsEdge(from, to)) {
			nodes.get(from).add(new Edge<N>(from, to));
		}
	}
	
	public void addEdge(Edge<N> edge) {
		if(containsNode(edge.from) && containsNode(edge.to) && !containsEdge(edge.from, edge.to)) {
			nodes.get(edge.from).add(edge);
		}
	}
}
