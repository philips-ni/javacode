package linkedlist;

import java.util.Stack;

import foundation.LinkedListNode;

/**
 * BB.LinkedList.006 Palindromes
 * 
 * Question : Given a linked list, write a function to determine whether
 * the list is a palindrome.
 * 
 * e.g.
 * 
 * palindrome(1 -> 2 -> 3) = false
 * 
 * palindrome(1 -> 2 -> 1) = true
 * 
 */
public class BB_006_Palindromes {

	public static boolean palindrome(LinkedListNode node) {

		LinkedListNode reversed = BB_005_Print_Reversed_Linkedlist.reverseLinkedList(node);

		while (node != null) {
			if (node.value != reversed.value)
				return false;
			node = node.next;
		}

		return true;
	}

	public static boolean palindrome_stack(LinkedListNode node) {

		LinkedListNode current = node;
		LinkedListNode runner = node;

		Stack<LinkedListNode> st = new Stack<LinkedListNode>();

		while (runner != null && runner.next != null) {
			st.push(current);
			current = current.next;
			runner = runner.next.next;
		}

		if (runner != null)
			current = current.next; // odd number case

		while (current != null) {
			if (st.pop().value != current.value)
				return false;
			current = current.next;

		}
		return true;
	}
	
	public static void main(String[] args) {

		LinkedListNode p1 = new LinkedListNode();
		LinkedListNode p2 = new LinkedListNode();
		LinkedListNode p3 = new LinkedListNode();
		LinkedListNode p4 = new LinkedListNode();
		p1.value = 1;
		p2.value = 2;
		p3.value = 2;
		p4.value = 1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		System.out.println(palindrome(p1));
		System.out.println(palindrome_stack(BB_005_Print_Reversed_Linkedlist.reverseLinkedList(p4)));

	}

}
