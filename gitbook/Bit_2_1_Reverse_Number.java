package gitbook;

/**
 * Bit.2.1 Reverse Number
 * 
 * Problem : Given an integer, reverse it
 * 
 * e.g. 321 - > 123
 *
 */
public class Bit_2_1_Reverse_Number {

	public static int reverseNumber(int x) {
		int result = 0;
		boolean neg = false;

		if (x == 0)
			return x;
		if (x < 0)
			neg = true;
		
		while (x != 0) {
			int digit = x % 10;
			x = x / 10;
			result = result * 10 + digit;
		}

		return neg ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(reverseNumber(321));
	}
}
