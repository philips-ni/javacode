package math;

/**
 * LC.Math.029 Divide Two Integers
 * 
 * Question : Divide two integers without using multiplication, division and mod
 * operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 */
public class LC_029_Divide_Two_Integers {

	public static int divide(int dividend, int divisor) {
		int sign = 1;

		// get sign
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;

		// handle edge cases
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend == 0 || dividend < divisor)
			return 0;

		int res = do_divide(dividend, divisor);

		res = (int) (sign * res);

		return res;

	}

	private static int do_divide(int dividend, int divisor) {
		// exit condition
		if (dividend < divisor)
			return 0;

		// since dividend is greater than divisor, there is at least one divisor
		// for sum
		int sum = divisor;
		int multiple = 1;

		// find greatest multiple so that (divisor*multiple<=dividend)
		// moving with stride 1,2,4,8,...,2^n for higher efficiency
		// using addition instead of multiply
		while ((sum + sum) <= dividend) {
			sum += sum;
			multiple += multiple;
		}

		// find additional value from remaining (dividend - sum) recursively
		return multiple + do_divide(dividend - sum, divisor);

	}

	public static void main(String[] args) {

		System.out.println("Input  : " + "21/4");
		System.out.println("Output : " + divide(21, 4));

	}

}
