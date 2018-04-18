package common;

import foundation.LinkedListNode;

public class Helper {
	public static void printLinkedList(LinkedListNode n) {
		while (n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
		System.out.println("");
	}
}
