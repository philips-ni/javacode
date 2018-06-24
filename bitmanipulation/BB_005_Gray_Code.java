package bitmanipulation;

/**
 * BB.BitManipulation.005 Gray Code
 * 
 * Question : Given two integers, write a function to determine whether or not
 * their binary representations differ by a single bit.
 * 
 * e.g.
 * 
 * gray(0, 1) = true
 * 
 * gray(1, 2) = false
 *
 */
public class BB_005_Gray_Code {

	public static boolean grayCode_bf(int a, int b) {
		if (a == b)
			return false; // all bits are equal

		int count = 0; // count number of different bits

		while (a != 0 || b != 0) {
			int lsb_a = a & 1; // get last bit of a
			int lsb_b = b & 1; // get last bit of b
			if ((lsb_a ^ lsb_b) == 1) {  // check if last bit of a and b is equal or not
				count++;
			}
			if (count > 1)
				return false;
			else {
				a >>= 1;
				b >>= 1;
			}
		}
		return true;
	}

	public static boolean grayCode(int a, int b) {
		int x = a ^ b;

		while (x > 0) {
			if (x % 2 == 1 && x >> 1 > 0)
				return false;
			x = x >> 1;
		}
		return true;
	}

	public static boolean grayCode_1(int a, int b) {
		int x = a ^ b;
		return (x & (x - 1)) == 0;
	}

	public static void main(String[] args) {

		System.out.println(grayCode_bf(0, 1));
		System.out.println(grayCode_bf(0, 9));
		System.out.println(grayCode_bf(2, 1));

		System.out.println(grayCode(0, 1));
		System.out.println(grayCode(2, 1));

		System.out.println(grayCode_1(0, 1));
		System.out.println(grayCode_1(2, 1));

	}
}