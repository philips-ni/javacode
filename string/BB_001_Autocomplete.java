package string;

import java.util.ArrayList;

/**
 * 
 * BB.String.001 Autocomplete
 * 
 * Question : Write an autocomplete class that returns all dictionary words with
 * a given prefix.
 *
 * e.g.
 *
 * dict: {"abc", "acd", "bcd", "def", "a", "aba"}
 * 
 * prefix: "a" -> "abc", "acd", "a", "aba" prefix: "b" -> "bcd"
 * 
 */
public class BB_001_Autocomplete {

	public static ArrayList<String> getWordsForPrefix(String[] dict, String prefix) {

		ArrayList<String> words = new ArrayList<String>();

		for (String s : dict) {
			if (prefix.length() > s.length())
				continue;

			boolean found = true;
			for (int j = 0; j < prefix.length(); j++) {
				if (prefix.charAt(j) != s.charAt(j)) {
					found = false;
					break;
				}
			}

			if (found)
				words.add(s);
		}
		return words;
	}

	public static void main(String[] args) {
		String[] dict = { "abc", "acd", "bcd", "def", "a", "aba" };
		System.out.println(getWordsForPrefix(dict, "a"));
	}

}
