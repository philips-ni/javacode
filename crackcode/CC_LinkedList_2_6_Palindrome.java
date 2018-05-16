package crackcode;

import java.util.Stack;

import util.LinkedListNode;

/**
 * CC.LinkedList.2.6 Palindrome
 * 
 * Question : Implement a function to check if a linked list is a palindrome.
 *
 * Hint : The list must be the same backwards and forwards.
 * 
 */
public class CC_LinkedList_2_6_Palindrome {

	public static boolean isPalindrome(LinkedListNode n) {
		LinkedListNode reversed = common.Helper.reverseList(n);
		while (n != null) {
			if (n.value != reversed.value)
				return false;

			n = n.next;
			reversed = reversed.next;
		}
		return true;
	}

	public static boolean isPalindrome_Stack(LinkedListNode n) {
		LinkedListNode slow = n;
		LinkedListNode fast = n;

		Stack<Integer> st = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			st.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) { // odd number case
			slow = slow.next;
		}

		while (slow != null) {
			int top = st.pop().intValue();
			if (top != slow.value)
				return false;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(0);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(2);
		LinkedListNode n4 = new LinkedListNode(1);
		LinkedListNode n5 = new LinkedListNode(0);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println(isPalindrome(n1));
		System.out.println(isPalindrome_Stack(n1));
	}

}
