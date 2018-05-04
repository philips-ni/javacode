package crackcode;

import java.util.EmptyStackException;

/**
 * CC.StackQueue.1.1 Three In One
 * 
 * Question : Describe how you could use a single array to implement three
 * stacks.
 *
 * Fixed division and Flexible division.
 * 
 */
public class CC_StackQueue_1_1_Three_In_One {

	public class FixedMultiStack {
		private int numStacks = 3;
		private int stackCapacity; // capacity for each stack
		private int[] values; // store values for three stacks
		private int[] sizes; // track actual size of each stack

		public FixedMultiStack(int stackSize) {
			stackCapacity = stackSize;
			values = new int[stackSize * numStacks];
			sizes = new int[numStacks];
		}

		public void push(int stackId, int value) throws java.lang.ArrayIndexOutOfBoundsException {
			if (isFull(stackId))
				throw new java.lang.ArrayIndexOutOfBoundsException();
			sizes[stackId]++;
			values[stackTopId(stackId)] = value;
		}

		public int pop(int stackId) throws EmptyStackException {
			if (isEmpty(stackId))
				throw new EmptyStackException();
			int value = values[stackTopId(stackId)];
			sizes[stackId]--;
			return value;
		}

		public int peek(int stackId) throws EmptyStackException {
			if (isEmpty(stackId))
				throw new EmptyStackException();
			return values[stackTopId(stackId)];
		}

		public boolean isFull(int stackId) {
			return sizes[stackId] == stackCapacity;
		}

		public boolean isEmpty(int stackId) {
			return sizes[stackId] == 0;
		}

		public int stackTopId(int stackId) {
			return stackCapacity * stackId + sizes[stackId] - 1;
		}
	}

	public class FlexMultiStack {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
