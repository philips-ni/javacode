package array;

/**
 * BB.Array.002 0-1 Knapsack
 * 
 * Question: Given a list of items with values and weights, as well as a max
 * weight, find the maximum value you can generate from items where the sum of
 * the weights is less than the max.
 * 
 * e.g.
 * 
 * Input : items = {(w:1,v:6), (w:2, v:10), (w:3, v:12)}, maxWeight = 5
 * 
 * Output : knapsack(items,maxWeight) = 22
 * 
 */
public class BB_002_Knapsack {
	
	public static int knapsack(int[] value, int[] weight, int W) {

		if (value.length != weight.length)
			return 0;

		return knapsack(value, weight, W, 0);
	}

	private static int knapsack(int[] value, int[] weight, int W, int i) {
		// return when we reach end of list
		if (i == weight.length)
			return 0;

		// if weight is greater than W, ignore current item
		if (W < weight[i])
			return knapsack(value, weight, W, i + 1);

		// try both including and excluding the current item
		return Math.max(knapsack(value, weight, W - weight[i], i + 1) + value[i], knapsack(value, weight, W, i + 1));
	}
	public static void main(String[] args) {
		int[] v = { 6, 10, 12 };
		int[] w = { 1, 2, 3 };
		int W = 5;
		System.out.println(knapsack(v, w, W));

	}

}
