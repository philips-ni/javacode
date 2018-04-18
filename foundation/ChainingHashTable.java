package foundation;

public class ChainingHashTable{
	
	private final static int TABLE_SIZE = 3;
	
	private Node[] ht;
	
	private class Node {
		private int key;
		private int value;
		private Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public int getValue(int key) {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return this.next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getKey() {
			return this.key;
		}
	}
	
	// constructor
	ChainingHashTable(){
		ht = new Node[TABLE_SIZE];
		for (int i = 0 ; i < TABLE_SIZE; i ++){
			ht[i] = null;
		}	
	}
	
	// hash function
	private int getHash(int key){
		return key % TABLE_SIZE;
	}
	
	// add or update (key,value)
	public void put(int key, int value){	
		System.out.println("key,value : " + key + "," + value );
		int hash = this.getHash(key);
		
		if(ht[hash] == null){
			System.out.println("Empty list at index " + hash + " and create new one");
			ht[hash] = new Node(key,value);			
		}else{
			Node it = ht[hash];
			
			while(it.getNext() != null && it.getKey() != key){
				it = it.getNext();
			}
			
			if(it.getKey() == key){
				//update
				System.out.println("update with " + value);
				it.setValue(value);			
			}else{
				//insert 
				System.out.println("insert with " + value);
				it.setNext(new Node(key,value));			
			}		
		}		
	}
	
	// get value
	public int get(int key){
		int hash = this.getHash(key);
		
		if(ht[hash] == null) {
			return -1;
		}else{
			// found hash list and need further check if key exists
			Node it = ht[hash];
			while(it != null && it.getKey() != key){
				it = it.getNext();
			}
			
			if(it == null){
				return -1;
			}else{
				return it.getValue(key);
			}
		}
	}
	
	//remove entry
	public void remove(int key){
		int hash = this.getHash(key);
		
		if(ht[hash] != null){
			// found list and further look for the key in the list
			Node it = ht[hash];
			Node prev = null; // use to save previous entry
			while(it.getNext()!=null && it.getKey() != key){
				prev = it;
				it = it.getNext();
			}
			
			if(it.getKey() == key){
				// found the key
				if(prev == null){
					ht[hash] = it.getNext();
				}else{
					prev.setNext(it.getNext());
				}			
			}
			
		}
	}
	
	public static void main(String args[]) {
		ChainingHashTable cht = new ChainingHashTable();
		
		cht.put(10, 101);
		cht.put(20, 201);
		cht.put(10, 102);
		cht.put(20, 202);
		cht.put(11, 203);
		cht.put(22, 204);
	}
}
