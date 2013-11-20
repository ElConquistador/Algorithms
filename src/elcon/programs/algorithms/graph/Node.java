package elcon.programs.algorithms.graph;

public class Node<N> {
	
	public N node;
	
	public boolean visited;
	public Node<N> previousNode;
	public double distance;
	
	public Node(N node) {
		this.node = node;
	}

	public Node(N node, double distance) {
		this(node);
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return node.toString();
	}
}
