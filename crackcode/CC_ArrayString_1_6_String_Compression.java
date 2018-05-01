package crackcode;

/**
 * 
 * CC.ArrayString.1.6 String Compression
 * 
 * Question : Given a string, write a function to compress it by shortening
 * every sequence of the same character to that character followed by the number
 * of repetitions. If the compressed string is longer than the original, you
 * should return the original string.
 * 
 * e.g.
 * 
 * compress("a") = "a"
 * 
 * compress("aaa") = "a3"
 * 
 * compress("aaabbb") = "a3b3"
 * 
 * compress("aaabccc") = "a3b1c3"
 *
 */
public class CC_ArrayString_1_6_String_Compression {

	public static String compression(String s) {
		String compressedStr = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count++;
			if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedStr = compressedStr+s.charAt(i) + count; // o(n^2) time
				count = 0;
			}
		}
		
		return compressedStr.length() < s.length() ? compressedStr : s;
	}

	public static String compression_Opt(String s){
		StringBuilder compressedStr = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count++;
			if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedStr.append(s.charAt(i));
				compressedStr.append(count);
				count = 0;
			}
		}
		
		return compressedStr.length() < s.length() ? compressedStr.toString() : s;
	}
	public static void main(String[] args) {
		System.out.println(compression("abbcccddddee"));
		System.out.println(compression_Opt("abbcccddddee"));
	}

}
