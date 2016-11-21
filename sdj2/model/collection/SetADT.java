package sdj2.model.collection;

import java.io.Serializable;

public interface SetADT<T> extends Iterable<T>, Serializable {

	public void add(T element);

	public void remove(T element);

	public boolean contains(T element);

	public boolean isEmpty();

	public int size();

	public boolean isSubset(SetADT<T> set);

	public SetADT<T> intersection(SetADT<T> set);

	public SetADT<T> union(SetADT<T> set);

}