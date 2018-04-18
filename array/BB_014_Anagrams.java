package array;


/**
 * BB.Array.014 Anagrams
 * 
 * Question : Given two strings, write a function to determine whether
 * they are anagrams.
 * 
 * e.g.
 * 
 * isAnagram("", "") = true
 * 
 * isAnagram("A", "A") = true
 * 
 * isAnagram("A", "B") = false
 * 
 * isAnagram("ab", "ba") = true
 * 
 * isAnagram("AB", "ab") = true
 * 
 */
public class BB_014_Anagrams {		

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] chars = new int[128];

		for (char c : s1.toCharArray()) {
			chars[c]++;
		}

		for (char c : s2.toCharArray()) {
			chars[c]--;
		}

		for (int i : chars) {
			if (i != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(BB_014_Anagrams.isAnagram("abb", "bab"));

	}
}
