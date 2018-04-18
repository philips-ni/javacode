package array;

/**
 * BB.Array.009 Matrix Search
 * 
 * Question: Given an nxm array where all rows and columns are in sorted order,
 * write a function to determine whether the array contains an element x.
 * 
 * e.g.
 * 
 * Input: {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}
 * 
 * Output: contains(arr,5)=true
 * 
 */
public class BB_009_Matrix_Search {
	public static boolean contains_bf(int[][] arr, int x) {

		if (arr.length == 0 || arr[0].length == 0)
			return true;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static boolean binary_search(int[] arr, int x) {
		if (arr.length == 0)
			return false;

		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x)
				return true;

			if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}

	public static boolean contains_binary_search(int[][] arr, int x) {
		if (arr.length == 0 || arr[0].length == 0)
			return true;

		for (int i = 0; i < arr.length; i++) {
			if (binary_search(arr[i], x))
				return true;
		}
		return false;
	}

	public static boolean contains_binaray_search_2(int[][] arr, int x) {
		if (arr.length == 0 || arr[0].length == 0)
			return true;

		// find searching range for x
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int[] subarr = arr[mid];

			if (x >= subarr[0] && x <= subarr[subarr.length - 1]) {
				// found sub array for x
				return binary_search(subarr, x);
			}

			if (x < subarr[0])
				high = mid - 1;
			if (x > subarr[subarr.length - 1])
				low = mid + 1;
		}
		return false;
	}

	public static boolean contains_optimal(int[][] arr, int x) {
		if (arr.length == 0 || arr[0].length == 0)
			return false;

		int row = 0;
		int col = arr[0].length - 1;

		while (row < arr.length && col >= 0) {
			if (arr[row][col] == x)
				return true;
			if (arr[row][col] < x)
				row++;
			else
				col--;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] sa = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		System.out.println(contains_bf(sa, 13));
		System.out.println(contains_binary_search(sa, 13));
		System.out.println(contains_binaray_search_2(sa, 13));
		System.out.println(contains_optimal(sa, 13));
	}

}
