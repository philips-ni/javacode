package leetcode;

import java.util.Arrays;

/**
 * LC.Math.031 Next Permutation
 * 
 * Question : Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 -> 1,3,2
 * 
 * 3,2,1 -> 1,2,3
 * 
 * 1,1,5 -> 1,5,1
 * 
 * This is actually finding out next greater permutation
 * 
 * 5,1,4,3,2 -> 5,2,1,3,4
 */
public class LC_031_Next_Permutation {

	public static int[] nextPermutation(int[] nums) {

		// 1. find out first nums[i] greater than nums[i-1] and swap positions.
		// All the numbers after i-1 is in descending order.
		int len = nums.length - 1;
		int i = len;
		for (; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				break; // found the first greater value
		}

		// 2. sort numbers after nums[i-1] in ascending order
		int j = len;
		for (; j > i - 1; j--) {
			if (nums[j] > nums[i - 1])
				break; // found the value just greater than nums[i-1]
		}

		swap(nums, i - 1, j);
		sort(nums, i);
		return nums;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void sort(int[] nums, int start) {
		int i = start;
		int j = nums.length - 1;

		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}

	}

	public static void main(String[] args) {

		int[] nums = { 5, 1, 4, 3, 2 };
		System.out.println("Input  : " + Arrays.toString(nums));
		System.out.println("Output : " + Arrays.toString(nextPermutation(nums)));

	}
}
