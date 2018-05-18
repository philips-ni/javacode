package crackcode;

import java.util.ArrayList;

import util.HashTableChaining;

/**
 * CC.OOP.7.12 HashTable
 * 
 * Question : Design and implement a hash table which uses chaining (linked
 * list) to handle collisions.
 *
 */
public class CC_OOP_7_12_HashTable {
	public class HashTable<K, V> {
		private class LinkedListNode<K, V> {
			private K key;
			private V value;
			private LinkedListNode<K, V> next;

			public LinkedListNode(K key, V value) {
				this.key = key;
				this.value = value;
			}
		}

		private ArrayList<LinkedListNode<K, V>> arr;

		public HashTable(int size) {
			arr = new ArrayList<LinkedListNode<K, V>>();
			for (int i = 0; i < size; i++) {
				arr.add(null);
			}
		}

		public int getHash(K key) {
			return Math.abs(key.hashCode() % arr.size());
		}

		public void put(K key, V value) {
			int hash = getHash(key);

			LinkedListNode<K, V> current = arr.get(hash);

			if (current == null) {
				System.out.println("create first node at index " + hash);
				arr.set(hash, new LinkedListNode<K, V>(key, value));
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

		public V get(K key) {
			int hash = getHash(key);

			LinkedListNode<K, V> current = arr.get(hash);

			if (current == null) {
				return null;
			} else {
				while (current.key != key && current.next != null) {
					current = current.next;
				}

				if (current.key == key)
					return current.value;
				else
					return null;
			}
		}
	}

	public static void main(String[] args) {
		CC_OOP_7_12_HashTable test = new CC_OOP_7_12_HashTable();
		HashTable<Integer, Integer> cht = test.new HashTable<Integer, Integer>(5);

		cht.put(10, 101);
		cht.put(20, 201);
		cht.put(10, 102);
		cht.put(20, 202);
		cht.put(11, 203);
		cht.put(22, 204);
	}

}
