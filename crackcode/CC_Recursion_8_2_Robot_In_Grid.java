package crackcode;

import java.util.ArrayList;

/**
 * CC.Recursion.8.2 Robot In a Grid
 * 
 * Question : Imagine a robot sitting on the upper left hand corner with r rows
 * and c columns. The robot can only move in two directions, right and down, but
 * certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the
 * bottom right.
 *
 */
public class CC_Recursion_8_2_Robot_In_Grid {

	private class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private ArrayList<Point> path = new ArrayList<Point>();

	private boolean isFree(int x, int y) {

		if (x == 2 && y == 4)
			return false;

		return true;
	}

	/*
	 * The robot has to move right m-1 times out of m-1+n-1 total moves. The
	 * possibles paths is C(m-1+n-1,m-1).
	 * 
	 * Arrangement: A(n,m)= n*(n-1)*...*(n-m+1)=n!/(n-m)!
	 * 
	 * Combination: C(n,m)=A(n,m)/m!=n!/m!(n-m)!
	 */
	public boolean getPath(int m, int n) {
		Point p = new Point(m, n);
		path.add(p);

		if (m == 0 && n == 0)
			return true; // found path

		boolean success = false;
		if (m > 0 && isFree(m - 1, n)) {
			// go right
			success = getPath(m - 1, n);
		}

		if (!success && isFree(m, n - 1)) {
			// go down
			success = getPath(m, n - 1);
		}

		if (!success) {
			// wrong way
			path.remove(p);
		}

		return success;
	}

	public void printPath() {
		for (int i = 0; i < path.size(); i++) {
			System.out.println(path.get(i).x + " : " + path.get(i).y);
		}
	}

	public static void main(String[] args) {
		CC_Recursion_8_2_Robot_In_Grid test = new CC_Recursion_8_2_Robot_In_Grid();
		System.out.println(test.getPath(4, 4));
		test.printPath();
	}

}
