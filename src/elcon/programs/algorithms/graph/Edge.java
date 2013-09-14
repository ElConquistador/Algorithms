package elcon.programs.algorithms.graph;

public class Edge<N> {

	public N from;
	public N to;
	
	public Edge(N from, N to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Edge<?>)) {
			return false;
		}
		Edge<?> edge = (Edge<?>) object;
		return from.equals(edge.from) && to.equals(edge.to);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Edge from %s to %s", from, to));
		return sb.toString();
	}
}
