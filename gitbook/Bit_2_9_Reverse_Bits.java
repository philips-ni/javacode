package gitbook;

/**
 * Bit.2.9 Reverse Bits
 * 
 * Problem : Given an integer, reverse the bits in it.
 *
 */
public class Bit_2_9_Reverse_Bits {

	public static int veverse(int x) {
		if (x == 0 || x == 1)
			return x;

		int result = 0;
		while (x > 0) {
			int last = x & 1; // get last bit

			if (last == 1) {
				result = (result << 1) ^ 1;
			} else {
				result = result << 1;
			}
			x = x >> 1; // drop last bit
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(veverse(8));
	}
}
