package array;

import java.util.Arrays;

/**
 * LC.Array.035 Search Insert Position
 * 
 * Question : Given a sorted array and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted
 * in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5->2
 * 
 * [1,3,5,6], 2->1
 * 
 * [1,3,5,6], 7->4
 * 
 * [1,3,5,6], 0->0
 * 
 */
public class LC_035_Search_Insert_Position {

	
	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return low;
	}
	public static void main(String[] args) {

		int[] SI = { 1, 3, 5, 6 };
		System.out.println("Input  : " + Arrays.toString(SI));
		System.out.println("Output : " + searchInsert(SI, 7));
	}

}
