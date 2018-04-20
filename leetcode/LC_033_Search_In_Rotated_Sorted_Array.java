package leetcode;

import java.util.Arrays;

/**
 * 
 * LC.Array.033 Search in Rotated Sorted Array
 * 
 * Question : Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 */
public class LC_033_Search_In_Rotated_Sorted_Array {

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target) // found
				return mid;

			if (nums[low] < nums[mid]) {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			if (nums[mid] < nums[high]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		
		int[] RSA = { 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3 };
		System.out.println("Input  : " + Arrays.toString(RSA));
		System.out.println("Output : " + search(RSA, 2));
	}

}
