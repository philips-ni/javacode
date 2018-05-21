package crackcode;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static ArrayList<String> uniqPerms(String str){
		ArrayList<String> words = getPerms(str);
		HashSet<String> set = new HashSet<String>();

		ArrayList<String> uniq = new ArrayList<String>();
		for (int i = 0; i < words.size(); i++) {
			if (!set.contains(words.get(i))) {
				set.add(words.get(i));	
				uniq.add(words.get(i));
			}
		}
		
		return uniq;
	}

	public static void main(String[] args) {
		ArrayList<String> words = uniqPerms("aba");
		for(int i=0;i<words.size();i++)
			System.out.println(words.get(i));
	}
}
