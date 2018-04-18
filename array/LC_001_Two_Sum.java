package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LC.Array.001. Two Sum
 * 
 * Question : Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * e.g. Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class LC_001_Two_Sum {

	public static int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer diff = (Integer) (target - nums[i]);
			if (hash.containsKey(diff)) {
				int toReturn[] = { hash.get(diff), i };
				return toReturn;
			}
			hash.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {

		int[] input = { 2, 7, 11, 15 };
		System.out.println("Input  : " + Arrays.toString(input));
		System.out.println("Output : " + Arrays.toString(twoSum(input, 9)));
		
	}
}
