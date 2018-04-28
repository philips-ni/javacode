package bitmanipulation;

/**
 * BB.BitManipulation.006 Rotate Bits
 * 
 * Question : Given a number, write a function to rotate the bits (ie circular
 * shift).
 *
 * e.g.
 * 
 * rotate(0xFFFF0000, 8) = 0x00FFFF00
 * 
 * rotate(0x13579BDF, 12) = 0xBDF13579
 * 
 * rotate(0b10110011100011110000111110000000, 17) =
 * 0b00011111000000010110011100011110
 * 
 */
public class BB_006_Rotate_Bits {

	private static final int BITS = 32;

	public static int rotateRight(int x, int n) {
		n = n % BITS;
		return (x >> n | x << (BITS - n));
	}

	public static int rotateLeft(int x, int n) {
		n = n % BITS;
		return (x << n | x >> (BITS - n));
	}

	public static void main(String[] args) {
		System.out.println(rotateRight(0b10110011100011110000111110000000, 17));
	}

}
