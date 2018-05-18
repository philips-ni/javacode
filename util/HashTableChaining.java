package util;

public class HashTableChaining<K, V> {

	private class LinkedListNode<K, V> {
		private K key;
		private V value;
		private LinkedListNode<K, V> next;

		LinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private final static int TABLE_SIZE = 3;

	private LinkedListNode<K, V>[] ht;

	// constructor
	public HashTableChaining() {
		ht = new LinkedListNode[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			ht[i] = null;
		}
	}

	// hash function
	private int getHash(K key) {
		return Math.abs(key.hashCode() % TABLE_SIZE);
	}

	// add or update (key,value)
	public void put(K key, V value) {
		int hash = getHash(key);
	
		LinkedListNode<K, V> current = ht[hash];

		if (current == null) {
			System.out.println("create first node at index "+hash);
			ht[hash] = new LinkedListNode<K, V>(key, value);
		} else {
			while (current.key != key && current.next != null) {
				current = current.next;
			}

			if (current.key == key) {
				System.out.println("update with <" + key + " , " + value + ">");
				current.value = value;
			} else {
				System.out.println("insert <" + key + " , " + value + ">");
				current.next = new LinkedListNode<K, V>(key, value);
			}
		}
	}

	// get value
	public V get(K key) {
		int hash = getHash(key);

		LinkedListNode<K, V> current = ht[hash];

		if (current == null) {
			return null;
		} else {
			// found hash list and need further check if key exists

			while (current.key != key && current.next != null) {
				current = current.next;
			}

			if (current.key == key) {
				return current.value;
			} else {
				return null;
			}
		}
	}

	// remove entry
	public void remove(K key) {
		int hash = getHash(key);

		LinkedListNode<K, V> current = ht[hash];

		if (current != null) {
			LinkedListNode<K, V> prev = null; // save previous entry

			while (current.key != key && current.next != null) {
				prev = current;
				current = current.next;
			}

			if (current.key == key) {
				// found the key
				if (prev != null) {
					prev.next = current.next;
					System.out.println("Node with key "+key+" is removed");
				} else {
					current = null; // first node case
				}
			}

		}
	}

	public static void main(String args[]) {
		HashTableChaining ht = new HashTableChaining();

		ht.put(10, 101);
		ht.put(20, 201);
		ht.put(10, 102);
		ht.put(20, 202);
		ht.put(11, 203);
		ht.put(22, 204);
		ht.remove(10);
	}
}
