package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * BB.Array.012 Permutations
 * 
 * Description: Write a function that returns all permutations of a given
 * list.
 * 
 * e.g.
 * 
 * Input: {1, 2, 3}
 * 
 * Output: [1, 2, 3],[1, 3, 2],[2, 1, 3],[2, 3, 1],[3, 1, 2],[3, 2, 1]
 * 
 */
public class BB_012_Permutations {

	public static ArrayList<ArrayList<Integer>> permutation(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		permute(nums, temp, result);
		return result;
	}

	private static void permute(int[] nums, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<Integer>(temp));
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i]))
				continue;

			temp.add(nums[i]);
			permute(nums, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] pa = { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> results = permutation(pa);
		for (ArrayList<Integer> result : results) {
			System.out.println(Arrays.toString(result.toArray()));
		}
	}

}
