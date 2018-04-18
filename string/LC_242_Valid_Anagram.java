package string;

/**
 * 
 * LC.String.242 Valid Anagram
 * 
 * Question : Given two strings s and t, write a function to determine if t is
 * an anagram of s.
 * 
 * e.g.
 * 
 * s = "anagram", t = "nagaram", return true.
 * 
 * s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 */
public class LC_242_Valid_Anagram {

	public static boolean isAnagram(String a, String b) {
		int[] freq = new int[26];
		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
		}
		for (int i = 0; i < b.length(); i++) {
			freq[b.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("car", "rca"));
	}

}
