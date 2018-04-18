package array;

import java.util.Arrays;

public class Reverse_Array {

	public static void reverseArray(int[] data){
		int left = 0;
		int right = data.length -1 ;
		
		while(left < right){
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;
			
			left++;
			right--;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}

}
