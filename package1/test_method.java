package package1;

import java.io.IOException;

public class test_method {
	
	public static void main(String args[]){
		
		try {
			Adapter_txt ad = (Adapter_txt) Adapter_txt.readFromFile("server_address.txt");//("server_address.txt");
			System.out.println(ad.size());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
