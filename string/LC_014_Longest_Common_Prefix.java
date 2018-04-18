package string;

import java.util.Arrays;

/**
 * LC.String.014 Longest Common Prefix
 * 
 * Question : Write a function to find the longest common prefix string amongst an
 * array of strings.
 * 
 */
public class LC_014_Longest_Common_Prefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		String pre = strs[0]; // init common prefix with strs[0]
		int i = 1;

		while (i < strs.length) {
			while (strs[i].indexOf(pre) != 0) {
				// not a common prefix, reduce the length and retry
				pre = pre.substring(0, pre.length() - 1);
			}

			// found common prefix, and go to next string
			i++;
		}

		return pre;
	}

	public static void main(String[] args) {

		String[] stra = { "prefixtest", "prefixtest123", "prefitest", "preftest", "prtest" };
		System.out.println("Input : " + Arrays.toString(stra));
		System.out.println("Output : " + longestCommonPrefix(stra));

	}

}
