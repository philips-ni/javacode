package string;

/**
 * LC.String.008 String to Integer (atoi)
 * 
 * Question : Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a
 * challenge, please do not see below and ask yourself what are the possible
 * input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no
 * given input specs). You are responsible to gather all the input
 * requirements up front.
 * 
 */
public class LC_008_String_to_Integer_atoi {

	public static int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;//
		str = str.trim();
		char firstChar = str.charAt(0);
		int sign = 1, start = 0, len = str.length();
		long sum = 0;
		if (firstChar == '+') {
			sign = 1;
			start++;
		} else if (firstChar == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < len; i++) {
			if (!Character.isDigit(str.charAt(i)))
				return (int) sum * sign;
			sum = sum * 10 + str.charAt(i) - '0';
			if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}

		return (int) sum * sign;
	}

	public static void main(String[] args) {

		System.out.println(atoi("-456a652b"));

	}

}
