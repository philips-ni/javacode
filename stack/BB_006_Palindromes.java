package stack;

import java.util.Stack;

import util.LinkedListNode;

/**
 * BB.Stack.006 Palindromes
 * 
 * Question : Given a linked list, write a function to determine whether the
 * list is a palindrome.
 *
 * e.g.
 * 
 * palindrome(1 -> 2 -> 3) = false
 * 
 * palindrome(1 -> 2 -> 1) = true
 */
public class BB_006_Palindromes {

	public static boolean palindrome(LinkedListNode node) {
		Stack<Integer> st = new Stack<Integer>();

		LinkedListNode cur = node;
		LinkedListNode runner = node;

		while (runner != null && runner.next != null) {
			st.push(cur.value);
			cur = cur.next;
			runner = runner.next.next;
		}

		if (runner != null) {
			// odd number list
			cur = cur.next;
		}

		while (cur != null) {
			if (cur.value != st.pop())
				return false;
			cur = cur.next;
		}

		return true;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		System.out.println(palindrome(n1));

	}

}
