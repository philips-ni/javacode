package array;

/**
 * BB.Array.3 Matrix product
 * 
 * Question : Given a matrix, find the path from top left to bottom right
 * with the greatest product by moving only down and right.
 * 
 * e.g.
 * 
 * Input:
 * 
 * [1, 2, 3]
 * 
 * [4, 5, 6]
 * 
 * [7, 8, 9]
 * 
 * Output:
 * 
 * 1 -> 4 -> 7 -> 8 -> 9
 * 
 * 2016
 * 
 * Input:
 * 
 * [-1, 2, 3]
 * 
 * [4, 5, -6]
 * 
 * [7, 8, 9]
 * 
 * Output:
 * 
 * -1 -> 4 -> 5 -> -6 -> 9
 * 
 * 1080
 * 
 */
public class BB_003_Matrix_Product {
	public static int matrixProduct(int[][] matrix) {
		int[][] minCache = new int[matrix.length][matrix[0].length];
		int[][] maxCache = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;

				if (i == 0 && j == 0) {
					min = matrix[i][j];
					max = matrix[i][j];
				}

				// consider the value above
				if (i > 0) {
					int tempMin = Math.min(matrix[i][j] * maxCache[i - 1][j], matrix[i][j] * minCache[i - 1][j]);
					int tempMax = Math.max(matrix[i][j] * maxCache[i - 1][j], matrix[i][j] * minCache[i - 1][j]);
					min = Math.min(min, tempMin);
					max = Math.max(max, tempMax);
				}

				// consider the value to the left
				if (j > 0) {
					int tempMin = Math.min(matrix[i][j] * maxCache[i][j - 1], matrix[i][j] * minCache[i][j - 1]);
					int tempMax = Math.max(matrix[i][j] * maxCache[i][j - 1], matrix[i][j] * minCache[i][j - 1]);
					min = Math.min(min, tempMin);
					max = Math.max(max, tempMax);
				}

				minCache[i][j] = min;
				maxCache[i][j] = max;
			}
		}
		return maxCache[matrix.length - 1][matrix[0].length - 1];
	}
	public static void main(String[] args) {
		int[][] matrix = { { -1, 2, 3 }, { 4, 5, -6 }, { 7, 8, 9 } };
		System.out.println(matrixProduct(matrix));

	}

}
