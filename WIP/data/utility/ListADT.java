package WIP.data.utility;

import java.io.Serializable;

public interface ListADT<T> extends Serializable, Iterable<T> {

	/**
	 * adds the element a the given index
	 * 
	 * @param index
	 *            where to add the element
	 * @param element
	 *            to add to the list
	 */
	public void add(int index, T element);

	/**
	 * adds the element at the end of the list
	 * 
	 * @param element
	 *            to add to the list
	 */
	public void add(T element);

	/**
	 * replace the element at the given index
	 * 
	 * @param index
	 *            where to put the element
	 * @param element
	 *            to add to the list
	 */
	public void set(int index, T element);

	/**
	 * get the element at the given index
	 * 
	 * @param index
	 *            of the element
	 * @return the element at the given index
	 */
	public T get(int index);

	/**
	 * remove the element at the given index
	 * 
	 * @param index
	 *            of the element
	 * @return the element at the given index
	 */
	public T remove(int index);

	/**
	 * remove the given element
	 * 
	 * @param element
	 *            to be removed
	 * @return element that was removed
	 */
	public T remove(T element);

	/**
	 * get the index of the given element
	 * 
	 * @param element
	 *            to search for in the list
	 * @return the index of the element
	 */
	public int indexOf(T element);

	/**
	 * does the list contain the element or not
	 * 
	 * @param element
	 *            to search for in the list
	 * @return if the list contains the element
	 */
	public boolean contains(T element);

	/**
	 * is the list empty or not
	 * 
	 * @return if the list is empty
	 */
	public boolean isEmpty();

	/**
	 * get the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size();

}