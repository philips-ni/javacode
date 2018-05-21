package crackcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CC.Recursion.8.12 Eight Queens
 * 
 * Question : Write an algorithm to print all ways of arrnging eight queeens on
 * an 8x8 chess board so that none of them share the same row, column, or
 * diagonal. In this case, "diagonal" means all diagonals not just the two that
 * bisect the board.
 *
 */
public class CC_Recursion_8_12_Eight_Queens {

	private static final int GRID_SIZE = 8;

	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(columns, row, col)) {
					columns[row] = col; // place queen
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	private static boolean checkValid(Integer[] columns, int row, int column) {
		for (int row1 = 0; row1 < row; row1++) {
			int column1 = columns[row1];

			// check if there is a queen in the same column
			if (column1 == column)
				return false;

			// check if there is a queen in the diagonals
			int columnDistance = Math.abs(column1 - column);
			int rowDistance = Math.abs(row1 - row);

			if (columnDistance == rowDistance)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0, columns, results);
		for (int i = 0; i < results.size(); i++) {
			System.out.println(Arrays.toString(results.get(i)));
		}
	}

}
