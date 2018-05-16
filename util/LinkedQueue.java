package util;

public class LinkedQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> head;
	private QueueNode<T> tail;

	public LinkedQueue() {
		head = tail = null;
	}

	public void enqueue(T data) {
		QueueNode<T> node = new QueueNode<T>(data);

		if (tail != null) {
			tail.next = node;
			tail = tail.next;
		}
		tail = node;
		
		if(head ==null){
			head = tail;
		}
	}
	
	public T dequeue() throws Exception{
		if(head ==null) throw new Exception();
		
		T data = head.data;
		head = head.next;
		
		if(head == null) tail = null;
		
		return data;
	}
	
	public T peek() throws Exception{
		if(head ==null) throw new Exception();
		
		return head.data;
	}
	
	public boolean isEmpty(){
		return (head==null);
	}
}
