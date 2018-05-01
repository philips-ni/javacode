package crackcode;

/**
 * 
 * CC.ArrayString.1.5 One Away
 * 
 * Question : There are three types of edits that can be performed on strings:
 * insert a character, remove a character or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * e.g.
 * 
 * pale, ple -> true
 * 
 * pales, pale -> true
 * 
 * pale, bale -> true
 * 
 * pale, bae -> false
 *
 */
public class CC_ArrayString_1_5_One_Away {

	public static boolean oneEdit(String s1, String s2) {
		if (s1.length() == s2.length())
			return oneEditReplace(s1, s2);
		else if (s1.length() == s2.length() - 1)
			return oneEditInsert(s1, s2);
		else if (s1.length() - 1 == s2.length())
			return oneEditInsert(s2, s1);
		return false;
	}

	private static boolean oneEditReplace(String s1, String s2) {
		boolean foundOne = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundOne)
					return false;
				foundOne = true;
			}
		}
		return true;
	}

	private static boolean oneEditInsert(String s1, String s2) {
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (i == j)
					j++;
				else
					return false;

			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneEdit("pale", "ple"));
		System.out.println(oneEdit("pale", "bae"));

	}

}
