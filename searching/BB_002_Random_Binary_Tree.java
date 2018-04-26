package searching;

import java.util.Random;

/**
 * BB.Searching.002 Random Binary Tree
 * 
 * Question : Implement a binary tree with a method getRandomNode() that returns
 * a random node.
 * 
 */
public class BB_002_Random_Binary_Tree {
	private class Node {
		Node left;
		Node right;
		int val;
		int children;
	}

	public int getRandomNode() {
		Node root = initTree();
		if (root == null)
			throw new NullPointerException();
		Random rand = new Random();
		int nNodes = numNodes(root);
		int index = rand.nextInt(nNodes); // Get random index [0 , nNodes)
		System.out.println("index : " + index);
		int val = getRandomNode(root, index);
		System.out.println("value : " + val);
		return val;
	}

	private int getRandomNode(Node n, int index) {
		if (index == numNodes(n.left))
			return n.val;

		if (index < numNodes(n.left))
			return getRandomNode(n.left, index);

		return getRandomNode(n.right, index - numNodes(n.left) - 1);
	}

	/**
	 * Get number of nodes of a subtree
	 */
	private int numNodes(Node n) {
		if (n == null)
			return 0;
		return n.children + 1;
	}

	public Node initTree() {
		Node root = new Node();
		root.val = 5;
		root.children = 6;

		Node n1 = new Node();
		n1.val = 2;
		n1.children = 2;

		Node n2 = new Node();
		n2.val = 1;
		n2.children = 0;

		Node n3 = new Node();
		n3.val = 3;
		n3.children = 0;

		Node n4 = new Node();
		n4.val = 7;
		n4.children = 2;

		Node n5 = new Node();
		n5.val = 6;
		n5.children = 0;

		Node n6 = new Node();
		n6.val = 8;
		n6.children = 0;

		root.left = n1;
		root.right = n4;

		n1.left = n2;
		n1.right = n3;

		n4.left = n5;
		n4.right = n6;

		return root;

	}

	public static void main(String[] args) {
		BB_002_Random_Binary_Tree sol = new BB_002_Random_Binary_Tree();
		sol.getRandomNode();
	}
}
