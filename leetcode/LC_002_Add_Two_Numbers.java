package leetcode;

import util.LinkedListNode;

/**
 * 
 * LC.LinkedList.002 Add Two Numbers
 * 
 * Question : You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except
 * the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * 
 * Output: 7 -> 0 -> 8
 * 
 */
public class LC_002_Add_Two_Numbers {

	public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode c1 = l1;
		LinkedListNode c2 = l2;
		LinkedListNode head = new LinkedListNode(0);

		LinkedListNode d = head;
		int sum = 0;
		while (c1 != null || c2 != null) {
			sum /= 10;
			if (c1 != null) {
				sum += c1.value;
				c1 = c1.next;
			}
			if (c2 != null) {
				sum += c2.value;
				c2 = c2.next;
			}
			d.next = new LinkedListNode(sum % 10);
			d = d.next;
		}
		if (sum / 10 == 1)
			d.next = new LinkedListNode(1);
		return head.next;
	}

	public static void main(String[] args) {
		
		LinkedListNode n1 = new LinkedListNode(2);
		n1.next = new LinkedListNode(4);
		n1.next.next = new LinkedListNode(3);

		LinkedListNode n2 = new LinkedListNode(5);
		
		n2.next = new LinkedListNode(6);
		n2.next.next = new LinkedListNode(4);
		System.out.println("2. Add Two Numbers :");
		System.out.println("ListNode 1 : " + "2->4->3");
		System.out.println("ListNode 2 : " + "5->6->4");
		LinkedListNode result = addTwoNumbers(n1, n2);
		
		System.out.print("Output : ");
		while (result != null) {
			if (result.next != null) {
				System.out.print(result.value + "->");
			} else {
				System.out.print(result.value);
			}

			result = result.next;
		}
	}
}
