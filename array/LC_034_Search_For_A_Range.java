package array;

import java.util.Arrays;

/**
 * LC.Array.034 Search for a range
 * 
 * Question : Given an array of integers sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * e.g.
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 */

public class LC_034_Search_For_A_Range {

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = searchFirst(nums, target);
		result[1] = searchLast(nums, target);
		return result;
	}

	public static int searchFirst(int[] nums, int target) {
		int idx = -1;
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] >= target) { // look for first in the left
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			if (nums[mid] == target)
				idx = mid; // save current found

		}

		return idx;
	}

	public static int searchLast(int[] nums, int target) {
		int idx = -1;
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] <= target) { // look for first in the right
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			if (nums[mid] == target)
				idx = mid; // save current found

		}

		return idx;
	}
	public static void main(String[] args) {
		
		int[] SR = { 0, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Input  : " + Arrays.toString(SR));
		System.out.println("Output : " + Arrays.toString(searchRange(SR, 3)));

	}

}
