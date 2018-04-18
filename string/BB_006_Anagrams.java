package string;

import array.BB_014_Anagrams;

/**
 * BB.String.006 Anagrams
 * 
 * Question : Given two strings, write a function to determine whether
 * they are anagrams.
 * 
 * e.g.
 * 
 * isAnagram("", "") = true
 * 
 * isAnagram("A", "A") = true
 * 
 * isAnagram("A", "B") = false
 * 
 * isAnagram("ab", "ba") = true
 * 
 * isAnagram("AB", "ab") = true
 * 
 */
public class BB_006_Anagrams {		

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] chars = new int[128];

		for (char c : s1.toCharArray()) {
			chars[c]++;
		}

		for (char c : s2.toCharArray()) {
			chars[c]--;
		}

		for (int i : chars) {
			if (i != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("abb", "bab"));

	}
}
