package crackcode;

/**
 * CC.SortSearch.10.4 Sorted Search, No Size
 * 
 * Question : Given an array like data structure Listy which lacks a size
 * method. It does, however, have an elementAt(i) method that returns the
 * element at index i in O(1) time. If i is beyond the bounds of the data
 * structure, it returns -1.(For this reason, the data structure only supports
 * positive integers.) Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs. If x occurs multiple times, you
 * may return any index.
 *
 */
public class CC_SortSearch_10_4_Sorted_Search_No_Size {

	public class Listy {
		private int[] arr;

		public int elementAt(int index) {
			return arr[index];
		}
	}

	public static int search(Listy list, int x) {
		int index = 0;

		// find out the size
		while (list.elementAt(index) != -1 && list.elementAt(index) < x) {
			index *= 2;
		}

		return search(list, x, index / 2, index);
	}

	private static int search(Listy list, int x, int low, int high) {
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			int middle = list.elementAt(mid);
			if (x == middle) {
				return mid;
			} else if (x < middle || middle == -1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
