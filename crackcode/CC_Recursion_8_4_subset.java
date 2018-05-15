package crackcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CC.Recursion.8.4 Subset
 * 
 * Question : Write a method that returns all subsets of a set.
 *
 */
public class CC_Recursion_8_4_subset {

	private ArrayList<Integer[]> results = new ArrayList<Integer[]>();
	
	public void subset(int[] arr) {
		Integer[] subset = new Integer[arr.length];
		getSubset(arr, subset, 0);
	}

	private void getSubset(int[] arr, Integer[] subset, int index) {

		if (index == arr.length) {
			// got one subset
			results.add(subset.clone());
		} else {
			// select current element
			subset[index] = arr[index];
			getSubset(arr, subset, index + 1);

			// not select current element
			subset[index] = null;
			getSubset(arr, subset, index + 1);
		}
	}

	public void printResults() {
		for(Integer[] result:results) {
			System.out.println(Arrays.toString(result));
		}
	}
	
	public static void main(String[] args) {
		CC_Recursion_8_4_subset test = new CC_Recursion_8_4_subset();
		int[] arr = { 1, 2, 3 };
		test.subset(arr);
		test.printResults();
	}
}
