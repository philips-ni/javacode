package dynamicprogramming;

/**
 * BB.DP.008 Target sum
 * 
 * Question : Given an array of integers, nums and a target value T, find the
 * number of ways that you can add and subtract the values in nums to add up to
 * T.
 * 
 * eg.
 * 
 * input : nums = {1, 1, 1, 1, 1}, T = 3.
 * 
 * output : targetSum(nums, T) = 5
 * 
 */
public class BB_008_Target_Sum {

	public static int targetSum(int[] nums, int T) {
		// brute force
		return targetSum(nums, T, 0, 0);
	}

	private static int targetSum(int[] nums, int T, int i, int sum) {
		// check if reaching the target once all numbers are gone through
		if (i == nums.length) {
			return sum == T ? 1 : 0;
		}

		// check all possibilities by adding and subtracting current number
		return targetSum(nums, T, i + 1, sum + nums[i]) + targetSum(nums, T, i + 1, sum - nums[i]);
	}
	
	public static void main(String[] args) {
		int[] nums={1,1,1,1,1};
		int T=3;
		System.out.println(targetSum(nums,T));
	}

}
