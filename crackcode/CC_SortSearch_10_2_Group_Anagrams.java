package crackcode;

import java.util.Arrays;
import java.util.Comparator;

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

	public class AnagramComparator implements Comparator<String>{
		private String sortStr(String s) {
			char[] a = s.toCharArray();
			Arrays.sort(a);
			return new String(a);
		}
		public int compare(String s1, String s2) {
			return sortStr(s1).compareTo(sortStr(s2));
		}
	}
	public static void main(String[] args) {
		String[] arr= {"acre","abcde","race","care","acrd"};
		Arrays.sort(arr, new AnagramComparator());
	}

}
