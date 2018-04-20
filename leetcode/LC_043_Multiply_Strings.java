package leetcode;

/**
 * LC.Math.043 Multiply Strings
 * 
 * Question : Given two non-negative integers num1 and num2 represented as
 * strings, return the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 */
public class LC_043_Multiply_Strings {

	public static String multiply(String num1, String num2) {

		int len1 = num1.length();
		int len2 = num2.length();

		int[] num = new int[len1 + len2];

		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				int mul = d1 * d2;

				int pos1 = i + j;
				int pos2 = i + j + 1;

				int sum = mul + num[pos2];

				num[pos1] += sum / 10;
				num[pos2] = sum % 10;

				System.out.println(pos1 + "," + pos2 + " : " + num[pos1] + "," + num[pos2]);

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < num.length; k++) {
			if (!(sb.length() == 0 && num[k] == 0))
				sb.append(num[k]); // ignore the start 0
		}

		return sb.length() == 0 ? "0" : sb.toString();

	}

	public static void main(String[] args) {
		
		System.out.println("Output : " + multiply("23", "16"));
		
	}

}
