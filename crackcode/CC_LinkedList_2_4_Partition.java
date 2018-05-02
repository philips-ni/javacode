package crackcode;

import foundation.LinkedListNode;

/**
 * CC.LinkedList.2.4 Partition
 * 
 * Question : Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x(see example). The partition element x can appear anywhere in the
 * "right partition". It does not need to appear between the left and the right
 * partitions.
 * 
 * e.g.
 * 
 * Input : 3 -> 5 -> 8 -> 5 -> 10 > 2-> 1 [partition=5]
 * 
 * Output : 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 */
public class CC_LinkedList_2_4_Partition {

	public static LinkedListNode partition(LinkedListNode n, int x) {
		LinkedListNode lefthead = null;
		LinkedListNode lefttail = null;
		LinkedListNode righthead = null;
		LinkedListNode righttail = null;

		while (n != null) {
			if (n.value < x) {
				if (lefthead == null) {
					lefthead = n;
					lefttail = lefthead;
				} else {
					lefttail.next = n;
					lefttail = n;
				}
			} else {
				if (righthead == null) {
					righthead = n;
					righttail = righthead;
				} else {
					righttail.next = n;
					righttail = n;
				}
			}
			n = n.next;
		}

		// left is empty and return right only
		if (lefthead == null)
			return righthead;

		// merge left and right list
		lefttail.next = righthead;
		return lefthead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
