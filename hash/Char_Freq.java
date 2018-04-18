package hash;

import java.util.HashMap;
import java.util.Map;

public class Char_Freq {	

	/**
	 * A simple array could be used as a counter. 
	 * An array could be used to keep track of the frequency of each character. 
	 * For example, if the input consists of ASCII characters, we could just use an integer array of size 256 to keep track of the frequency.
	 * For example, the following program calculates each character's frequency using a simple array of size 256.
	 */
	public static void charFreq(char[] str){
		int[] freq = new int[256];
		for (int i = 0;i<str.length;i++){
			freq[str[i]] ++;
		}
		
		for (int i = 0;i<256;i++){
			if(freq[i]>0)
				System.out.println("[" + (char)i + "] = " + freq[i] );
		}
	}
	
	/**
	 * Why do we choose size 256? Why not 128 or 26? 
	 * The reason is because there are a total of 256 possible ASCII characters, from 0 to 255. 
	 * If you are sure that the input characters are all lowercase letters (a - z), 
	 * then you can save some space by using an array of size 26.
	 */
	public static void lowerCharFreq(char[] str){
		int[] freq = new int[26];
		for (int i = 0;i<str.length;i++){
			// 'a' has an ascii value of 97, so there is an offset in accessing the index.
			freq[str[i]-'a'] ++;
		}
		
		for (int i = 0;i<26;i++){
			if(freq[i]>0)
				System.out.println("[" + (char)(i+'a') + "] = " + freq[i] );
		}
	}
	
	/**
	 * Now, what if the input contains unicode characters? 
	 * In Java, each character is represented internally as 2 bytes, or 16 bits. 
	 * That means you can increase the array size to 2^{16} = 65536, 
	 * which would work but seems like a waste of space. 
	 * For example, what if your input has only 10 characters? 
	 * Most of the array elements will be initialized to 0 and to print the frequencies we need to traverse all 65536 elements one by one, which is inefficient.
	 * A better method is to use a hash table, in Java it's called HashMap, in C++ it's called unordered_map, and in Python it's called dict.
	 */
	public static void printFreq(char[] str) {
	    Map<Character, Integer> freq = new HashMap<>();
	    for (int i = 0; i < str.length; i++) {
	        if (freq.containsKey(str[i])) {
	            freq.put(str[i], freq.get(str[i]) + 1);
	        } else {
	            freq.put(str[i], 1);
	        }
	    }
	    for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
	        System.out.println("[" + (char)(entry.getKey()) + "] = " + entry.getValue());
	    }
	}
	
	public static void main(String args[]) {
		
		char[] str = "Hello World".toCharArray();
		charFreq(str);	
	    
	    str = "helloworld".toCharArray();
	    lowerCharFreq(str);
	    
	    str = "◣⚽◢⚡◣⚾⚡◢".toCharArray();
	    printFreq(str);
	    
	    str = "Hello world.hahaha.".toCharArray();
	    printFreq(str);

	}
}
