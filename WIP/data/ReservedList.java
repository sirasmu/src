package WIP.data;

public class ReservedList {

	private ListADT<Reserved> list;

	public ReservedList() {
		list = new ArrayList<>();
	}

	public ListADT<Reserved> getAll() {
		return list;
	}
	
	public Reserved get(int index) {
		return list.get(index);
	}
	
	public void add(Reserved reserved){
		list.add(reserved);
	}

	public int size() {
		return list.size();
	}

	public String toString() {
		StringBuilder str = new StringBuilder("****CURRENT RESERVATIONS****\n");
		for(int i = 0; i < list.size(); i++){
			str.append(get(i) + "\n");
		}
		str.append("END");
		return str.toString();
	}

}
