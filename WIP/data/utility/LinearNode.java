package WIP.data.utility;

import java.io.Serializable;

public class LinearNode<T> implements Serializable {

	private T element;
	private LinearNode<T> next;

	public LinearNode() {
	}

	public LinearNode(T element) {
		this();
		this.element = element;
	}

	public LinearNode(T element, LinearNode<T> next) {
		this(element);
		this.next = next;
	}

	public LinearNode<T> getNext() {
		return next;
	}

	public void setNext(LinearNode<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
