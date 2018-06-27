package gitbook;

/**
 * Bit.2.11 Spreadsheet Decoding
 * 
 * Problem : Given a spreadsheet column string like AA, AZ etc, decode it into
 * its numeric value.
 *
 */
public class Bit_2_11_Spreadsheet_Decoding_Encoding {

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
	
	public static String encoding(int num) {

		StringBuilder sb = new StringBuilder();
		while(num>0){
			int digit = num %26;
			sb.append((char)('A'+digit-1));
			num = num/10;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(decoding("AA"));
		System.out.println(decoding("Z"));
		System.out.println(encoding(27));
	}
}
