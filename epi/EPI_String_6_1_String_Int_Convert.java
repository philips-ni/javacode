package epi;

public class EPI_String_6_1_String_Int_Convert {

	public static String intToString(int x) {
		boolean neg = false;
		if (x < 0)
			neg = true;

		StringBuilder sb = new StringBuilder();

		while (x != 0) {
			sb.append((char) ('0' + Math.abs(x % 10)));
			x /= 10;
		}

		return sb.append(neg ? "-" : "").reverse().toString();
	}

	public static int stringToInt(String s) {
		s = s.trim();
		boolean neg = false;

		int i = 0;
		if (s.charAt(i) == '-') {
			neg = true;
			i++;
		} else if (s.charAt(i) == '+')
			i++;

		double result = 0;
		while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
			result = result * 10 + (s.charAt(i) - '0');
			i++;
		}

		if (neg)
			result = -result;

		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(stringToInt("621"));
		System.out.println(intToString(621));
	}
}
