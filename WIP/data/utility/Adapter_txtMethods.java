package WIP.data.utility;

import java.io.IOException;

public class Adapter_txtMethods {

	private String address;
	private Adapter_txt ip_list;
	
	public Adapter_txtMethods(Adapter_txt ip_list)
	{
		
		this.ip_list = ip_list;
		loadList();
	}
	
	public Adapter_txt loadList(){
		try {
			ip_list = (Adapter_txt) Adapter_txt.readFromFile(address);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip_list;
		
	}
	
	public String[] getAllNames()
	{
		String[] temp = new String[ip_list.size()];
		System.out.println(ip_list.size());
		for(int i=0;i<ip_list.size();i++)
		{
			temp[i] = ip_list.get(i)[0];
		}
		return temp;
	}
	
	public String getIPbyName(String name)
	{
		String temp=null;
		for(int i=0;i<ip_list.size();i++)
		{
			if(name.equals(ip_list.get(i)[0]))
			{
				temp = ip_list.get(i)[1];
				System.out.println(temp);
			}
			
		}
		return temp;
	}
	
}
