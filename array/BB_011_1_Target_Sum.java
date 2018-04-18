package array;

import java.util.Arrays;

/**
 * BB.Array.011.1 Target sum
 * 
 * Question : Given an unsorted array of nonnegative integers, find a
 * continuous subarray which adds to a given number.
 * 
 * e.g.
 * 
 * Input: { 15, 2, 4, 8, 9, 5, 10, 23 }, sum=23
 * 
 * Output: {}
 * 
 */
public class BB_011_1_Target_Sum {

	public static int[] targetSum(int[] arr, int sum) {
		int currentSum = 0;

		for (int i = 0; i < arr.length; i++) {

			currentSum = arr[i]; // reset start point

			for (int j = i + 1; j < arr.length; j++) {
				if (currentSum == sum) {
					return Arrays.copyOfRange(arr, i, j);
				}

				if (currentSum > sum)
					break;
				else {
					currentSum += arr[j];
				}
			}
		}

		return null;
	}

	public static int[] targetSum_optimal(int[] arr, int sum) {
		int currentSum = arr[0];
		int start = 0;

		for (int i = 1; i < arr.length; i++) {

			if (currentSum == sum) {
				return Arrays.copyOfRange(arr, start, i);
			}

			while ((currentSum > sum) && (start < (i - 1))) {
				currentSum -= arr[start];
				start++;
			}

			currentSum += arr[i];
		}

		return null;
	}

	public static void main(String[] args) {
		int tsa[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int sum = 23;
		System.out.println(Arrays.toString(targetSum(tsa, sum)));
		System.out.println(Arrays.toString(targetSum_optimal(tsa, sum)));
	}

}
