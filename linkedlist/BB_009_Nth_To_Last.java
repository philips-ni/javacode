package linkedlist;

import util.LinkedListNode;

/**
 * BB.LinkedList.009 Nth-to-last Element in a Linked List
 * 
 * Question : Given a linked list, and an input n, write a function that
 * returns the nth-to-last element of the linked list.
 * 
 * e.g. list = 1 -> 2 -> 3 -> 4 -> 5 -> null nthToLast(list, 1) = 4
 * 
 */
public class BB_009_Nth_To_Last {

	public static LinkedListNode nthToLast(LinkedListNode node, int n) {
		LinkedListNode current = node;
		LinkedListNode follower = node;

		for (int i = 0; i < n; i++) {
			if (current == null)
				return null;
			current = current.next;
		}

		while (current.next != null) {
			current = current.next;
			follower = follower.next;
		}

		return follower;
	}

	public static void main(String[] args) {

		LinkedListNode f1 = new LinkedListNode();
		LinkedListNode f2 = new LinkedListNode();
		LinkedListNode f3 = new LinkedListNode();
		LinkedListNode f4 = new LinkedListNode();
		LinkedListNode f5 = new LinkedListNode();
		f1.value = 1;
		f2.value = 2;
		f3.value = 3;
		f4.value = 4;
		f5.value = 5;
		f1.next = f2;
		f2.next = f3;
		f3.next = f4;
		f4.next = f5;
		f5.next = null;
		LinkedListNode nth = nthToLast(f1, 1);
		System.out.println(nth.value);
		
	}
}
