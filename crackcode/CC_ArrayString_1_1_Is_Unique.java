package crackcode;

import java.util.Arrays;

/**
 * 
 * CC.ArrayString.1.1 Is Unique
 * 
 * Question : Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structure?
 *
 */
public class CC_ArrayString_1_1_Is_Unique {

	public static boolean isUnique(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		return true;
	}

	public static boolean isUnique_hash(String s) {
		// assuming the character set is ASCII
		if (s.length() > 128)
			return false;

		boolean[] c = new boolean[128];

		for (int i = 0; i < s.length(); i++) {
			if (!c[s.charAt(i)])
				c[s.charAt(i)] = true;
			else
				return false;
		}
		return true;
	}

	public static boolean isUnique_Sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);

		// check neighbor
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == c[i + 1])
				return false;
		}
		return true;
	}

	public static boolean isUnique_Index(String s) {
		for (char c : s.toCharArray()) {
			if (s.indexOf(c) != s.lastIndexOf(c))
				return false;
		}

		return true;
	}

	public static boolean isUnique_Bit(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;

			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isUnique("abcda"));
		System.out.println(isUnique_hash("abcda"));
		System.out.println(isUnique_Sort("abcda"));
		System.out.println(isUnique_Index("abcda"));
		System.out.println(isUnique_Bit("abcda"));
	}

}
