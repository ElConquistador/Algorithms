package elcon.programs.algorithms.graph;

import java.util.List;

public interface IGraph<N> extends Iterable<N> {

	public void addNode(N node);
	
	public void addEdge(N from, N to);
	
	public boolean containsNode(N node);
	
	public boolean containsEdge(N from, N to);
	
	public boolean containsEdge(Edge<N> edge);
	
	public void removeNode(N node);
	
	public void removeEdge(N from, N to);
	
	public void removeEdge(Edge<N> edge);
	
	public void removeEdgesFrom(N from);
	
	public void removeEdgesTo(N to);
	
	public void removeEdgesBetween(N from, N to);
	
	public List<N> getNodes();
	
	public List<Edge<N>> edgesFrom(N from);
	
	public List<Edge<N>> edgesTo(N to);

	public int size();

	public boolean isEmpty();
}
