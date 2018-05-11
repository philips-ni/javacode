package crackcode;

import foundation.BTNode;

/**
 * CC.TreeGraph.4.10 Check Subtree
 * 
 * Question : T1 and T2 are two very large binary trees, with T1 bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of T1.
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the
 * subtree of n is identical to T2. That is, if you cut off the tree at node n,
 * the two trees would be identical.
 *
 */
public class CC_TreeGraph_4_10_Check_Subtree {

	public static boolean containsTree(BTNode n1, BTNode n2) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		getOrderString(n1, s1);
		getOrderString(n2, s2);

		return s1.indexOf(s2.toString()) != -1; 

	}

	// build order string with pre-order traversal
	private static void getOrderString(BTNode n, StringBuilder sb) {
		if (n == null) {
			sb.append("x");
			return;
		}

		sb.append(n.val);
		getOrderString(n.left, sb);
		getOrderString(n.right, sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
