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

	private static int[] coins = new int[] { 1, 5, 10, 25 };
	
	public static int makeChange(int change) {

		if (change == 0)
			return 0;

		int minCoins = Integer.MAX_VALUE;

		// Removing every single coin to see how many coins are needed for
		// remaining change
		for (int coin : coins) {
			if (coin <= change) {
				int curMinCoins = makeChange(change - coin);
				minCoins = Math.min(minCoins, curMinCoins);
			}
		}

		// Adding back the removed coin
		return minCoins + 1;

	}

	public static int makeChange_topdown_helper(int change) {

		int[] cache = new int[change + 1];
		for (int i = 0; i <= change; i++) {
			cache[i] = -1;
		}

		return makeChange_topdown(change, cache);
	}

	private static int makeChange_topdown(int change, int[] cache) {
		if (cache[change] >= 0)
			return cache[change];

		int minCoins = Integer.MAX_VALUE;

		for (int coin : coins) {
			if (coin <= change) {
				int curMinCoins = makeChange_topdown(change - coin, cache);
				minCoins = Math.min(curMinCoins, minCoins);
			}
		}

		cache[change] = minCoins + 1;

		return cache[change];
	}

	public static void main(String[] args) {

		System.out.println(makeChange(16));
		System.out.println(makeChange_topdown_helper(16));
	}
}
