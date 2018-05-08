package crackcode;

import foundation.BTNode;
import java.util.ArrayList;

/**
 * CC.TreeGraph.4.5 Validate BST
 * 
 * Question : Implement a function to check if a binary tree is a binary search
 * tree.
 *
 */
public class CC_TreeGraph_4_5_Validate_BST {

	// in-order traverse binary tree and copy nodes to array
	private static void copyBST(BTNode n, ArrayList<Integer> nodes) {
		if (n == null)
			return;

		copyBST(n.left, nodes);
		nodes.add(n.val);
		copyBST(n.right, nodes);
	}

	// check copied array to see if the array is sorted
	public static boolean isBST(BTNode n) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		copyBST(n, nodes);
		for (int i = 1; i < nodes.size(); i++) {
			if (nodes.get(i) < nodes.get(i - 1))
				return false;
		}
		return true;
	}

	// track last node as we traversed the tree and compare with current node
	public static boolean isBST_Opt(BTNode n, Integer prev) {
		if (n == null)
			return true;
		if (!isBST_Opt(n.left, prev))
			return false;

		if (prev != null && n.val < prev)
			return false;

		// set current value as previous
		prev = n.val;

		if (!isBST_Opt(n.right, prev))
			return false;

		return true;
	}

	public static boolean isBST_Min_Max(BTNode n) {
		return checkBST(n, null, null);
	}

	private static boolean checkBST(BTNode n, Integer min, Integer max) {
		if (n == null)
			return true;

		if ((min != null && n.val < min) || (max != null && n.val > max))
			return false;

		if (!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max))
			return false;

		return true;
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

		System.out.println(isBST(root));
		System.out.println(isBST_Opt(root, null));
		System.out.println(isBST_Min_Max(root));
	}

}
