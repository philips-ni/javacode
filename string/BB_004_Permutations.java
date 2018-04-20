package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import foundation.LinkedListNode;

/**
 * 
 * BB.String.004 Permutations
 * 
 * Description: Write a function that returns all permutations of a given list.
 * 
 * e.g.
 * 
 * Input: {1, 2, 3}
 * 
 * Output: [1, 2, 3],[1, 3, 2],[2, 1, 3],[2, 3, 1],[3, 1, 2],[3, 2, 1]
 * 
 * Input: "abc"
 * 
 * Output: "abc",
 * 
 */
public class BB_004_Permutations {

	public static ArrayList<String> permutations(String s) {
		ArrayList<String> results = new ArrayList<String>();
		permutations("", s, results);
		return results;
	}

	private static void permutations(String prefix, String suffix, ArrayList<String> results) {
		if (suffix.isEmpty()) {
			results.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permutations(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
			}
		}
	}

	public static List<int[]> listPermutations(int[] a) {
		ArrayList<int[]> results = new ArrayList<int[]>();
		listPermutations(a, 0, results);
		return results;
	}

	private static void listPermutations(int[] a, int start, List<int[]> result) {
		if (start >= a.length) {
			System.out.println(Arrays.toString(a.clone()));
			result.add(a.clone());
		} else {
			for (int i = start; i < a.length; i++) {
				swap(a, start, i);
				listPermutations(a, start + 1, result);
				swap(a, start, i);
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static ArrayList<ArrayList<Integer>> listPermutation_DFS(int[] nums) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		permute(nums, temp, results);
		return results;
	}

	private static void permute(int[] nums, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> results) {
		if (temp.size() == nums.length) {
			System.out.println(temp);
			results.add(temp);
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i]))
				continue;

			temp.add(nums[i]);
			permute(nums, temp, results);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode();
		node.value = 1;
		node.next = new LinkedListNode();
		node.next.value = 2;
		node.next.next = new LinkedListNode();
		node.next.next.value = 3;

		permutations("abc");

		int[] list = { 1, 2, 3 };
		listPermutations(list);

		listPermutation_DFS(list);
	}

}
