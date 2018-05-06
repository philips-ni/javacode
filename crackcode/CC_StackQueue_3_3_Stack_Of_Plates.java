package crackcode;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * CC.StackQueue.3.3 Stack Of Plates
 * 
 * Question : Imagine a (literal) stack of plates. If the stack gets too high,
 * it might topple. Therefore, in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several
 * stacks and should create a new stack once the previous one exceeds
 * capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically
 * to a single stack(that is, pop() should return the same values as it would if
 * there were just a single stack).
 * 
 * Follow up : Implement a function popAt(int index) which performs a pop
 * operation on a specific sub-stack.
 *
 */
public class CC_StackQueue_3_3_Stack_Of_Plates {

	public class SetOfStacks{
		ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
		
		public int capacity;
		
		public SetOfStacks(int capacity){
			this.capacity = capacity;
		}
		
		public Stack<Integer> getLastStack(){
			if(stacks.size()==0) return null;
			return stacks.get(stacks.size()-1);
		}
		
		public void push(int v){
			Stack<Integer> last = getLastStack();
			if(last == null || last.size()==last.capacity()){
				// create a new stack
				Stack<Integer> st = new Stack<Integer>();
				st.push(v);
				stacks.add(st);
			}else{
				// push to existing stack
				last.push(v);
			}
		}
		
		public int pop(){
			Stack<Integer> last = getLastStack();
			if(last == null || last.isEmpty()){
				throw new EmptyStackException();
			}
			int top = last.pop();
			if((last.size()==0)) stacks.remove(last);
			return top;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
