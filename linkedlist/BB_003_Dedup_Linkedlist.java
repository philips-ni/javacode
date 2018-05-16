package linkedlist;

import java.util.HashSet;
import common.Helper;
import util.LinkedListNode;

/**
 * BB.LinkedList.003 Dedup the LinkedList
 * 
 * Question : Given an unsorted linked list, write a function to remove all the
 * duplicates.
 * 
 * e.g. dedup(1 -> 2 -> 3 -> 2 -> 1) = 1 -> 2 -> 3
 * 
 */
public class BB_003_Dedup_Linkedlist {

	public static void dedupLinkedList(LinkedListNode node) {
		while (node != null) {
			LinkedListNode current = node;
			while (current.next != null) {
				if (current.next.value == node.value) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}
			node = node.next;
		}
	}

	public static void dedupLinkedList_optimal(LinkedListNode node) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode prev = null;

		while (node != null) {
			if (set.contains(node.value)) {
				prev.next = node.next;
			} else {
				set.add(node.value);
				prev = node;
			}
			node = node.next;
		}
		prev.next = null; // Set next to null since prev is now at the end of
							// LinkedList.
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();

		n1.value = 1;
		n2.value = 2;
		n3.value = 1;
		n1.next = n2;
		n2.next = n3;
		n3.next = null;

		dedupLinkedList(n1);
		Helper.printLinkedList(n1);

		n2.next = n3;
		n3.next = null;
		dedupLinkedList_optimal(n1);
		Helper.printLinkedList(n1);

	}

}
