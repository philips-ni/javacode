package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue; // Priority Queue is the class extending AbstractQueue

/**
 * BB.Array.008 Merge K Arrays
 * 
 * Question : Given k sorted arrays, merge them into a single sorted array.
 * 
 * e.g.
 * 
 * merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
 * 
 */
public class BB_008_Merge_K_Arrays_Comparator {

	private class PQNode {
		int array;
		int index;
		int value;

		PQNode(int array, int index, int value) {
			this.array = array;
			this.index = index;
			this.value = value;
		}
	}

	// Implement a external comparator
	private class PQComparator implements Comparator<PQNode> {
		public int compare(PQNode n1, PQNode n2) {
			return n1.value - n2.value;
		}
	}

	public int[] merge(int[][] arrays) {
		Comparator<PQNode> comparator = new PQComparator();
		PriorityQueue<PQNode> pq = new PriorityQueue<PQNode>(arrays.length, comparator);
		int size = 0; // result array size
		for (int i = 0; i < arrays.length; i++) {
			size += arrays[i].length;
			if (arrays[i].length > 0) { 
				pq.add(new PQNode(i, 0, arrays[i][0]));
			}
		}
		
		int[] result = new int[size];
		for(int i=0;!pq.isEmpty();i++) {
			PQNode n = pq.poll();
			result[i] = n.value;
			int newIndex = n.index + 1;
			if(newIndex < arrays[n.array].length) {
				pq.add(new PQNode(n.array, newIndex, arrays[n.array][newIndex]));
			}
		}
		
		return result;
	}

	public void test_comparator() {	
		PQNode n1 = new PQNode(0,2,5);
		PQNode n2 = new PQNode(1,3,3);
		PQNode n3 = new PQNode(2,4,4);
		Comparator<PQNode> comparator = new PQComparator();
		PriorityQueue<PQNode> pq = new PriorityQueue<PQNode>(3, comparator);
		pq.add(n1);
		pq.add(n2);
		pq.add(n3);
		pq.poll();
		pq.add(new PQNode(3,5,7));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().value);
		}
	}
	public static void main(String[] args) {
		int[][] mkArray = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		BB_008_Merge_K_Arrays_Comparator as = new BB_008_Merge_K_Arrays_Comparator();
		as.test_comparator();
		int[] mkArrayResult = as.merge(mkArray);
		System.out.println(Arrays.toString(mkArrayResult));		
	}
}
