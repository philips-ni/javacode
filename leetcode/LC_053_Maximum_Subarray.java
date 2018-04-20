package leetcode;

import java.util.Arrays;

/**
 * LC.Array.053 Maximum Subarray
 * 
 * Question : Find the contiguous subarray within an array (containing at least
 * one number) which has the largest sum.
 * 
 * e.g.
 * 
 * Given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1]
 * has the largest sum = 6.
 * 
 */
public class LC_053_Maximum_Subarray {

	public static int maxSubArray(int[] arr) {

		int max_global = arr[0];

		for (int i = 0; i <= arr.length - 1; i++) {
			int max_current = arr[i];
			if (max_current > max_global) {
				max_global = max_current;
			}

			for (int j = i + 1; j <= arr.length - 1; j++) {
				max_current += arr[j];
				if (max_current > max_global) {
					max_global = max_current;
				}
			}
		}

		return max_global;
	}

	// Kadane's algorithm
	public static int maxSubArray_optimal(int[] arr) {

		int max_global = arr[0];
		int max_current = arr[0];

		for (int i = 1; i < arr.length; i++) {
			max_current = Math.max(arr[i], max_current + arr[i]);

			if (max_current > max_global) {
				max_global = max_current;
			}
		}
		return max_global;

	}

	public static void main(String[] args) {
		int[] msa = { 8, 2, -2, -2, -2, -2, 4, 7 };
		System.out.println("Input  : " + Arrays.toString(msa));
		System.out.println("Output : " + maxSubArray(msa));
		System.out.println("Output : " + maxSubArray_optimal(msa));

	}

}
