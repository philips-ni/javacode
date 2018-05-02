package crackcode;

import foundation.LinkedListNode;

/**
 * CC.LinkedList.2.5 Sum Lists
 * 
 * Question : You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list.
 * 
 * e.g.
 * 
 * Input : (7 -> 1 -> 6) + (5 -> 9-> 2>)
 * 
 * Output : 2 -> 1 -> 9. That is 617+295=912
 * 
 * Follow up:
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * e.g.
 * 
 * Input : (6 -> 1 -> 7) + (2 -> 9 -> 5)
 * 
 * Output : 9 -> 1 -> 2. That is 912.
 *
 */
public class CC_LinkedList_2_5_Sum_Lists {

	public static LinkedListNode sumLists(LinkedListNode n1, LinkedListNode n2) {
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;

		int carry = 0;
		LinkedListNode head = null;
		LinkedListNode current = null;

		while (n1 != null && n2 != null) {
			int temp = (n1.value + n2.value + carry) % 10;
			LinkedListNode result = new LinkedListNode(temp);
			if (head == null) {
				current = result;
				head = current;
			} else {
				current.next = result;
				current = current.next;
			}
			carry = (n1.value + n2.value + carry) / 10;
			n1 = n1.next;
			n2 = n2.next;
		}

		while (n1 != null) {
			int temp = (n1.value + carry) % 10;
			LinkedListNode result = new LinkedListNode(temp);
			current.next = result;
			current = current.next;

			carry = (n1.value + carry) / 10;
			n1 = n1.next;
		}

		while (n2 != null) {
			int temp = (n2.value + carry) % 10;
			LinkedListNode result = new LinkedListNode(temp);
			current.next = result;
			current = current.next;

			carry = (n2.value + carry) / 10;
			n2 = n2.next;
		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
