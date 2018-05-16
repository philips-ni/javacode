package crackcode;

import util.LinkedListNode;

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
 * Input : (7 -> 1 -> 6) + (5 -> 9 -> 2)
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

	public static LinkedListNode sumLists_forward(LinkedListNode n1,LinkedListNode n2) {
		LinkedListNode r1 = reverseList(n1);
		LinkedListNode r2 = reverseList(n2);
		return sumLists(r1, r2);
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(7);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(6);
		LinkedListNode n4 = new LinkedListNode(5);
		LinkedListNode n5 = new LinkedListNode(9);
		LinkedListNode n6 = new LinkedListNode(2);

		n1.next = n2;
		n2.next = n3;

		n4.next = n5;
		n5.next = n6;

		common.Helper.printLinkedList(sumLists(n1, n4));

		LinkedListNode n7 = new LinkedListNode(6);
		LinkedListNode n8 = new LinkedListNode(1);
		LinkedListNode n9 = new LinkedListNode(7);
		LinkedListNode n10 = new LinkedListNode(2);
		LinkedListNode n11 = new LinkedListNode(9);
		LinkedListNode n12 = new LinkedListNode(5);

		n7.next = n8;
		n8.next = n9;

		n10.next = n11;
		n11.next = n12;

		common.Helper.printLinkedList(sumLists_forward(n7,n10));
	}

}
