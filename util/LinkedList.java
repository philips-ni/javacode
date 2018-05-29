package util;

/**
 * In a singly linked list, each node in the list stores the contents of the
 * node and a pointer or reference to the next node in the list. It does not
 * store any pointer or reference to the previous node. It is called a singly
 * linked list because each node only has a single link to another node.
 * 
 * To store a single linked list, you only need to store a reference or pointer
 * to the first node in that list. The last node has a pointer to nothingness to
 * indicate that it is the last node.
 * 
 */
public class LinkedList {

	private LinkedListNode head;
	private LinkedListNode tail; // easier to add node to the end with tail

	private int count;

	public LinkedList() {
		this.count = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return this.count;
	}

	public void add(int value) {
		LinkedListNode node = new LinkedListNode();
		node.value = value;

		if (head == null) {
			// setting both head and tail pointing to the only node
			head = node;
			tail = node;
		} else {
			// set tail's next to the new node
			tail.next = node;

			// set tail to the new node
			tail = node;
		}

		this.count++;
	}

	public void add(int value, int pos) {
		LinkedListNode node = new LinkedListNode();
		node.value = value;

		LinkedListNode current = this.head;
		int it = 1;

		while (current.next != null && it < pos) {
			current = current.next;
			it++;
		}

		if (it == pos) {
			if (current.next != null) {
				// insert new node
				node.next = current.next;
				current.next = node;
			} else {
				// append new node after tail
				current.next = node;
				// set tail to the new node
				tail = node;
			}

			this.count++;
		} else {
			System.out.println("Specified position number is too big.");
		}

	}

	public void delete(int value) {
		LinkedListNode previous = this.head;
		LinkedListNode current = this.head;

		while (true) {
			if (current.value == value) {
				// delete node
				System.out.println("Found the value to delete");
				if (current.next != null) {
					System.out.println("drop current node");
					previous.next = current.next;
				} else {
					// set tail to previous
					System.out.println("Drop current node and set tail to previous");
					previous.next = null;
					tail = previous;
				}
				this.count--;
				break;
			} else {
				if (current.next != null) {
					previous = current;
					current = current.next;
				} else {
					// this is the tail
					System.out.println("Didn't find value to delete");
					break;
				}
			}
		}
	}

	public void print() {
		LinkedListNode current = this.head;

		while (current.next != null) {
			System.out.println(Integer.toString(current.value));
			current = current.next;
		}

		// print last one
		System.out.println(Integer.toString(current.value));
	}

	public static void main(String args[]) {

		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.delete(3);
		list.delete(5);

		System.out.println("List size is  " + list.size());
		list.print();

	}

}
