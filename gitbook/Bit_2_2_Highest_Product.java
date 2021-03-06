package gitbook;

/**
 * Bit.2.2 Highest Product of 3 Number
 * 
 * Problem :      Given an Integer array, find the highest product with 3
 * Integers.                                                                  
 *               
 *
 */
public class Bit_2_2_Highest_Product {

	public static int highestProduct(int[] a) {
		int highest = Math.max(a[0], a[1]);
		int lowest = Math.min(a[0], a[1]);

		int highest_product_of_2 = a[0] * a[1];
		int lowest_product_of_2 = a[0] * a[1];

		int highest_product_of_3 = a[0] * a[1] * a[2];

		int i = 2;
		while (i < a.length) {
			highest_product_of_3 = Math.max(highest_product_of_3,
					Math.max(highest_product_of_2 * a[i], lowest_product_of_2 * a[i]));

			highest_product_of_2 = Math.max(highest_product_of_2, highest * a[i]);
			lowest_product_of_2 = Math.min(lowest_product_of_2, lowest * a[i]);

			highest = Math.max(highest, a[i]);
			lowest = Math.min(lowest, a[i]);

			i++;
		}

		return highest_product_of_3;
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 5, 3, 1, 9, 6 };
		System.out.println(highestProduct(a));
	}
}
