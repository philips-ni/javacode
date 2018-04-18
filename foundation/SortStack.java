package foundation;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sortStack(Stack<Integer> stack) {

		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int tmp = stack.pop();

			while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
				stack.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(3);
		st.push(4);
		st.push(2);
		System.out.println("Input : " + st);
		System.out.println("Output : " + sortStack(st));

	}

}
