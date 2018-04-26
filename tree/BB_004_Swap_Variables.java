package tree;

/**
 * BB.BitManipulation.004 Swap Variables
 * 
 * Question : Given two integers, write a function that swaps them without using
 * any temporary variables.
 * 
 * 
 *
 */
public class BB_004_Swap_Variables {

	public static void swap(int x, int y) {
		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("x : " + x + " , y : " + y);
	}

	public static void swap_bit(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x : " + x + " , y : " + y);
	}

	public static void main(String[] args) {
		swap(3, 5);
		swap_bit(3, 5);

	}

}
