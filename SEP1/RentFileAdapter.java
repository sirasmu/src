package SEP1;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the rentals file, making it easy to retrieve and store
 * information.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class RentFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * 
    * @param fileName
    *           the name and path of the file where rentals will be saved and retrieved
    */
   public RentFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   /**
    * Uses the MyFileIO class to retrieve a RentList object with all Rents.
    * 
    * @return rentals 
    *             a RentList object with all stored rentals
    */
   public RentList getAllRents()
   {
      RentList rentals = new RentList();

      try
      {
         rentals = (RentList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return rentals;
   }

   /**
    * Use the MyFileIO class to retrieve all rentals from a given pick up date.
    * 
    * @param day
    *           the day retrieve rentals from
    * @param month
    *           the month retrieve rentals from
    * @param year
    *           the year retrieve rentals from
    * @return rentals 
    *           a RentList object with rentals from the pick up date
    */
   public RentList getRentsFromPickUpDate(int day, int month, int year)
   {
      TheTime findDate = new TheTime(day, month, year);
      RentList rentals = new RentList();

      try
      {
         RentList result = (RentList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getPickUpTime().equals(findDate))
            {
               rentals.addRent(result.get(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return rentals;
   }

   /**
    * Use the MyFileIO class to retrieve all rentals from a given pick up date.
    *
    * @param month
    *           the month retrieve rentals from
    * @param year
    *           the year retrieve rentals from
    * @return rentals 
    *           a RentList object with rentals from the pick up date
    */
   public RentList getRentsFromPickUpDate(int month, int year)
   {
      TheTime findDate = new TheTime(0, month, year);
      RentList rentals = new RentList();

      try
      {
         RentList result = (RentList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getPickUpTime().getMonth() == findDate.getMonth()
                  && result.get(i).getPickUpTime().getYear() == findDate
                        .getYear())
            {
               rentals.addRent(result.get(i));
            }
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return rentals;
   }

   /**
    * Uses MyFileIO class to retrieve a list of a specific type of vehicle
    * 
    * @param status
    *           the type of the vehicle
    * @return rentals 
    *           a RentList object with rentals by their status
    */
   public RentList getRentListByTypeStatus(String status)
   {
      RentList rentals = new RentList();

      RentList result = getAllRents();
      for (int i = 0; i < result.size(); i++)
      {
         if (result.get(i).checkRentType().equals(status))
         {
            rentals.addRent(result.get(i));
         }
      }
      return rentals;
   }

   /**
    * Uses the MyFileIO to add new rentals
    * 
    * @param rent
    *           a new rent to the list
    */
   public void addRent(Rent rent)
   {
      try
      {
         RentList list = getAllRents();
         list.addRent(rent);
         mfio.writeToFile(fileName, list);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Not found");
         System.exit(1);
      }
      catch (IOException e)
      {
         System.out.println("IO error");
      }
   }

   /**
    * Use the MyFileIO class to save some rentals.
    * 
    * @param rentals
    *           the list of rentals that will be saved
    */
   public void saveRents(RentList rentals)
   {
      try
      {
         mfio.writeToFile(fileName, rentals);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
         e.printStackTrace();
      }
   }

   /**
    * Uses the MyFileIO class to change the first name, last name, pick up time,
    * return time, pick up place, return place, estimated kilometers and vehicle
    * of a rent with the given reservation number.
    * 
    * @param resNo
    *           the reservation number of the client
    * @param firstName
    *           the first name of the client
    * @param lastName
    *           the last name of the client
    * @param pickUpTime
    *           the pick up time of the vehicle
    * @param returnTime
    *           the return time of the vehicle
    * @param pickUpPlace
    *           the pick up place of the vehicle
    * @param returnPlace
    *           the return place of the vehicle
    * @param estimateKm
    *           the estimated amount of kilometers the client will drive in the vehicle
    * @param vehicle
    *           the vehicle the client books
    */
   public void changeBooking(int resNo, String firstName, String lastName,
         TheTime pickUpTime, TheTime returnTime, String pickUpPlace,
         String returnPlace, int estimateKm, Vehicle vehicle)
   {
      RentList rentals = getAllRents();

      for (int i = 0; i < rentals.size(); i++)
      {
         Rent rent = rentals.get(i);

         if (rent.getResNo() == resNo)
         {
            rent.setFirstName(firstName);
            rent.setLastName(lastName);
            rent.setPickUpTime(pickUpTime);
            rent.setReturnTime(returnTime);
            rent.setPickUpPlace(pickUpPlace);
            rent.setReturnPlace(returnPlace);
            rent.setEstimateKm(estimateKm);
            rent.setVehicle(vehicle);
         }
      }

      saveRents(rentals);
   }

   /**
    * Uses the MyFileIO class to store the driversLicense and the phoneNo
    * 
    * @param resNo
    *           the reservation number of the client for the comparison
    * @param driversLicense
    *           the driver license of the client
    * @param phoneNo
    *           the phone number of the client
    */
   public void changeRent(int resNo, String driversLicense, String phoneNo)
   {
      RentList rentals = getAllRents();
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent rent = rentals.get(i);
         if (rent.getResNo() == resNo)
         {
            rent.setDriversLicense(driversLicense);
            rent.setPhoneNo(phoneNo);
         }
      }
      saveRents(rentals);
   }

   /**
    * Uses the MyFileIO class to change the real date, real drivenKm, condition
    * and real price of a rent with the given reservation number.
    * 
    * @param resNo
    *           the reservation number for the comparison
    * @param realDate
    *           the new date will be set to
    * @param realDrivenKm
    *           the new kilometers will be set to
    * @param condition
    *           the new condition of the vehicle
    * @param realPrice
    *           the new real price
    */
   public void changeReturn(int resNo, TheTime realDate, int drivenKm,
         String condition, double realPrice)
   {
      RentList rentals = getAllRents();
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent rent = rentals.get(i);

         if (rent.getResNo() == resNo)
         {
            rent.setRealDate(realDate);
            rent.setEstimateKm(drivenKm);
            rent.setCondition(condition);
            rent.setRealPrice(realPrice);
         }
      }
      saveRents(rentals);
   }

   /**
    * A method checking if the date for renting is currently available
    * 
    * @param list
    *           the vehicle list
    * @param pickUpTime2
    *           the pick up time of the vehicle
    * @param returnTime2
    *           the return time of the vehicle
    * @return list 
    *           the list with vehicle that are available for a specific period of time
    */

   public VehicleList timeIsAvailable(VehicleList list, TheTime pickUpTime2,
         TheTime returnTime2)
   {
      RentList rentals = getAllRents();
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent rent = rentals.get(i);
         if (rent.getPickUpTime().equals(pickUpTime2)
               || rent.getReturnTime().equals(returnTime2)
               || rent.getPickUpTime().equals(returnTime2)
               || rent.getReturnTime().equals(pickUpTime2))
         {
            list.remove(rent.getVehicle());
         }

         else if (rent.getPickUpTime().isBefore(pickUpTime2)
               && pickUpTime2.isBefore(rent.getReturnTime()))
         {
            list.remove(rent.getVehicle());
         }
         else if (pickUpTime2.isBefore(rent.getPickUpTime())
               && rent.getPickUpTime().isBefore(returnTime2))
         {
            list.remove(rent.getVehicle());
         }
         else if (rent.getPickUpTime().isBefore(pickUpTime2)
               && returnTime2.isBefore(rent.getReturnTime()))
         {
            list.remove(rent.getVehicle());
         }
         else if (pickUpTime2.isBefore(rent.getPickUpTime())
               && rent.getReturnTime().isBefore(returnTime2))
         {
            list.remove(rent.getVehicle());
         }
      }
      return list;
   }

   /**
    * A method checking if the place for renting is available
    * 
    * @param pickUpPlace
    *           the pick up place of the vehicle
    * @param returnPlace
    *           the return place of the vehicle
    * @return "is available" 
    *           if the pick up place and return place are available
    */
   public String placeIsAvailable(String pickUpPlace, String returnPlace)
   {
      RentList rentals = getAllRents();
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent rent = rentals.get(i);

         if (rent.getPickUpPlace().equals(pickUpPlace)
               && rent.getReturnPlace().equals(returnPlace))
         {
            return "ok place";
         }

         if ((rent.getPickUpPlace().equals(pickUpPlace) && !(rent
               .getReturnPlace().equals(returnPlace))))
         {
            return "choose another return place";
         }

         if (!(rent.getPickUpPlace().equals(pickUpPlace))
               && (rent.getReturnTime().equals(returnPlace)))
         {
            return "choose another pick up place";
         }
      }
      return "is available";
   }

   /**
    * Gets all the rentals of the vehicles
    * 
    * @param vehicle
    *           a specific vehicle by the registration number
    * @return temp 
    *           a list of all rents for selected vehicle
    */
   public RentList getAllRentsForVehicle(Vehicle vehicle)
   {
      RentList list = new RentList();
      RentList temp = new RentList();
      String RegNo = vehicle.getRegNo();

      list = getAllRents();

      for (int i = 0; i < list.size(); i++)
      {
         if (RegNo.equals(list.get(i).getVehicle().getRegNo()))
         {
            temp.addRent(list.get(i));
         }
      }

      if (temp.size() == 0)
      {
         return null;
      }

      return temp;
   }

}
