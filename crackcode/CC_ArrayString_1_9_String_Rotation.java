package crackcode;

/**
 * CC.ArrayString.1.9 String Rotation
 * 
 * Question : Assume you have a method isSubString which checks if one word is
 * substring of another. Given two strings, s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubString.
 * 
 * e.g.
 * 
 * "waterbottle" is a rotation of "erbottlewat"
 *
 */
public class CC_ArrayString_1_9_String_Rotation {

	private static boolean isSubString(String s1, String s2) {
		for (int i = 0; i <= s1.length()-s2.length(); i++) {
			if (s1.charAt(i) != s2.charAt(0))
				continue;

			if (s1.substring(i, i + s2.length()).equals(s2))
				return true;
		}
		return false;
	}

	public static boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			String s1s1 = s1 + s1;
			return isSubString(s1s1, s2);
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isRotation("waterbottle", "erbottlewat"));
		System.out.println(isRotation("abc", "cab"));
	}

}
