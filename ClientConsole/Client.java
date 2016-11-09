package ClientConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import WIP.data.Reserved;
import WIP.data.ReservedList;
import WIP.data.utility.TheTime;

public class Client {

	private String remoteHostName;
	private int remotePort;
	private InterfaceModel show;
	private ClientController showAll;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));

	public Client(String remoteHostName, int remotePort) {
		super();
		this.remoteHostName = remoteHostName;
		this.remotePort = remotePort;
		connectToServer();
		displayMenu();
	}

	private void connectToServer() {
		String connectLocation = "//" + remoteHostName + ":" + remotePort
				+ "/Connect";
		try {
			System.out.println("Connecting to client at : " + connectLocation);
			show = (InterfaceModel) Naming.lookup(connectLocation);
			showAll = new ClientController(show);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
	}

	private void displayMenu() {
		System.out.println("1 to see bookings in a date interval");
		System.out.println("2 to see a specific booking");
		System.out.println("9 to exit");
		System.out.println("8 to see all bookings");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				displayBookingsInInterval();
				break;
			case "2":
				displaySpecificBooking();
				break;
			case "9":
				System.exit(0);
				break;
			case "8":
				displayBookings();
				break;
			default:
				System.out.println("Please insert valid number");
				break;
			}
		} catch (IOException e) {
			System.out
					.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	private void displayBookings() {
		ReservedList result = null;
		result = showAll.getAll();
		System.out.println("Result is :" + result);
	}

	private void displayBookingsInInterval() {
		try {
			System.out.println("Please insert a start date:");
			String startDate = reader.readLine();
			System.out.println("Please insert a end date:");
			String endDate = reader.readLine();
			ReservedList result = null;
			result = showAll.getAllInInterval(startDate, endDate);
			System.out.println("Result is :" + result);
		} catch (IOException e) {
			System.out
					.println("Unexpected problem with reading your input, please try again.");
			displayBookingsInInterval();
		}
		displayMenu();
	}

	private void displaySpecificBooking() {
		System.out.println("Insert a booking number:");
		try {
			String in = reader.readLine();
			Integer resNo = Integer.valueOf(in);
			Reserved reservation = showAll.getReservation(resNo);
			System.out.println("Reservation is :" + reservation);
			editBooking(reservation);

		} catch (IOException e) {
			System.out
					.println("Unexpected problem with reading your input, please try again.");
			displaySpecificBooking();
		} catch (NumberFormatException e) {
			System.out.println("Please insert a number.");
			displaySpecificBooking();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		displayMenu();
	}

	private void editBooking(Reserved reservation) {
		System.out.println("1 to remove");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				showAll.removeReservation(reservation.getResNo());
				break;
			default:
				System.out.println("Please insert valid number");
				break;
			}
		} catch (IOException e) {
			System.out
					.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	public void update() {
		displayBookings();
	}

}
