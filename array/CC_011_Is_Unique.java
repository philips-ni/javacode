package array;

/**
 * CC.1.1 Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 * 
 */
public class CC_011_Is_Unique {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) // assume it's ASCII string
			return false;

		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueChars_bf(String str) {
		if (str.length() > 128) // assume it's ASCII string
			return false;

		// no additional data structure
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {

				if (i != j) {
					if (str.charAt(i) == str.charAt(j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String str = "Helowrd";
		System.out.println("Input  : " + str);
		System.out.println("Output : " + isUniqueChars(str));
		System.out.println("Output : " + isUniqueChars_bf(str));

	}
}
