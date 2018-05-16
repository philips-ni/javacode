package recursion;

import util.BTNode;

/**
 * 
 * BB.Recursion.006 Longest Consecutive Branch
 * 
 * Question : Given a tree, write a function to find the length of the longest branch of nodes in increasing consecutive order.
 *
 * e.g.
 *         0
 *       1   2
 *      1 2 1 3 
 *      
 */
public class BB_006_Longest_Consecutive_Branch {

	public static int consecutive(BTNode n) {
		if (n == null)
			return 0;
		return max(consecutive(n.left, n.val, 1), consecutive(n.right, n.val, 1));
	}

	public static int consecutive(BTNode n, int prev, int length) {
		if (n == null)
			return length;
		if (n.val == prev + 1) {
			int leftLength = consecutive(n.left, n.val, length + 1);
			int rightLength = consecutive(n.right, n.val, length + 1);
			return max(leftLength, rightLength);
		} else {
			int leftLength = consecutive(n.left, n.val, 1);
			int rightLength = consecutive(n.right, n.val, 1);
			return max(leftLength, rightLength, length);
		}
	}

	public static int max(int... vals) {
		int max = Integer.MIN_VALUE;
		for (int x : vals) {
			if (x > max)
				max = x;
		}
		return max;
	}

	public static void main(String[] args) {
		BTNode root = new BTNode();
		root.val = 0;
		
		BTNode n1 = new BTNode();
		n1.val = 1;
		
		BTNode n2 = new BTNode();
		n2.val = 2;
		
		root.left = n1;
		root.right = n2;
		
		BTNode n3 = new BTNode();
		n3.val = 1;
		
		BTNode n4 = new BTNode();
		n4.val = 2;
		
		n1.left=n3;
		n1.right=n4;
		
		BTNode n5 = new BTNode();
		n5.val=1;
		
		BTNode n6 = new BTNode();
		n6.val=3;
		
		n2.left=n5;
		n2.right=n6;
		
		System.out.println(consecutive(root));
	}

}
