package crackcode;

import foundation.LinkedListNode;

/**
 * CC.LinkedList.2.8 Loop Detection
 * 
 * Question : Given a circular linked list, implement an algorithm that returns
 * the node at the beginning of the loop.
 * 
 * Definition :
 * 
 * Circular linked list : A(corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 * 
 * e.g.
 * 
 * Input : a -> b -> c -> d -> e -> c [the same c as earlier]
 * 
 * Output : c
 *
 */
public class CC_LinkedList_2_8_Loop_Detection {

	public static LinkedListNode findLoopStart(LinkedListNode n) {
		LinkedListNode slow = n;
		LinkedListNode fast = n;

		// find first meet spot
		while (fast != null & fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}

		// no loop detected
		if (fast == null || slow == null)
			return null;

		// Move slow to list head. Keep fast at meet point. Each are k steps
		// from the loop start.
		slow = n;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// Both are at loop start
		return fast;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		System.out.println(findLoopStart(n1).value);

	}

}
