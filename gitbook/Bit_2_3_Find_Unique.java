package gitbook;

/**
 * Bit.2.3 Find Unique
 * 
 * Problem : Given the array of IDs, which contains many duplicate integers and
 * one unique integer, find the unique one. Note: All Integers except one appear
 * exactly 2 times.
 *
 */
public class Bit_2_3_Find_Unique {

	public static int getUnique(int[] a) {
		int unique= a[0];
		
		for (int i=1;i<a.length;i++) {
			unique = unique ^ a[i];
		}
		return unique;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,5,2,4,5,6,7,8,7,8};
		System.out.println(getUnique(a));
	}
}
