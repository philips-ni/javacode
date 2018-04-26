package queue;

import java.util.Queue;
import java.util.LinkedList;
import java.lang.IndexOutOfBoundsException;

/**
 * BB.Stack.004 Stack From Queues
 * 
 * Question : Implement a LIFO stack with basic functionality (push and pop)
 * using FIFO queues to store the data.
 * 
 * 
 *
 */
public class BB_002_Stack_From_Queues {

	public class stack {

		Queue<Integer> q1 = new LinkedList<Integer>(); // used for stack
		Queue<Integer> q2 = new LinkedList<Integer>(); // used to reverse queue

		public stack() {
		}

		public void push(int value) {
			q2.add(value);
			while (!q1.isEmpty()) {
				q2.add(q1.remove());
			}

			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}

		public int pop() {
			if (q1.isEmpty())
				throw new IndexOutOfBoundsException();

			return q1.remove();
		}
	}

	public void test(){
		stack st = new stack();
		st.push(1);
		st.push(3);
		st.push(2);
		st.push(4);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
	public static void main(String[] args) {
		BB_002_Stack_From_Queues sq = new BB_002_Stack_From_Queues();
		
		sq.test();

	}

}
