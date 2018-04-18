package array;

/**
 * BB.Array.006 Zero Matrix
 * 
 * Question : Given a boolean matrix, update it so that if any cell is true,
 * all the cells in that row and column are true.
 * 
 * e.g.
 * 
 * Input:
 * 
 * [true, false, false]
 * 
 * [false, false, false]
 * 
 * [false, false, true]
 * 
 * Output:
 * 
 * [true, true, true]
 * 
 * [true, false, true]
 * 
 * [true, true, true]
 * 
 */
public class BB_006_Zero_Matrix {

	public static void zeroMatrix(boolean[][] matrix) {

		// rows and cols are used to track which rows and cols should be set to
		// true. boolean type is default to false
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					rows[i] = true; // row i will be set to true
					cols[j] = true; // col j will be set to true
				}
			}
		}

		// set rows to true
		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				for (int j = 0; j < cols.length; j++) {
					matrix[i][j] = true;
				}
			}
		}

		// set cols to true
		for (int i = 0; i < cols.length; i++) {
			if (cols[i]) {
				for (int j = 0; j < rows.length; j++) {
					matrix[j][i] = true;
				}
			}
		}
	}

	public static void zeroMatrix_optimal(boolean[][] matrix) {

		boolean zeroCol = false;
		boolean zeroRow = false;

		// get the value first column should be set
		for (int i = 0; i < matrix.length; i++) {
			zeroCol |= matrix[i][0];
		}
		// get the value first row should be set
		for (int j = 0; j < matrix[0].length; j++) {
			zeroRow |= matrix[0][j];
		}

		// check remaining inner matrix and track the row/column value with
		// first
		// column/row space
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j]) {
					matrix[i][0] = true;
					matrix[0][j] = true;
				}
			}
		}

		// set rows
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0]) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = true;
				}
			}
		}

		// set columns
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j]) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = true;
				}
			}
		}

		// set first row
		if (zeroRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = true;
			}
		}

		// set first column
		if (zeroCol) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = true;
			}
		}
	}

	public static void printArray(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}

	}
	
	public static void main(String[] args) {
		boolean[][] zeroMatrix = { { true, false, false }, { false, false, false }, { false, false, true } };
		zeroMatrix_optimal(zeroMatrix);
		printArray(zeroMatrix);
		boolean[][] zeroMatrix1 = { { true, false, false }, { false, false, false }, { false, false, true } };
		zeroMatrix_optimal(zeroMatrix1);
		printArray(zeroMatrix1);
	}

}
