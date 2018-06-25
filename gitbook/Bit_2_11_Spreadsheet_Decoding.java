package gitbook;

/**
 * Bit.2.11 Spreadsheet Decoding
 * 
 * Problem : Given a spreadsheet column string like AA, AZ etc, decode it into
 * its numeric value.
 *
 */
public class Bit_2_11_Spreadsheet_Decoding {

	public static int decoding(String column) {

		if (column.length() == 0)
			return -1;

		int value = 0;
		for (int i = 0; i < column.length(); i++) {
			char c = column.charAt(i);
			value = value * 26 + c - 'A' + 1;
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(decoding("AA"));
		System.out.println(decoding("Z"));
	}
}
