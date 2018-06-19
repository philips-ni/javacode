package epi;

import java.util.Stack;

/**
 * EPI.StackQueue.8.8 Implement a Queue Using Stacks
 *
 */
public class EPI_StackQueue_8_8_Queue_from_Stacks {

	public class Queue<T> {
		private Stack<T> st1 = new Stack<T>(); // enqueue
		private Stack<T> st2 = new Stack<T>(); // dequeue

		public void enqueue(T x) {
			st1.push(x);
		}

		public T dequeue() {
			if (st2.isEmpty()) {
				while (!st1.isEmpty()) {
					st2.push(st1.pop());
				}
			}

			return st2.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}