package crackcode;

import java.util.ArrayList;

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

		public int getIndex(K key) {
			return Math.abs(key.hashCode() % arr.size());
		}

		public void put(K key, V value) {
			int id = getIndex(key);

			LinkedListNode<K, V> current = arr.get(id);

			if (current == null) {
				current = new LinkedListNode<K, V>(key, value);
			} else {
				while (current.key != key && current.next != null) {
					current = current.next;
				}

				if (current.key == key) {
					current.value = value; // update value
				} else {
					current.next = new LinkedListNode<K, V>(key, value); // add new node
				}
			}
		}

		public V get(K key) {
			int id = getIndex(key);

			LinkedListNode<K, V> current = arr.get(id);

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
		// TODO Auto-generated method stub

	}

}
