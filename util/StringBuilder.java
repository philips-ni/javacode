package util;

import java.util.Arrays;

public class StringBuilder {

	private char[] value;
	private int count;
	private static final int CAPACITY = 1000;

	public StringBuilder() {
		value = new char[CAPACITY];
	}

	public int length() {
		return count;
	}

	public int capacity() {
		return value.length;
	}

	public StringBuilder append(String str) {
		if (str == null)
			str = "null";
		int len = str.length();
		if (len == 0)
			return this;
		int newCount = count + len;
		if (newCount > value.length)
			expandCapacity(newCount);
		str.getChars(0, len, value, count);
		count = newCount;
		return this;
	}

	public void expandCapacity(int minimumCapacity) {
		int newCapacity = (value.length + 1) * 2;
		if (newCapacity < 0) {
			newCapacity = Integer.MAX_VALUE;
		} else if (minimumCapacity > newCapacity) {
			newCapacity = minimumCapacity;
		}
		value = Arrays.copyOf(value, newCapacity);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
