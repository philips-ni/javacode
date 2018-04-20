package string;

/**
 * BB.String.003 Longest common substring
 * 
 * Question : Given two strings, write a function that returns the longest
 * common substring.
 * 
 * e.g.
 * 
 * longestSubstring("ABAB", "BABA") = "ABA"
 * 
 * 
 *    substring length cache:
 *    
 *      A  B  A  B
 *    B 0  1  0  1 
 *    A 1  0  2  0
 *    B 0  2  0  3 
 *    A 1  0  3  0
 *    
 *    
 */
public class BB_003_Longest_Common_Substring {

	public static String longestSubstring(String a, String b) {
		String c = "";
		int len = 0;
		if (a.length() == 0 || b.length() == 0)
			return c;
		
		int[][] cache = new int[a.length()][b.length()];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {

				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0)
						cache[i][j] = 1;
					else
						cache[i][j] = cache[i - 1][j - 1] + 1;

					if (cache[i][j] > len) {	
						len = cache[i][j];
						c = a.substring(i - len + 1, i + 1);
					}
				}
			}
		}

		return c;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("ABAB","BABA"));
	}

}
