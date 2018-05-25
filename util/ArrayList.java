package util;

public class ArrayList<E> {
	private Object[] data; // Can't create a generic type of array. Object type works good here!
	private int size = 0;
	private static final int INIT_SIZE = 100;

	public ArrayList() {
		data = new Object[INIT_SIZE];
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < size) {
			return (E) data[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean add(E e) {
		if (size == data.length)
			ensureCapacity(size + 1);

		data[size++] = e;

		return true;
	}

	private void ensureCapacity(int minCapacity) {

		int oldCapacity = data.length;

		if (minCapacity > oldCapacity) {
			Object[] temp = data;
			int newCapacity = oldCapacity * 2 + 1;

			if (newCapacity < minCapacity)
				newCapacity = minCapacity;

			data = new Object[newCapacity];
			for (int i = 0; i < size; i++) {
				data[i] = temp[i];
			}

			// data = Arrays.copyOf(temp, newCapacity);
		}
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException();

		Object removed = data[index];

		for (int i = index; i < size; i++) {
			data[i] = data[i++];
		}

		size--;
		return (E) removed;
	}
}
