package sdj2.model.date;

/**
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 2.0 date 19-05-2016
 */
public class IllegalDateException extends RuntimeException {

	private static final long serialVersionUID = -1286725288467619713L;

	public IllegalDateException() {
		super("Invalid date");
	}

	public IllegalDateException(String msg) {
		super("Invalid date: " + msg);
	}

}
