package foundation;

/**
 * 
 * This is to implement a stack class including push, pop, peek method
 */
class Stack {
	private int STACK_SIZE;
	private int top;
	private int[] stack;

	Stack(int size) {
		STACK_SIZE = size; // set the max stack size
		stack = new int[STACK_SIZE]; // create the stack array
		top = -1; // initialize the stack pointer
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int pop() {
		if (top != -1)
			return stack[top--];
		else {
			System.out.println("No element to pop");
			return -1;
		}
	}

	public void push(int value) {
		if (top == STACK_SIZE - 1)
			System.out.println("Too much elements to push");
		else
			stack[++top] = value;
	}

	public int peek() {
		return stack[top];
	}

	public static void main(String[] args) {
		Stack st = new Stack(5);
		st.push(11);
		st.push(12);
		st.push(13);
		st.push(14);
		st.push(15);
		st.push(16);

		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
	}
}
