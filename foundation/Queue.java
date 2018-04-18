package foundation;

public class Queue {
	
	private Node first;
	private Node last;
	
	private int size;
	
	private static class Node{
		private int value;
		private Node next;
		
		Node(int value){
			this.value = value;
			this.next = null;
		}
	}
	
	public Queue(){
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int length(){
		return size;
	}
	
	public void enqueue(int value){		
		Node oldlast = last;
		last = new Node(value);
		
		if(isEmpty()) first = last;
		else oldlast.next = last;
		
		size++;
	}

	public int dequeue(){
		if(isEmpty()) System.out.println("Queue underflow");
		
		int value = first.value;
		
		if(first.next == null){
			last = null;
		}
		
		first = first.next;
		size--;
		
		return value;
	}
	
	public int peek() {
		if(isEmpty()) System.out.println("queue underflow");
		
		return first.value;
	}
	
	public static void main(String[] args){
		Queue q = new Queue();
		q.enqueue(11);
		q.enqueue(22);
		q.enqueue(33);
		System.out.println("queue length : "+q.length());
		System.out.println("first element : " + q.peek());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("queue length : "+q.length());
	}
}
