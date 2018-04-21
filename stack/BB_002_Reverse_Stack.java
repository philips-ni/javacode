package stack;

import java.util.Stack;

/**
 * BB.Stack.002 Reverse Stack
 * 
 * Question : Given a stack, reverse the items without creating any additional
 * data structures.
 * 
 * e.g.
 * 
 * reverse(1->2->3) = 3->2->1
 *
 */
public class BB_002_Reverse_Stack {

	public static Stack<Integer> reverse(Stack<Integer> st) {
		if (st.isEmpty())
			return st;

		int temp = st.pop();
		reverse(st);
		insertAtBottom(st, temp);

		return st;
	}

	private static void insertAtBottom(Stack<Integer> st, int x) {
		if (st.isEmpty()) {
			st.push(x);
			return;
		}

		int temp = st.pop();
		insertAtBottom(st, x);
		st.push(temp);

	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();

		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st);
		System.out.println(reverse(st));

	}

}
