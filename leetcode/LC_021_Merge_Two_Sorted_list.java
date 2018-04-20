package leetcode;

import foundation.LinkedListNode;

/**
 * LC.LinkedList.021 Merge Two Sorted Lists
 * 
 * Question : Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 */
public class LC_021_Merge_Two_Sorted_list {
	
	public static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		LinkedListNode headNode;
		if (l1.value < l2.value) {
			headNode = l1;
			headNode.next = mergeTwoLists(l1.next, l2);
		} else {
			headNode = l2;
			headNode.next = mergeTwoLists(l1, l2.next);
		}

		return headNode;
	}
	
	public static void main(String[] args) {

		LinkedListNode l1 = new LinkedListNode(2);
		l1.next = new LinkedListNode(4);
		LinkedListNode l2 = new LinkedListNode(3);
		l2.next = new LinkedListNode(5);
		
		System.out.println("Input  : 2->4 and 3->5");
		
		LinkedListNode merged = mergeTwoLists(l1, l2);
		while (merged != null) {
			System.out.print(Integer.toString(merged.value) + "->");
			merged = merged.next;
		}

	}

}
