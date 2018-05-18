package util;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Tree {

	public TreeNode addChild(TreeNode parent, String childId) {
		TreeNode child = new TreeNode();
		child.setParent(parent);
		child.setId(childId);
		parent.getChildren().add(child);
		return child;
	}

	/**
	 * Traverse the given tree in preorder
	 */
	public void preorderPrint(TreeNode node) {
		System.out.print(" " + node.getId());
		for (TreeNode child : node.getChildren()) {
			preorderPrint(child);
		}
	}

	/**
	 * Traverse the given tree in postorder
	 */
	public void postorderPrint(TreeNode node) {

		for (TreeNode child : node.getChildren()) {
			postorderPrint(child);
		}

		System.out.print(" " + node.getId());
	}

	/**
	 * Perform a depth-first search with recursive method
	 */
	public void recursiveDfs(TreeNode node) {
		System.out.print(node.getId() + "->");
		for (TreeNode child : node.getChildren()) {
			recursiveDfs(child);
		}
	}

	/**
	 * Perform a depth-first search to look for target node
	 */
	public boolean recursiveDfs(TreeNode node, String target) {
		if (node.getId().equals(target)) {
			System.out.print(target);
			return true;
		}

		for (TreeNode child : node.getChildren()) {

			if (recursiveDfs(child, target)) {
				System.out.print(" <- " + node.getId());
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Perform a depth-first search with stack implementation
	 */
	public boolean dfs(TreeNode root, String target) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (node.getId().equals(target)) {
				System.out.println(target);
				return true;
			} else {
				System.out.print(node.getId() + "->");
			}

			stack.addAll(node.getChildren());
		}
		return false;
	}

	/**
	 * Perform a breadth-first search
	 */
	public boolean bfs(TreeNode root, String target) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = (TreeNode) queue.remove();

			if (node.getId().equals(target)) {
				System.out.println(node.getId());
				return true;
			} else {
				System.out.print(node.getId() + "->");
			}
			queue.addAll(node.getChildren());

		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.setParent(null);
		root.setId("1");

		// add children to root
		Tree t = new Tree();
		TreeNode c1 = t.addChild(root, "2");
		TreeNode c2 = t.addChild(root, "3");

		// add children to child-1
		TreeNode c11 = t.addChild(c1, "4");
		TreeNode c12 = t.addChild(c1, "5");

		System.out.print("preorder print :");
		t.preorderPrint(root);

		System.out.println("");
		System.out.print("postorder print :");
		t.postorderPrint(root);
		System.out.println("");

		System.out.println("");
		System.out.print("recursive dfs : ");
		t.recursiveDfs(root);

		System.out.println("");
		System.out.print("recursive dfs for target : ");
		t.recursiveDfs(root, "4");

		System.out.println("");
		System.out.print("dfs with stack : ");
		t.dfs(root, "4");

		System.out.println("");
		System.out.print("bfs with queue for target node : ");
		t.bfs(root, "4");
	}
}
