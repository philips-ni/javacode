package leetcode;

import java.util.ArrayList;

/**
 * LC.Recursion.089 Gray Code
 * 
 * Question : The gray code is a binary numeral system where two successive
 * values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 *
 * Example 1:
 *
 * Input: 2
 * 
 * Output: [0,1,3,2]
 * 
 * Explanation: 00 - 0 01 - 1 11 - 3 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0 10 - 2 11 - 3 01 - 1
 * 
 * Example 2:
 * 
 * Input: 0
 * 
 * Output: [0]
 * 
 * Explanation: We define the gray code sequence to begin with 0.
 * 
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 =
 * 1. Therefore, for n = 0 the gray code sequence is [0].
 * 
 */
public class LC_089_Gray_code {

	public static ArrayList<Integer> grayCode(int n) {
		if (n == 0) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}

		ArrayList<Integer> result = grayCode(n - 1);
		int addend = 1 << (n - 1); // add 1 before current highest bit
		int size = result.size();
		for (int i = size - 1; i >= 0; i--) { // add bit in reverse order
			result.add(result.get(i) + addend);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
}
