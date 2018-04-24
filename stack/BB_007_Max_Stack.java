package stack;

/**
 * BB.Stack.007 Max Stack
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
public class BB_007_Max_Stack {

	public class Stack {
		private class Node {
			private int val;
			private Node next;
			private Node oldMax; // track old max value when new value is pushed in stack
		}

		private Node top;
		private Node max;

		public Stack() {
			top = null;
			max = null;
		}

		public void push(int val) {
			Node n = new Node();
			n.val = val;

			if (top == null) {
				top = n;
			} else {
				n.next = top;
				top = n;
			}

			n.oldMax = max; // save max to oldmax
			if (max == null || n.val > max.val) {				
				max = n; //reset max
			}
		}

		public int pop() {
			if (top == null)
				throw new NullPointerException();

			Node temp = top;
			top = temp.next;
			max = temp.oldMax;
			return temp.val;
		}

		public int max() {
			if (max == null)
				throw new NullPointerException();
			return max.val;
		}
	}

	public void test() {
		Stack st = new Stack();
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

	public static void main(String[] args) {
		BB_007_Max_Stack ms = new BB_007_Max_Stack();
		ms.test();
	}
}
