package WIP.data;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/**
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class TestReservedFileAdapter
{
   public static void main(String[] args)
   {
      VehicleFileAdapter vfa = new VehicleFileAdapter("vehicles.bin");
      ReservedFileAdapter rfa = new ReservedFileAdapter("reservedList.bin");

      // Get all vehicles from the file and print them out
      VehicleList list = vfa.getAllVehicles();
      ReservedList reservedList = rfa.getAllReserveds();
      
      System.out.println("All vehicles:\n" + list);

      System.out.println();
      // Add a new rent
      System.out.println("HERE");

      System.out.println();

      reservedList = rfa.getAllReserveds();
      System.out.println(reservedList);

      
       Reserved book1= new Reserved(list.get(3), 1, new TheTime(16,3,2016),new TheTime(17,3,2016),  "horsens","aarhus","maria","chifor",100,1000); 
       reservedList.add(book1);
       System.out.println("here:\n" + reservedList); rfa.saveReserveds(reservedList);
       reservedList = rfa.getAllReserveds(); 
       
   }
}
