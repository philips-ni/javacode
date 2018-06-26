package gitbook;

/**
 * Bit.2.12 Find if two rectangles overlap
 * 
 * Two rectangles do not overlap if one of the following conditions is true.
 * 
 * 1) One rectangle is above top edge of other rectangle.
 * 
 * 2) One rectangle is on left side of left edge of other rectangle.
 *
 */
public class Bit_2_12_Overlap_Rectangle {

	public class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean intersect(Point left1, Point right1, Point left2, Point right2) {
		// check if one rectangle is on the left of another
		if ((right1.x < left2.x) || (right2.x < left1.x))
			return false;

		// check if one rectangle is above of another
		if (right1.y > left2.y || right2.y > left1.y)
			return false;

		return true;
	}
	
	public void test() {
		Point p11 = new Point(4, 6);
		Point p12 = new Point(15, -6);
		Point p21 = new Point(5, 5);
		Point p22 = new Point(10, 6);
		System.out.println(intersect(p11, p12, p21, p22));
	}

	public static void main(String[] args) {
		Bit_2_12_Overlap_Rectangle test = new Bit_2_12_Overlap_Rectangle();
		test.test();
	}
}
