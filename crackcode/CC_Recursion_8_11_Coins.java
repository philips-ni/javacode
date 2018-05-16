package crackcode;

/**
 * CC.Recursion.8.11 Coins
 *
 * Question : Given an infinite number of quarters,dimes,nickels and pennies,
 * write code to calculate the number of ways of representing n cents.
 *
 */
public class CC_Recursion_8_11_Coins {

	public static int makeChange(int x, int[] coins, int index) {
		if (index >= coins.length - 1) // reach the last coin 
			return 1; 

		int coin = coins[index];

		int ways = 0;

		for (int i = 0; i * coin <= x; i++) {
			int remaining = x - i * coin;
			ways += makeChange( remaining, coins, index + 1);
		}

		return ways;
	}

	public static int makeChange_dp(int x, int[] coins) {
		int[][] map = new int[x + 1][coins.length];
		return makeChange_dp(x, coins, 0, map);
	}

	public static int makeChange_dp(int x, int[] coins, int index, int[][] map) {
		if (map[x][index] > 0)
			return map[x][index];

		if (index >= coins.length - 1)
			return 1; // reach the last coin

		int coin = coins[index];

		int ways = 0;

		for (int i = 0; i * coin <= x; i++) {
			int remaining = x - i * coin;
			ways += makeChange_dp(remaining,coins, index + 1, map);
		}

		map[x][index] = ways;
		return ways;
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5, 1 };
		System.out.println(makeChange(10,coins,0));
		System.out.println(makeChange_dp(10,coins));
	}
}