package dynamicprogramming;

import java.util.Arrays;

/**
 * BB.DP.007 Make change
 * 
 * Question : Given a value N, if we want to make change for N cents, and we
 * have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many
 * ways can we make the change? The order of coins does not matter.
 * 
 * e.g.
 * 
 * For N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2},
 * {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 * 
 * Solution:
 * 
 * To count the total number of solutions, we can divide all set solutions into
 * two sets.
 * 
 * 1) Solutions that do not contain mth coin (or Sm).
 * 
 * 2) Solutions that contain at least one Sm.
 * 
 * Let count(S[], m, n) be the function to count the number of solutions, then
 * it can be written as sum of count(S[], m-1, n) and count(S[], m, n-Sm).
 * 
 * Therefore, the problem has optimal substructure property as the problem can
 * be solved using solutions to subproblems.
 * 
 */
public class BB_007_Make_Change {

	static int makeChanges(int coins[], int num, int change) {
		// If change is 0 then there is 1 solution
		// (do not include any coin)
		if (change == 0)
			return 1;

		// If change is less than 0 then no solution exists
		if (change < 0)
			return 0;

		// If there are no coins and change is greater than 0, then no solution
		// exist
		if (num <= 0 && change >= 1)
			return 0;

		// count solutions excluding coins[num-1] and including at least one coins[num-1]
		return makeChanges(coins, num - 1, change) + makeChanges(coins, num, change - coins[num - 1]);
	}

	public static long makeChanges_bottomup(int coins[], int num, int change) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[change + 1];

		// Initialize all table values as 0
		Arrays.fill(table, 0); // O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < num; i++)
			for (int j = coins[i]; j <= change; j++)
				table[j] += table[j - coins[i]];

		return table[change];
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int coins[] = { 1, 5, 10, 25 };
		int num = coins.length;
		System.out.println(makeChanges(coins, num, 25));
		System.out.println(makeChanges_bottomup(coins, num, 25));
	}
}
