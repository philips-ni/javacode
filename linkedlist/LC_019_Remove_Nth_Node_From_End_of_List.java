package linkedlist;

import foundation.LinkedListNode;

/**
 * LC.LinkedList.019 Remove Nth Node From End of List
 * 
 * Question : Given a linked list, remove the nth node from the end of list and
 * return its head.
 * 
 * e.g.
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 */

public class LC_019_Remove_Nth_Node_From_End_of_List {

	public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
		LinkedListNode start = new LinkedListNode(0);

		LinkedListNode slow = start, fast = start;

		slow.next = head;

		// move fast pointer to Nth node from start
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}

		// move slow and fast pointers together all the way down
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;
		return start.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
