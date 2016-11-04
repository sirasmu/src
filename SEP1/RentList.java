package SEP1;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Rent objects.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class RentList implements Serializable
{
   private ArrayList<Rent> rentals;

   /**
    * No-argument constructor initializing the RentList.
    */
   public RentList()
   {
      rentals = new ArrayList<Rent>();
   }

   /**
    * Adds a Rent to the list.
    * 
    * @param rent
    *           the rent to add to the list
    */
   public void addRent(Rent rent)
   {
      rentals.add(rent);
   }

   /**
    * Remove a Rent from the list.
    * 
    * @param rent
    *           the rent to remove from the list
    */
   public void remove(Rent rent)
   {
      rentals.remove(rent);
   }

   /**
    * Replaces the Rent object at index with rent.
    * 
    * @param rent
    *           the rent to replace with
    * @param index
    *           the position in the list that will be replaced
    */
   public void set(Rent rent, int index)
   {
      rentals.set(index, rent);
   }

   /**
    * Gets a Rent object from position index from the list.
    * 
    * @param index
    *           the position in the list of the Rent object
    * @return rentals
    *           the Rent object at position index if one exists, else null
    */
   public Rent get(int index)
   {
      if (index < rentals.size())
      {
         return rentals.get(index);
      }
      else
      {
         return null;
      }
   }

   /**
    * Gets a Rent object with the given first name and last name from the list.
    * 
    * @param resNo
    *           the reservation number of the Rent object
    * @return temp 
    *           the Rent object with the given reservation number if one exists, else null
    */
   public Rent getResNo(int resNo)
   {
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent temp = rentals.get(i);

         if (temp.getResNo() == resNo)
         {
            return temp;
         }
      }

      return null;
   }

   /**
    * Gets the index of a Rent object with the given reservation number.
    * 
    * @param resNo
    *           the reservation number of the Rent object
    * @return i 
    *           the index of the Rent object with the given reservation number if one exists, else -1
    */
   public int getIndex(int resNo)
   {
      for (int i = 0; i < rentals.size(); i++)
      {
         Rent temp = rentals.get(i);

         if (temp.getResNo() == resNo)
         {
            return i;
         }
      }
      return -1;
   }

   /**
    * Gets how many Rent objects are in the list.
    * 
    * @return the number of Rent objects in the list
    */
   public int size()
   {
      return rentals.size();
   }

   /**
    * Gets a String representation of the RentList.
    * 
    * @return returnStr
    *             a String containing information about all Rent objects in the list
    *             - each Rent object followed by a new line character
    */
   public String toString()
   {
      String returnStr = "";

      for (int i = 0; i < rentals.size(); i++)
      {
         Rent temp = rentals.get(i);

         returnStr += temp + "\n";
      }
      return returnStr;
   }

}