package gitbook;

/**
 * Bit.2.4 Find Twice
 * 
 * Problem : Given an array where every number in the range 1...n appears once
 * except for one number which appear twice. Write a function to find the number
 * that appears twice.
 *
 */
public class Bit_2_4_Find_Twice {

	public static int findTwice(int[] a, int n) {
		int expected = n * (n + 1) / 2;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum - expected;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 8 };
		System.out.println(findTwice(a, 8));
	}
}
