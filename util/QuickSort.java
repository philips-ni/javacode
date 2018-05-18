package util;

import java.util.Arrays;

public class QuickSort {
	/**
	 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
	 * element as pivot and partitions the given array around the picked pivot.
	 * There are many different versions of quickSort that pick pivot in different
	 * ways.
	 * 
	 * 1. Always pick first element as pivot.
	 * 
	 * 2. Always pick last element as pivot (implemented below)
	 * 
	 * 3. Pick a random element as pivot.
	 * 
	 * 4. Pick median as pivot.
	 * 
	 * The key process in quickSort is partition(). Target of partitions is, given
	 * an array and an element x of array as pivot, put x at its correct position in
	 * sorted array and put all smaller elements (smaller than x) before x, and put
	 * all greater elements (greater than x) after x. All this should be done in
	 * linear time.
	 * 
	 */
	private static int partition(int arr[], int low, int high) {
		int pivot = arr[high]; // pick last element as pivot
		
		int i = (low - 1); // index of smaller element, start with -1
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				// place smaller elements to the very left side		
				i++;		
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// move pivot to the right place
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high); // pivot element is in the right place after partition

			quickSort(arr, low, pi - 1); // sort left elements of pivot
			quickSort(arr, pi + 1, high); // sort right elements of pivot
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
