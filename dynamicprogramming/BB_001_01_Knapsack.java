package dynamicprogramming;

/**
 * 0-1 Knapsack
 * 
 * Question : Given a list of items with values and weights, as well as a max
 * weight, find the maximum value you can generate from items where the sum of
 * the weights is less than the max.
 *
 * e.g.
 * 
 * input : items = {(w:1, v:6), (w:2, v:10), (w:3, v:12)} maxWeight = 5
 * 
 * output : knapsack(items, maxWeight) = 22
 *
 */
public class BB_001_01_Knapsack {
	
	public static int knapsack(int[] value, int[] weight, int W) {

		if (value.length != weight.length)
			return 0;

		return knapsack(value, weight, W, 0);
	}

	private static int knapsack(int[] value, int[] weight, int W, int i) {
		// return if we have gone through all the items
		if (i == weight.length)
			return 0;

		// if weight is greater than W, ignore current item
		if (W < weight[i])
			return knapsack(value, weight, W, i + 1);

		// try both including and excluding the current item
		return Math.max(knapsack(value, weight, W - weight[i], i + 1) + value[i], knapsack(value, weight, W, i + 1));
	}
	
	public static void main(String[] args) {
		int[] weight= {1,2,3};
		int[] value={6,10,12};
		System.out.println(knapsack(value,weight,5));

	}

}
