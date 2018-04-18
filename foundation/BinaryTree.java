package foundation;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	/**
	 * Using nested Node class to store the node including data element, left
	 * pointer and right pointer. The left and right pointers can be null.
	 */
	private class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	private Node root; // Root Node pointer. Can be null.

	/**
	 * Construct a empty tree
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * This is used to create non-binary tree for testing purpose.
	 */
	public Node createNode(int value) {
		Node newNode = new Node(value);
		return newNode;
	}

	/**
	 * Get the BST size
	 */
	public int size(Node node) {
		if (node == null)
			return 0;
		else {
			return size(node.left) + 1 + size(node.right);
		}
	}

	/**
	 * Get BST depth
	 */
	public int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int ldepth = maxDepth(node.left);
			int rdepth = maxDepth(node.right);

			return (Math.max(ldepth, rdepth) + 1);
		}
	}

	/**
	 * Lookup the path from root to leaf such that adding up all the values
	 * along the path equals to given sum.
	 */
	public boolean hasPathSum(Node node, int sum) {
		if (node == null) {
			return (sum == 0);
		} else {
			sum = sum - node.data;
			return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
		}
	}

	/**
	 * Lookup target value in the binary tree
	 */
	public boolean lookup(Node node, int target) {

		if (node == null)
			return false;

		if (node.data == target) {
			System.out.print(target);
			return true; // found the target node
		}

		if (target < node.data) {
			// search left subtree
			System.out.print(node.data + "->");
			return lookup(node.left, target);
		} else {
			// search right subtree
			System.out.print(node.data + "->");
			return lookup(node.right, target);
		}
	}

	/**
	 * Insert the target value to the binary tree
	 */
	public Node insert(Node node, int target) {
		if (node == null) {
			// reach the leaf node and insert target node here
			node = new Node(target);
			System.out.println("Insert target : " + target);
		} else {
			if (target <= node.data) {
				// search left subtree
				node.left = insert(node.left, target);
			} else {
				// search right subtree
				node.right = insert(node.right, target);
			}
		}

		return node;
	}

	/**
	 * preorder traverse
	 */
	public void preorderPrint(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorderPrint(node.left);
		preorderPrint(node.right);
	}

	/**
	 * inorder traverse
	 */
	public void inorderPrint(Node node) {
		if (node == null)
			return;
		inorderPrint(node.left);
		System.out.print(node.data + " ");
		inorderPrint(node.right);
	}

	/**
	 * postorder traverse
	 */
	public void postorderPrint(Node node) {
		if (node == null)
			return;
		postorderPrint(node.left);
		postorderPrint(node.right);
		System.out.print(node.data + " ");
	}

	/**
	 * Given a binary tree, prints out all of its root-to-leaf paths, one path
	 * per line.
	 */
	public void printPathsWrong(Node node, List<Node> nodelist) {
		if (node == null) {
			return;
		}
		nodelist.add(node);

		if (node.left == null && node.right == null) {
			// found leaf node and print path here
			for (int i = 0; i < nodelist.size(); i++) {
				System.out.print(nodelist.get(i).data + " ");
			}
			System.out.println();
		} else {
			printPathsWrong(node.left, nodelist);
			printPathsWrong(node.right, nodelist);
		}
	}
	
	public void printPathsCorrect(Node node, List<Node> nodelist) {
		if (node == null) {
			return;
		}
		nodelist.add(node);

		if (node.left == null && node.right == null) {
			// found leaf node and print path here
			for (int i = 0; i < nodelist.size(); i++) {
				System.out.print(nodelist.get(i).data + " ");
			}
			System.out.println();
		} else {
			printPathsCorrect(node.left, new ArrayList(nodelist));
			printPathsCorrect(node.right, new ArrayList(nodelist));
		}
	}

	private void printPaths(Node node, List<Node> nodelist) {
		if (node == null)
			return;

		nodelist.add(node);

		if (node.left == null && node.right == null) {
			// found leaf node and print path here
			for (int i = 0; i < nodelist.size(); i++) {
				System.out.print(nodelist.get(i).data + " ");
			}
			System.out.println();
		} else {
			printPaths(node.left, nodelist);
			printPaths(node.right, nodelist);
		}

		// remove the node which has been printed in recursive path
		nodelist.remove(node);

	}

	private void printPaths(Node node, int[] path, int pathLen) {
		if (node == null)
			return;

		// append this node to the path array
		path[pathLen] = node.data;
		pathLen++;

		if (node.left == null && node.right == null) {
			// found leaf node and print path here
			for (int i = 0; i < pathLen; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
		} else {
			// otherwise try both subtrees
			printPaths(node.left, path, pathLen);
			printPaths(node.right, path, pathLen);
		}
	}

	/**
	 * Simple but wrong method
	 * 
	 * example:
	 * 
	 * 3
	 * 
	 * 2 5
	 * 
	 * 1 4 6
	 * 
	 * To correct, the max of left subtree should be smaller than current node
	 * and the min of right subtree should be greater than current node.
	 */
	public boolean isBSTWrong(Node node) {
		if (node == null)
			return true;

		if (node.left != null && node.data < node.left.data)
			return false;

		if (node.right != null && node.data > node.right.data)
			return false;

		if (!isBST(node.left) || !isBST(node.right))
			return false;

		return true;
	}

	/**
	 * Get min value of the tree
	 */
	public int minValue(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	/**
	 * Get max value of the tree
	 */
	public int maxValue(Node node) {
		Node current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	/**
	 * Correct but not efficient because it traverses some parts of tree
	 * multiple times.
	 */
	public boolean isBST(Node node) {
		if (node == null)
			return true;

		if (node.left != null && node.data < maxValue(node.left))
			return false;

		if (node.right != null && node.data > minValue(node.right))
			return false;

		if (!isBST(node.left) || !isBST(node.right))
			return false;

		return true;
	}

	/**
	 * Correct and efficient method since each node is only accessed once.
	 * 
	 * Use min and max value to narrow down the range for each node.
	 * 
	 * Initial range is Ineteger.MIN and Integer.MAX
	 */
	public boolean isBST(Node node, int min, int max) {
		if (node == null)
			return true;

		if (node.data < min || node.data > max)
			return false;

		return (isBST(node.left, min, node.data) && isBST(node.right, node.data, max));
	}

	public static void main(String[] args) {
		// Sample BST
		//
		// 4
		//
		// 2 5
		//
		// 1 3 6

		BinaryTree bt = new BinaryTree();
		bt.root = bt.insert(null, 4);
		bt.insert(bt.root, 2);
		bt.insert(bt.root, 5);
		bt.insert(bt.root, 1);
		bt.insert(bt.root, 3);
		bt.insert(bt.root, 6);

		System.out.println("Path for 3 :");
		bt.lookup(bt.root, 3);

		System.out.println("");
		System.out.println("Preorder print : ");
		bt.preorderPrint(bt.root);

		System.out.println("");
		System.out.println("Inorder print : ");
		bt.inorderPrint(bt.root);

		System.out.println("");
		System.out.println("Postorder print : ");
		bt.postorderPrint(bt.root);

		System.out.println("");
		System.out.println("Postorder print : ");
		bt.postorderPrint(bt.root);

		System.out.println("");
		System.out.println("Min value : " + bt.minValue(bt.root));

		System.out.println("");
		System.out.println("Max value : " + bt.maxValue(bt.root));

		System.out.println("");
		System.out.println("BST size : " + bt.size(bt.root));

		System.out.println("");
		System.out.println("BST depth : " + bt.maxDepth(bt.root));

		System.out.println("");
		int sum = 19;
		if (bt.hasPathSum(bt.root, sum)) {
			System.out.println("Found path for gvien sum " + sum);
		} else {
			System.out.println("Can't find path for gvien sum " + sum);
		}

		System.out.println("Looking for paths (wrong method): ");
		List<Node> nodelist = new ArrayList<Node>();
		bt.printPathsWrong(bt.root, nodelist);
		
		System.out.println("Looking for paths (correct method): ");
		nodelist.clear();
		bt.printPathsCorrect(bt.root, nodelist);

		System.out.println("");
		System.out.println("Looking for paths(method 1) : ");
		nodelist.clear();
		bt.printPaths(bt.root, nodelist);

		System.out.println("");
		System.out.println("Looking for paths(method 2) : ");
		int[] path = new int[1000];
		bt.printPaths(bt.root, path, 0);

		Node root1 = bt.createNode(3);
		root1.left = bt.createNode(2);
		root1.right = bt.createNode(5);
		root1.left.left = bt.createNode(1);
		root1.left.right = bt.createNode(4);

		System.out.println("");
		if (bt.isBSTWrong(root1)) {
			System.out.println("This is a BST.(Unexpected result)");
		} else {
			System.out.println("This is not a BST.");
		}

		System.out.println("");
		if (bt.isBST(root1)) {
			System.out.println("This is a BST.(Expected result)");
		} else {
			System.out.println("This is not a BST.");
		}

		System.out.println("");
		if (bt.isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("This is a BST.(Expected result)");
		} else {
			System.out.println("This is not a BST.");
		}

	}
}
