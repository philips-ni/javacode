package crackcode;

/**
 * CC.StackQueue.3.1 Min Stack
 * 
 * Question : How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element? Push, pop and min
 * should all operate in O(1) time.
 *
 */
public class CC_StackQueue_3_2_Min_Stack {

	public class Stack {
		private class Node {
			private int val;
			private Node next;
			private Node oldMin; // track old min value when new value is pushed in stack
		}

		private Node top;
		private Node min;

		public Stack() {
			top = null;
			min = null;
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

			n.oldMin = min; // save min to oldmin
			if (min == null || n.val < min.val) {
				min = n; // reset max
			}
		}

		public int pop() {
			if (top == null)
				throw new NullPointerException();

			Node temp = top;
			top = temp.next;
			min = temp.oldMin;
			return temp.val;
		}

		public int min() {
			if (min == null)
				throw new NullPointerException();
			return min.val;
		}
	}

	public void test() {
		Stack st = new Stack();
		st.push(3);
		System.out.println(st.min());
		st.push(2);
		System.out.println(st.min());
		st.push(1);
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
		st.pop();
		System.out.println(st.min());
	}

	public static void main(String[] args) {
		CC_StackQueue_3_2_Min_Stack ms = new CC_StackQueue_3_2_Min_Stack();
		ms.test();
	}

}
