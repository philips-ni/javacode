package dynamicprogramming;

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
 *    substring length cache:
 *    
 *      A  B  A  B
 *    B 0  1  0  1 
 *    A 1  0  2  0
 *    B 0  2  0  3 
 *    A 1  0  3  0
 *    
 */
public class BB_005_Longest_Common_Substring {

	public static String longestSubstring_bf(String a, String b) {
		int len = 0;
		String c = "";
		if(a.length() == 0 || b.length() == 0) 
			return c;
		
		for(int i = 0; i < a.length(); i++) {
			for(int j = 0; j < b.length(); j++) {
				int tempLen = 0;
				int i_start = i;
				int j_start = j;
				
				StringBuilder sb = new StringBuilder();
				while(i_start < a.length() && j_start < b.length()) {
					if(a.charAt(i_start) == b.charAt(j_start)) {
						tempLen++;
						sb.append(a.charAt(i_start));			
						if(tempLen > len) {
							len = tempLen;
							c = sb.toString();
						}	
						i_start++;
						j_start++;
					}else break;
				}	

			}
		}
		return c;
	}
	
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
		System.out.println(longestSubstring_bf("ABAB","BABA"));
	}

}
