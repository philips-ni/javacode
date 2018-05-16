package crackcode;

/**
 * CC.Recursion.8.11 Coins
 *
 * Question : Given an infinite number of quarters,dimes,nickels and pennies,
 * write code to calculate the number of ways of representing n cents.
 *
 */
public class CC_Recursion_8_11_Coins {

	public static int makeChange(int[] coins, int target) {

		if (target == 0)
			return 1;

		int ways = 0;
		for (int coin : coins) {
			if (target - coin >= 0) {
				ways += makeChange(coins, target - coin);
			}
		}

		return ways;
	}

	public static int makeChange(int[] coins, int target, int index) {
		if (index >= coins.length - 1)
			return 1; // reach the last coin

		int coin = coins[index];

		int ways = 0;

		for (int i = 0; i * coin <= target; i++) {
			int remainingTarget = target - i * coin;
			ways += makeChange(coins, remainingTarget, index + 1);
		}
		return ways;
	}
	
	public static int makeChange_dp_helper(int[] coins, int n) {
		int[][] map = new int[n+1][coins.length];
		return makeChange_dp(coins,n,0,map);
	}
	public static int makeChange_dp(int[] coins, int target, int index,int[][] map) {
		if(map[target][index]>0) return map[target][index];
		
		if (index >= coins.length - 1)
			return 1; // reach the last coin

		int coin = coins[index];

		int ways = 0;

		for (int i = 0; i * coin <= target; i++) {
			int remainingTarget = target - i * coin;
			ways += makeChange_dp(coins, remainingTarget, index + 1,map);
		}
		
		map[target][index] = ways;
		return ways;
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5, 1 };
		System.out.println(makeChange(coins, 10));
		System.out.println(makeChange(coins, 10, 0));
		System.out.println(makeChange_dp_helper(coins, 10));
	}

}