package epi;

import java.util.Stack;

/**
 * EPI.StackQueue.8.1 Max Stack
 * 
 * Question : Implement a LIFO stack that has a push(), pop(), and max()
 * function, where max() returns the maximum value in the stack. All of these
 * functions should run in O(1) time.
 * 
 * e.g.
 * 
 * push(1) max() = 1 push(2) max() = 2 push(1) max() = 2 pop() = 1 max() = 2
 * pop() = 2 max() = 1
 *
 */
public class EPI_StackQueue_8_1_Max_Stack {

	private class stackElement {
		private int value;
		private int max;

		private stackElement(int value, int max) {
			this.value = value;
			this.max = max;
		}
	}

	private Stack<stackElement> st = new Stack<stackElement>();

	public boolean isEmpty() {
		return st.isEmpty();
	}

	public int max() {
		if (st.isEmpty())
			throw new NullPointerException();
		return st.peek().max;
	}

	public void push(int x) {
		st.push(new stackElement(x, Math.max(x, isEmpty() ? x : max())));
	}

	public int pop() {
		if (isEmpty())
			throw new NullPointerException();

		return st.pop().value;
	}

	public static void main(String[] args) {
		EPI_StackQueue_8_1_Max_Stack st = new EPI_StackQueue_8_1_Max_Stack();
		st.push(1);
		System.out.println(st.max());
		st.push(2);
		System.out.println(st.max());
		st.push(1);
		System.out.println(st.max());
		st.pop();
		System.out.println(st.max());
		st.pop();
		System.out.println(st.max());
	}
}
