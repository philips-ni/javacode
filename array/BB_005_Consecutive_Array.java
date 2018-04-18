package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * BB.Array.005 Consecutive Array
 * 
 * Question : Given an unsorted array, find the length of the longest
 * sequence of consecutive numbers in the array.
 * 
 * e.g.
 * 
 * consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
 * 
 * consecutive([5, 5, 3, 1]) = 1, [1], [3], or [5]
 * 
 */
public class BB_005_Consecutive_Array {

	public static int max_consecutive_sort(int[] arr) {
		Arrays.sort(arr);
		System.out.println("Sorted array: " + Arrays.toString(arr));
		int max_length = 0;
		int length = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] + 1) {
				length++;
			} else {
				max_length = Math.max(length, max_length);
				length = 1;
			}

		}
		max_length = Math.max(length, max_length); // count last element
		return max_length;
	}

	public static int max_consecutive_hashset(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();

		// remove duplicates
		for (int value : arr) {
			set.add(value);
		}

		int max_length = 0;

		// traverse values in HashSet
		for (int value : set) {
			// skip current value if it's not the leftmost value
			if (set.contains(value - 1))
				continue;

			int length = 1;
			while (set.contains(++value))
				length++;

			max_length = Math.max(max_length, length);
		}

		return max_length;
	}
	public static void main(String[] args) {
		int[] ca = { 4, 2, 1, 6, 5 };
		System.out.println(max_consecutive_hashset(ca));
		System.out.println(Arrays.toString(ca));
		System.out.println(max_consecutive_sort(ca));

	}

}
