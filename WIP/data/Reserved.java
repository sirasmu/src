package WIP.data;

import java.io.Serializable;

import WIP.data.utility.IllegalDateException;
import WIP.data.utility.TheTime;

public class Reserved implements Serializable{
	private Vehicle vehicle;
	private int resNo;
	private TheTime pickUpTime;
	private TheTime returnTime;
	private String pickUpPlace;
	private String returnPlace;
	private String firstName;
	private String lastName;
	private int estimateKm;
	private double estimatePrice;
	private ReservedFileAdapter rfa;

	/**
	 * 10-arg contructor for creating a object of Reserved. This class has a vehicle and information about the reservation.
	 * 
	 * @param vehicle is the vehicle that has been reserved
	 * @param resNo identifies which reservation it is
	 * @param pickUpTime when the vehicle will be picked up from the rental company
	 * @param returnTime when the vehicle will be returned to the rental company
	 * @param pickUpPlace the location the vehicle will be picked up
	 * @param returnPlace the location the vehicle will be returned to
	 * @param firstName is the first name of the client whom reserve the vehicle
	 * @param lastName is the last name of the client whom reserve the vehicle
	 * @param estimateKm is the amount of kilometers the client estimated they will drive
	 * @param estimatePrice is what the rental company estimates the total cost of renting the vehicle will be
	 */
	public Reserved(Vehicle vehicle, int resNo, TheTime pickUpTime, TheTime returnTime, String pickUpPlace,
			String returnPlace, String firstName, String lastName, int estimateKm, double estimatePrice) {
		this.vehicle = vehicle;
		this.resNo = resNo;
		if ((returnTime.getDay() < pickUpTime.getDay()) && (returnTime.getMonth() <= pickUpTime.getMonth())) {
			throw new IllegalDateException("return time must be after pick up time");
		}

		if ((returnTime.getMonth() < pickUpTime.getMonth()) && (returnTime.getYear() <= pickUpTime.getYear())) {
			throw new IllegalDateException("return time must be after pick up time");
		}

		if (returnTime.getYear() < pickUpTime.getYear()) {
			throw new IllegalDateException("return time must be after pick up time");
		}

		this.pickUpTime = pickUpTime;
		this.returnTime = returnTime;
		this.pickUpPlace = pickUpPlace;
		this.returnPlace = returnPlace;
		this.firstName = firstName;
		this.lastName = lastName;
		this.estimateKm = estimateKm;
		this.estimatePrice = estimatePrice;
	}

	/**
	 * Gets the vehicle with all the information about it
	 * 
	 * @return vehicle the vehicle with all the information about it
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Gets the reservation number of the client after he made the booking
	 * 
	 * @return resNo the client's reservation number
	 */
	public int getResNo() {
		return resNo;
	}

	/**
	 * Gets the time when the client will pick up the vehicle
	 * 
	 * @return pickUpTime the vehicle's pick up time
	 */
	public TheTime getPickUpTime() {
		return pickUpTime;
	}

	/**
	 * Gets the time when the client will return the vehicle
	 * 
	 * @return returnTime the vehicle's return time
	 */
	public TheTime getReturnTime() {
		return returnTime;
	}

	/**
	 * Gets the place from where the client will pick up the vehicle
	 * 
	 * @return pickUpPlace the vehicle's pick up place
	 */
	public String getPickUpPlace() {
		return pickUpPlace;
	}

	/**
	 * Gets the place where the client will return the vehicle
	 * 
	 * @return returnPlace the vehicle's return place
	 * 
	 */
	public String getReturnPlace() {
		return returnPlace;
	}

	/**
	 * Gets the estimated kilometers that the client will drive
	 * 
	 * @return estimateKm the estimated kilometers of the vehicle
	 */
	public int getEstimateKm() {
		return estimateKm;
	}

	/**
	 * Gets the estimate price for a rental
	 * 
	 * @return estimatedPrice the estimate price of the rental
	 */
	public double getEstimatePrice() {
		return estimatePrice;
	}

