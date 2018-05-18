package util;

import java.util.Arrays;

public class MergeSort {
	/**
	 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm.
	 * 
	 * It divides input array in two halves, calls itself for the two halves and then
	 * merges the two sorted halves. The merge() function is used for merging two
	 * halves.
	 * 
	 * The merge(array, l, m, r) is key process that assumes that array[l..m] and
	 * array[m+1..r] are sorted and merges the two sorted sub-arrays into one. See
	 * following C implementation for details.
	 * 
	 * MergeSort(array[], l, r)
	 * 
	 * If r > l
	 * 
	 * 1. Find the middle point to divide the array into two halves:
	 * 
	 * middle m = (l+r)/2
	 * 
	 * 2. Call mergeSort for first half:
	 * 
	 * Call mergeSort(array, l, m)
	 * 
	 * 3. Call mergeSort for second half:
	 * 
	 * Call mergeSort(array, m+1, r)
	 * 
	 * 4. Merge the two halves sorted in step 2 and 3:
	 * 
	 * Call merge(array, l, m, r)
	 * 
	 * The array is recursively divided in two halves till the size becomes 1. Once
	 * the size becomes 1, the merge processes comes into action and starts merging
	 * arrays back till the complete array is merged.
	 */
	public static void mergeSort(int arr[], int low, int high) {
		if (low < high) {
			// find the middle point
			int mid = (low + high) / 2;

			// sort first and second half
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			// merge the sorted halves
			System.out.print("Before merge ( " + low + "," + mid + "," + high + "): ");
			printarr(arr);
			merge(arr, low, mid, high);
			System.out.print("After merge : ");
			printarr(arr);
		}
	}

	/**
	 * merge two sub-arrays of array[]
	 * 
	 * The first subarray is array[1,...,m]
	 * 
	 * The second subarray is array[m+1,...,h]
	 */
	private static void merge(int arr[], int low, int mid, int high) {
		// Find sizes of two subarrs to be merged
		int n1 = mid - low + 1;
		int n2 = high - mid;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[low + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		System.out.println(Arrays.toString(L));
		System.out.println(Arrays.toString(R));

		// place smaller element in the left by moving pointer k to the right
		int k = low;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		// remaining elements are already sorted so just copy them in order
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	/**
	 * A utility function to print array of size n
	 */
	public static void printarr(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };
		mergeSort(arr, 0, arr.length - 1);

	}
}
