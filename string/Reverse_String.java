package string;

public class Reverse_String {

	public static void swap(char[] str, int i, int j){
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
	// reverse the characters in a string
	public static void reverse(char[] str){
		int i = 0, j = str.length - 1;
		while( i < j ){
			swap(str,i,j);
			i++;
			j--;
		}
		//System.out.println(str);
	}
	
	public static void main(String[] args) {
		char[] str = { 'a', 'b', 'c', 'd' };
		reverse(str);
		System.out.println(str);

	}

}
