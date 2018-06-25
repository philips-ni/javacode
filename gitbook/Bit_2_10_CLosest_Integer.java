package gitbook;

/**
 * Bit.2.10 Closest Integer
 * 
 * Problem : Given an integer, find the closest integer with the same weight.
 * Here weight is defined as the count of set bits in the decimal representation
 * of the integer.
 *
 */
public class Bit_2_10_CLosest_Integer {

	public static int closestInt(int x) {
		for (int i = 0; i < 32; i++) {

			// check if consecutive bits are different
			int current_bit = (x >> i) & 1;
			int previous_bit = (x >> (i + 1)) & 1;
			if ((current_bit ^ previous_bit) == 1) {

				// flip each bit
				x = x ^ (1 << i);
				x = x ^ (1 << i + 1);
				return x;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(closestInt(7));
	}
}
