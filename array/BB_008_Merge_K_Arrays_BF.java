package array;

import java.util.Arrays;

/**
 * BB.Array.008 Merge K Arrays
 * 
 * Question : Given k sorted arrays, merge them into a single sorted array.
 * 
 * e.g.
 * 
 * merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
 * 
 */
public class BB_008_Merge_K_Arrays_BF {

	public static int[] merge(int[][] arrays) {
		int size = arrays.length * arrays[0].length;
		int[] result = new int[size];

		int i = 0;
		for (int j = 0; j < arrays.length; j++) {
			for (int k = 0; k < arrays[j].length; k++) {
				result[i++] = arrays[j][k];
			}
		}
		
		Arrays.sort(result);
		return result;
	}

	public static void main(String[] args) {
		int[][] mkArray = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		int[] mkArrayResult = merge(mkArray);
		System.out.println(Arrays.toString(mkArrayResult));
	}
}
