package dynamicprogramming;

/**
 * BB.DP.007 Make change 
 * 
 * Question : Given an integer representing a given amount of change,
 * write a function to compute the total number of coins required to make
 * that amount of change. You can assume that there is always a coin.
 * 
 */
public class BB_007_Make_Change {

	public static int makeChange(int x, int[] coins) {
		if (x == 0)
			return 0;

		int min = x; 
		for (int coin : coins) {
			if (x - coin >= 0) {
				int c = makeChange(x - coin, coins);
				if (min > c + 1) // add back the removed coin
					min = c + 1;
			}
		}
		return min;
	}

	public static int makeChange_dp(int x, int[] coins) {
		int[] cache = new int[x];
		for (int i = 1; i < x; i++) {
			cache[i] = -1;
		}
		return makeChange_dp(x, coins, cache);
	}

	public static int makeChange_dp(int x, int[] coins, int[] cache) {
		if (x == 0)
			return 0;

		int min = x;
		for (int coin : coins) {
			if (x - coin >= 0) {
				int c;
				if (cache[x - coin] >= 0)
					c = cache[x - coin];
				else {
					c = makeChange_dp(x - coin, coins, cache);
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
		System.out.println(makeChange(50, coins));
		System.out.println(makeChange_dp(32, coins));
	}
}
