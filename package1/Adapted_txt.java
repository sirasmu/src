package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Adapted_txt {
	
	private static String[][] list_address;

	public Adapted_txt(String path) throws IOException {
		readFromFile(path);	
	}
	
	public void readFromFile(String path) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		try{
			String line = br.readLine();
			
			while (line != null){
				
				String[] tempArray = line.split(","); 
				br.readLine();
			}
		}finally{
			br.close();
		}
		
	}
	
	public String[][] request_address_list() 
	{
			return list_address;
	}
}
