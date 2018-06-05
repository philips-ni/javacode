package crackcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * CC.SortSearch.10.2 Group Anagrams
 * 
 * Question : Write a method to sort an array of strings so that all the
 * anagrams are next to each other
 * 
 * Anagrams are words that have the same characters but in different orders.
 *
 */
public class CC_SortSearch_10_2_Group_Anagrams {

	public class AnagramComparator implements Comparator<String> {
		private String sortStr(String s) {
			char[] a = s.toCharArray();
			Arrays.sort(a);
			return new String(a);
		}

		public int compare(String s1, String s2) {
			return sortStr(s1).compareTo(sortStr(s2));
		}
	}

	public void sort(String[] arr) {
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

		for (String s : arr) {
			String key = sortStr(s);
			if (!hm.containsKey(key)) {			
				hm.put(key, new ArrayList<String>());
			}
			hm.get(key).add(s);
		}

		int index = 0;
		for (String key : hm.keySet()) {
			ArrayList<String> anagrams = hm.get(key);
			for (String anagram : anagrams) {
				arr[index++] = anagram;
			}
		}
	}

	private String sortStr(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	public static void main(String[] args) {
		
		CC_SortSearch_10_2_Group_Anagrams test = new CC_SortSearch_10_2_Group_Anagrams();
		
		// sort all the strings
		String[] arr = { "acre", "abcde", "race", "care", "acrd" };
		Arrays.sort(arr, test.new AnagramComparator());
		System.out.println(Arrays.toString(arr));
		
		// only group anagram strings
		String[] arr1 = { "acre", "abcde", "race", "care", "acrd" };
		test.sort(arr1);
		System.out.println(Arrays.toString(arr1));
	}

}
