package crackcode;

/**
 * BB.ArrayString.1.4 Palindrome Permutation
 * 
 * Question : Given a string, write a function to check if it is a permutation
 * of a palindrome.
 * 
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * 
 * e.g.
 * 
 * Input : Tact Coa
 * 
 * Output : True(permutations:"taco cat","atco cta",etc.)
 * 
 * To be a permutation of a palindrome, a string can have no more than one
 * character that is odd.
 *
 */
public class CC_ArrayString_1_4_Palindrome_Permutation {

	public static boolean isPalindromePermutation(String s) {
		int[] count = new int[128]; // assume it's ASCII string
		charFreq(s, count);
		if (checkOddNumber(count) > 1)
			return false;
		return true;
	}

	private static void charFreq(String s, int[] count) {
		s = s.toLowerCase(); // assume it's not case sensitive
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
	}

	private static int checkOddNumber(int[] count) {
		int odds = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 == 1)
				odds++;
		}
		return odds;
	}

	public static boolean isPalindromePermutation_Opt(String s) {
		int[] count = new int[128]; // assume it's ASCII string
		int odds = 0;
		s=s.toLowerCase(); // assume it's not case sensitive

		for (int i = 0; i < s.length(); i++) {
			// Though we have to look through the entire string, we can count
			// overall odd number as we go.
			char c = s.charAt(i);
			count[c]++;
			if (count[c] % 2 == 1)
				odds++;
			else
				odds--;
		}

		return odds <= 1;
	}

	public static void main(String[] args) {
		String s = "Tact  Coa";
		System.out.println(isPalindromePermutation(s));
		System.out.println(isPalindromePermutation_Opt(s));
	}
}
