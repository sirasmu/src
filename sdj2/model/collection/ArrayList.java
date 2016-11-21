package sdj2.model.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListADT<T>, Serializable {

	private static final long serialVersionUID = -1957456393459597554L;
	private final static int DEFAULT_CAPACITY = 100;
	private int size = 0;
	private T[] list;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public void add(int index, T element) {
		if (element == null) {
			throw new IllegalArgumentException("Null value not allowed");
		}
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		isFull();
		if (index != size) {
			for (int i = size - 1; i >= index; i--) {
				int j = i + 1;
				list[j] = list[i];
			}
		}
		list[index] = element;
		size++;

	}

	public void add(T element) {
		add(size, element);
	}

	private void isFull() {
		if (size == list.length - 1) {
			expandCapacity();
		}
	}

	public void set(int index, T element) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new IllegalArgumentException("Null value not allowed");
		}
		list[index] = element;
	}

	public T get(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		return list[index];
	}

	public T remove(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		T e = list[index];
		for (int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		size--;
		return e;
	}

	public T remove(T element) {
		if (element != null) {
			for (int i = 0; i < size; i++) {
				if (element.equals(list[i])) {
					return remove(i);
				}
			}
		}
		throw new IllegalStateException("Element is not in the list!");
	}

	public int indexOf(T element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (element == list[i]) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(list[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean contains(T element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (element == list[i]) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(list[i])) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void expandCapacity() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) (new Object[list.length * 2]);
		for (int i = 0; i <= size; i++) {
			temp[i] = list[i];
		}
		list = temp;
	}

	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<T> {

		private int index;
		private boolean canRemove = false;

		public ArrayListIterator() {
			index = -1;
		}

		public boolean hasNext() {
			return index + 1 < size;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			canRemove = true;
			index++;
			return list[index];
		}

		public void remove() {
			if (!canRemove) {
				throw new IllegalStateException();
			}
			index--;
			for (int i = index; i < size; i++) {
				list[i] = list[i + 1];
			}
			size--;
			canRemove = false;
		}
	}
}
