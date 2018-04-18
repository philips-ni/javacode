package foundation;

/**
 *
 * Singly Linked Lists are a type of data structure. It is a type of list. In a
 * singly linked list each node in the list stores the contents of the node and
 * a pointer or reference to the next node in the list. It does not store any
 * pointer or reference to the previous node. It is called a singly linked list
 * because each node only has a single link to another node.
 * 
 * To store a single linked list, you only need to store a reference or pointer
 * to the first node in that list. The last node has a pointer to nothingness to
 * indicate that it is the last node.
 * 
 */
public class MyLinkedList {

	private MyNode head;
	private MyNode tail; // using tail pointer is much easier to add node to the
							// end

	private int count;

	public MyLinkedList() {
		this.count = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return this.count;
	}

	public void add(int value) {
		MyNode node = new MyNode();
		node.setValue(value);

		if (head == null) {
			// setting both head and tail pointing to the only node
			head = node;
			tail = node;
		} else {
			// set tail's next to the new node
			tail.setNext(node);

			// set tail to the new node
			tail = node;
		}

		this.count++;
	}

	public void add(int value, int pos) {
		MyNode node = new MyNode();
		node.setValue(value);

		MyNode current = this.head;
		int it = 1;

		while (current.getNext() != null && it < pos) {
			current = current.getNext();
			it++;
		}

		if (it == pos) {
			if (current.getNext() != null) {
				// insert new node
				node.setNext(current.getNext());
				current.setNext(node);
			} else {
				// append new node after tail
				current.setNext(node);
				// set tail to the new node
				tail = node;
			}

			this.count++;
		} else {
			System.out.println("Specified position number is too big.");
		}

	}

	public void delete(int value) {
		MyNode previous = this.head;
		MyNode current = this.head;

		while (true) {
			if (current.getValue() == value) {
				// delete node
				System.out.println("Found the value to delete");
				if (current.getNext() != null) {
					System.out.println("drop current node");
					previous.setNext(current.getNext());
				} else {
					// set tail to previous
					System.out.println("Drop current node and set tail to previous");
					previous.setNext(null);
					tail = previous;
				}
				this.count--;
				break;
			} else {
				if (current.getNext() != null) {
					previous = current;
					current = current.getNext();
				} else {
					// this is the tail
					System.out.println("Didn't find value to delete");
					break;
				}
			}
		}
	}

	public void print() {
		MyNode current = this.head;

		while (current.getNext() != null) {
			System.out.println(Integer.toString(current.getValue()));
			current = current.getNext();
		}

		// print last one
		System.out.println(Integer.toString(current.getValue()));
	}

	public static void main(String args[]) {

		MyLinkedList list = new MyLinkedList();
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
