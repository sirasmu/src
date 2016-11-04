package SEP1;
import java.io.Serializable;
import java.util.ArrayList;
  
/**
 * A class containing a list of Vehicle objects
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe Rasmussen)
 * @version 7.0
 * @date 26-05-2016
 */ 
public class VehicleList implements Serializable
{
   private ArrayList<Vehicle> vehicles;

   /**
    * No-argument constructor initializing the VehicleList
    */
   public VehicleList()
   {
      vehicles = new ArrayList<Vehicle>();
   }
   
   /**
    * Gets how many Vehicle objects are in the list
    * 
    * @return the number of Vehicle objects in the list
    */
   public int size()
   {
      return vehicles.size();
   }
  
   /**
    * Adds a Vehicle to the list
    * 
    * @param vehicle the vehicle to add to the list
    */ 
   public void add(Vehicle vehicle)
   {
      vehicles.add(vehicle);
   }
 
   /**
    * Replaces the Vehicle object at index with vehicle.
    * 
    * @param vehicle 
    *          the vehicle to replace with
    * @param index 
    *          the position in the list that will be replaced
    */
   public void set(Vehicle vehicle, int index)
   {
      vehicles.set(index, vehicle);
   }
   
   /**
    * Gets a Vehicle object from position index from the list of vehicle
    * 
    * @param index 
    *          the position in the list of the Vehicle object
    * @return the Vehicle object at position index if exists, if not return null
    */
   public Vehicle get(int index)
   {
      if (index < vehicles.size())
      {
         return vehicles.get(index);
      }
      else
      {
         return null;
      }
   }

   /**
    * Gets a Vehicle object with the given registration number from the list.
    * 
    * @param regNo 
    *          the registration number of the Vehicle object
    * @return the Vehicle object with the given registration number if one exists, else null
    */
   public Vehicle getRegNo(String regNo)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getRegNo().equals(regNo))
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Gets a Vehicle object with the given make from the list.
    * 
    * @param make 
    *          the make of the Vehicle object
    * @return the Vehicle object with the given make if one exists, else null
    */
   public Vehicle getMake(String make)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getMake().equals(make))
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Gets a Vehicle object with the given model from the list.
    * 
    * @param model 
    *          the model of the Vehicle object
    * @return the Vehicle object with the given model if one exists, else null
    */
   public Vehicle getModel(String model)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getModel().equals(model))
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Gets a Vehicle object with the given year from the list.
    * 
    * @param year 
    *          the year of the Vehicle object
    * @return the Vehicle object with the given year if one exists, else null
    */
   public Vehicle getYear(int year)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getYear() == year)
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Gets a Vehicle object with the given color from the list.
    * 
    * @param color 
    *          the color of the Vehicle object
    * @return the Vehicle object with the given color if one exists, else null
    */
   public Vehicle getColor(String color)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getColor().equals(color))
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Checks if the vehicle is in service or not
    * 
    * @param service
    *             true if the vehicle is in service, and false if it isn't 
    * @return a list with vehicles that are in service
    */
   public Vehicle getService(boolean service)
   {
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         
         if(temp.getService() == service)
         {
            return temp;
         }
      }
      
      return null;
   }
   
   /**
    * Removed vehicle from a vehicle list.
    *  
    * @param vehicle 
    *             the vehicle to be removed from the VehicleList object.
    */
   public void remove(Vehicle vehicle)
   {
	   vehicles.remove(vehicle);
	   
   }
   
   /**
    * Gets a String representation of the VehicleList.
    * 
    * @return a String containing information about all Vehicle objects in the list 
    * - each Vehicle object followed by a new line character    
    */
   public String toString()
   {
      String returnStr = "";
   
      for(int i = 0; i<vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
      
         returnStr += temp +"\n";
      }  
      return returnStr;
   }
   
}
