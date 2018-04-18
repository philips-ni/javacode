package math;

import java.util.ArrayList;
import java.util.List;

/**
 * LC.Math.046 Permutations
 * 
 * Question : Given a collection of distinct numbers, return all possible
 * permutations.
 * 
 * e.g.
 * 
 * [1,2,3] have the following permutations:
 * 
 * [ [1,2,3],[1,3,2],[2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 */
public class LC_046_Permutations {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();

		List<Integer> first = new ArrayList<Integer>();
		first.add(nums[0]);
		answer.add(first);

		// start iterative for each number
		for (int i = 1; i < nums.length; i++) {
			List<List<Integer>> new_answer = new ArrayList<List<Integer>>();

			for (int j = 0; j <= i; j++) {
				for (List<Integer> l : answer) {
					List<Integer> tmpList = new ArrayList<Integer>(l);
					tmpList.add(j, nums[i]);
					new_answer.add(tmpList);
				}
			}

			// save the new answer list
			answer = new_answer;
		}

		return answer;
	}

	public static void main(String args[]) {

		int[] permute_nums = { 1, 2, 3 };
		System.out.println("Output : " + permute(permute_nums));

	}

}
