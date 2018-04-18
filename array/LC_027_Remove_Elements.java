package array;

import java.util.Arrays;

/**
 * 
 * LC.Array.027 Remove Element
 * 
 * Question : Given an array and a value, remove all instances of that value in place
 * and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of
 * nums being 2.
 * 
 */
public class LC_027_Remove_Elements {
	
	public static int removeElement(int[] nums, int val) {
		int i = 0;

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				// construct new array with valid element
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	public static void main(String[] args) {
		int[] removeE = { 1, 2, 2, 3, 2, 4, 5, 2 };
		System.out.println("Input  : " + Arrays.toString(removeE));
		System.out.println("Output : " + removeElement(removeE, 2));
	}

}
