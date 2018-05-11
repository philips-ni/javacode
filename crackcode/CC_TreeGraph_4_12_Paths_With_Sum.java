package crackcode;

import foundation.BTNode;

/**
 * CC.TreeGraph.4.12 Paths With Sum
 * 
 * Question : Given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the
 * number of paths that sum to a given value. The path does not need to start or
 * end at the root or a leaf, but it must go downwards(traveling only from
 * parent nodes to child nodes).
 *
 */
public class CC_TreeGraph_4_12_Paths_With_Sum {

	public static int countPaths(BTNode n, int target) {
		if (n == null)
			return 0;

		int paths = countPathsFromNode(n, target, 0);

		int pathsLeft = countPaths(n.left, target);
		int pathsRight = countPaths(n.right, target);

		return paths + pathsLeft + pathsRight;
	}

	private static int countPathsFromNode(BTNode n, int target, int currentSum) {
		if (n == null)
			return 0;

		currentSum += n.val;

		int paths = 0;
		if (currentSum == target)
			paths++;

		paths += countPathsFromNode(n.left, target, currentSum);
		paths += countPathsFromNode(n.right, target, currentSum);

		return paths;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
