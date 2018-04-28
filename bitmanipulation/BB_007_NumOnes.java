package bitmanipulation;

/**
 * 
 * BB.BitManipulation.007 Number of Ones in a Binary Number
 * 
 * Question : Given an integer, write a function to compute the number of ones
 * in the binary representation of the number.
 *
 */
public class BB_007_NumOnes {

	public static int ones(int x) {
		int sum = 0;

		while (x > 0) {
			sum += x & 1;
			x = x >> 1;
		}
		return sum;
	}

	public static int ones_1(int x) {
		int sum = 0;

		while (x > 0) {
			sum += x % 2;
			x = x >> 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(ones(10));
		System.out.println(ones_1(10));
	}

}
