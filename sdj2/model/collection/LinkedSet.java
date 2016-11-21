package sdj2.model.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet<T> implements SetADT<T>, Serializable {

	private static final long serialVersionUID = -8002905340527721416L;
	private int size = 0;
	private LinearNode<T> front;

	public void add(T element) {
		if (!contains(element)) {
			front = new LinearNode<T>(element, front);
			size++;
		}
	}

	public void remove(T element) {
		LinearNode<T> node = front;
		if (element == null) {
			while (node != null && node.getElement() != element) {
				node = node.getNext();
			}
		} else {
			while (node != null && !element.equals(node.getElement())) {
				node = node.getNext();
			}
		}
		if (node == null) {
			throw new IllegalStateException("Element not in the list");
		}
		node.setElement(front.getElement());
		front = front.getNext();
		size--;
	}

	public boolean contains(T element) {
		LinearNode<T> node = front;
		if (element == null) {
			while (node != null && node.getElement() != element) {
				node = node.getNext();
			}
		} else {
			while (node != null && !element.equals(node.getElement())) {
				node = node.getNext();
			}
		}
		if (node == null) {
			return false;
		}
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean isSubset(SetADT<T> set) {
		LinearNode<T> node = front;
		while (node != null) {
			if (!set.contains(node.getElement())) {
				return false;
			}
			node = node.getNext();
		}
		return true;
	}

	public SetADT<T> intersection(SetADT<T> set) {
		SetADT<T> result = new LinkedSet<>();
		LinearNode<T> node = front;
		while (node != null) {
			if (set.contains(node.getElement())) {
				result.add(node.getElement());
			}
			node = node.getNext();
		}
		return result;
	}

	public SetADT<T> union(SetADT<T> set) {
		LinkedSet<T> result = new LinkedSet<>();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			result.add(it.next());
		}
		Iterator<T> it2 = set.iterator();
		while (it2.hasNext()) {
			result.add(it2.next());
		}
		return result;
	}

	public Iterator<T> iterator() {
		return new LinkedSetIterator();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		LinearNode<T> node = front;
		String s = ", ";
		while (node != null) {
			if (node.getNext() == null) {
				s = "";
			}
			sb.append(node.getElement() + s);
			node = node.getNext();
		}
		return sb.toString();
	}

	private class LinkedSetIterator implements Iterator<T> {

		private LinearNode<T> currentNode;

		public LinkedSetIterator() {
			currentNode = new LinearNode<T>(null, front);
		}

		@Override
		public boolean hasNext() {
			return currentNode.getNext() != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentNode = currentNode.getNext();
			return currentNode.getElement();
		}

	}
}
