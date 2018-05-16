package tree;

import util.BTNode;

/**
 * 
 * BB.Tree.005 Tree To Doubly Linked List
 * 
 * Question : Given a tree, write a function to convert it into a circular
 * doubly linked list from left to right by only modifying the existing
 * pointers.
 *
 * e.g.
 * 
 * 1
 * 
 * 2 3
 * 
 * 4 5 6 7
 * 
 * output : <- 4 <-> 2 <-> 5 <-> 1 <-> 6 <-> 3 <-> 7 ->
 * 
 */
public class BB_005_Tree_To_Doubly_Linkedlist {

	private static BTNode concatenate(BTNode a, BTNode b) {
	    if (a == null) return b;
	    if (b == null) return a;

	    BTNode aEnd = a.left;
	    BTNode bEnd = b.left;

	    a.left = bEnd;
	    bEnd.right = a;
	    aEnd.right = b;
	    b.left = aEnd;
	    return a;
	}

	public static BTNode treeToList(BTNode n) {
	    if (n == null) return n;
	    BTNode leftList = treeToList(n.left);
	    BTNode rightList = treeToList(n.right);
	    n.left = n;
	    n.right = n;

	    n = concatenate(leftList, n);
	    n = concatenate(n, rightList);
	    return n;
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
		
		n1.left=n3;
		n1.right=n4;
		
		BTNode n5 = new BTNode();
		n5.val=6;
		
		BTNode n6 = new BTNode();
		n6.val=7;
		
		n2.left=n5;
		n2.right=n6;
		
		treeToList(root);

	}

}
