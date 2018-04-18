package array;

import java.util.Arrays;

/**
 * BB.Array.010 Merge Arrays
 * 
 * Question : Given 2 sorted arrays, A and B, where A is long enough to
 * hold the contents of A and B, write a function to copy the contents of B
 * into A without using any buffer or additional memory.
 * 
 * e.g.
 * 
 * input: A = {1,3,5,0,0,0}, B = {2,4,6}
 * 
 * Output: A = {1,2,3,4,5,6}
 * 
 */
public class BB_010_Merge_Arrays {

	public static void mergeArray(int[] a, int[] b, int aLength, int bLength) {

		if (a.length < (aLength + bLength))
			throw new IllegalArgumentException();

		int ap = aLength - 1;
		int bp = bLength - 1;
		int mp = aLength + bLength - 1;

		while (ap >= 0 && bp >= 0) {
			if (a[ap] > b[bp]) {
				a[mp] = a[ap--];
			} else {
				a[mp] = b[bp--];
			}
			mp--;
		}

		while (bp >= 0) {
			a[mp] = b[bp--];
			mp--;
		}

	}
	
	public static void main(String[] args) {
		int[] mergea1 = { 2, 3, 5, 0, 0, 0, 0 };
		int[] mergea2 = { 1, 4 };
		mergeArray(mergea1, mergea2, 3, 2);
		System.out.println(Arrays.toString(mergea1));
	}

}
