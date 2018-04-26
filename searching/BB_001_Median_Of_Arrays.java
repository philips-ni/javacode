package searching;

import java.util.Arrays;

/**
 * BB.Searching.001 Median Of Arrays
 * 
 * Question : Find the median of two sorted arrays.
 * 
 * e.g.
 * 
 * arr1 = [1, 3, 5] arr2 = [2, 4, 6]
 * 
 * median(arr1, arr2) = 3.5
 *
 */
public class BB_001_Median_Of_Arrays {

	public static double getMedian(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j])
				arr[k++] = arr1[i++];
			else
				arr[k++] = arr2[j++];
		}

		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}

		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}

		System.out.println(Arrays.toString(arr));

		if (k % 2 == 1)
			return arr[k / 2];
		else{
			return (double)(arr[k / 2 - 1] + arr[k / 2]) / 2;}
		
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5 };
		int[] arr2 = { 2, 4, 6,7 };

		System.out.println(getMedian(arr1, arr2));

	}

}
