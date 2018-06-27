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
	
	public static ArrayList<Integer[]> subset(int[] arr) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] subset = new Integer[arr.length];
		getSubset(arr, results, subset, 0);
		return results;
	}

	private static void getSubset(int[] arr, ArrayList<Integer[]> results, Integer[] subset, int index) {

		if (index == arr.length) {
			// got one subset
			results.add(subset.clone());
			System.out.println(Arrays.toString(subset));
		} else {
			// select current element
			subset[index] = arr[index];
			getSubset(arr, results,subset, index + 1);

			// not select current element
			subset[index] = null;
			getSubset(arr, results,subset, index + 1);
		}
	}

	public static void printResults(ArrayList<Integer[]> results) {
		for(Integer[] result:results) {
			System.out.println(Arrays.toString(result));
		}
	}
	
	// Print all subsets of given set[]
    static void printSubsets(char set[])
    {
        int n = set.length;
 
        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print("{ ");
 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
 
            System.out.println("}");
        }
    }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		ArrayList<Integer[]> results = subset(arr);
		//printResults(results);
		
		char set[] = {'a', 'b', 'c'};
        printSubsets(set);
	}
}
