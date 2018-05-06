package crackcode;

/**
 * CC.TreeGraph.4.2 Minimal Tree
 * 
 * Question : Given a sorted(increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 *
 */
public class CC_TreeGraph_4_2_Minimal_Tree {

	private class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int v) {
			this.value = v;
		}
	}

	public TreeNode createTree(int[] arr) {
		return create(arr, 0, arr.length - 1);
	}

	private TreeNode create(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = create(arr, start, mid - 1);
		n.right = create(arr, mid + 1, end);

		return n;
	}

	public void test() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		createTree(arr);
	}

	public static void main(String[] args) {
		CC_TreeGraph_4_2_Minimal_Tree driver = new CC_TreeGraph_4_2_Minimal_Tree();
		driver.test();
	}

}
