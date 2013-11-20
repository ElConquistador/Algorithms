package elcon.programs.algorithms.graph;

import java.util.List;

public interface IWeightedGraph<N, W> extends Iterable<N> {

	public void addNode(N node);
	
	public void addEdge(N from, N to, W weight);
	
	public boolean containsNode(N node);
	
	public boolean containsEdge(N from, N to);
	
	public boolean containsEdge(N from, N to, W weight);
	
	public boolean containsEdge(WeightedEdge<N, W> edge);
	
	public void removeNode(N node);
	
	public void removeEdge(N from, N to);
	
	public void removeEdge(N from, N to, W weight);
	
	public void removeEdge(WeightedEdge<N, W> edge);
	
	public void removeEdgesFrom(N from);
	
	public void removeEdgesTo(N to);
	
	public void removeEdgesBetween(N from, N to);
	
	public List<N> getNodes();
	
	public List<WeightedEdge<N, W>> edgesFrom(N from);
	
	public List<WeightedEdge<N, W>> edgesTo(N to);
	
	public List<WeightedEdge<N, W>> edgesBetween(N from, N to);

	public int size();

	public boolean isEmpty();
}
