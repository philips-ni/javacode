package linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * LC.LinkedList.017 Letter Combinations of a Phone Number
 * 
 * Question : Given a digit string, return als possible letter combinations that
 * the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input : Digit string "23"
 * 
 * Output : ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */

public class LC_017_Letter_Combination_Of_Phone_Number {

	public static List<String> letterCombinations(String digits) {

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		LinkedList<String> res = new LinkedList<String>();
		res.add(""); // init the linked list

		for (int i = 0; i < digits.length(); i++) {
			int digit = Character.getNumericValue(digits.charAt(i)); // get
																		// index
																		// key
																		// from
																		// mapping

			String str = mapping[digit]; // get chars by index key from mapping

			while (res.peek().length() == i) {

				String first = res.remove();

				for (char c : str.toCharArray()) {
					res.add(first + c);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String lc = "234";
		System.out.println("Input  : " + lc);
		List<String> lt = letterCombinations(lc);
		String output = "";
		for (int i = 0; i < lt.size(); i++) {
			if (i != 0)
				output = output + "->" + lt.get(i);
			else
				output += lt.get(i);
		}
		System.out.println("Output : " + output);

	}

}
