package string;

import java.util.Arrays;

/**
 * LC.String.028 Implement strStr()
 * 
 * Question : Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 */
public class LC_028_Implement_strStr {

	public static int strStr(String haystack, String needle) {
		for(int i = 0;;i++){
			for(int j = 0;;j++){
				if(j == needle.length()) return i;
				if(i+j == haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) break;
			}
		}
	}
	public static void main(String[] args) {

		String[] strb = { "helloworldtest", "world" };
		System.out.println("Input : " + Arrays.toString(strb));
		System.out.println("Output : " + strStr(strb[0], strb[1]));

	}

}
