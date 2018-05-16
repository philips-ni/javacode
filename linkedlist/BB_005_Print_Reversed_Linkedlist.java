package linkedlist;

import common.Helper;
import util.LinkedListNode;

/**
 * BB.LinkedList.005 Print reversed linked list
 * 
 * Question : Given a linked list, write a function that prints the nodes of the
 * list in reverse order.
 * 
 * e.g. input : 1, 2, 3 output: 3, 2, 1
 * 
 */
public class BB_005_Print_Reversed_Linkedlist {


	public static LinkedListNode reverseLinkedList(LinkedListNode node) {
		LinkedListNode head = node;
		LinkedListNode first = node;
		while (node.next != null) {
			head = node.next; // save the new head
			node.next = node.next.next;
			head.next = first;
			first = head;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();

		n1.value = 1;
		n2.value = 2;
		n3.value = 3;
		n1.next = n2;
		n2.next = n3;
		n3.next = null;

		Helper.printLinkedList(reverseLinkedList(n1));

	}

}
