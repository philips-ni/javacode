package crackcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * CC.Recursion.8.9 Parentheses
 * 
 * Question : Implement an algorithm to print all the valid(i.e. properly opened
 * and closed) combinations of n pairs of parentheses.
 * 
 * e.g.
 * 
 * input : 3
 * 
 * output: ((())),(()()),()(()),(())(), ()()()
 *
 */
public class CC_Recursion_8_9_Parentheses {

	public static HashSet<String> generateParens(int n) {
		HashSet<String> set = new HashSet<String>();

		if (n == 0) {
			set.add("");
		} else {
			// get parentheses of n-1 pairs
			HashSet<String> prev = generateParens(n - 1);

			for (String p : prev) {
				set.add("()" + p);
				for (int i = 0; i < p.length(); i++) {
					// insert () inside existing pair of parentheses
					if (p.charAt(i) == '(') {
						String s = insertChar(p, i);
						set.add(s); // HashSet will automatically check for
									// duplicates
					}
				}
			}
		}

		return set;
	}

	private static String insertChar(String s, int i) {
		String s1 = s.substring(0, i + 1); // insert after '('
		String s2 = s.substring(i + 1);

		return s1 + "()" + s2;
	}

	public static ArrayList<String> generateParens_1(int n) {
		ArrayList<String> results = new ArrayList<String>();
		generate(results, "", 0, 0, n);
		return results;
	}

	private static void generate(ArrayList<String> results, String cur, int open, int close, int max) {
		// System.out.println(cur + "" + open + " " + close);
		if (cur.length() == max * 2) {
			results.add(cur);
			return;
		}

		if (open < max)
			generate(results, cur + "(", open + 1, close, max);
		if (close < open)
			generate(results, cur + ")", open, close + 1, max);

	}

	public static void main(String[] args) {
		HashSet<String> set = generateParens(3);
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println("Method 2:");
		System.out.println(generateParens_1(2));
	}

}
