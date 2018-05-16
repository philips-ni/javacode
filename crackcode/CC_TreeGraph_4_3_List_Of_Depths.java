package crackcode;

import java.util.ArrayList;
import java.util.LinkedList;

import util.BTNode;

/**
 * CC.TreeGraph.4.3 List Of Depths
 * 
 * Question : Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth(e.g. if you have a tree with depth D, you
 * will have D linked lists.)
 *
 */
public class CC_TreeGraph_4_3_List_Of_Depths {

	public static ArrayList<LinkedList<BTNode>> createLevelLinkedList_dfs(BTNode root) {
		ArrayList<LinkedList<BTNode>> lists = new ArrayList<LinkedList<BTNode>>();
		createLinkedList(root, lists, 0);
		return lists;
	}

	private static void createLinkedList(BTNode node, ArrayList<LinkedList<BTNode>> lists, int level) {
		if (node == null)
			return; // base case

		LinkedList<BTNode> list = null;
		if (lists.size() == level) {
			// not exist a linked list yet for current level
			list = new LinkedList<BTNode>();
			lists.add(list);

		} else {
			// already exist a linked list for current level
			list = lists.get(level);
		}

		list.add(node);

		createLinkedList(node.left, lists, level + 1);
		createLinkedList(node.right, lists, level + 1);
	}

	public static ArrayList<LinkedList<BTNode>> createLevelLinkedList_bfs(BTNode root) {
		ArrayList<LinkedList<BTNode>> lists = new ArrayList<LinkedList<BTNode>>();

		LinkedList<BTNode> current = new LinkedList<BTNode>();
		if (root != null)
			current.add(root);
		
		while(current.size()>0){
			lists.add(current); // add current level to result lists
			
			LinkedList<BTNode> parents = current; // go to next level
			current = new LinkedList<BTNode>(); // create linked list for next level
			
			for(BTNode parent: parents){
				if(parent.left!=null)
					current.add(parent.left);
				if(parent.right!=null)
					current.add(parent.right);
			}
		}
		return lists;
	}

	public static void printLists(ArrayList<LinkedList<BTNode>> lists) {
		for (LinkedList<BTNode> list : lists) {
			while (list.size() != 0) {
				System.out.print(list.poll().val + " -> ");
			}
			System.out.println("");
		}
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

		ArrayList<LinkedList<BTNode>> lists = createLevelLinkedList_dfs(root);
		printLists(lists);
		
		System.out.println();
		lists = createLevelLinkedList_bfs(root);
		printLists(lists);
	}

}
