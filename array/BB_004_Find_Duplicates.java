package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * BB.Array.004 Find Duplicates
 * 
 * Question : Given an array of integers where each value between 1 and
 * len(array), write a function that finds all the duplicates in the array.
 * 
 * e.g.
 * 
 * Input: { 1, 2, 1, 2, 1, 3, 2, 2 }
 * 
 */
public class BB_004_Find_Duplicates {

	public static ArrayList<Integer> findDuplicates_bf(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					// found duplicate
					set.add(arr[j]);
				}
			}
		}

		return new ArrayList<Integer>(set);
	}

	public static List<Integer> findDuplicates_optimal(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			// translate the value into index since 1 <= x <= len(array)
			int index = Math.abs(arr[i]) - 1;

			if (arr[index] > 0) {
				// Negate for future duplicate check
				arr[index] = -arr[index];
			} else {
				// Found duplicates
				set.add(Math.abs(arr[index]));
			}
		}

		// reset array to original state
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(arr[i]);
		}

		return new ArrayList<Integer>(set);
	}
	
	public static void main(String[] args) {
		int[] da = { 1, 2, 1, 2, 1, 3, 2, 2 };
		System.out.println(findDuplicates_bf(da));
		System.out.println(findDuplicates_optimal(da));

	}

}
