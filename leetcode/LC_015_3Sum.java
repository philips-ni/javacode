package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC.Array.015. 3Sum
 * 
 * Question : Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * e.g.
 * 
 * given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 */
public class LC_015_3Sum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0)
				break; // first element must be negative

			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip same result

			int j = i + 1; // left pointer
			int k = nums.length - 1; // right pointer

			while (j < k) {
				if (nums[j] + nums[k] == -nums[i]) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++; // skip same result
					while (j < k && nums[k] == nums[k + 1])
						k++; // skip same result
				} else if (nums[j] + nums[k] > -nums[i]) {
					k--;
				} else {
					j++;
				}
			}
		}

		return result;

	}
	public static void main(String[] args) {

		int[] threesum = { -1, 0, 1, 2, -1, -4 };
		System.out.println("Input  : " + Arrays.toString(threesum));
		System.out.println("Output : " + threeSum(threesum));
	}

}
