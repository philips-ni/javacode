package recursion;

import foundation.BSTNode;

/**
 * BB.Recursion.010 Binary search tree verification
 * 
 * Question : Given a binary tree, write a function to test if the tree is a binary search tree.
 *
 * e.g. invalid binary search tree
 * 
 *            5
 *          2   7
 *         1 3 6 4  
 *         
 *       valid binary search tree
 *       
 *              5
 *           3    7 
 *         1  4 6  8
 */
public class BB_010_Binary_Search_Tree {

	public static boolean isBST(BSTNode n, int min, int max) {
		if(n == null) return true;
		if(n.val<min || n.val > max) return false;
		return isBST(n.left,min,n.val) && isBST(n.right,n.val+1,max);
	}
	public static void main(String[] args) {
		BSTNode root = new BSTNode();
		root.val = 5;
		
		BSTNode n1 = new BSTNode();
		n1.val = 3;
		
		BSTNode n2 = new BSTNode();
		n2.val = 7;
		
		root.left = n1;
		root.right = n2;
		
		BSTNode n3 = new BSTNode();
		n3.val = 1;
		
		BSTNode n4 = new BSTNode();
		n4.val = 4;
		
		n1.left=n3;
		n1.right=n4;
		
		BSTNode n5 = new BSTNode();
		n5.val=6;
		
		BSTNode n6 = new BSTNode();
		n6.val=8;
		
		n2.left=n5;
		n2.right=n6;
		
		System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

}
