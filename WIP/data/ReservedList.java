package WIP.data;

public class ReservedList {

	private ListADT<Reserved> reserved;

	public ReservedList() {
		reserved = new ArrayList<>();
	}

	public ListADT<Reserved> getAll() {
		return reserved;
	}

	public int size() {
		return reserved.size();
	}

	public String toString() {
		return "";
	}

}
