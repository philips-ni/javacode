package crackcode;

import java.util.ArrayList;

/**
 * CC.Recursion.6.2 NxN paths
 * 
 * Question : Imagine a robot sitting on the upper left hand corner of an NxN
 * grid. The robot can only move in two directions: right and down. How many
 * possible paths are there for the robot? FOLLOW UP Imagine certain squares are
 * “off limits”, such that the robot can not step on them. Design an algorithm
 * to get all possible paths for the robot.
 *
 */
public class CC_Recursion_6_2_N_N_Paths {

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
		CC_Recursion_6_2_N_N_Paths test = new CC_Recursion_6_2_N_N_Paths();
		System.out.println(test.getPath(4, 4));
		test.printPath();
	}

}
