package crackcode;

import java.util.Stack;

/**
 * CC.StackQueue.3.5 Sort Stack
 * 
 * Question : Write a program to sort a stack such that the smallest items are
 * on the top. You can use an additional temporary stack, but you may not copy
 * the elements into any other data structure(such as an array). The stack
 * supports the following operations: push,pop,peek and isEmpty.
 *
 */
public class CC_StackQueue_3_5_Sort_Stack {

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
		Stack<Integer> temp = sortStack(st);
		System.out.println(temp);
		System.out.println(temp.peek());

	}

}
