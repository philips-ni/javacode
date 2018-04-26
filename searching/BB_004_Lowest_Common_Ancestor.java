package searching;

import java.util.List;
import java.util.ArrayList;

/**
 * BB.Searching.004 Lowest Common Ancestor
 *
 * Question : Given two nodes in a binary tree, write a function to find the
 * lowest common ancestor.
 */
public class BB_004_Lowest_Common_Ancestor {

	public class Node {
		Node left;
		Node right;
		int val;
	}

	public Node lca(Node root, Node n1, Node n2) {
		List<Node> path1 = new ArrayList<Node>();
		List<Node> path2 = new ArrayList<Node>();

		// find path for target nodes
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
			return null;
		}

		// find lowest common ancestor
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			// System.out.println(path1.get(i).val + " " + path2.get(i).val);
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}

		return path1.get(i - 1);
	}

	private boolean findPath(Node root, Node n, List<Node> path) {
		if (root == null)
			return false;

		path.add(root);

		if (root.equals(n)) {
			return true;
		}

		if (root.left != null) {
			if (findPath(root.left, n, path))
				return true;
		}
		if (root.right != null) {
			if (findPath(root.right, n, path))
				return true;
		}

		path.remove(root);
		return false;

	}

	public Node initTree() {
		Node root = new Node();
		root.val = 1;

		Node n1 = new Node();
		n1.val = 2;

		Node n2 = new Node();
		n2.val = 3;

		Node n3 = new Node();
		n3.val = 4;

		Node n4 = new Node();
		n4.val = 5;

		Node n5 = new Node();
		n5.val = 6;

		Node n6 = new Node();
		n6.val = 7;

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n1.right = n4;

		n2.left = n5;
		n2.right = n6;

		return root;
	}

	public static void main(String[] args) {
		BB_004_Lowest_Common_Ancestor lca = new BB_004_Lowest_Common_Ancestor();
		Node root = lca.initTree();

		Node ancestor = lca.lca(root, root.left.right, root.right);
		if (ancestor != null)
			System.out.println(ancestor.val);
		else
			System.out.println("not exist");

	}
}
