package package1;

import java.io.IOException;

public class test_method {
	
	public static void main(String args[]){
		
		try {
			Adapted_txt ad = Adapted_txt.readFromFile("server_address.txt");//("server_address.txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
