package SEP1;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/**
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class TestRentFileAdapter
{
   public static void main(String[] args)
   {
      VehicleFileAdapter vfa = new VehicleFileAdapter("vehicles.bin");
      RentFileAdapter rfa = new RentFileAdapter("rentals.bin");

      // Get all vehicles from the file and print them out
      VehicleList list = vfa.getAllVehicles();
      RentList rentList = rfa.getAllRents();
      int resNo = rentList.size();
      System.out.println("All vehicles:\n" + list);

      System.out.println();
      // Add a new rent
      System.out.println("HERE");

      System.out.println();

      rentList = rfa.getAllRents();
      System.out.println(rentList);

      /*
       * Rent book1= new Rent(list.get(2), resNo, new TheTime(1,3,2016),new
       * TheTime(5,3,2016), "horsens","horsens","ana","chifor",200,1000);
       * //book1.setRent("abc","def"); //book1.setReturn(new
       * TheTime(19,4,2016),200, "good", 1000); rentList.addRent(book1); resNo =
       * rentList.size(); Rent book2= new Rent(list.get(3), resNo, new
       * TheTime(16,3,2016),new TheTime(17,3,2016),
       * "horsens","aarhus","maria","chifor",100,1000); rentList.addRent(book2);
       * System.out.println("here:\n" + rentList); rfa.saveRents(rentList);
       * rentList = rfa.getAllRents(); VehicleList v = rfa.timeIsAvailable(list,
       * new TheTime(2,3,2016),new TheTime(9,3,2016)); System.out.println(v);
       */
   }
}
