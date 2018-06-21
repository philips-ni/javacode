package sorting;

import java.util.HashSet;

/**
 * 
 * BB.Sorting.002 Consecutive Array
 * 
 * Question : Given an unsorted array, find the length of the longest sequence
 * of consecutive numbers in the array.
 *
 * e.g.
 * 
 * consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
 * 
 * consecutive([5, 5, 3, 1]) = 1, [1], [3], or [5]
 * 
 */
public class BB_002_Consecutive_Array {

	public static int longestConsecutive(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int a : arr) {  // remove duplicates
			hs.add(a);
		}

		int longest = 0;

		for (int a : hs) {
			if (hs.contains(a - 1)) // current value is not start point of max sequence
				continue;

			int length = 0;

			while (hs.contains(a++)) {
				length++;
			}

			longest = Math.max(length, longest);
		}

		return longest;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 6, 5 };

		System.out.println(longestConsecutive(arr));
	}

}
