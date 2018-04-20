package leetcode;

import java.util.HashMap;

/**
 * LC.String.003 Longest Substring Without Repeating Characters
 * 
 * Question : Given a string, find the length of the longest substring without
 * repeating characters.
 * 
 * e.g.
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 */
public class LC_003_Longest_Substring {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int left = 0, right = 0; right < s.length(); right++) {

			// found duplicate character and reset left pointer
			if (map.containsKey(s.charAt(right))) {
				left = map.get(s.charAt(right)) + 1;
			}

			// put or update the right character
			map.put(s.charAt(right), right);

			// get longest string length
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		String s = new String("abcabcdabc");	
		System.out.println("Input  : " + s);
		System.out.println("Output : " + lengthOfLongestSubstring(s));
	}

}
