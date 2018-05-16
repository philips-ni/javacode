package leetcode;

import util.LinkedListNode;

/**
 * 
 * LC.LinkedList.024 Swap Nodes in Pairs
 * 
 * Question : Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the
 * values in the list, only nodes itself can be changed.
 * 
 */
public class LC_024_Swap_Nodes_In_Pairs {

	public static LinkedListNode swapPairs(LinkedListNode head) {

		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		LinkedListNode current = dummy;

		while (current.next != null && current.next.next != null) {
			LinkedListNode first = current.next;
			LinkedListNode second = current.next.next;

			first.next = second.next;
			second.next = first;
			current.next = second;

			current = current.next.next;

		}

		return dummy.next;
	}

	public static void main(String args[]) {
		
		LinkedListNode l3 = new LinkedListNode(2);
		l3.next = new LinkedListNode(4);
		l3.next.next = new LinkedListNode(3);
		l3.next.next.next = new LinkedListNode(5);
	
		System.out.println("Input  : 2->4->3->5");

		LinkedListNode it3 = swapPairs(l3);
		while (it3 != null) {
			System.out.print(Integer.toString(it3.value) + "->");
			it3 = it3.next;
		}

	}
}
