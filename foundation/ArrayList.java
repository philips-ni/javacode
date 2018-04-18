package foundation;

public class ArrayList {
	private Object[] data;
	private int size = 0;
	private static final int INIT_SIZE = 100;

	public ArrayList() {
		data = new Object[INIT_SIZE];
	}
	
	public int size(){
		return size;
	}

	public Object get(int index) throws Exception {
		if (index < size) {
			return data[index];
		} else {
			throw new Exception();
		}
	}

	public void add(Object obj) {
		if (size == data.length)
			ensureCapacity(2 * size);

		data[size] = obj;
		size++;
	}

	private void ensureCapacity(int newSize) {
		if (newSize <= size)
			return;

		Object[] tmp = data;

		data = new Object[newSize];

		for (int i = 0; i < size; i++) {
			data[i] = tmp[i];
		}
	}

	public Object remove(int index) throws Exception {
		if (index >= size)
			throw new Exception();

		Object removed = data[index];

		for (int i = index; i < size; i++) {
			data[i] = data[i++];
		}

		size--;

		return removed;

	}
}
