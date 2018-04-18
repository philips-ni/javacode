package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * BB.Searching.006 Three Sum
 * 
 * Question : Given a list of integers, write a function that returns all
 * sets of 3 numbers in the list, a,b and c, so that a+b+c=0.
 * 
 * e.g. threeSum({-1,0,1,2,-1,-4}) => {-1,-1,2},{-1,0,1}
 * 
 */
public class BB_006_Three_Sum {

	public static ArrayList<int[]> threeSum_bf(int[] arr) {

		ArrayList<int[]> results = new ArrayList<int[]>();

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if (temp == 0) {
						int[] result = { arr[i], arr[j], arr[k] };
						results.add(result);
						System.out.println(Arrays.toString(result));
					}
				}
			}
		}

		return results;
	}
	
	public static ArrayList<int[]> threeSum_hash(int[] arr){
		ArrayList<int[]> results = new ArrayList<int[]>();
		
		for(int i=0;i<arr.length-1;i++){
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j=0;j<arr.length;j++){
				int x = -(arr[i]+arr[j]);
				if(set.contains(x)){
					int[] result = { arr[i], arr[j], x };
					results.add(result);
					System.out.println(Arrays.toString(result));
				}else{
					set.add(arr[j]);
				}
			}
		}
		return results;
	}
	
	public static ArrayList<int[]> threeSum(int[] arr) {
		ArrayList<int[]> results = new ArrayList<int[]>();
		if (arr.length < 3)
			return results;

		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1; // left pointer
			int k = arr.length - 1; // right pointer

			while (j < k) {
				if (arr[j] + arr[k] == -arr[i]) {
					int[] result = { arr[i], arr[j], arr[k] };
					results.add(result);
					System.out.println(Arrays.toString(result));
					
					j++;
					k--;
					
				} else if (arr[j] + arr[k] > -arr[i]) {
					k--;
				} else {
					j++;
				}
			}
		}

		return results;

	}
	

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		
		System.out.println("threeSum_bf");
		BB_006_Three_Sum.threeSum_bf(arr);
		
		
		System.out.println("threeSum_hash");
		BB_006_Three_Sum.threeSum_hash(arr);
		
		
		System.out.println("threeSum");
		BB_006_Three_Sum.threeSum(arr);
	}
}
