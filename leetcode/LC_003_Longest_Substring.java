package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

	public static int lengthOfLongestSubstring_bf(String s) {
		int max = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			int newMax = 1;
			set.add(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) {
				if (!set.contains(s.charAt(j))) {
					set.add(s.charAt(j));
					newMax++;
				}else break;
			}
			set.clear();	
			max = Math.max(max, newMax);
		}
		return max;
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int max = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				// find max in range[i,j]
				set.add(s.charAt(j++));
				max = Math.max(max, j - i);
			} else {
				// remove left from set and move left to next char
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = new String("abbadfafafasdddadf");
		System.out.println("Input  : " + s);
		System.out.println("Output : " + lengthOfLongestSubstring(s));
		System.out.println("Output : " + lengthOfLongestSubstring_bf(s));
	}
}
