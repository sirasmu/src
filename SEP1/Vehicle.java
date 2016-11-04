package SEP1;
import java.io.Serializable;

/**
 * A class representing a vehicle with a make, model, year, color and
 * registration number.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class Vehicle implements Serializable
{
   private String regNo;
   private String type;
   private String make;
   private String model;
   private int year;
   private String color;
   private int seats;
   private int drivenKm;
   private int load;
   private boolean service;

   /**
    * Ten-argument constructor.
    * 
    * @param regNo
    *           the vehicle's registration number
    * @param type
    *           the vehicle's type (van, camper or car)
    * @param make
    *           the vehicle's make
    * @param model
    *           the vehicle's model
    * @param year
    *           the vehicle's fabrication year
    * @param color
    *           the vehicle's color
    * @param seats
    *           the vehicle's seats
    * @param drivenKm
    *           the vehicle's driven kilometers
    * @param load
    *           the van's load
    * @param service
    *           shows whether the vehicle is in service or not
    */
   public Vehicle(String regNo, String type, String make, String model,
         int year, String color, int seats, int drivenKm, int load,
         boolean service)
   {
      this.regNo = regNo;
      this.type = type;
      this.make = make;
      this.model = model;
      this.year = year;
      this.color = color;
      this.seats = seats;
      this.drivenKm = drivenKm;
      if (!type.equals("van"))
      {
         this.load = 0;
      }
      else
         this.load = load;
      this.service = service;
   }

   /**
    * Gets the vehicles registration number.
    * 
    * @return regNo
    *           the vehicle's registration number
    */
   public String getRegNo()
   {
      return regNo;
   }

   /**
    * Gets the vehicle's type
    * 
    * @return type
    *            the vehicle's type
    */

   public String getType()
   {
      return type;
   }

   /**
    * Gets the vehicle's make.
    * 
    * @return make
    *           the vehicle's make
    */
   public String getMake()
   {
      return make;
   }

   /**
    * Gets the vehicles model.
    * 
    * @return model
    *           the vehicle's model
    */
   public String getModel()
   {
      return model;
   }

   /**
    * Gets the vehicle's year.
    * 
    * @return year 
    *           the vehicle's year
    */
   public int getYear()
   {
      return year;
   }

   /**
    * Gets the vehicle's color.
    * 
    * @return color
    *           the vehicle's color
    */
   public String getColor()
   {
      return color;
   }

   /**
    * Gets the vehicle's seats number
    * 
    * @return seats
    *            the vehicle's number of seats
    */
   public int getSeats()
   {
      return seats;
   }

   /**
    * Gets the vehicle's driven kilometers
    * 
    * @return drivenKm
    *             the vehicle's driven kilometers
    */
   public int getDrivenKm()
   {
      return drivenKm;
   }

   /**
    * Gets the van's load in tons
    * 
    * @return load
    *           the van's load
    */
   public int getLoad()
   {
      return load;
   }

   /**
    * Gets the vehicle service status
    * 
    * @return service 
    *             the service status of the vehicle
    */
   public boolean getService()
   {
      return service;
   }

   /**
    * Sets the vehicle's registration number.
    * 
    * @param regNo
    *           the vehicle's registration number that will be set to
    */
   public void setRegNo(String regNo)
   {
      this.regNo = regNo;
   }

   /**
    * Sets the vehicle's type
    * 
    * @param type
    *           the type that will be set to (van, camper or car)
    */
   public void setType(String type)
   {
      this.type = type;
   }

   /**
    * Sets the vehicle's make.
    * 
    * @param make
    *           the make that will be set to
    */
   public void setMake(String make)
   {
      this.make = make;
   }

   /**
    * Sets the vehicle's model.
    * 
    * @param model
    *           the vehicle's model that will be set to
    */
   public void setModel(String model)
   {
      this.model = model;
   }

   /**
    * Sets the vehicle's year.
    * 
    * @param year
    *           the vehicle's year that will be set to
    */
   public void setYear(int year)
   {
      this.year = year;
   }

   /**
    * Sets the vehicle's color.
    * 
    * @param color
    *           the vehicle's color that will be set to
    */
   public void setColor(String color)
   {
      this.color = color;
   }

   /**
    * Sets the vehicle's number of seats.
    * 
    * @param seats
    *           the vehicle's number of seats that will be set to
    */
   public void setSeats(int seats)
   {
      this.seats = seats;
   }

   /**
    * Sets the vehicle's number of driven kilometers
    * 
    * @param updatedKm
    *           the vehicle's number of extra driven kilometers
    */
   public void setDrivenKm(int updatedKm)
   {
      this.drivenKm = updatedKm;
   }

   /**
    * Sets the van's load in tons
    * 
    * @param load
    *           what the van's load is
    */
   public void setLoad(int load)
   {
      this.load = load;
   }

   /**
    * Sets the vehicle's service status
    * 
    * @param service
    *           what the vehicle's service is
    */
   public void setService(boolean service)
   {
      this.service = service;
   }

   /**
    * Returns a string representation of the vehicle.
    * 
    * @return a string representation of the vehicle in the format:
    *         "regNo make model year color seats drivenKm load"
    */
   public String toString()
   {
      return regNo + "," + type + "," + make + "," + model + "," + year + ","
            + color + "," + seats + "," + drivenKm + "," + load + "," + service;
   }

   /**
    * Compares registration number of 2 vehicles.
    * 
    * @param obj
    *           the object to compare with
    * @return true 
    *           if the given object is equal to this vehicle
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Vehicle))
      {
         return false;
      }

      Vehicle other = (Vehicle) obj;

      return regNo.equals(other.regNo);
   }

}
