package SEP1;

import sdj2.model.VehicleList;

/**
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class TestVehiclesFileAdapter
{
   public static void main(String[] args)
   {
      VehicleFileAdapter vfa = new VehicleFileAdapter("resources/vehicles.bin");

      // Get all vehicles from the file and print them out
      VehicleList list = vfa.getAllVehicles();
      System.out.println("All vehicles:\n" + list);

      //System.out.println("HEREEEEE: "+vfa.getVehicleMake("BMW"));

      /*
       * //Add a new vehicle Vehicle one = new
       * Vehicle("AL19742","Car","Ferrari","F50",1997,"red",2,6000,0,0);
       * vfa.addVehicle(one); list = vfa.getAllVehicles();
       * System.out.println("Added:\n"+list); //Get vehicles by color list =
       * vfa.getVehicleColor("red"); System.out.println("Vehicles by color:\n"
       * +list); //Remove a vehicle by registration number
       * vfa.removeVehicleByRegNo("AL19742"); list = vfa.getAllVehicles();
       * vfa.saveVehicles(list);
       */


   }
}
