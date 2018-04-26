package bitmanipulation;

/**
 * BB.BitManipulation.003 Sum
 * 
 * Question : Given two integers, write a function to sum the numbers
 * without using any arithmetic operators.
 * 
 * e.g. sum(5+3) = 8
 */
public class BB_003_Sum {

	public static int sum(int a, int b) {
		if (b == 0)
			return a;
		int partialSum = a ^ b;
		int carry = (a & b) << 1;
		return sum(partialSum, carry);
	}

	public static void main(String[] args) {
		
		System.out.println(sum(5, 3));
	}
}
