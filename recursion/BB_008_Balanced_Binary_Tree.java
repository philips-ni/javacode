package recursion;

import util.BTNode;

/**
 * 
 * BB.Recursion.008 Balanced Binary Tree
 * 
 * Question : Given a binary tree, write a function to determine whether the
 * tree is balanced.
 * 
 * e.g.
 * 
 *
 */
public class BB_008_Balanced_Binary_Tree {

	public static boolean isBalanced(BTNode n) {
		if (balancedHeight(n) > -1)
			return true;
		return false;
	}

	public static int balancedHeight(BTNode n) {
		if (n == null)
			return 0;

		int h1 = balancedHeight(n.right);
		int h2 = balancedHeight(n.left);

		if (h1 == -1 || h2 == -1)
			return -1;

		if (Math.abs(h1 - h2) > 1)
			return -1;

		if (h1 > h2)
			return h1 + 1;

		return h2 + 1;
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
