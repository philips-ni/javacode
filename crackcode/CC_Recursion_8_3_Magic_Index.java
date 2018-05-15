package crackcode;

/**
 * CC.Recursion.8.3 Magic Index
 * 
 * Question : A magic index in an array A[1,2,...,n-1] is defined to be an index
 * such that A[i]=i. Given a sorted array of distinct integers, write a method
 * to find a magic index, if one exists, in array A.
 * 
 * Follow up : What if the values are not distinct?
 *
 */
public class CC_Recursion_8_3_Magic_Index {

	// brute force
	public static int getMagic(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i)
				return i;
		}

		return -1;
	}

	public static int getMagic_Recursive(int[] arr) {
		return getMagic_Recursive(arr, 0, arr.length - 1);
	}

	private static int getMagic_Recursive(int[] arr, int start, int end) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;

		if (arr[mid] == mid)
			return mid;
		else if (arr[mid] > mid)
			return getMagic_Recursive(arr, start, mid - 1);
		else
			return getMagic_Recursive(arr, mid + 1, end);
	}

	public static int getMagic_followup(int[] arr) {
		return getMagic_followup(arr, 0, arr.length - 1);
	}

	private static int getMagic_followup(int[] arr, int start, int end) {
		if (start > end)
			return -1;

		int mid = (start + end) / 2;
		int midValue = arr[mid];
		if (midValue == mid)
			return mid;

		int leftIndex = Math.min(mid - 1, midValue);
		System.out.println(start + " " + leftIndex);
		if (leftIndex >= 0) {
			int left = getMagic_followup(arr, start, leftIndex);
			if (left > 0)
				return left;
		}else {
			return -1;
		}

		int rightIndex = Math.min(mid + 1, midValue);
		System.out.println(rightIndex + " " + end);
		int right = getMagic_followup(arr, rightIndex, end);

		return right;
	}

	public static void main(String[] args) {
		int[] arr = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 11, 12, 13 };
		System.out.println(getMagic(arr));
		System.out.println(getMagic_Recursive(arr));

		int[] arr1 = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println(getMagic_followup(arr1));
	}
}
