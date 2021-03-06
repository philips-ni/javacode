package recursion;

import util.BTNode;

/**
 * BB.Recursion.010 Binary search tree verification
 * 
 * Question : Given a binary tree, write a function to test if the tree is a
 * binary search tree.
 *
 * e.g. invalid binary search tree
 * 
 *      3 
 * 
 *    2   5 
 * 
 *  1   4 
 * 
 * valid binary search tree
 * 
 *      4
 *      
 *    2   5
 *    
 *  1   3
 *    
 */
public class BB_010_Binary_Search_Tree {

	public static boolean isBST(BTNode n){
		if(n==null) return true;
		
		if(n.left != null && n.val < minValue(n.left)) return false;
		if(n.right != null && n.val > maxValue(n.right)) return false;
		
		if(!isBST(n.left) || !isBST(n.right)) return false;
		
		return true;
	}
	
	private static int minValue(BTNode n){
		BTNode current = n;
		while(current.left != null){
			current = current.left;
		}
		return current.val;
	}
	
	private static int maxValue(BTNode n){
		BTNode current = n;
		while(current.right != null){
			current = current.right;
		}
		return current.val;
	}
	
	public static boolean isBST(BTNode n, int min, int max) {
		if (n == null)
			return true;
		if (n.val < min || n.val > max)
			return false;
		return isBST(n.left, min, n.val - 1) && isBST(n.right, n.val + 1, max);
	}

	public static void main(String[] args) {
		BTNode root = new BTNode();
		root.val = 5;

		BTNode n1 = new BTNode();
		n1.val = 3;

		BTNode n2 = new BTNode();
		n2.val = 7;

		root.left = n1;
		root.right = n2;

		BTNode n3 = new BTNode();
		n3.val = 1;

		BTNode n4 = new BTNode();
		n4.val = 4;

		n1.left = n3;
		n1.right = n4;

		BTNode n5 = new BTNode();
		n5.val = 6;

		BTNode n6 = new BTNode();
		n6.val = 8;

		n2.left = n5;
		n2.right = n6;

		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
