package leetcode;

import java.util.Arrays;

/**
 * LC.Array.016 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the
 * sum is closest to a given number, target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * e.g.
 * 
 * Given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class LC_016_3Sum_Closest {

	public static int threeSumClosest(int[] nums, int target) {

		int result = nums[0] + nums[1] + nums[nums.length - 1];

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {

				int sum = nums[i] + nums[j] + nums[k];

				if (sum > target) {
					k--; // looking for a smaller value
				} else {
					j++; // looking for a bigger value
				}

				if (Math.abs(sum - target) < Math.abs(result - target))
					result = sum;
			}

		}

		return result;

	}
	public static void main(String[] args) {
		int[] threesumclosest = { -1, 2, 1, -4 };
		System.out.println("Input  : " + Arrays.toString(threesumclosest));
		System.out.println("Output : " + threeSumClosest(threesumclosest, 1));

	}

}
