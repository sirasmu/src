package WIP.data;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * An adapter to the vehicles file, making it easy to retrieve and store
 * information.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class VehicleFileAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * 
    * @param fileName
    *           the name and path of the file where the vehicles will be saved and retrieved
    */
   public VehicleFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }

   /**
    * Uses the MyFileIO class to retrieve a VehiclesList object with all
    * Vehicles
    * 
    * @return vehicles
    *             a VehiclesList object with all the vehicles stored
    */
   public VehicleList getAllVehicles()
   {
      VehicleList vehicles = null;

      try
      {
         vehicles = (VehicleList) mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
         e.printStackTrace();
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by registration number
    * 
    * @param byRegNo
    *            the vehicle's registration number
    * @return vehicles
    *            a VehicleList object with vehicles by the given registration number
    */
   public VehicleList getVehicleRegNo(String byRegNo)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getRegNo().equals(byRegNo))
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by type
    * 
    * @param byType
    *          the vehicle's type
    * @return vehicles
    *          a VehicleList object with vehicles by the given type
    */
   public VehicleList getVehicleType(String byType)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getType().equals(byType))
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by make
    * 
    * @param byMake
    *          the vehicle's make
    * @return vehicles
    *          a VehicleList object with vehicles by the given make
    */
   public VehicleList getVehicleMake(String byMake)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getMake().equals(byMake))
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by model
    * 
    * @param byModel
    *          the vehicle's model
    * @return vehicles
    *          a VehicleList object with vehicles by the given model
    */
   public VehicleList getVehicleModel(String byModel)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getModel().equals(byModel))
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by year
    * 
    * @param byYear
    *          the vehicle's year
    * @return vehicles
    *          a VehicleList object with vehicles by the given year
    */
   public VehicleList getVehicleYear(int byYear)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getYear() == byYear)
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by color
    * 
    * @param byColor
    *             the vehicle's color
    * @return vehicles 
    *             a VehicleList object with vehicles by the given color
    */
   public VehicleList getVehicleColor(String byColor)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getColor().equals(byColor))
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by seats
    * 
    * @param bySeats
    *          the vehicle's seats
    * @return vehicles
    *          a VehicleList object with vehicles by the given seats
    */
   public VehicleList getVehicleSeats(int bySeats)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getSeats() == bySeats)
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by driven kilometers
    * 
    * @param byDrivenKm
    *          the vehicle's driven kilometers
    * @return vehicles
    *          a VehicleList object with vehicles by the given kilometers
    */
   public VehicleList getVehicleDrivenKm(int byDrivenKm)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getDrivenKm() == byDrivenKm)
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Use the MyFileIO class to retrieve all vehicles by load size
    * 
    * @param byLoad
    *          the vehicle's load
    * @return vehicles 
    *          a VehicleList object with vehicles by the given load size
    */
   public VehicleList getVehicleLoad(int byLoad)
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getLoad() == byLoad)
            {
               vehicles.add(result.get(i));
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

      return vehicles;
   }

   /**
    * Get the vehicles that are currently sent to maintenance.
    * 
    * @return vehicles 
    *             the vehicles that are sent to maintenance
    */
   public VehicleList getVehiclesInService()
   {
      VehicleList vehicles = new VehicleList();

      try
      {
         VehicleList result = (VehicleList) mfio.readObjectFromFile(fileName);

         for (int i = 0; i < result.size(); i++)
         {
            if (result.get(i).getService() == true)
            {
               vehicles.add(result.get(i));
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
         e.printStackTrace();

      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }

      return vehicles;
   }

   /**
    * Uses the MyFileIO class to save vehicles
    * 
    * @param vehicles
    *           the list of vehicles that will be saved
    */
   public void saveVehicles(VehicleList vehicles)
   {
      try
      {
         mfio.writeToFile(fileName, vehicles);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

   /**
    * Uses the MyFileIO to add new vehicles
    * 
    * @param vehicle
    *          add a new vehicle
    */
   public void addVehicle(Vehicle vehicle)
   {
      try
      {
         VehicleList list = getAllVehicles();
         list.add(vehicle);
         mfio.writeToFile(fileName, list);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(1);
      }
      catch (IOException e)
      {
         System.out.println("IO Error");
      }
   }

   /**
    * Uses the MyFileIO class to remove vehicles by registration number
    * 
    * @param vehicle
    *          remove a vehicle
    */
   public void removeVehicle(Vehicle vehicle)
   {
      VehicleList list = getAllVehicles();
      VehicleList temp = new VehicleList();

      for (int i = 0; i < list.size(); i++)
      {
         if (!list.get(i).getRegNo().equals(vehicle))
         {
            temp.add(list.get(i));
         }
      }
      try
      {
         mfio.writeToFile(fileName, temp);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(1);
      }
      catch (IOException e)
      {
         System.out.println("IO Error");
      }
   }

   /**
    * Uses the MyFileIO class to remove vehicles
    * 
    * @param vehicles
    *             remove vehicles
    */
   public void removeVehicles(VehicleList vehicles)
   {
      VehicleList list = getAllVehicles();
      VehicleList temp = new VehicleList();

      for (int i = 0; i < list.size(); i++)
      {
         if (!list.get(i).equals(vehicles))
         {
            temp.add(list.get(i));
         }
      }
      try
      {
         mfio.writeToFile(fileName, temp);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(1);
      }
      catch (IOException e)
      {
         System.out.println("IO Error");
      }
   }

   /**
    * Uses the MyFileIO class to remove vehicles by registration number
    * 
    * @param regNo
    *          the vehicle's registration number
    */
   public void removeVehicleByRegNo(String regNo)
   {
      VehicleList list = getAllVehicles();
      VehicleList temp = new VehicleList();

      for (int i = 0; i < list.size(); i++)
      {
         if (!list.get(i).getRegNo().equals(regNo))
         {
            temp.add(list.get(i));
         }
      }
      try
      {
         mfio.writeToFile(fileName, temp);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
         System.exit(1);
      }
      catch (IOException e)
      {
         System.out.println("IO Error");
      }
   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's make
    * 
    * @param list
    *          the vehicle list
    * @param make
    *          the vehicle's make
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific make
    */
   public VehicleList filterByMake(VehicleList list, String make,
         String noneSelector)
   {
      if (make.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[2].equals(make))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   
   /**
    *  Goes through the vehicle list and filters it by the vehicle's model
    * 
    * @param list
    *          the vehicle list
    * @param model
    *          the vehicle's model
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific model
    */
   public VehicleList filterByModel(VehicleList list, String model,
         String noneSelector)
   {
      if (model.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[3].equals(model))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's year
    * 
    * @param list
    *          the vehicle list
    * @param year
    *          the vehicle's year
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific year
    */
   public VehicleList filterByYear(VehicleList list, String year,
         String noneSelector)
   {
      if (year.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[4].equals(year))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's color
    * 
    * @param list
    *          the vehicle list
    * @param color
    *          the vehicle's color
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific color
    */
   public VehicleList filterByColor(VehicleList list, String color,
         String noneSelector)
   {
      if (color.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[5].equals(color))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's seats
    * 
    * @param list
    *          the vehicle list
    * @param seats
    *          the vehicle's seats
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific seats
    */
   public VehicleList filterBySeats(VehicleList list, String seats,
         String noneSelector)
   {
      if (seats.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[6].equals(seats))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's load
    * 
    * @param list
    *          the vehicle list
    * @param load
    *          the vehicle's load
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific load
    */
   public VehicleList filterByLoad(VehicleList list, String load,
         String noneSelector)
   {
      if (load.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[8].equals(load))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * Goes through the vehicle list and filters it by the vehicle's type
    * 
    * @param list
    *          the vehicle list
    * @param type
    *          the vehicle's type
    * @param noneSelector
    *          a string value for the filter
    * @return tempList
    *          a list of vehicles of a specific type
    */
   public VehicleList filterByType(VehicleList list, String type,
         String noneSelector)
   {
      if (type.equals(noneSelector))
      {
         return list;
      }

      VehicleList tempList = new VehicleList();
      String[] tempArray;

      for (int i = 0; i < list.size(); i++)
      {
         tempArray = list.get(i).toString().split(",");

         if (tempArray[1].equals(type))
         {
            tempList.add(list.get(i));
         }
      }

      return tempList;

   }

   /**
    * This method changes the service status of a given vehicle.
    * 
    * @param vehicle
    *           the vehicle you want to find and change the service status for
    * @param inService
    *           the service boolean that you will change
    */
   public void changeInService(Vehicle vehicle, boolean inService)
   {
      VehicleList vehicles = getAllVehicles();
      for (int i = 0; i < vehicles.size(); i++)
      {
         Vehicle temp = vehicles.get(i);
         if (temp.equals(vehicle))
         {
            temp.setService(inService);
            System.out.println(temp);
            break;
         }
      }

      saveVehicles(vehicles);
   }

   /**
    * Goes through the vehicle list and checks if there are any vehicle with
    * over 20000 driven kilometers
    * 
    * @return vehicles 
    *             a list of vehicle with over 20000 driven kilometers
    */
   public VehicleList checkKm()
   {
      VehicleList vehicles = new VehicleList();

      VehicleList result = getAllVehicles();
      for (int i = 0; i < result.size(); i++)
      {
         if (result.get(i).getDrivenKm() >= 200000)
         {
            vehicles.add(result.get(i));
         }
      }
      return vehicles;
   }

   /**
    * Goes through the vehicles list, finds the right vehicle by the 
    * registration number and updates the vehicle's information
    * 
    * @param regNo
    *          the vehicle's registration number
    * @return foundVehicle
    *          the vehicle with the updated information
    */
   public Vehicle updateVehicle(String regNo)
   {
      VehicleList vehicles = new VehicleList();
      vehicles = getAllVehicles();

      Vehicle foundVehicle = new Vehicle("DV19742", "Car", "Ferrari", "F50",
            1997, "red", 2, 6000, 0, false);

      for (int i = 0; i < vehicles.size(); i++)
      {
         if (vehicles.get(i).getRegNo().equals(regNo))
         {
            foundVehicle.setRegNo(vehicles.get(i).getRegNo());
            foundVehicle.setType(vehicles.get(i).getType());
            foundVehicle.setMake(vehicles.get(i).getMake());
            foundVehicle.setModel(vehicles.get(i).getModel());
            foundVehicle.setYear(vehicles.get(i).getYear());
            foundVehicle.setColor(vehicles.get(i).getColor());
            foundVehicle.setSeats(vehicles.get(i).getSeats());
            foundVehicle.setDrivenKm(vehicles.get(i).getDrivenKm());
            foundVehicle.setLoad(vehicles.get(i).getLoad());
            foundVehicle.setService(vehicles.get(i).getService());
            break;
         }
      }

      return foundVehicle;
   }
}