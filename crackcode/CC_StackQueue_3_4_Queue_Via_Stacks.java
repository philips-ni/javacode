package crackcode;

import java.util.Stack;

/**
 * CC.StackQueue.3.5 Queue from Stacks
 * 
 * Question : Implement a MyQueue class which implements a queue using two stacks.
 *
 */
public class CC_StackQueue_3_4_Queue_Via_Stacks {

	public class MyQueue<T> {

		private Stack<T> st1 ; // store enqueue values
		private Stack<T> st2 ; // store older values to be dequeued
		
		public MyQueue(){
			st1 = new Stack<T>();
			st2 = new Stack<T>();
		}
		public void enqueue(T v){
			st1.push(v);	
		}
		
		public T dequeue(){
			if(st2.isEmpty()){
				// shift values unless the old queue is empty
				while(!st1.isEmpty()){
					st2.push(st1.pop());
				}
			}
			
			return st2.pop();
		}

	}

	public void test(){
		MyQueue q = new MyQueue();
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
		q.enqueue(3);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	public static void main(String[] args) {
		CC_StackQueue_3_4_Queue_Via_Stacks sq = new CC_StackQueue_3_4_Queue_Via_Stacks();	
		sq.test();
	}
}
