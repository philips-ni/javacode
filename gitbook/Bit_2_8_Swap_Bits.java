package gitbook;

/**
 * Bit.2.8 Swap Bits
 * 
 * Problem : Given an integer n and two bit positions p1 and p2 inside it, swap
 * bits at the given positions. The given positions are from least significant
 * bit (lsb). For example, the position for lsb is 0.
 *
 */
public class Bit_2_8_Swap_Bits {

	public static int swap(int x, int i, int j) {
		if (x == 0 || x == 1)
			return x;

		int bit_i = (x >> i) & 1; // get bit at position i
		int bit_j = (x >> j) & 1; // get bit at position j

		if (bit_i != bit_j) {
			x = (1 << i) ^ x; // flip the bit at position i
			x = (1 << j) ^ x; // flip the bit at position j
		}

		return x;
	}

	public static void main(String[] args) {
		System.out.println(swap(5, 1, 2));
	}
}
