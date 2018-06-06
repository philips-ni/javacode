package epi;

public class EPI_String_6_13_First_Occurrence_SubString {

	public static int indexOf(String s, String t) {
		int sourceCount = s.length();
		int targetCount = t.length();

		char first = t.charAt(0);

		for (int i = 0; i < sourceCount; i++) {

			// look for first char in target string
			if (s.charAt(i) != first)
				continue;

			// reset start pointer for source and target string
			int j = i, k = 0;

			// compare with target string in the sliding window
			while (j < i + targetCount) {
				if (s.charAt(j) != t.charAt(k)) {
					break;
				}
				j++;
				k++;
			}

			// found target string
			if (j == i + targetCount)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		String source = "abcabcdefabd";
		String target = "abd";
		System.out.println(indexOf(source, target));
	}
}
