package WIP.data;

import SEP1.IllegalDateException;
import SEP1.Rent;
import SEP1.RentList;
import SEP1.TheTime;
import SEP1.Vehicle;

public class Reserved {
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
	   
	   public Reserved(Vehicle vehicle, int resNo, TheTime pickUpTime,
		         TheTime returnTime, String pickUpPlace, String returnPlace,
		         String firstName, String lastName, int estimateKm, double estimatePrice)
		   {
		      this.vehicle = vehicle;
		      this.resNo = resNo;
		      if ((returnTime.getDay() < pickUpTime.getDay())
		            && (returnTime.getMonth() <= pickUpTime.getMonth()))
		      {
		         throw new IllegalDateException(
		               "return time must be after pick up time");
		      }

		      if ((returnTime.getMonth() < pickUpTime.getMonth())
		            && (returnTime.getYear() <= pickUpTime.getYear()))
		      {
		         throw new IllegalDateException(
		               "return time must be after pick up time");
		      }

		      if (returnTime.getYear() < pickUpTime.getYear())
		      {
		         throw new IllegalDateException(
		               "return time must be after pick up time");
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
		    * Sets the rental information of a booking
		    * 
		    * @param driversLicense
		    *             the client's driving license
		    * @param phoneNo
		    *             the client's phone number
		    */
		   public void setRent(String driversLicense, String phoneNo)
		   {
		      this.driversLicense = driversLicense;
		      this.phoneNo = phoneNo;
		   }

		   
		   /**
		    * Sets the return information of a rental
		    * @param realDate
		    *             the vehicle's return date
		    * @param realDrivenKm
		    *             the vehicle's driven kilometers
		    * @param condition
		    *             the vehicle's condition 
		    * @param realPrice
		    *             the price for the rental
		    */
		   public void setReturn(TheTime realDate, int realDrivenKm, String condition,
		         double realPrice)
		   {
		      this.realDate = realDate;
		      this.realDrivenKm = realDrivenKm;
		      this.condition = condition;
		      this.realPrice = realPrice;
		   }

		   
		   /**
		    * Gets the vehicle with all the information about it
		    * @return vehicle 
		    *             the vehicle with all the information about it
		    */
		   public Vehicle getVehicle()
		   {
		      return vehicle;
		   }

		   
		   /**
		    * Gets the reservation number of the client after he made the booking
		    * @return resNo
		    *             the client's reservation number 
		    */
		   public int getResNo()
		   {
		      return resNo;
		   }

		   
		   /**
		    * Gets the time when the client will pick up the vehicle
		    * @return pickUpTime
		    *             the vehicle's pick up time
		    */
		   public TheTime getPickUpTime()
		   {
		      return pickUpTime;
		   }

		   
		   /**
		    * Gets the time when the client will return the vehicle
		    * @return returnTime
		    *             the vehicle's return time
		    */
		   public TheTime getReturnTime()
		   {
		      return returnTime;
		   }

		   
		   /**
		    * Gets the place from where the client will pick up the vehicle
		    * @return pickUpPlace
		    *             the vehicle's pick up place
		    */
		   public String getPickUpPlace()
		   {
		      return pickUpPlace;
		   }

		   
		   /**
		    * Gets the place where the client will return the vehicle
		    * @return returnPlace
		    *             the vehicle's return place
		    *          
		    */
		   public String getReturnPlace()
		   {
		      return returnPlace;
		   }

		   
		   /**
		    * Gets the estimated kilometers that the client will drive
		    * @return estimateKm
		    *             the estimated kilometers of the vehicle
		    */
		   public int getEstimateKm()
		   {
		      return estimateKm;
		   }

		   
		   /**
		    * Gets the estimate price for a rental
		    * @return estimatedPrice
		    *             the estimate price of the rental
		    */
		   public double getEstimatePrice()
		   {
		      return estimatePrice;
		   }

		   
		   /**
		    * Gets the client's driving license number
		    * @return driversLicense
		    *             the client's driving license 
		    */
		   public String getDriversLicense()
		   {
		      return driversLicense;
		   }

		   
		   /**
		    * Gets the client's first name
		    * @return firstName
		    *             the client's first name
		    */
		   public String getFirstName()
		   {
		      return firstName;
		   }

		   
		   /**
		    * Gets the client's last name.
		    * @return lastName
		    *             the client's last name
		    */
		   public String getLastName()
		   {
		      return lastName;
		   }

		   /**
		    * Gets the client's phone number
		    * @return phoneNo
		    *             the client's phone number
		    */
		   public String getPhoneNo()
		   {
		      return phoneNo;
		   }

		   
		   /**
		    * Gets the actual date when the vehicle has been returned
		    * @return realDate
		    *             the vehicle's return date
		    */
		   public TheTime getRealDate()
		   {
		      return realDate;
		   }

		   /**
		    * Gets the actual driven kilometers of the vehicle
		    * @return realDrivenKm
		    *          the actual driven kilometers
		    */
		   public int getRealDrivenKm()
		   {
		      return realDrivenKm;
		   }

		   /**
		    * Gets the real price of the vehicle after it has been returned
		    * @return realPrice
		    *             the real price of the vehicle
		    */
		   public double getRealPrice()
		   {
		      return realPrice;
		   }

		   /**
		    * Gets the condition of the vehicle after it has been returned
		    * @return condition
		    *             the condition of the vehicle(good/damaged)
		    */
		   public String getCondition()
		   {
		      return condition;
		   }

		   /**
		    * Sets a vehicle
		    * @param vehicle
		    *           the vehicle that will be rented
		    */
		   public void setVehicle(Vehicle vehicle)
		   {
		      this.vehicle = vehicle;
		   }

		   /**
		    * Sets the pick up time of the vehicle
		    * @param pickUpTime
		    *           the vehicle's pick up time that will be set to
		    */
		   public void setPickUpTime(TheTime pickUpTime)
		   {
		      this.pickUpTime = pickUpTime;
		   }

		   /**
		    * Sets the return time of the vehicle
		    * @param returnTime
		    *          the vehicle's return time that will be set to
		    */
		   public void setReturnTime(TheTime returnTime)
		   {
		      this.returnTime = returnTime;
		   }

		   /**
		    * Sets the pick up place
		    * @param pickUpPlace
		    *           the vehicle's pick up place that will be set to
		    */
		   public void setPickUpPlace(String pickUpPlace)
		   {
		      this.pickUpPlace = pickUpPlace;
		   }

		   /**
		    * Sets the return time
		    * @param returnPlace
		    *           the vehicle's return place that will be set to
		    */
		   public void setReturnPlace(String returnPlace)
		   {
		      this.returnPlace = returnPlace;
		   }

		   /**
		    * Sets the estimated kilometers
		    * @param estimateKm
		    *           the vehicle's estimated kilometers that will be set to
		    */
		   public void setEstimateKm(int estimateKm)
		   {
		      this.estimateKm = estimateKm;
		   }

		   /**
		    * Sets the estimated price
		    * @param estimatePrice
		    *           the rental's estimated price that will be set to
		    */
		   public void setEstimatePrice(double estimatePrice)
		   {
		      this.estimatePrice = estimatePrice;
		   }

		   /**
		    * Sets the client's first name.
		    * @param firstName
		    *           the client's first name that will be set to
		    */
		   public void setFirstName(String firstName)
		   {
		      this.firstName = firstName;
		   }

		   /**
		    * Sets the client's last name.
		    * @param firstName
		    *           the client's last name that will be set to
		    */
		   public void setLastName(String lastName)
		   {
		      this.lastName = lastName;
		   }

		   /**
		    * Sets the client's driving license number
		    * @param driversLicense
		    *           the driving license number of the client
		    */
		   public void setDriversLicense(String driversLicense)
		   {
		      this.driversLicense = driversLicense;
		   }

		   /**
		    * Sets the client's phone number
		    * @param phoneNo
		    *           the phone number of the client
		    */
		   public void setPhoneNo(String phoneNo)
		   {
		      this.phoneNo = phoneNo;
		   }

		   /**
		    * Sets the real date when the vehicle will be returned
		    * @param realDate
		    *             the vehicle's real date
		    */
		   public void setRealDate(TheTime realDate)
		   {
		      this.realDate = realDate;
		   }

		   /**
		    * Sets the vehicle's actual driven kilometers
		    * @param realDrivenKm
		    *           the actual driven kilometers that will be set to
		    */
		   public void setRealDrivenKm(int realDrivenKm)
		   {
		      this.realDrivenKm = realDrivenKm;
		   }

		   /**
		    * Sets the vehicle's condition on return
		    * @param condition
		    *           the condition of the vehicle that will be set to (good/damaged)
		    */
		   public void setCondition(String condition)
		   {
		      this.condition = condition;
		   }

		   /**
		    * Sets the vehicle's actual price
		    * @param realPrice
		    *           the price of the rental that will be set to
		    */
		   public void setRealPrice(double realPrice)
		   {
		      this.realPrice = realPrice;
		   }

		   /**
		    * Sets the vehicle's reservation number
		    * @param resNo
		    *           the rental's reservation number
		    */
		   public void setResNo(int resNo)
		   {
		      this.resNo = resNo;
		   }

		   /**
		    * Returns a string representation of the rental.
		    * 
		    * @return a string representation of the rental in the format:
		    *         "vehicle,resNo,pickUpTime,returnTime,pickUpPlace,returnPlace,firstName,lastNam
		    *         e , estimateKm,estimatePrice,driversLicense,phoneNo, realDate,
		    *         realDrivenKm, condition"
		    *                a string with all the information about the vehicle and the client
		    */                
		   public String toString()
		   {

		      return vehicle + "," + resNo + "," + pickUpTime + "," + returnTime + ","
		            + pickUpPlace + "," + returnPlace + "," + firstName + ","
		            + lastName + "," + estimateKm + "," + estimatePrice + ","
		            + driversLicense + "," + phoneNo + "," + realDate + ","
		            + realDrivenKm + "," + condition + "," + realPrice;
		   }

		   
		   /**
		    * Compares vehicle, driversLicense, phoneNo of two rents.
		    * 
		    * @param obj
		    *           the object to compare with
		    * @return true if the given object is equal to this rent
		    */
		   public boolean equals(Object obj)
		   {
		      if (!(obj instanceof Rent))
		      {
		         return false;
		      }

		      Rent other = (Rent) obj;

		      if (driversLicense != null)
		      {
		         return vehicle.equals(other.vehicle)
		               && driversLicense.equals(other.driversLicense)
		               && phoneNo.equals(other.phoneNo);
		      }
		      else
		      {
		         return vehicle.equals(other.vehicle) && phoneNo.equals(other.phoneNo)
		               && other.driversLicense == null;
		      }
		   }

		   /**
		    * Generates random 4-digit number for reservation
		    * @return random
		    *             the reservation number of the rental
		    */
		   public int generateResNo()
		   {
		      // int random = (int )(Math.random() * 8900 + 1) + 1000;
		      int random = (int) (Math.random() * 10 + 1) + 1;

		      return random;
		   }

		   
		   /**
		    * Shows at which stage is the rental
		    * @return Book
		    *             if the vehicle is booked
		    * @return Rent
		    *             if the vehicle is rented
		    * @return history
		    *             if the price of the rental is not 0
		    * @return unknown
		    *             if non of the above circumstances is true 
		    */
		   public String checkRentType()
		   {
		      String drivingLicence2;
		      double realPrice2;

		      drivingLicence2 = getDriversLicense();
		      realPrice2 = getRealPrice();

		      if ((drivingLicence2.equals("")) && (realPrice2 == 0))
		      {
		         return "Book";
		      }

		      else if (!(drivingLicence2.equals("")) && (realPrice2 == 0))
		      {
		         return "Rent";
		      }

		      else if (realPrice2 != 0)
		      {
		         return "history";
		      }
		      return "unknown";
		   }

		   
		   /**
		    * Checks if the reservation number is valid
		    * @return ValidResNo
		    *             if the reservation number is valid
		    */

		   public int checkValidandGenerateResNo()
		   {
		      RentList ValidList = rfa.getAllRents();
		      int ValidResNo = generateResNo();
		      int isValid = 1;

		      for (int i = 0; i < ValidList.size(); i++)
		      {
		         if (ValidList.get(i).getResNo() == ValidResNo)
		         {
		            isValid = 0;
		         }
		      }

		      if (isValid == 0)
		      {
		         return checkValidandGenerateResNo();
		      }

		      return ValidResNo;
		   }
}
