package crackcode;

/**
 * CC.SortSearch.10.3 Search In Rotated Array
 * 
 * Question : Given a sorted array of n integers that has been rotated an
 * unknown number of times, write code to find an element in the array. You may
 * assume that the array was originally sorted in increasing order.
 * 
 * e.g.
 * 
 * Input : find 5 in {15,16,19,20,25,1,3,4,5,7,10,14}
 * 
 * Output : 8
 * 
 */
public class CC_SortSearch_10_3_Search_In_Rotated_Array {

	public static int search(int[] arr, int x, int left, int right) {

		int mid = (left + right) / 2;
		if (x == arr[mid])
			return mid;

		if (left > right)
			return -1;

		if (arr[left] < arr[mid]) { // left is normally ordered.
			if (x >= arr[left] && x < arr[mid]) {
				return search(arr, x, left, mid - 1);
			} else {
				return search(arr, x, mid + 1, right);
			}

		} else if (arr[left] > arr[mid]) { // right is normally ordered.
			if (x > arr[mid] && x <= arr[right]) {
				return search(arr, x, mid + 1, right);
			} else {
				return search(arr, x, left, mid - 1);
			}
		} else if (arr[left] == arr[mid]) {
			// left or right is repeated. e.g. {2,2,2,3,4,2}

			if (arr[mid] != arr[right]) { // right is different and search right
				return search(arr, x, mid + 1, right);
			} else {
				// search both sides
				int result = search(arr, x, left, mid - 1);
				if (result == -1) {
					return search(arr, x, mid + 1, right);
				} else {
					return result;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		System.out.println(search(arr, 5, 0, 11));
	}
}
