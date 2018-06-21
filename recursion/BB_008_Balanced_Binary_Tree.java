package recursion;

import util.BTNode;

/**
 * 
 * BB.Recursion.008 Balanced Binary Tree
 * 
 * Question : Given a binary tree, write a function to determine whether the
 * tree is balanced.
 *
 * An empty tree is height-balanced.
 * 
 * A non-empty binary tree T is balanced if:
 * 
 * 1) Left subtree of T is balanced
 * 
 * 2) Right subtree of T is balanced
 * 
 * 3) The difference between heights of left subtree and right subtree is not
 * more than 1.
 * 
 */
public class BB_008_Balanced_Binary_Tree {

	public static boolean isBalanced(BTNode node) {
		if (node == null) // base case : empty tree is balanced
			return true;

		int lh = height(node.left);
		int rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/*
	 * The function Compute the "height" of a tree. Height is the number of nodes
	 * along the longest path from the root node down to the farthest leaf node.
	 */
	private static int height(BTNode node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right heights
		 */
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String[] args) {
		BTNode root = new BTNode();
		root.val = 1;

		BTNode n1 = new BTNode();
		n1.val = 2;

		BTNode n2 = new BTNode();
		n2.val = 3;

		root.left = n1;
		root.right = n2;

		BTNode n3 = new BTNode();
		n3.val = 4;

		BTNode n4 = new BTNode();
		n4.val = 5;

		n1.left = n3;
		n1.right = n4;

		BTNode n5 = new BTNode();
		n5.val = 6;

		BTNode n6 = new BTNode();
		n6.val = 7;

		n3.left = n5;
		n3.right = n6;

		System.out.println(isBalanced(root));
	}
}
