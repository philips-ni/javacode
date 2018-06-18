package epi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class EPI_StackQueue_8_9_Max_Queue {

	private Queue<Integer> qu = new LinkedList<Integer>();
	private Deque<Integer> max = new LinkedList<Integer>();

	public void enqueue(Integer e) {
		qu.add(e);
		while (!max.isEmpty() && max.peekLast() < e) {
			max.removeLast();
		}
		max.addLast(e);
	}

	public int deque() {
		if (!qu.isEmpty()) {
			int result = qu.remove();
			if (result == max.peekFirst()) {
				max.removeFirst();
			}
			return result;
		}
		throw new NoSuchElementException("deque failed due to empty");
	}

	public int max() {
		if (!max.isEmpty()) {
			return max.peekFirst();
		}
		throw new NoSuchElementException("get max failed due to empty");
	}

	public static void main(String[] args) {
		EPI_StackQueue_8_9_Max_Queue qu = new EPI_StackQueue_8_9_Max_Queue();
		qu.enqueue(3);
		qu.enqueue(1);
		qu.enqueue(3);
		qu.enqueue(2);
		qu.enqueue(0);
		qu.enqueue(1);
		qu.deque();
		qu.deque();
		qu.enqueue(2);
		qu.enqueue(4);
		qu.deque();
		qu.enqueue(4);
	}
}
