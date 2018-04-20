package leetcode;

/**
 * 
 * LC.String.005 Longest Palindromic Substring
 * 
 * Question : Given a string s, find the longest palindromic substring in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 */
public class LC_005_Longest_Palindromic_Substring {

	private static int start, maxLen;

	private static void findPalindrome(String s, int left, int right) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			// looking for next palindrome from left and right side
			left--;
			right++;
		}

		int curLen = right - left - 1;
		if (maxLen < curLen) {
			start = left + 1;
			maxLen = curLen;
		}
	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			findPalindrome(s, i, i); // odd length
			findPalindrome(s, i, i + 1); // even length.
		}
		return s.substring(start, start + maxLen);
	}

	public static void main(String args[]) {

		System.out.println("Input  : " + "babad");
		System.out.println("Output : " + longestPalindrome("babad"));

	}
}
