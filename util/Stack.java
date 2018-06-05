package util;

import java.util.EmptyStackException;

public class Stack<T> {

	private T[] stack;
	private int top;
	private int size;
	private int STACK_SIZE = 1024; // define the stack capacity

	public Stack() {
		stack = (T[]) new Object[STACK_SIZE]; // create the stack array
		top = -1; // initialize the stack pointer
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		return stack[top--];
	}

	public void push(T value) {
		if (size == stack.length)
			ensureCapacity(size * 2 + 1);

		stack[++top] = value;
		size++;
	}

	private void ensureCapacity(int capacity) {
		if (capacity < size)
			return;

		T[] old = stack;

		stack = (T[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			stack[i] = old[i];
		}
	}

	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();

		return stack[top];
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(11);
		st.push(12);
		st.push(13);
		st.push(14);
		st.push(15);
		st.push(16);

		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
	}
}
