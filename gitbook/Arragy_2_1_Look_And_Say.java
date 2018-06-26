package gitbook;

/**
 * Array.2.1 Look and say
 * 
 * Problem : Find the n’th term in Look-and-say (Or Count and Say) Sequence.
 * 
 * The look-and-say sequence is the sequence of below integers: 1, 11, 21, 1211,
 * 111221, 312211, 13112221, 1113213211, …
 *
 */
public class Arragy_2_1_Look_And_Say {

	public static String lookandsay(int n) {

		if (n == 1)
			return "1";

		String result = "1";

		for (int i = 2; i <= n; i++) {
			// recount for each new look
			char c = result.charAt(0);
			int count = 1;
			String temp = "";

			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == result.charAt(j - 1)) {
					count++;
				} else {
					temp = temp + count + "" + c;

					c = result.charAt(j);
					count = 1;
				}
			}

			result = temp + count + "" + c;
			System.out.println(result);
		}
		return result;
	}

	public static void main(String[] args) {
		lookandsay(6);
	}
}
