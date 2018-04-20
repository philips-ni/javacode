package leetcode;

/**
 * 
 * LC.Array.013 Roman to Integer
 * 
 * Question : Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */
public class LC_013_Roman_To_Integer {

	public static int romanToInt(String s) {
		int nums[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				nums[i] = 1000;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'I':
				nums[i] = 1;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				sum -= nums[i];
			else
				sum += nums[i];
		}
		return sum + nums[nums.length - 1];
	}
	public static void main(String[] args) {

		String s = "MMC";
		System.out.println("Input  : " + s);
		System.out.println("Output : " + romanToInt(s));

	}

}
