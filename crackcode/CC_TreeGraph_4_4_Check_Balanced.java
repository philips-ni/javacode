package crackcode;

import util.BTNode;

/**
 * CC.TreeGraph.4.4 Check Balanced
 * 
 * Question : Implement a function to check if a binary tree is balanced. For
 * the purposes of this question, a balanced tree is defined to be a tree such
 * that the heights of the two subtree of any node never differ by more than
 * one.
 *
 */
public class CC_TreeGraph_4_4_Check_Balanced {

	private static int getHeight(BTNode n) {
		if (n == null)
			return 0 ;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}

	public static boolean isBalanced(BTNode n) {
		if (n == null)
			return true;

		int leftHeight = getHeight(n.left);
		int rightHeight= getHeight(n.right);
		int diff = leftHeight - rightHeight;
		System.out.println(leftHeight+" "+rightHeight+" "+diff);
		//int diff = getHeight(n.left) - getHeight(n.right);
		if (Math.abs(diff) > 1)
			return false;
		else
			return isBalanced(n.left) && isBalanced(n.right);
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(4);
		BTNode n1 = new BTNode(1);
		BTNode n2 = new BTNode(2);
		BTNode n3 = new BTNode(3);
		BTNode n5 = new BTNode(5);
		BTNode n6 = new BTNode(6);
		BTNode n7 = new BTNode(7);

		root.left = n2;
		root.right = n6;

		n2.left = n1;
		n2.right = n3;

		n6.left = n5;
		n6.right = n7;
		
		isBalanced(root);
	}

}
