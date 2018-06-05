package tree;

/**
 * Inorder Successor in Binary Search Tree
 * 
 * In Binary Tree, Inorder successor of a node is the next node in Inorder
 * traversal of the Binary Tree. Inorder Successor is NULL for the last node in
 * Inoorder traversal. In Binary Search Tree, Inorder Successor of an input node
 * can also be defined as the node with the smallest key greater than the key of
 * input node. So, it is sometimes important to find next node in sorted order.
 *
 */
public class Successor {
	private class Node {
		int data;
		Node left, right, parent;

		Node(int d) {
			data = d;
			left = right = parent = null;
		}
	}

	public class BinaryTree {

		public Node insert(Node node, int data) {
			if (node == null) { // base case
				return new Node(data);
			} else {
				Node temp = null;
				if (data <= node.data) {
					temp = insert(node.left, data);
					node.left = temp;
					temp.parent = node;
				} else {
					temp = insert(node.right, data);
					node.right = temp;
					temp.parent = node;
				}
				return node;
			}
		}

		// method 1
		public Node inOrderSuccessor(Node n) {

			if (n == null)
				return null;

			// 1. Successor is minimum value in the right subtree if it's not
			// null.
			if (n.right != null) {
				return minValue(n.right);
			}

			// 2. Travel up for a node which is left child of its parent.
			Node p = n.parent;
			while (p != null) {
				if (p.left == n)
					break;

				n = p;
				p = p.parent;
			}
			return p;
		}

		private Node minValue(Node node) {
			Node current = node;

			// The leftmost node is minimum
			while (current.left != null) {
				current = current.left;
			}
			return current;
		}

		// method 2
		public Node inOrderSuccessor(Node root, Node n) {
			if (n.right != null)
				return minValue(n.right);

			Node succ = null;

			// Start from root and search for successor down the tree
			while (root != null) {
				if (n.data < root.data) {
					succ = root;
					root = root.left;
				} else if (n.data > root.data)
					root = root.right;
				else
					break;
			}

			return succ;
		}
	}

	public void test() {
		BinaryTree tree = new BinaryTree();
		Node root = tree.insert(null, 20);
		root = tree.insert(root, 8);
		root = tree.insert(root, 22);
		root = tree.insert(root, 4);
		root = tree.insert(root, 12);
		root = tree.insert(root, 10);
		root = tree.insert(root, 14);
		Node temp = root.left.right.right;
		Node suc = tree.inOrderSuccessor(temp);
		if (suc != null) {
			System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
		} else {
			System.out.println("Inorder successor does not exist");
		}
	}

	public static void main(String[] args) {
		Successor s = new Successor();
		s.test();
	}
}
