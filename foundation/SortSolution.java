package foundation;

import java.util.Arrays;

public class SortSolution {

	public void swap(int[] array, int pos1, int pos2) {
		int tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}

	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				int k = j + 1;
				if (array[j] > array[k]) {
					swap(array, j, k);
				}
			}
			System.out.println(Arrays.toString(array));
		}
	}

	/**
	 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
	 * element as pivot and partitions the given array around the picked pivot.
	 * There are many different versions of quickSort that pick pivot in
	 * different ways.
	 * 
	 * 1. Always pick first element as pivot.
	 * 
	 * 2. Always pick last element as pivot (implemented below)
	 * 
	 * 3. Pick a random element as pivot.
	 * 
	 * 4.Pick median as pivot.
	 * 
	 * The key process in quickSort is partition(). Target of partitions is,
	 * given an array and an element x of array as pivot, put x at its correct
	 * position in sorted array and put all smaller elements (smaller than x)
	 * before x, and put all greater elements (greater than x) after x. All this
	 * should be done in linear time.
	 * 
	 */

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int low, int high) {
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
				System.out.println("after swap : "+Arrays.toString(arr));
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
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	void quickSort(int arr[], int low, int high) {
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

	/**
	 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm.
	 * 
	 * It divides input array in two halves, calls itself for the two halves and
	 * then merges the two sorted halves. The merge() function is used for
	 * merging two halves.
	 * 
	 * The merge(arr, l, m, r) is key process that assumes that arr[l..m] and
	 * arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See
	 * following C implementation for details.
	 * 
	 * MergeSort(arr[], l, r)
	 * 
	 * If r > l
	 * 
	 * 1. Find the middle point to divide the array into two halves:
	 * 
	 * middle m = (l+r)/2
	 * 
	 * 2. Call mergeSort for first half:
	 * 
	 * Call mergeSort(arr, l, m)
	 * 
	 * 3. Call mergeSort for second half:
	 * 
	 * Call mergeSort(arr, m+1, r)
	 * 
	 * 4. Merge the two halves sorted in step 2 and 3:
	 * 
	 * Call merge(arr, l, m, r)
	 * 
	 * The array is recursively divided in two halves till the size becomes 1.
	 * Once the size becomes 1, the merge processes comes into action and starts
	 * merging arrays back till the complete array is merged.
	 */
	public void mergeSort(int arr[], int low, int high) {
		if (low < high) {
			// find the middle point
			int mid = (low + high) / 2;

			// sort first and second half
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);

			// merge the sorted halves
			System.out.print("Before merge ( " + low + "," + mid + "," + high + "): ");
			printArray(arr);
			merge(arr, low, mid, high);
			System.out.print("After merge : ");
			printArray(arr);
		}
	}

	/**
	 * merge two sub-arrays of arr[]
	 * 
	 * The first subarray is arr[1,...,m]
	 * 
	 * The second subarray is arr[m+1,...,h]
	 */
	private void merge(int arr[], int low, int mid, int high) {
		// Find sizes of two subarrays to be merged
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
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		SortSolution ss = new SortSolution();

		System.out.println("Bubble sort :");
		ss.bubbleSort(arr);

		System.out.println();
		System.out.println("Quick sort :");
		int[] arr1 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println(Arrays.toString(arr1));
		ss.quickSort(arr1, 0, arr1.length - 1);
		System.out.println(Arrays.toString(arr1));

		System.out.println();
		System.out.println("Merge sort :");
		int arr2[] = { 38, 27, 43, 3, 9, 82, 10 };
		ss.mergeSort(arr2, 0, arr2.length - 1);

	}
}
