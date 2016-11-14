package ClientConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import WIP.data.Reserved;
import WIP.data.ReservedList;
import WIP.data.utility.IllegalDateException;

public class ClientView {

	private ClientController controller;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public void addController(ClientController controller) {
		this.controller = controller;
	}

	/**
	 * Displays the menu for action selection
	 */
	public void displayMenu() {
		System.out.println("1 to see bookings in a date interval");
		System.out.println("2 to see a specific booking");
		System.out.println("3 to see all bookings");
		System.out.println("9 to exit");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				displayBookingsInInterval();
				break;
			case "2":
				displaySpecificBooking();
				break;
			case "3":
				displayBookings();
				break;
			case "9":
				System.exit(0);
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

	private void displayBookings() {
		ReservedList result = controller.getAll();
		System.out.println("Result is :" + result);
	}

	private void displayBookingsInInterval() {
		try {
			System.out.println("Please insert a start date:");
			String startDate = reader.readLine();
			System.out.println("Please insert a end date:");
			String endDate = reader.readLine();
			ReservedList result = controller.getAllInInterval(startDate, endDate);
			System.out.println("Result is :" + result);
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
			displayBookingsInInterval();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			displayBookingsInInterval();
		} catch (IllegalDateException e) {
			System.out.println(e.getMessage());
			displayBookingsInInterval();
		}
		displayMenu();
	}

	private void displaySpecificBooking() {
		System.out.println("Insert a booking number:");
		try {
			String in = reader.readLine();
			Integer resNo = Integer.valueOf(in);
			Reserved reservation = controller.getReservation(resNo);
			System.out.println("Reservation is :");
			System.out.println("Reservation number: " + reservation.getResNo());
			System.out.println("Pick up time: " + reservation.getPickUpTime());
			System.out.println("Return time: " + reservation.getReturnTime());
			System.out.println("Pick up place: " + reservation.getPickUpPlace());
			System.out.println("Return place: " + reservation.getReturnPlace());
			System.out.println("First name: " + reservation.getFirstName());
			System.out.println("Last name: " + reservation.getLastName());
			System.out.println("Estimated km: " + reservation.getEstimateKm());
			System.out.println("Estimated price: " + reservation.getEstimatePrice());
			System.out.println("Vehicle: " + reservation.getVehicle());
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

	private void editBooking(Reserved reservation) {
		System.out.println("1 to display menu");
		System.out.println("2 to delete the booking");
		System.out.println("3 to modify the booking");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				displayMenu();
				break;
			case "2":
				controller.deleteReservation(reservation.getResNo());
				break;
			case "3":
				displayModificationMenu(reservation);
				break;
			default:
				System.out.println("Please insert valid number");
				editBooking(reservation);
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	private void displayModificationMenu(Reserved reservation) {
		System.out.println("1 to save modifications");
		System.out.println("2 to change the pickUpTime");
		System.out.println("3 to change the returnTime");
		System.out.println("4 to change the firstName");
		System.out.println("5 to change the lastName");
		System.out.println("6 to abort modifications");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				// controller.saveReservation(reservation);
				break;
			case "2":
				// set pickUpTime
				break;
			case "3":
				// set returnTime
				break;
			case "4":
				// set firstName
				break;
			case "5":
				// set lastName
				break;
			case "6":
				displayMenu();
				break;
			default:
				System.out.println("Please insert valid number");
				displayModificationMenu(reservation);
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	/**
	 * Informs the user that the data has been changed
	 * 
	 * @param updateMsg
	 *            message from the server with the changes
	 */
	public void update(Object updateMsg) {
		System.out.println("-----------------------Updated from server.---------------------");
		System.out.println(updateMsg);
	}

}
