package util;

import java.util.Arrays;

public class QuickSort {
	/**
	 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
	 * element as pivot and partitions the given arr around the picked pivot. There
	 * are many different versions of quickSort that pick pivot in different ways.
	 * 
	 * 1. Always pick first element as pivot.
	 * 
	 * 2. Always pick last element as pivot (implemented below)
	 * 
	 * 3. Pick a random element as pivot.
	 * 
	 * 4.Pick median as pivot.
	 * 
	 * The key process in quickSort is partition(). Target of partitions is, given
	 * an arr and an element x of arr as pivot, put x at its correct position in
	 * sorted arr and put all smaller elements (smaller than x) before x, and put
	 * all greater elements (greater than x) after x. All this should be done in
	 * linear time.
	 * 
	 */

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted arr, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	private static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element, start with -1
		for (int j = low; j < high; j++) {

			if (arr[j] <= pivot) {
				// found element smaller than pivot
				i++;

				// swap arr[i] and arr[j]
				// place smaller elements to the very left side
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				System.out.println("after swap : " + Arrays.toString(arr));
			}
		}

		// swap arr[i+1] and arr[high] (or pivot).
		// i is pointing to very last position of element smaller than pivot
		// i+1 is the final position for pivot
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> arr to be sorted, low
	 * --> Starting index, high --> Ending index
	 */
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);
			System.out.println(
					"pivot : " + pi + " " + "low : " + low + " " + "high : " + high + " " + Arrays.toString(arr));

			// Recursively sort elements before
			// partition and after partition
			System.out.println("sort left");
			quickSort(arr, low, pi - 1);
			System.out.println("sort right");
			quickSort(arr, pi + 1, high);
		}
	}
	public static void main(String[] args) {
		int[] arr = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
