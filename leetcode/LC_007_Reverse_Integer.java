package leetcode;

/**
 * LC.Math.007 Reverse Integer Reverse digits of an integer.
 * 
 * e.g.
 * 
 * input : x = 123, output : 321
 * 
 * input : x = -123 output : -321
 * 
 * Notes
 * 
 * 1. If the integer's last digit is 0, what should the output be? i.e., cases
 * such as 10, 100.
 * 
 * 2. Did you notice that the reversed integer might overflow? Assume the input
 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases? For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows. The input is assumed to be a
 * 32-bit signed integer. Your function should return 0 when the reversed
 * integer overflows.
 * 
 * 
 * Useful Information:
 * 
 * 1. The Java programming language is statically-typed, which means that all
 * variables must first be declared before they can be used.
 * 
 * 2. By default, the int data type is a 32-bit signed two's complement integer,
 * which has a minimum value of -2^31 and a maximum value of 2^31-1 A constant
 * holding the maximum value an int can have, 2^31-1.(2147483647) A constant
 * holding the minimum value an int can have, -2^31. (-2147483648)
 * 
 * 3. The long data type is a 64-bit two's complement integer. The signed long
 * has a minimum value of -2^63 and a maximum value of 2^63-1.
 * 
 */

public class LC_007_Reverse_Integer {

	public static int reverseInt(int x) {

		// check if last digit is 0
		if (x % 10 == 0)
			return 0;

		long rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;

			// overflow
			if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;

		}

		return (int) rev;
	}

	public static void main(String[] args) {

		System.out.println(reverseInt(10)); // last digit is 0
		System.out.println(reverseInt(10123)); // normal case
		System.out.println(reverseInt(1147483648)); // overflow
	}

}
