package recursion;

import java.util.Stack;

/**
 * BB.Recursion.004 Reverse Stack
 * 
 * Question : Given a stack, reverse the items without creating any additional
 * data structures.
 * 
 * e.g. reverse(1->2->3) = 3->2->1
 *
 */
public class BB_004_Reverse_Stack {

	public static Stack<Integer> reverse(Stack<Integer> stack){
		if(stack.isEmpty()) return stack;
		
		int temp = stack.pop(); // empty stack
		System.out.println("pop : "+temp);
		reverse(stack);
		System.out.println("insert : " + temp);
		insertAtBottom(stack,temp); // insert at bottom
		return stack;
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int x){
		if(stack.isEmpty()) {
			stack.push(x); // insert at bottom of stack when it's empty
			return;
		}
		
		int temp = stack.pop(); // empty the stack
		insertAtBottom(stack,x);
		stack.push(temp); // push back to stack
	}
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		
		reverse(st);
	}

}
