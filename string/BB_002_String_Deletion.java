package string;

import java.util.HashSet;

/**
 * 
 * BB.String.002 String Deletion
 * 
 * Question : Given a string and a dictionary HashSet, write a function to
 * determine the minimum number of characters to delete to make a word.
 *
 * e.g.
 *
 * dictionary: [“a”, “aa”, “aaa”] query: “abc”
 * 
 * output: 2
 * 
 */
public class BB_002_String_Deletion {

	public static int strDeletion(HashSet<String> hs, String s) {
		int min = Integer.MAX_VALUE;

		for (String word : hs) {
			System.out.println("Checking word : " + word);

			int count = 0; // count the char to be deleted
			int remaining = 0; // number of chars after current location
			boolean found = false; // check if the char is found

			int i = 0, j = 0;

			for (i = 0; i < word.length(); i++) {
				for (; j < s.length(); j++) {
					if (word.charAt(i) != s.charAt(j)) {
						found = false;
						count++;
					} else {
						found = true;
						remaining = s.length() - j - 1;
						j++; // move pointer to next char before break out
						break; // check next char in word
					}
				}
			}

			// the string can be used to make the word
			if (found) {
				count = count + remaining; // number of chars to be deleted
				System.out.println("Need delete : " + count);
				min = Math.min(min, count);
			}
		}

		return min;
	}

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("a");
		hs.add("aa");
		hs.add("aaa");

		System.out.println("Minimum delete to make word : " + strDeletion(hs, "naaa"));
	}

}
