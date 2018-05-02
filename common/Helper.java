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
	
	public static LinkedListNode reverseList(LinkedListNode n) {
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
}
