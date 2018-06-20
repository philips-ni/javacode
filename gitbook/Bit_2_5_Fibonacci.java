package gitbook;

/**
 * Bit.2.5 Fibonacci
 *
 */
public class Bit_2_5_Fibonacci {

	public static int fib(int n) {
		if (n == 0 || n == 1)
			return n;

		int first = 0;
		int second = 1;
		int third = 0;
		for (int i = 2; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}
	
	public static int fib_recur(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib_recur(n - 1) + fib_recur(n - 2);
	}

	public static int fib_dp(int n) {
		if (n < 2)
			return n;

		int[] cache = new int[n + 1];
		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {
			cache[i] = -1;
		}

		return fib(n, cache);
	}

	private static int fib(int n, int[] cache) {

		// already computed
		if (cache[n] >= 0)
			return cache[n];

		// recursive computation by saving to cache
		cache[n] = fib(n - 2, cache) + fib(n - 1, cache);

		return cache[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
