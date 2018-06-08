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
		LinkedListNode head = new LinkedListNode(0);
		LinkedListNode current = head;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.value;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.value;
				l2 = l2.next;
			}
			current.next = new LinkedListNode(sum % 10);
			current = current.next;
		}
		if (sum / 10 == 1)
			current.next = new LinkedListNode(1);
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
