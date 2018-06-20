package gitbook;

/**
 * Bit.2.7 Compute Parity
 * 
 * Problem : Given an integer compute its parity (number of set bits). For
 * negative numbers the MSB will be set, take that into account while counting
 * set bits.
 *
 */
public class Bit_2_7_Compute_Parity {

	public static int count(int x) {
		if (x == 0 || x == 1)
			return x;

		int count = 0;
		if (x < 0) {
			count++;
			x = -x;
		}

		while (x != 0) {
			count++;
			x = x & (x - 1);// drop lowest set bit of x
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count(8));
	}
}
