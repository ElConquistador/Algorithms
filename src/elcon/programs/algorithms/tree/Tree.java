package elcon.programs.algorithms.tree;

import java.util.Arrays;

public class Tree<N> {

	public int maxChilds;
	public int height;
	public N[] tree;
	
	public Tree(int maxChilds, int height) {
		this.maxChilds = maxChilds;
		this.height = height;
		tree = (N[]) new Object[(int) Math.pow(maxChilds, height)];
	}
	
	public int getParentIndex(int index) {
		return (index - 1) / maxChilds;
	}
	
	public int getChildIndex(int index, int child) {
		return maxChilds * index + 1 + child;
	}
	
	public N get(int index) {
		return tree[index];
	}
	
	public N getParent(int index) {
		return tree[getParentIndex(index)];
	}
	
	public N getChild(int index, int child) {
		return tree[getChildIndex(index, child)];
	}
	
	public N[] getChilds(int index) {
		return Arrays.copyOfRange(tree, getChildIndex(index, 0), getChildIndex(index, maxChilds - 1));
	}
	
	public void set(int index, N value) {
		tree[index] = value;
	}
	
	public void setParent(int index, N value) {
		tree[getParentIndex(index)] = value;
	}
	
	public void setChild(int index, int child, N value) {
		tree[getChildIndex(index, child)] = value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < tree.length; i++) {
			sb.append(tree[i] != null ? tree[i].toString() : "null");
			if(i < tree.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static int getHeight(int amount) {
		return (int) Math.ceil(Math.log(amount) / Math.log(2));
	}
}
