package util;

import java.util.EmptyStackException;

public class LinkedStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	public LinkedStack() {
		top = null;
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T data = top.data;
		top = top.next;

		return data;
	}

	public void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		node.next = top;
		top = node;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return (top == null);
	}
}
