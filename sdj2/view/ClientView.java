package sdj2.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sdj2.controller.ClientController;
import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.VehicleList;
import sdj2.model.date.IllegalDateException;
import sdj2.model.date.TheTime;

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
		System.out.println("\n1 to see vehicles in a date interval");
		System.out.println("2 to see a specific reservation");
		System.out.println("3 to see all reservations");
		System.out.println("9 to exit\n");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				displayCarsInInterval();
				break;
			case "2":
				displaySpecificBooking();
				break;
			case "3":
				displayBookings();
				break;
			case "9":
				System.out.println("Client application terminated");
				System.exit(0);
				break;
			default:
				System.out.println("Please insert a valid number");
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	private void displayBookings() {
		RentList result = controller.getAll();
		System.out.println("\nAll bookings: \n" + result);
	}

	private void displayCarsInInterval() {
		try {
			System.out.println("\nPlease insert a start date(dd/mm/yyyy): ");
			String startDate = reader.readLine();
			System.out.println("\nPlease insert an end date(dd/mm/yyyy): ");
			String endDate = reader.readLine();
			VehicleList result = controller.getAllInInterval(startDate, endDate);
			System.out.println("\nThe reservation(s) found in the requested interval: \n" + result);
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
			displayCarsInInterval();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			displayCarsInInterval();
		} catch (IllegalDateException e) {
			System.out.println(e.getMessage());
			displayCarsInInterval();
		}
		displayMenu();
	}

	private void displaySpecificBooking() {
		System.out.println("\nInsert a booking number: ");
		try {
			String in = reader.readLine();
			Integer resNo = Integer.valueOf(in);
			Rent reservation = controller.getReservation(resNo);
			System.out.println("\nReservation is: ");
			System.out.println("Reservation number: " + reservation.getResNo());
			System.out.println("Pick-up time: " + reservation.getPickUpTime());
			System.out.println("Return time: " + reservation.getReturnTime());
			System.out.println("Pick-up location: " + reservation.getPickUpPlace());
			System.out.println("Return location: " + reservation.getReturnPlace());
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

	private void editBooking(Rent reservation) {
		System.out.println("\n1 to return to the main menu");
		System.out.println("2 to delete the booking");
		System.out.println("3 to modify the booking\n");
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
				System.out.println("Please insert a valid number");
				editBooking(reservation);
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		}
		displayMenu();
	}

	private void displayModificationMenu(Rent reservation) {
		System.out.println("\n1 to save modifications");
		System.out.println("2 to change the pick-up time");
		System.out.println("3 to change the return time");
		System.out.println("4 to change the first name");
		System.out.println("5 to change the last name");
		System.out.println("6 to cancel modifications\n");
		try {
			String in = reader.readLine();
			switch (in) {
			case "1":
				controller.saveReservation(reservation);
				displayMenu();
				break;
			case "2":
				System.out.println("\nInsert the new pick up date");
				in = reader.readLine();
				controller.validateDate(in);
				reservation.setPickUpTime(TheTime.convert(in));
				break;
			case "3":
				System.out.println("\nInsert the new return date");
				in = reader.readLine();
				controller.validateDate(in);
				reservation.setReturnTime(TheTime.convert(in));
				break;
			case "4":
				System.out.println("\nInsert the new first name");
				in = reader.readLine();
				reservation.setFirstName(in);
				break;
			case "5":
				System.out.println("\nInsert the new last name");
				in = reader.readLine();
				reservation.setLastName(in);
				break;
			case "6":
				displayMenu();
				break;
			default:
				System.out.println("\nPlease insert a valid number");
				displayModificationMenu(reservation);
				break;
			}
		} catch (IOException e) {
			System.out.println("Unexpected problem with reading your input, please try again.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		displayModificationMenu(reservation);
	}

	/**
	 * Informs the user that the data has been changed
	 * 
	 * @param updateMsg
	 *            message from the server with the changes
	 */
	public void update(Object updateMsg) {
		System.out.println("\n-----------------------Update message from server---------------------");
		System.out.println(updateMsg);
	}
}