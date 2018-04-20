package leetcode;

/**
 * LC.009 Palindrome Number
 * 
 * Question : Determine whether an integer is a palindrome. Do this without
 * extra space.
 * 
 * Hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 */
public class LC_009_Palindrome_Number {

	public static boolean isPalindromeInteger(int x) {
		// handle negative case and last digit = 0 case
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;

		int rev = 0;

		// Only compare half of the digits in x, so don't need to deal with
		// overflow
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		// even or odd number of digits
		return (x == rev || x == rev / 10);
	}

	public static void main(String[] args) {

		System.out.println(isPalindromeInteger(123321)); // even number
		System.out.println(isPalindromeInteger(1235321)); // odd number

	}

}
