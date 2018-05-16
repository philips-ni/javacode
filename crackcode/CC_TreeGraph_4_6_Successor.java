package crackcode;

import util.BTNode;

/**
 * CC.TreeGraph.4.6 Successor
 * 
 * Question : Write an algorithm to find the ‘next’ node (e.g. in-order
 * successor) of a given node in a binary search tree where each node has a link
 * to its parent.
 *
 * On an in-order traversal, we visit X.left, then X, then X.right.
 * 
 * So, if we want to find X.successor(), we do the following:
 * 
 * 1. If X has a right child, then the successor must be on the right side of X
 * (because of the order in which we visit nodes). Specifically, the left-most
 * child must be the first node visited in that subtree.
 * 
 * 2. Else, we go to X’s parent (call it P).
 * 
 * 2.a. If X was a left child (P.left = X), then P is the successor of X
 * 
 * 2.b. If X was a right child (P.right = X), then we have fully visited P, so
 * we call successor(P).
 * 
 * e.g.
 * 
 *         20
 * 
 *       8   22
 * 
 *     4   12
 * 
 *       10  14
 * 
 * In the above diagram, inorder successor of 8 is 10, inorder successor of 10
 * is 12 and inorder successor of 14 is 20.
 * 
 */
public class CC_TreeGraph_4_6_Successor {

	public static BTNode insert(BTNode node, int data) {

		if (node == null) {
			return (new BTNode(data));
		} else {
			BTNode temp = null;

			/* 2. Otherwise, recur down the tree */
			if (data <= node.val) {
				temp = insert(node.left, data);
				node.left = temp;
				temp.parent = node;

			} else {
				temp = insert(node.right, data);
				node.right = temp;
				temp.parent = node;
			}

			/* return the (unchanged) node pointer */
			return node;
		}
	}

	public static BTNode successor(BTNode n) {

		// step 1 : check left most of right subtree if has right child
		if (n.right != null) {
			return leftmost(n.right);
		}

		// step 2 : no right child case, check parent back
		BTNode p = n.parent;
		while (p != null && n == p.right) {
			n = p;
			p = p.parent;
			System.out.println(n.val+" "+p.val);
		}
		return p;
	}

	private static BTNode leftmost(BTNode n) {
		if (n == null)
			return null;

		while (n.left != null)
			n = n.left;

		return n;
	}

	public static void main(String[] args) {

		BTNode root = null, x = null, suc = null;
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);
		x = root.left.right.right;
		suc = successor(x);
		if (suc != null) {
			System.out.println("Inorder successor of " + x.val + " is " + suc.val);
		} else {
			System.out.println("Inorder successor does not exist");
		}
	}

}
