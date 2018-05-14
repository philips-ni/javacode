package crackcode;

/**
 * CC.Recursion.6.1 Fibonacci
 * 
 * Question : Write a method to generate the nth Fibonacci number.
 *
 */
public class CC_Recursion_6_1_Fibonacci {

	public static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (n > 1)
			return fib(n - 2) + fib(n - 1);
		else
			return -1;
	}

	public static int fib_dp(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int[] cache = new int[n+1];
		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++)
			cache[i] = -1;

		return fib_dp(n, cache);
	}

	private static int fib_dp(int n, int[] cache) {

		if (cache[n] != -1)
			return cache[n];

		cache[n] = fib_dp(n - 2, cache) + fib_dp(n - 1, cache);
		
		return cache[n];

	}

	public static int fib_iterative(int n) {
		if (n < 0)
			return -1;

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int n1 = 0, n2 = 1;

		for (int i = 2; i <= n; i++) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}

		return n2;
	}

	public static void main(String[] args) {
		System.out.println(fib(3));
		System.out.println(fib_iterative(3));
		System.out.println(fib_dp(3));
	}

}
