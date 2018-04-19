package string;

import java.lang.StringBuilder;

/**
 * 
 * BB.String.005 String Compression
 * 
 * Question : Given a string, write a function to compress it by shortening
 * every sequence of the same character to that character followed by the number
 * of repetitions. If the compressed string is longer than the original, you
 * should return the original string.
 * 
 * e.g.
 * 
 * compress(“a”) = "a"
 * 
 * compress(“aaa”) = "a3"
 * 
 * compress(“aaabbb”) = "a3b3"
 * 
 * compress(“aaabccc”) = "a3b1c3"
 *
 */
public class BB_005_String_Compression {

	public static String compress(String s) {

		StringBuilder sb = new StringBuilder();

		if (s.length() == 0)
			return s;

		char prev = s.charAt(0);
		int count = 1;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prev)
				count++;
			else {
				sb.append(prev);
				if (count > 1)
					sb.append(count);
				prev = s.charAt(i);
				count = 1;
			}
		}

		sb.append(prev);
		if (count > 1)
			sb.append(count);

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(compress("eaaabbbbcccccd"));

	}

}
