package crackcode;

/**
 * CC.SortSearch.10.5 Sparse Search
 * 
 * Question : Given a sorted array of strings that is interspersed with empty
 * strings, write a method to find the location of a given string.
 * 
 * e.g.
 * 
 * Input : find "ball" in {"at","","","","ball","","","dad","",""}
 *
 * Output : 4
 */
public class CC_SortSearch_10_5_Sparse_Search {

	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str == "")
			return -1;

		return search(strings, str, 0, strings.length - 1);
	}

	private static int search(String[] strings, String str, int first, int last) {
		if (first > last)
			return -1;

		int mid = (first + last) / 2;

		// Find closest non-empty string if mid is empty.
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;

			while (true) {
				if (left < first && right > last) {
					return -1;
				} else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				left--;
				right++;
			}
		}

		if (str.equals(strings[mid])) {
			return mid;
		} else if (str.compareTo(strings[mid]) < 0) { // search left
			return search(strings, str, first, mid - 1);
		} else {
			return search(strings, str, mid + 1, last);
		}
	}

	public static void main(String[] args) {
		String[] strings = { "at", "", "", "", "ball", "", "", "dad", "", "" };
		System.out.println(search(strings, "at"));
	}
}
