package math;

import java.util.Arrays;

/**
 * 
 * Add one to number
 * 
 * Question : Given a non-negative number represented as an array of digits, add
 * 1 to the number
 * 
 */
public class Add_One_To_Number {

	public static int[] add_one(int[] arr) {
		int[] result = new int[arr.length];

		int carry = 1;

		for (int i = arr.length - 1; i >= 0; i--) {
			int sum = arr[i] + carry;
			if (sum == 10)
				carry = 1;
			else
				carry = 0;

			result[i] = sum % 10;
		}

		if (carry == 1) {
			result = new int[arr.length + 1];
			result[0] = 1;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] ao = { 1, 3, 2, 4 };
		System.out.println("Input  : " + Arrays.toString(ao));
		System.out.println("Output : " + Arrays.toString(add_one(ao)));
		
		int[] ao1 = { 1, 3, 2, 9 };
		System.out.println("Input  : " + Arrays.toString(ao1));
		System.out.println("Output : " + Arrays.toString(add_one(ao1)));
		
		int[] ao2 = { 9, 9, 9 };
		System.out.println("Input  : " + Arrays.toString(ao2));
		System.out.println("Output : " + Arrays.toString(add_one(ao2)));
	}

}
