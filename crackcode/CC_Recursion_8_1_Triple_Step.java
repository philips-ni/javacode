package crackcode;

import java.util.Arrays;

/**
 * CC.Recursion.8.1 Triple Step
 * 
 * Question : A child is running up a staircase with n steps and can hop either
 * 1 step, 2 steps or 3 steps at a time. Implement a method to count how many
 * possible ways the child can run up the stairs.
 *
 */
public class CC_Recursion_8_1_Triple_Step {

	public static int countWays(int n) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else
			return countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
	}

	public static int countWays_dp(int n) {
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		return countWays(n, cache);
	}

	private static int countWays(int n, int[] cache) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else if (cache[n] > -1)
			return cache[n];
		else {
			cache[n] = countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
			return cache[n];
		}

	}

	public static void main(String[] args) {
		System.out.println(countWays(3));
		System.out.println(countWays_dp(3));
	}
}
