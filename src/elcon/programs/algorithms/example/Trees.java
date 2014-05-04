package elcon.programs.algorithms.example;

import elcon.programs.algorithms.tree.Tree;

public class Trees {

	public static void main(String[] args) {
		Tree<Integer> binaryTree = new Tree<Integer>(2, Tree.getHeight(10));
		for(int i = 0; i < 10; i++) {
			binaryTree.set(i, i + 1);
		}
		System.out.println(binaryTree);
		System.out.println(binaryTree.getChild(2, 1));
		System.out.println(binaryTree.getParent(binaryTree.getChildIndex(2, 1)));
	}
}
