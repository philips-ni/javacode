package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * BB.Array.011 Zero Sum Subarray
 * 
 * Question : Given an array, write a function to find any subarray that
 * sums to zero, if one exists.
 * 
 * e.g.
 * 
 * zeroSum({1, 2, -5, 1, 2, -1}) = [2, -5, 1, 2]
 * 
 */
public class BB_011_Zero_Sum_Subarray {

	public static int[] zeroSum(int[] arr) {
		int currentSum = 0;

		for (int i = 0; i < arr.length; i++) {

			currentSum = arr[i]; // reset start point

			for (int j = i + 1; j < arr.length; j++) {
				if (currentSum == 0) {
					return Arrays.copyOfRange(arr, i, j);
				}
				currentSum += arr[j];
			}
		}

		return null;
	}

	public static int[] zeroSum_optimal(int arr[]) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0) {
				return new int[] { arr[i] };
			}
			if (sum == 0) {
				return Arrays.copyOfRange(arr, 0, i);
			}

			if (hm.get(sum) != null) {
				return Arrays.copyOfRange(arr, hm.get(sum) + 1, i + 1);
			}
			// Add sum to hash map
			hm.put(sum, i);
		}

		// not exist
		return null;
	}
	
	public static void main(String[] args) {
		int zeroSumArr[] = { 1, 2, -5, 1, 2, -1 };
		System.out.println(Arrays.toString(zeroSum(zeroSumArr)));
		System.out.println(Arrays.toString(zeroSum_optimal(zeroSumArr)));
	}

}
