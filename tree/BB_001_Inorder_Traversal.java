package tree;

import java.util.Stack;

import util.BTNode;

/**
 * BB.Tree.001 Inorder traversal
 * 
 * Question : Given a binary search tree, print out the elements of the tree in
 * order without using recursion.Ï
 *
 * e.g.
 * 
 * Input : A binary search tree
 * 
 * 5
 * 
 * 2 7
 * 
 * 1 3 6 8
 * 
 * Output: 1 2 3 5 6 7 8
 * 
 */
public class BB_001_Inorder_Traversal {

	public static void inorder(BTNode n) {

		if (n.left != null)
			inorder(n.left);

		System.out.println(n.val);

		if (n.right != null)
			inorder(n.right);

	}
 
	public static void inorder_stack(BTNode n) {

		Stack<BTNode> st = new Stack<BTNode>();
		addToStack(st, n);
		while (!st.isEmpty()) {
			BTNode cur = st.pop();
			System.out.println(cur.val);
			addToStack(st, cur.right);
		}
	}

	private static void addToStack(Stack<BTNode> st, BTNode n) {
		while (n != null) {
			st.push(n);
			n = n.left;
		}
	}

	public static void main(String[] args) {
		BTNode root = new BTNode();
		root.val = 5;

		BTNode n1 = new BTNode();
		n1.val = 2;

		BTNode n2 = new BTNode();
		n2.val = 7;

		root.left = n1;
		root.right = n2;

		BTNode n3 = new BTNode();
		n3.val = 1;
		BTNode n4 = new BTNode();
		n4.val = 3;

		n1.left = n3;
		n1.right = n4;

		BTNode n5 = new BTNode();
		n5.val = 6;
		BTNode n6 = new BTNode();
		n6.val = 8;
		n2.left = n5;
		n2.right = n6;

		inorder(root);
		inorder_stack(root);
	}

}
