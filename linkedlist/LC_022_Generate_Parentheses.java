package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * LC.LinkedList.022 Generate Parentheses
 * 
 * Question : Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 * 
 */

public class LC_022_Generate_Parentheses {


	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		generateOneByOne("", list, n, n);
		return list;
	}

	public static void generateOneByOne(String sublist, List<String> list, int left, int right) {
		if (left > right) {
			return;
		}
		if (left > 0) {
			generateOneByOne(sublist + "(", list, left - 1, right);
		}
		if (right > 0) {
			generateOneByOne(sublist + ")", list, left, right - 1);
		}
		if (left == 0 && right == 0) {
			list.add(sublist);
			return;
		}
	}
	
	public static void main(String[] args) {

		List<String> parenthesis = generateParenthesis(3);
		for (int i = 0; i < parenthesis.size(); i++) {
			System.out.println(parenthesis.get(i));
		}

	}

}
