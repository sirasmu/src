package sdj2.model;

import java.io.Serializable;

import SEP1.IllegalDateException;
import SEP1.TheTime;

/**
 * A class representing a rental with booking information, drivers license, and
 * phone number of the client.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class Rent implements Serializable {

	private static final long serialVersionUID = -3561910294667831417L;

	// Booking
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

	// Renting
	private String driversLicense;
	private String phoneNo;

	// Returning
	private TheTime realDate;
	private int realDrivenKm;
	private String condition;
	private double realPrice;

	/**
	 * Nine-argument constructor.
	 * 
	 * @param vehicle
	 *            the vehicle's information
	 * @param pickUpTime
	 *            the vehicle's pick up time
	 * @param returnTime
	 *            the vehicle's return time
	 * @param pickUpPlace
	 *            the vehicle's pick up place
	 * @param returnPlace
	 *            the vehicle's return place
	 * @param firstName
	 *            the client's first name
	 * @param lastName
	 *            the client's last name
	 * @param estimateKm
	 *            the vehicle's estimated kilometers
	 * @param estimatePrice
	 *            the client's estimated renting price
	 */

	public Rent(/* book */Vehicle vehicle, int resNo, TheTime pickUpTime, TheTime returnTime, String pickUpPlace,
			String returnPlace, String firstName, String lastName, int estimateKm, double estimatePrice) {
		// book
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

		// Renting
		this.driversLicense = "";
		this.phoneNo = "";

		// Returning
		this.realDate = null;
		this.realDrivenKm = 0;
		this.condition = "";
		this.realPrice = 0;
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
	 * Gets the client's driving license number
	 * 
	 * @return driversLicense the client's driving license
	 */
	public String getDriversLicense() {
		return driversLicense;
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
	 * Gets the client's phone number
	 * 
	 * @return phoneNo the client's phone number
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Gets the actual date when the vehicle has been returned
	 * 
	 * @return realDate the vehicle's return date
	 */
	public TheTime getRealDate() {
		return realDate;
	}

	/**
	 * Gets the actual driven kilometers of the vehicle
	 * 
	 * @return realDrivenKm the actual driven kilometers
	 */
	public int getRealDrivenKm() {
		return realDrivenKm;
	}

	/**
	 * Gets the real price of the vehicle after it has been returned
	 * 
	 * @return realPrice the real price of the vehicle
	 */
	public double getRealPrice() {
		return realPrice;
	}

	/**
	 * Gets the condition of the vehicle after it has been returned
	 * 
	 * @return condition the condition of the vehicle(good/damaged)
	 */
	public String getCondition() {
		return condition;
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
	 * Sets the client's driving license number
	 * 
	 * @param driversLicense
	 *            the driving license number of the client
	 */
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}

	/**
	 * Sets the client's phone number
	 * 
	 * @param phoneNo
	 *            the phone number of the client
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Sets the real date when the vehicle will be returned
	 * 
	 * @param realDate
	 *            the vehicle's real date
	 */
	public void setRealDate(TheTime realDate) {
		this.realDate = realDate;
	}

	/**
	 * Sets the vehicle's actual driven kilometers
	 * 
	 * @param realDrivenKm
	 *            the actual driven kilometers that will be set to
	 */
	public void setRealDrivenKm(int realDrivenKm) {
		this.realDrivenKm = realDrivenKm;
	}

	/**
	 * Sets the vehicle's condition on return
	 * 
	 * @param condition
	 *            the condition of the vehicle that will be set to
	 *            (good/damaged)
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Sets the vehicle's actual price
	 * 
	 * @param realPrice
	 *            the price of the rental that will be set to
	 */
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
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
		return resNo + "," + pickUpTime + "," + returnTime + "," + pickUpPlace + "," + returnPlace + "," + firstName
				+ "," + lastName + "," + estimateKm + "," + estimatePrice + "," + driversLicense + "," + phoneNo + ","
				+ realDate + "," + realDrivenKm + "," + condition + "," + realPrice + "," + vehicle;
	}

	/**
	 * Compares vehicle, driversLicense, phoneNo of two rents.
	 * 
	 * @param obj
	 *            the object to compare with
	 * @return true if the given object is equal to this rent
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Rent)) {
			return false;
		}

		Rent other = (Rent) obj;

		if (driversLicense != null) {
			return vehicle.equals(other.vehicle) && driversLicense.equals(other.driversLicense)
					&& phoneNo.equals(other.phoneNo);
		} else {
			return vehicle.equals(other.vehicle) && phoneNo.equals(other.phoneNo) && other.driversLicense == null;
		}
	}

	/**
	 * Shows at which stage is the rental
	 * 
	 * @return Book if the vehicle is booked
	 * @return Rent if the vehicle is rented
	 * @return history if the price of the rental is not 0
	 * @return unknown if non of the above circumstances is true
	 */
	public String checkRentType() {
		String drivingLicence2;
		double realPrice2;

		drivingLicence2 = getDriversLicense();
		realPrice2 = getRealPrice();

		if ((drivingLicence2.equals("")) && (realPrice2 == 0)) {
			return "Book";
		}

		else if (!(drivingLicence2.equals("")) && (realPrice2 == 0)) {
			return "Rent";
		}

		else if (realPrice2 != 0) {
			return "history";
		}
		return "unknown";
	}
}
