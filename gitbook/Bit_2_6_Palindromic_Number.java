package gitbook;

import java.util.Stack;

/**
 * Bit.2.6 Palindromic Number
 * 
 * Problem : Given a number test if it's a palindrome.
 *
 */
public class Bit_2_6_Palindromic_Number {

	private static int reverseNumber(int x) {
		int reversed = 0;
		while (x != 0) {
			int digit = x % 10;
			x = x / 10;
			reversed = reversed * 10 + digit;
		}
		return reversed;
	}

	public static boolean isPalindrome(int x) {
		if (x == reverseNumber(x))
			return true;
		else
			return false;
	}

	public static boolean isPalindrome_Stack(int x) {
		Stack<Integer> st = new Stack<Integer>();
		int y = x;
		while (y != 0) {
			st.push(y % 10);
			y = y / 10;
		}

		while (!st.isEmpty()) {
			if (st.pop() == (x % 10))
				x = x / 10;
			else
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(321));
		System.out.println(isPalindrome(32123));
		System.out.println(isPalindrome_Stack(321));
		System.out.println(isPalindrome_Stack(32123));
	}

}
