package array;

import java.util.Arrays;

/*
 * 
 * LC.Array.011 Container With Most Water
 * 
 * Question : Given n non-negative integers a1, a2, ..., an, where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
 * together with x-axis forms a container, such that the container contains
 * the most water. Note: You may not slant the container and n is at least
 * 2.

 * explanation: 1.The widest container (using first and last line) is a good
 * candidate, because of its width. Its water level is the height of the
 * smaller one of first and last line. 2.All other containers are less wide
 * and thus would need a higher water level in order to hold more water.
 * 3.The smaller one of first and last line doesn't support a higher water
 * level and can thus be safely removed from further consideration.
 * 
 */
public final class LC_011_Container_With_Most_Water {

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		int h = 0;
		int w = 0;

		while (left < right) {
			h = Math.min(height[left], height[right]);
			w = right - left;

			maxArea = Math.max(maxArea, h * w);
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 2, 4, 3, 5, 6, 4, 7, 3, 5 };
		System.out.println("Input  : " + Arrays.toString(height));
		System.out.println("Output : " + maxArea(height));
	}

}
