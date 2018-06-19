package epi;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * EPI.StackQueue.8.10 Implement a Stack Using Queues
 *
 */
public class EPI_StackQueue_8_10_Stack_from_Queues {

	public class Stack<T> {
		private Queue<T> q1 = new LinkedList<T>(); // pop
		private Queue<T> q2 = new LinkedList<T>(); // push

		public void push(T x) {
			q2.add(x);

			// add x to the front of q1
			while (!q1.isEmpty()) {
				q2.add(q1.remove());
			}

			Queue<T> temp = q2;
			q2 = q1;
			q1 = temp;
		}

		public T pop() {
			if (q1.isEmpty())
				throw new NoSuchElementException("empty stack");
			return q1.remove();
		}
	}
	
	public void test(){
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

	public static void main(String[] args) {
		EPI_StackQueue_8_10_Stack_from_Queues st = new EPI_StackQueue_8_10_Stack_from_Queues();
		st.test();
	}
}
