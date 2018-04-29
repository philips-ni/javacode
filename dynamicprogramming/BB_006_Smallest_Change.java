package dynamicprogramming;

/**
 * BB.Recursion.011 Smallest change
 * 
 * Question : Given an input amount of change x, write a function to determine
 * the minimum number of coins required to make that amount of change.
 * 
 */
public class BB_006_Smallest_Change {

	public static int change(int x, int[] coins) {
		if (x == 0)
			return 0;

		int min = x;
		for (int coin : coins) {
			if (x - coin >= 0) {
				int c = change(x - coin, coins);
				if (min > c + 1)
					min = c + 1;
			}
		}
		return min;
	}

	public static int change_dp(int x, int[] coins) {
		int[] cache = new int[x];
		for (int i = 1; i < x; i++) {
			cache[i] = -1;
		}
		return change_dp(x, coins, cache);
	}

	public static int change_dp(int x, int[] coins, int[] cache) {
		if (x == 0)
			return 0;

		int min = x;
		for (int coin : coins) {
			if (x - coin >= 0) {
				int c;
				if (cache[x - coin] >= 0)
					c = cache[x - coin];
				else {
					c = change_dp(x - coin, coins, cache);
					cache[x - coin] = c;
				}
				if (min > c + 1)
					min = c + 1;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 5, 10, 25 };
		System.out.println(change(32, coins));
		System.out.println(change_dp(32, coins));
	}
}
