package string;

import java.util.HashMap;


/**
 * Longest consecutive repeating character in string
 * 
 * e.g.
 * 
 * Input : str = "geeekk" 
 * 
 * Output : {'e',3}
 * 
 */
public class Longest_Consecutive_Repeating_Character {

	public static HashMap<Character,Integer> longest(String str) {
		char longest_char = 0; // init to null
		int longest_char_count = 0;
		
		char prev_char = 0; // init to null
		char current_char = 0; // init to null
		
		int current_char_count = 0;
		
		for (int i = 0; i< str.length(); i++){
			current_char = str.charAt(i);
			
			if(current_char == prev_char) current_char_count++;
			else current_char_count = 1; // reset to 1 if found new character
			
			if(current_char_count > longest_char_count){
				longest_char = current_char;
				longest_char_count = current_char_count;			
			}
			
			prev_char = current_char;
		}
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		hm.put(longest_char, longest_char_count);
		return hm;
	}

	public static void main(String args[]) {
		
		String str = "abbaaaccde";
		System.out.println("Output  : " + longest(str));

	}
}
