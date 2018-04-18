package dynamicprogramming;

/**
 * Fibonacci number
 * 
 * Question : Given an integer n, write a function to compute the nth Fibonacci
 * number.
 *
 * e.g.
 * 
 * fibonacci(1) = 1
 * 
 * fibonacci(5) = 5
 * 
 * fibonacci(10) = 55
 */
public class BB_004_Fibonacci_Number {
	
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static int fib_topdown_helper(int n) {
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

	public static int fib_bottomup(int n) {
		if (n < 2)
			return n;

		int[] cache = new int[n + 1];
		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 2] + cache[i - 1];
		}

		return cache[n];
	}

	public static int fib_bottomup_optimal(int n) {
		if (n < 2)
			return n;

		int first = 0;
		int second = 1;
		int third = -1;

		for (int i = 2; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}

		return third;
	}
	public static void main(String[] args) {
		System.out.println(fib(6));
		System.out.println(fib_topdown_helper(6));
		System.out.println(fib_bottomup(6));
		System.out.println(fib_bottomup_optimal(6));

	}

}
