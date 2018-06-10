package linkedlist;

import java.util.Stack;

import common.Helper;
import util.LinkedListNode;

/**
 * BB.LinkedList.005 Print reversed linked list
 * 
 * Question : Given a linked list, write a function that prints the nodes of the
 * list in reverse order.
 * 
 * e.g. input : 1, 2, 3 output: 3, 2, 1
 * 
 */
public class BB_005_Print_Reversed_Linkedlist {	
	// reverse and print
	public static LinkedListNode reverse(LinkedListNode node) {
		LinkedListNode head = node;
		while (node.next != null) {
			LinkedListNode temp = node.next;
			node.next = node.next.next;
			temp.next = head;
			head = temp;
		}
		return head;
	}
	
	// clone a new list when original list is not allowed to reverse, 
	public static LinkedListNode reverseClone(LinkedListNode node) {
		LinkedListNode head = null; // head of cloned list
		while(node!=null) {
			LinkedListNode temp = new LinkedListNode(node.value);
			temp.next = head;
			head = temp;
			node = node.next;
		}
		
		return head;
	}
	
	// use stack to print in reverse order
	public static void printReversedList(LinkedListNode node){
		Stack<LinkedListNode> st = new Stack<LinkedListNode>();
		while(node!=null){
			st.push(node);
			node = node.next;
		}
		while(!st.isEmpty()){
			System.out.println(st.pop().value);
		}
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
		n3.next = null;

		Helper.printLinkedList(reverse(n1)); // reversed list is 3 -> 2 -> 1
		printReversedList(n3); // list is still 3 -> 2 -> 1 and print in reversed order
		
		Helper.printLinkedList(reverseClone(n3)); // clone a new list with reversed order 1 -> 2 -> 3
	}
}
