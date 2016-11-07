package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Adapted_txt {

	private static ArrayList<String[]> address_list;

	public Adapted_txt(String path) throws IOException {
		readFromFile(path);
	}

	public ArrayList<String[]> readFromFile(String path) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(path));

		String line = br.readLine();
		String[] tempArray;
		address_list = new ArrayList<String[]>();

		while (line != null) {

			tempArray = line.split(",");
			address_list.add(tempArray);
			line = br.readLine();

		}
		br.close();
		return address_list;
	}

}
