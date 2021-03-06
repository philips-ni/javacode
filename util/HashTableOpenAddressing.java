package util;

public class HashTableOpenAddressing {
	
	private class HashEntry {
		private int key;
		private int value;
		
		HashEntry(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	
	private final static int TABLE_SIZE = 128;

	HashEntry[] table;

	HashTableOpenAddressing() {
		table = new HashEntry[TABLE_SIZE];

		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}
		table[hash] = new HashEntry(key, value);
	}

	public int get(int key) {
		int hash = (key % TABLE_SIZE);

		while (table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}

		if (table[hash] == null)
			return -1;
		else
			return table[hash].value;

	}
}
