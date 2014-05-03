package elcon.programs.algorithms.graph;

import java.util.Comparator;

public class WeightedEdgeComparator<N> implements Comparator<WeightedEdge<N, Number>>{

	@Override
	public int compare(WeightedEdge<N, Number> edge1, WeightedEdge<N, Number> edge2) {
		return (int) (edge1.weight.doubleValue() - edge2.weight.doubleValue());
	}
}
