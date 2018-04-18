package linkedlist;

import foundation.LinkedListNode;

/**
 * BB.LinkedList.007 Split a linked list
 * 
 * Question : Given a linked list, write a function to split the list into
 * two equal halves.
 * 
 * e.g.
 * 
 * split(1 -> 2 -> 3 -> 4) = 1 -> 2, 3 -> 4
 * 
 * split(1 -> 2 -> 3 -> 4 -> 5) = 1 -> 2 -> 3, 4 -> 5
 * 
 */
public class BB_007_Split_Linked_List {

	public static LinkedListNode splitList(LinkedListNode node) {
		LinkedListNode prev = null;
		LinkedListNode current = node;
		LinkedListNode runner = current;

		while (runner != null && runner.next != null) {
			prev = current;
			current = current.next;
			runner = runner.next.next;
		}

		prev.next = null;

		return current;
	}
	
	public static void main(String[] args) {

		LinkedListNode s1 = new LinkedListNode();
		LinkedListNode s2 = new LinkedListNode();
		LinkedListNode s3 = new LinkedListNode();
		LinkedListNode s4 = new LinkedListNode();
		LinkedListNode s5 = new LinkedListNode();
		s1.value = 1;
		s2.value = 2;
		s3.value = 3;
		s4.value = 4;
		s5.value = 5;
		s1.next = s2;
		s2.next = s3;
		s3.next = s4;
		s4.next = s5;
		s5.next = null;
		LinkedListNode half = splitList(s1);
		System.out.println(half.value);

	}

}
