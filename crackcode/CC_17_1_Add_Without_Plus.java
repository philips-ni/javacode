package crackcode;

/**
 * CC.17.1 Add without plus
 * 
 * Question : Write a function that adds two numbers. You should not use + or
 * any arithmetic operators.
 *
 */
public class CC_17_1_Add_Without_Plus {

	public static int add(int a, int b) {
		if (b == 0)
			return a;

		int sum = a ^ b;
		int carry = (a & b) << 1;

		return add(sum, carry);
	}

	public static int add_iteratively(int a, int b) {
		while (b != 0) {
			int sum = a ^ b;
			int carry = (a & b) << 1;
			a = sum;
			b = carry;
		}

		return a;
	}

	public static void main(String[] args) {
		System.out.println(add(5, 3));
		System.out.println(add_iteratively(5, 3));
	}

}
