package tree;

import java.util.Queue;

import util.BTNode;

import java.util.LinkedList;

/**
 * 
 * BB.Tree.008 Tree Level Order
 * 
 * Question : Given a tree, write a function that prints out the nodes of the
 * tree in level order.
 * 
 * e.g.
 * 
 * 1
 * 
 * 2 3
 * 
 * 4 5 6 7
 * 
 * traverse(tree) = 1 2 3 4 5 6 7
 *
 */
public class BB_008_Tree_Level_Order {

	public static void treeLevelOrder(BTNode node) {
		Queue<BTNode> qu = new LinkedList<BTNode>();
		qu.add(node);

		while (!qu.isEmpty()) {
			BTNode temp = qu.remove();
			System.out.println(temp.val);

			if (temp.left != null)
				qu.add(temp.left);
			if (temp.right != null)
				qu.add(temp.right);
		}
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
		
		treeLevelOrder(root);
	}

}
