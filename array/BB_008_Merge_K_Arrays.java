package array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * BB.Array.008 Merge K Arrays
 * 
 * Question : Given k sorted arrays, merge them into a single sorted
 * array.
 * 
 * e.g.
 * 
 * merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
 * 
 */
public class BB_008_Merge_K_Arrays {

	private class pqNode implements Comparable<pqNode> {
		int row, col, value;

		public pqNode(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}

		public int compareTo(pqNode n) {
			if (this.value > n.value)
				return 1;
			if (this.value < n.value)
				return -1;
			return 0;
		}

	}

	public int[] mergeKArrays(int[][] arrays) {
		PriorityQueue<pqNode> pq = new PriorityQueue<pqNode>();

		int size = 0;
		for (int i = 0; i < arrays.length; i++) {
			size += arrays[i].length;
			if (arrays[0].length > 0) {
				pq.add(new pqNode(i, 0, arrays[i][0]));
			}
		}

		int[] result = new int[size];

		for (int i = 0; !pq.isEmpty(); i++) {
			pqNode firstNode = pq.poll();
			result[i] = firstNode.value;
			int newCol = firstNode.col + 1;
			if (newCol < arrays[firstNode.row].length)
				pq.add(new pqNode(firstNode.row, newCol, arrays[firstNode.row][newCol]));
		}

		return result;

	}
	
	public static void main(String[] args) {
		int[][] mkArray = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
		BB_008_Merge_K_Arrays as = new BB_008_Merge_K_Arrays();
		int[] mkArrayResult = as.mergeKArrays(mkArray);
		System.out.println(Arrays.toString(mkArrayResult));
	}

}
