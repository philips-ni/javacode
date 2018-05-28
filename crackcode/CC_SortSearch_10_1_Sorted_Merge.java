package crackcode;

import java.util.Arrays;

/**
 * CC.SortSearch.10.1 Sorted Merge
 * 
 * Question : You are given two sorted arrays, A and B, where A has large enough
 * buffer at the end to hold B. Write a method to merge B into A in sorted
 * order.
 *
 */
public class CC_SortSearch_10_1_Sorted_Merge {

	public static void merge(int[] a, int[] b, int lenA, int lenB) {
		int i = lenA - 1;
		int j = lenB - 1;
		int k = lenA + lenB - 1;

		while (j >= 0) {
			if (i >= 0 && a[i] > b[j]) {
				a[k] = a[i--];
			} else {
				a[k] = b[j--];
			}
			k--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9, 0, 0, 0, 0 };
		int[] b = { 2, 4, 6, 8 };

		merge(a, b, 5, 4);
		System.out.println(Arrays.toString(a));

	}

}
