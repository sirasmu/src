package ClientConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import WIP.data.Reserved;
import WIP.data.ReservedList;

public class ClientView {

	private ClientController controller;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public void addController(ClientController controller) {
		this.controller = controller;
	}

	public void displayMenu() {
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
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	public void displayBookings() {
		ReservedList result = null;
		result = controller.getAll();
		System.out.println("Result is :" + result);
	}

	public void displayBookingsInInterval() {
		try {
			System.out.println("Please insert a start date:");
			String startDate = reader.readLine();
			System.out.println("Please insert a end date:");
			String endDate = reader.readLine();
			ReservedList result = null;
			result = controller.getAllInInterval(startDate, endDate);
			System.out.println("Result is :" + result);
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
			displayBookingsInInterval();
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			displayBookingsInInterval();
		}
		displayMenu();
	}

	public void displaySpecificBooking() {
		System.out.println("Insert a booking number:");
		try {
			String in = reader.readLine();
			Integer resNo = Integer.valueOf(in);
			Reserved reservation = controller.getReservation(resNo);
			System.out.println("Reservation is :" + reservation);
			editBooking(reservation);

		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
			displaySpecificBooking();
		} catch (NumberFormatException e) {
			System.out.println("Please insert a number.");
			displaySpecificBooking();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		displayMenu();
	}

	public void editBooking(Reserved reservation) {
		System.out.println("1 to remove");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				controller.removeReservation(reservation.getResNo());
				break;
			default:
				System.out.println("Please insert valid number");
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	public void update() {
		displayBookings();
	}

}
