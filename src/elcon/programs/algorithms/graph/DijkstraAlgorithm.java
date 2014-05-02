package elcon.programs.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DijkstraAlgorithm<N> {
	
	public HashMap<N, Node<N>> nodes = new HashMap<N, Node<N>>();
	public N source;
	public N target;
	public ArrayList<Node<N>> path = new ArrayList<Node<N>>();
	
	public DijkstraAlgorithm(IWeightedGraph<N, Number> graph, N source, N target) {
		for(N node : graph) {
			nodes.put(node, new Node<N>(node, Double.MAX_VALUE));
		}
		nodes.get(source).distance = 0;
		
		HashSet<N> nodesToVisit = new HashSet<N>();
		nodesToVisit.add(source);
		
		while(!nodesToVisit.isEmpty()) {
			double distance = Double.MAX_VALUE;
			N current = null;
			for(N n : nodesToVisit) {
				if(!nodes.get(n).visited && nodes.get(n).distance < distance) {
					distance = nodes.get(n).distance;
					current = n;
				}
			}
			nodesToVisit.remove(current);
			nodes.get(current).visited = true;
			double currentDistance = nodes.get(current).distance;
			List<WeightedEdge<N, Number>> adjacentEdges = graph.edgesFrom(current);
			for(WeightedEdge<N, Number> edge : adjacentEdges) {
				double newDistance = currentDistance + edge.weight.doubleValue();
				if(newDistance < nodes.get(edge.to).distance) {
					nodes.get(edge.to).distance = newDistance;
					nodes.get(edge.to).previousNode = nodes.get(current);
					if(!nodes.get(edge.to).visited) {
						nodesToVisit.add(edge.to);
					}
				}
			}
		}
		ArrayList<Node<N>> tempPath = new ArrayList<Node<N>>();
		Node<N> node = nodes.get(target);
		while(node != null) {
			tempPath.add(node);
			node = node.previousNode;
		}
		Collections.reverse(tempPath);
		path = tempPath;
	}
	
	public ArrayList<Node<N>> getPath() {
		return path;
	}

	public String getPathString() {
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
