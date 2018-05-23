package crackcode;

/**
 * CC.16.9 Operations
 * 
 * Question : Write methods to implement the multiply, subtract and divide
 * operations for integers. The results of all of these are integers. Use only
 * the add operator.
 *
 */
public class CC_16_9_Operations {

	public static int minus(int a, int b) {
		return a + negate(b); // a - b = a + (-1)*b
	}

	private static int negate(int x) {
		int sign = x > 0 ? -1 : 1;
		int negate = 0;

		while (x != 0) {
			negate += sign; // the negation of x is to add -1(or 1) x times.
			x += sign;
		}

		return negate;
	}

	public static int multiply(int a, int b) {
		if (a < b)
			return multiply(b, a);

		int sum = 0;

		for (int i = abs(b); i > 0; i = minus(i, 1)) {
			sum += a; // sum a for b times
		}

		if (b < 0)
			sum = negate(sum);

		return sum;
	}

	private static int abs(int x) {
		if (x < 0)
			return negate(x);
		else
			return x;
	}

	public static int divide(int a, int b) {
		if (b == 0)
			throw new ArithmeticException("zero dividend");

		int a1 = abs(a);
		int b1 = abs(b);

		int product = 0;
		int x = 0;

		while (product + b1 < a1) {
			product += b1; // adding b to itself x times
			x++;
		}

		if ((a < 0 && b < 0) || (a > 0 & b > 0))
			return x;
		else
			return negate(x);

	}

	public static void main(String[] args) {
		System.out.println(minus(10, 8));
		System.out.println(multiply(10, 8));
		System.out.println(divide(10, 8));
	}

}
