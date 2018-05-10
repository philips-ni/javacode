package crackcode;

import foundation.BTNode;

/**
 * CC.TreeGraph.4.8 First Common Ancestor
 * 
 * Question : Design an algorithm and write code to find the first common
 * ancestor of two nodes in a binary tree. Avoid storing additional nodes in a
 * data structure. NOTE: This is not necessarily a binary search tree.
 *
 */
public class CC_TreeGraph_4_8_First_Common_Ancestor {

	public static BTNode commonAncestor(BTNode p, BTNode q) {
		int diff = getDepth(p) - getDepth(q);

		BTNode shorter = diff > 0 ? q : p;
		BTNode longer = diff > 0 ? p : q;

		// move to same level
		while (diff > 0 && longer != null) {
			longer = longer.parent;
			diff--;
		}

		// move two pointers in the same time until intersect
		while (shorter != longer & shorter != null && longer != null) {
			shorter = shorter.parent;
			longer = longer.parent;
		}

		return shorter == null || longer == null ? null : longer;
	}

	private static int getDepth(BTNode n) {
		int depth = 0;
		while (n.parent != null) {
			n = n.parent;
			depth++;
		}
		return depth;
	}

	public static void main(String[] args) {

	}

}
