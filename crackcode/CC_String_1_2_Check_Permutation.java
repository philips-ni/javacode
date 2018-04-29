package crackcode;

import java.util.Arrays;

/**
 * 
 * CC.String.1.2 Check Permutation
 * 
 * Question : Given two strings, write a method to decide if one is a
 * permutation of the other.
 * 
 * Clarification : Case sensitive? Whitespace?
 * 
 * Permutation :
 * 
 * 1. If two strings are permutations, they have same characters in different
 * orders.
 *
 * 2. Definition - Two words with same character counts
 * 
 */
public class CC_String_1_2_Check_Permutation {

	public static String sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);

		return new String(c);
	}

	public static boolean permutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		return sort(s1).equals(sort(s2));
	}

	public static boolean permutation_hash(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] c = new char[128]; // need clarify the size of character set
		for (int i = 0; i < s1.length(); i++) {
			c[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			c[s2.charAt(i)]--;
			if (c[s2.charAt(i)] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(permutation("dog", "God "));
		System.out.println(permutation("dog", "god"));
		System.out.println(permutation_hash("dog", "God "));
		System.out.println(permutation_hash("dog", "god"));
	}

}
