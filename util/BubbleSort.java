package util;

import java.util.Arrays;

public class BubbleSort {
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
