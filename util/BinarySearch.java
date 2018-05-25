package util;

import java.util.Arrays;

public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target)
				return mid;

			if (nums[mid] > target) {
				high = mid - 1;
			}

			if (nums[mid] < target) {
				low = mid + 1;
			}

		}

		return -1;
	}

	public static int binarySearch_recursive(int[] nums, int target, int low, int high) {
		if (low > high)
			return -1;

		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch_recursive(nums, target, low, mid - 1);
		} else {
			return binarySearch_recursive(nums, target, mid + 1, high);
		}
	}

	public static void main(String[] args) {

		int[] SA = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Input  : " + Arrays.toString(SA));
		System.out.println("Output : " + binarySearch(SA, 6));
		System.out.println("Output : " + binarySearch_recursive(SA, 6, 0, SA.length - 1));

	}

}
