package sdj2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Adapter_txt extends ArrayList<String[]> {

	private static final long serialVersionUID = 1507835882916430649L;
	private static Adapter_txt address_list = null;

	private Adapter_txt() {
	}

	public static Adapter_txt getInstance() {
		if (address_list == null) {
			address_list = new Adapter_txt();
		}
		return address_list;
	}

	public void readFromFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));

		String line = br.readLine();
		String[] tempArray;

		while (line != null) {
			tempArray = line.split(",");
			address_list.add(tempArray);
			line = br.readLine();
		}
		br.close();
	}
}
