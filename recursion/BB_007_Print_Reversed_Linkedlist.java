package recursion;
import util.LinkedListNode;

/**
 * BB.Recursion.007 Print reversed linked list
 *
 * Question : Given a linked list, write a function that prints the nodes of the
 * list in reverse order.
 *
 */
public class BB_007_Print_Reversed_Linkedlist {

	public static void printReversedLinkedlist(LinkedListNode node){
		if(node==null) return;
		printReversedLinkedlist(node.next);
		System.out.println(node.value);
	}
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode();
		n1.value = 1;
		LinkedListNode n2 = new LinkedListNode();
		n2.value = 2;
		LinkedListNode n3 = new LinkedListNode();
		n3.value = 3;
		
		n1.next = n2;
		n2.next = n3;
		
		printReversedLinkedlist(n1);

	}

}
