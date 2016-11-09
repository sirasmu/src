package package1;

import java.io.IOException;

public class test_method {
	
	public static void main(String args[]){
		
		try {
			Adapted_txt address_list = (Adapted_txt)Adapted_txt.readFromFile("server_address.txt");//("server_address.txt");
			System.out.println(address_list.getAddressByName("01"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
