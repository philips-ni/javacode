package common;

import foundation.LinkedListNode;

public class Helper {
	public static void printLinkedList(LinkedListNode n) {
		while (n != null) {
			System.out.print(n.value + " -> ");
			n = n.next;
		}
		System.out.println("");
	}
	
	public static LinkedListNode reverseList_bad(LinkedListNode n) {
		LinkedListNode head = null;
		LinkedListNode first = null;

		while (n != null) {
			first = n;
			n = n.next;
			first.next = head;
			head = first;
		}
		return head;
	}
	
	public static LinkedListNode reverseList(LinkedListNode n) {
		LinkedListNode head = null;

		while (n != null) {
			LinkedListNode current = new LinkedListNode(n.value); // clone a new node. Not impact original list.
			current.next = head;
			head = current;
			n = n.next;
		}
		return head;
	}
}
