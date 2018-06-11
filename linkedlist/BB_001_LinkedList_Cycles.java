package linkedlist;

import java.util.HashSet;

import util.LinkedListNode;

/**
 * BB.LinkedList.001 Linked List cycles
 * 
 * Question : Given a linked list, determine whether it contains a cycle.
 * 
 */
public class BB_001_LinkedList_Cycles {

	public static boolean hasCycle(LinkedListNode node) {

		HashSet<LinkedListNode> set = new HashSet<LinkedListNode>();
		LinkedListNode current = node;
		while (current != null) {
			if (set.contains(current)) {
				// has cycle
				return true;
			} else {
				set.add(current);
			}
			current = current.next;
		}
		return false;
	}

	public static boolean hasCycle_bt(LinkedListNode head) {

		LinkedListNode it1 = head;
		int nVisited = 0;
		while (it1 != null && it1.next != null) {
			it1 = it1.next;
			nVisited++;

			LinkedListNode it2 = head;
			int x = nVisited;

			int nCurrentVisited = 0;
			while (x-- > 0) {
				it2 = it2.next;

				if (it2 == it1) {
					nCurrentVisited++;
				}

				if (nCurrentVisited == 2)
					return true;
			}
		}

		return false;
	}

	/**
	 * Floyd's algorithm. Increment one pointer by one and the other by two.If they
	 * are ever pointing to the same node, there is a cycle.
	 * 
	 * Refer to: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
	 * 
	 * @param node
	 *            The head node of LinkedList.
	 * @return true if having cycle.
	 */
	public static boolean hasCycle_Floyd(LinkedListNode node) {
		if (node == null)
			return false;
		LinkedListNode slow = node;
		LinkedListNode fast = node.next;

		while (fast != null && fast.next != null) {
			if (fast == slow)
				return true;
			fast = fast.next.next;
			slow = slow.next;
		}

		return false;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		LinkedListNode n2 = new LinkedListNode();
		LinkedListNode n3 = new LinkedListNode();

		n1.value = 1;
		n2.value = 2;
		n3.value = 3;
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;

		System.out.println(hasCycle(n1));
		System.out.println(hasCycle_bt(n1));
		System.out.println(hasCycle_Floyd(n1));

	}

}
