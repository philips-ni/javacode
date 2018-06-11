package bitmanipulation;

/**
 * BB.BitManipulation.003 Sum
 * 
 * Question : Given two integers, write a function to sum the numbers without
 * using any arithmetic operators.
 * 
 * e.g. sum(5+3) = 8
 */
public class BB_003_Sum {

	public static int sum(int a, int b) {
		if (b == 0)
			return a;
		int sum = a;
		while (b != 0) {
			sum = a ^ b; // partial sum without carry bits
			b = (a & b) << 1; // carry bits
			a = sum; // save partial sum in a for next loop
		}
		return sum;
	}

	public static int sum_recur(int a, int b) {
		if (b == 0)
			return a;
		int partialSum = a ^ b;
		int carry = (a & b) << 1;
		return sum_recur(partialSum, carry);
	}
	
	public static int minus(int a,int b){
		int minus_b = sum(~b,1);
		return sum(a,minus_b);
	}

	public static void main(String[] args) {
		System.out.println(sum(5, 3));
		System.out.println(sum_recur(5, 3));
		System.out.println(sum(-5, 3));
		System.out.println(sum_recur(-5, 3));
		System.out.println(minus(5, -3));
		System.out.println(minus(-5, 3));
		System.out.println(minus(-5, -3));
		System.out.println(minus(5, 3));
	}
}
