package crackcode;

import java.util.HashSet;

import util.LinkedListNode;

/**
 * CC.LinkedList.2.1 Remove Dups
 * 
 * Question : Write code to remove duplicates from an unsorted linked list. How
 * would you solve this problem if a temporary buffer is not allowed?
 *
 */
public class CC_LinkedList_2_1_Remove_Dups {

	public static void removeDups(LinkedListNode n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		LinkedListNode prev = null;
		while (n != null) {
			if (hs.contains(n.value)) {
				// found duplicate
				prev.next = n.next;
			} else {
				hs.add(n.value);
				prev = n;
			}
			n = n.next;
		}
	}

	public static void removeDups_BF(LinkedListNode n) {
		LinkedListNode current = n;

		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.value == current.value) {
					// found duplicate
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		removeDups(n1);

	}

}
