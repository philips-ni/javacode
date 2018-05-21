package crackcode;

import java.util.HashSet;

/**
 * CC.Recursion.8.8 Permutations with Duplicates
 * 
 * Question : Write a method to compute all permutations of a string whose
 * characters are not necessarily unique. The list of permutations should not
 * have duplicates.
 *
 */
public class CC_Recursion_8_8_Permutations_With_Dups {

	public static HashSet<String> getPerms(String str) {

		HashSet<String> permutations = new HashSet<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
		} else {
			char first = str.charAt(0);
			String remainder = str.substring(1);

			HashSet<String> words = getPerms(remainder);
			for (String word : words) {
				for (int i = 0; i <= word.length(); i++) {
					String s = insertChar(word, first, i);
					permutations.add(s);
				}
			}
		}

		return permutations;
	}

	private static String insertChar(String s, char c, int i) {
		String s1 = s.substring(0, i);
		String s2 = s.substring(i);
		return s1 + c + s2;
	}

	public static void main(String[] args) {
		HashSet<String> words = getPerms("aba");
		for (String s : words)
			System.out.println(s);
	}
}
