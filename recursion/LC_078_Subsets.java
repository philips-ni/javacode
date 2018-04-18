package recursion;

import java.util.Arrays;

/**
 * LC.Recursion.078 Subsets
 * 
 * Question £º Given a set of distinct integers, nums, return all possible
 * subsets (the power set).Note: The solution set must not contain duplicate
 * subsets.
 * 
 * e.g input : [1,2] output : [], [1], [2], [1,2]
 */
public class LC_078_Subsets {

	public void all_subsets(Integer[] arr) {
		Integer[] subset = new Integer[arr.length]; // make subset with same
													// length
		// using null element as placeholder
		recur(arr, subset, 0); // start from first element to construct subset
	}

	private void recur(Integer[] arr, Integer[] subset, Integer i) {
		if (i == arr.length)
			print_subset(subset);
		else {
			subset[i] = null;
			recur(arr, subset, i + 1); // don't add item to subset and recur for
										// next item
			subset[i] = arr[i]; // add item to subset
			recur(arr, subset, i + 1);

		}
	}

	private void print_subset(Integer[] subset) {
		System.out.print("subset :");
		System.out.println(Arrays.toString(subset));
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2 };
		LC_078_Subsets r = new LC_078_Subsets();
		r.all_subsets(arr);
	}

}
