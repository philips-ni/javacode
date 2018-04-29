package crackcode;

import java.util.Arrays;

/**
 * CC.ArrayString.1.3 URLify
 * 
 * Question : Write a method to replace all spaces in a string with '%20'. You
 * may assume that the string has sufficient space at the end to hold the
 * additional characters, and that you are given the "true" length of the
 * string. (Note: if implementing in Java, please use a character array so that
 * you can perform this operation in place.)
 * 
 * e.g.
 * 
 * Input: "Mr John Smith ",13
 * 
 * Output: "Mr%20John%20Smith"
 *
 */
public class CC_ArrayString_1_3_URLify {

	public static void replaceSpaces(char[] str, int length) {
		// count space
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				count++;
		}
		
		int j = length + count * 2; // length of new char array
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				// replace space
				str[j - 1] = '0';
				str[j - 2] = '2';
				str[j - 3] = '%';
				j = j - 3;
			} else {
				// copy character to the new place
				str[j - 1] = str[i];
				j--;
			}
		}
	}

	public static void main(String[] args) {

		char[] str = "Mr John Smith       ".toCharArray();
		replaceSpaces(str, 13);
		System.out.println(str);
	}

}
