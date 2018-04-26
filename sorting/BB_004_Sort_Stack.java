package sorting;

import java.util.Stack;

/**
 * BB.Stack.003 Sort Stack
 * 
 * Question : Given a stack, sort the elements in the stack using one additional
 * stack.
 * 
 * e.g.
 * 
 * sort([1, 3, 2, 4]) = [1, 2, 3, 4]
 *
 */
public class BB_004_Sort_Stack {

	public static Stack<Integer> sortStack(Stack<Integer> st) {
		Stack<Integer> sortedSt = new Stack<Integer>();

		while (!st.isEmpty()) {
			int temp = st.pop();

			// looking for a spot to push
			while (!sortedSt.isEmpty() && temp > sortedSt.peek()) {

				st.push(sortedSt.pop());

			}

			// found spot and push
			sortedSt.push(temp);
		}

		return sortedSt;
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(3);
		st.push(2);
		st.push(4);
		System.out.println(sortStack(st));

	}

}
