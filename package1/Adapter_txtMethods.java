package package1;

import java.io.IOException;

public class Adapter_txtMethods {

	public Adapter_txt loadList(Adapter_txt ip_list, String address){
		try {
			ip_list = (Adapter_txt) Adapter_txt.readFromFile(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip_list;
		
	}
}
