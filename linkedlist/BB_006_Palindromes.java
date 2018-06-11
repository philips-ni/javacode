package linkedlist;

import java.util.Stack;

import util.LinkedListNode;

/**
 * BB.LinkedList.006 Palindromes
 * 
 * Question : Given a linked list, write a function to determine whether the
 * list is a palindrome.
 * 
 * e.g.
 * 
 * palindrome(1 -> 2 -> 3) = false
 * 
 * palindrome(1 -> 2 -> 1) = true
 * 
 */
public class BB_006_Palindromes {

	// clone a new list when original list is not allowed to reverse,
	private static LinkedListNode reverseClone(LinkedListNode node) {
		LinkedListNode head = null; // head of cloned list
		while (node != null) {
			LinkedListNode temp = new LinkedListNode(node.value);
			temp.next = head;
			head = temp;
			node = node.next;
		}
		return head;
	}

	public static boolean palindrome(LinkedListNode node) {
		LinkedListNode reversed = reverseClone(node);
		while (node != null) {
			if (node.value != reversed.value)
				return false;
			node = node.next;
		}
		return true;
	}

	public static boolean palindrome_stack(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;

		Stack<LinkedListNode> st = new Stack<LinkedListNode>();

		while (fast != null && fast.next != null) {
			st.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next; // odd number case

		while (slow != null) {
			if (st.pop().value != slow.value)
				return false;
			slow = slow.next;
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
		System.out.println(palindrome_stack(reverseClone(p4)));
	}
}
