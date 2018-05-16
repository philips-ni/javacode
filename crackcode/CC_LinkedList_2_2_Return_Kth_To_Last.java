package crackcode;

import util.LinkedListNode;

/**
 * CC.LinkedList.2.2 Return Kth To Last
 * 
 * Question : Implement an algorithm to find the kth to last element of a singly
 * linked list.
 *
 */
public class CC_LinkedList_2_2_Return_Kth_To_Last {

	public static LinkedListNode nthToLast(LinkedListNode node, int n) {
		LinkedListNode current = node;
		LinkedListNode follower = node;

		for (int i = 0; i < n; i++) {
			if (current == null)
				return null;
			current = current.next;
		}

		while (current.next != null) {
			current = current.next;
			follower = follower.next;
		}

		return follower;
	}

	public static void main(String[] args) {

		LinkedListNode f1 = new LinkedListNode();
		LinkedListNode f2 = new LinkedListNode();
		LinkedListNode f3 = new LinkedListNode();
		LinkedListNode f4 = new LinkedListNode();
		LinkedListNode f5 = new LinkedListNode();
		f1.value = 1;
		f2.value = 2;
		f3.value = 3;
		f4.value = 4;
		f5.value = 5;
		f1.next = f2;
		f2.next = f3;
		f3.next = f4;
		f4.next = f5;
		f5.next = null;
		LinkedListNode nth = nthToLast(f1, 1);
		System.out.println(nth.value);
		
	}

}
