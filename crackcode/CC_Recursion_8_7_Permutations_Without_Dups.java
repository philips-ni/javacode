package crackcode;

import java.util.ArrayList;

/**
 * CC.Recursion.8.7 Permutations without dups
 * 
 * Question : Write a method to compute all permutations of a string of unique
 * characters.
 *
 */
public class CC_Recursion_8_7_Permutations_Without_Dups {

	public static ArrayList<String> getPerms(String str) {
		if (str == null)
			return null;

		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String s = insertChar(word, first, i);
				permutations.add(s);
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
		ArrayList<String> words = getPerms("abc");
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
	}

}