	/**
	 * Gets the client's first name
	 * 
	 * @return firstName the client's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the client's last name.
	 * 
	 * @return lastName the client's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets a vehicle
	 * 
	 * @param vehicle
	 *            the vehicle that will be rented
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Sets the pick up time of the vehicle
	 * 
	 * @param pickUpTime
	 *            the vehicle's pick up time that will be set to
	 */
	public void setPickUpTime(TheTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	/**
	 * Sets the return time of the vehicle
	 * 
	 * @param returnTime
	 *            the vehicle's return time that will be set to
	 */
	public void setReturnTime(TheTime returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * Sets the pick up place
	 * 
	 * @param pickUpPlace
	 *            the vehicle's pick up place that will be set to
	 */
	public void setPickUpPlace(String pickUpPlace) {
		this.pickUpPlace = pickUpPlace;
	}

	/**
	 * Sets the return time
	 * 
	 * @param returnPlace
	 *            the vehicle's return place that will be set to
	 */
	public void setReturnPlace(String returnPlace) {
		this.returnPlace = returnPlace;
	}

	/**
	 * Sets the estimated kilometers
	 * 
	 * @param estimateKm
	 *            the vehicle's estimated kilometers that will be set to
	 */
	public void setEstimateKm(int estimateKm) {
		this.estimateKm = estimateKm;
	}

	/**
	 * Sets the estimated price
	 * 
	 * @param estimatePrice
	 *            the rental's estimated price that will be set to
	 */
	public void setEstimatePrice(double estimatePrice) {
		this.estimatePrice = estimatePrice;
	}

	/**
	 * Sets the client's first name.
	 * 
	 * @param firstName
	 *            the client's first name that will be set to
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the client's last name.
	 * 
	 * @param firstName
	 *            the client's last name that will be set to
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Sets the vehicle's reservation number
	 * 
	 * @param resNo
	 *            the rental's reservation number
	 */
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	/**
	 * Returns a string representation of the rental.
	 * 
	 * @return a string representation of the rental in the format:
	 *         "vehicle,resNo,pickUpTime,returnTime,pickUpPlace,returnPlace,
	 *         firstName,lastNam e ,
	 *         estimateKm,estimatePrice,driversLicense,phoneNo, realDate,
	 *         realDrivenKm, condition" a string with all the information about
	 *         the vehicle and the client
	 */
	public String toString() {
		return vehicle + "," + resNo + "," + pickUpTime + "," + returnTime + "," + pickUpPlace + "," + returnPlace + ","
				+ firstName + "," + lastName + "," + estimateKm + "," + estimatePrice;
	}

	/**
	 * Compares vehicle, driversLicense, phoneNo of two rents.
	 * 
	 * @param obj
	 *            the object to compare with
	 * @return true if the given object is equal to this rent
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Reserved)) {
			return false;
		}

		Reserved other = (Reserved) obj;
		return vehicle.equals(other.vehicle);
	}

	/**
	 * Generates random 4-digit number for reservation
	 * 
	 * @return random the reservation number of the rental
	 */
	public int generateResNo() {
		// int random = (int )(Math.random() * 8900 + 1) + 1000;
		int random = (int) (Math.random() * 10 + 1) + 1;

		return random;
	}

	/**
	 * Checks if the reservation number is valid
	 * 
	 * @return ValidResNo if the reservation number is valid
	 */

	public int checkValidandGenerateResNo() {
		ReservedList ValidList = rfa.getAllReserveds();
		int ValidResNo = generateResNo();
		int isValid = 1;

		for (int i = 0; i < ValidList.size(); i++) {
			if (ValidList.getAll().get(i).getResNo() == ValidResNo) {
				isValid = 0;
			}
		}

		if (isValid == 0) {
			return checkValidandGenerateResNo();
		}

		return ValidResNo;
	}
}
