package ClientConsole;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class UDPClient {
public static void main(String[] args) throws Exception {
	
	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket clientSocket = new DatagramSocket();
	InetAddress IPAddress = InetAddress.getByName("10.52.236.67");
	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[4];
	System.out.println("Give your bankName: ");
	String bankID=inFromUser.readLine();
	sendData = bankID.getBytes();
	DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5311);
	clientSocket.send(sendPacket);
	DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	clientSocket.receive(receivePacket);
	InetAddress bankIP;
	bankIP=InetAddress.getByAddress(receivePacket.getData());
	System.out.println("FROM SERVER:" + bankIP);
	clientSocket.close();
}
}