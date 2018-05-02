package crackcode;

import foundation.LinkedListNode;

/**
 * CC.LinkedList.2.3 Delete Middle Node
 * 
 * Question : Implement an algorithm to delete a node in the middle of a singly
 * linked list, given only access to that node. It's any node but the first and
 * last node, not necessarily the exact middle.
 * 
 * e.g.
 * 
 * Input : the node c from linked list a-b-c-d-e-f
 * 
 * Output: nothing is returned, but the new linked list looks like a-b-d-e-f
 *
 */
public class CC_LinkedList_2_3_Delete_Middle_Node {

	public static boolean deleteMiddleNode(LinkedListNode n){
		if(n==null||n.next==null){
			return false;
		}
		
		LinkedListNode next = n.next;
		n.value = next.value;
		n.next = next.next;
		return true;
	}
	public static void main(String[] args) {
		
	}

}
