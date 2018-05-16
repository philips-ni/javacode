package crackcode;

import util.LinkedListNode;

/**
 * CC.LinkedList.2.7 Intersection
 * 
 * Question : Given two singly linked lists, determine if the two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node(by reference) as the jth node of the
 * second linked list then they are intersecting.
 * 
 * e.g.
 * 
 * 3 -> 1 -> 5 -> 9 ->
 * 
 * 						7 -> 2 -> 1
 * 
 * 			 4 -> 6 ->
 *
 */
public class CC_LinkedList_2_7_Intersection {
	private class result {
		int length;
		LinkedListNode tail;
		result(int length, LinkedListNode tail){
			this.length = length;
			this.tail = tail;
		}
	}

	private result getLenTail(LinkedListNode n) {
		int length = 1;
		while (n.next != null) {
			length++;
			n = n.next;
		}
		return new result(length,n);
	}

	public boolean isIntersecting(LinkedListNode n1, LinkedListNode n2) {
		// get lenghth for each linkedlist
		result r1 = getLenTail(n1);
		result r2 = getLenTail(n2);

		// compare the tails for two linkedlist
		if(r1.tail!=r2.tail) return false;

		// on the longer list, advance the pointer by the difference in length
		int diff = Math.abs(r1.length - r2.length);
		LinkedListNode shorter = r1.length>r2.length? n2:n1;
		LinkedListNode longer = r1.length>r2.length?n1:n2;
		
		for(int i=0;i<diff;i++){
			longer = longer.next; // advance longer pointer by diff to align with shorter pointer
		}	

		// traverse on each linkedlist until the pointers are the same
		while(longer!=null){
			if(longer==shorter) return true;
			longer = longer.next;
			shorter = shorter.next;
		}

		return false;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(3);
		LinkedListNode n2 = new LinkedListNode(1);
		LinkedListNode n3 = new LinkedListNode(5);
		LinkedListNode n4 = new LinkedListNode(9);
		LinkedListNode n5 = new LinkedListNode(7);
		LinkedListNode n6 = new LinkedListNode(2);
		LinkedListNode n7 = new LinkedListNode(1);
		LinkedListNode n8 = new LinkedListNode(4);
		LinkedListNode n9 = new LinkedListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n8.next = n9;
		n9.next = n5;

		CC_LinkedList_2_7_Intersection test = new CC_LinkedList_2_7_Intersection();
		System.out.println(test.isIntersecting(n1, n8));
	}

}
