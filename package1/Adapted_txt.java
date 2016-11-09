package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Adapted_txt extends ArrayList<String[]>{

	private static Adapted_txt address_list = new Adapted_txt();

	public Adapted_txt(){}

	public static ArrayList<String[]> readFromFile(String path) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(path));
		//ArrayList<String[]> address_list;
		
		String line = br.readLine();
		String[] tempArray;
		//address_list = new ArrayList<String[]>();

		while (line != null) {

			tempArray = line.split(",");
			address_list.add(tempArray);
			line = br.readLine();

		}
		br.close();
		return address_list;
	}
	
/*	public ArrayList<String[]> showIpAddress(){
		return address_list;
		
		
	}*/

}
