package WIP.data;

import java.io.FileNotFoundException;
import java.io.IOException;

import WIP.data.file.MyFileIO;
import WIP.data.utility.TheTime;

/**
 * An adapter to the reserveds file, making it easy to retrieve and store
 * information.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class ReservedFileAdapter {
	private MyFileIO mfio;
	private String fileName;

	/**
	 * 1-argument constructor setting the file name.
	 * 
	 * @param fileName
	 *            the name and path of the file where reserveds will be saved
	 *            and retrieved
	 */
	public ReservedFileAdapter(String fileName) {
		mfio = new MyFileIO();
		this.fileName = fileName;
	}

	/**
	 * Uses the MyFileIO class to retrieve a ReservedList object with all
	 * reserveds.
	 * 
	 * @return reserveds a ReservedList object with all stored reserveds
	 */
	public ReservedList getAllReserveds() {
		ReservedList reserveds = new ReservedList();

		try {
			reserveds = (ReservedList) mfio.readObjectFromFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}
		return reserveds;
	}

	/**
	 * Use the MyFileIO class to retrieve all reserveds from a given pick up
	 * date.
	 * 
	 * @param day
	 *            the day retrieve reserveds from
	 * @param month
	 *            the month retrieve reserveds from
	 * @param year
	 *            the year retrieve reserveds from
	 * @return reserveds a ReservedList object with reserveds from the pick up
	 *         date
	 */
	public ReservedList getReservedsFromPickUpDate(int day, int month, int year) {
		TheTime findDate = new TheTime(day, month, year);
		ReservedList reserved = new ReservedList();

		try {
			ReservedList result = (ReservedList) mfio.readObjectFromFile(fileName);

			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getPickUpTime().equals(findDate)) {
					reserved.add(result.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return reserved;
	}

	/**
	 * Use the MyFileIO class to retrieve all reserveds from a given pick up
	 * date.
	 *
	 * @param month
	 *            the month retrieve reserveds from
	 * @param year
	 *            the year retrieve reserveds from
	 * @return reserveds a ReservedList object with reserveds from the pick up
	 *         date
	 */
	public ReservedList getReservedsFromPickUpDate(int month, int year) {
		TheTime findDate = new TheTime(0, month, year);
		ReservedList reserveds = new ReservedList();

		try {
			ReservedList result = (ReservedList) mfio.readObjectFromFile(fileName);

			for (int i = 0; i < result.size(); i++) {
				if (result.get(i).getPickUpTime().getMonth() == findDate.getMonth()
						&& result.get(i).getPickUpTime().getYear() == findDate.getYear()) {
					reserveds.add(result.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error reading file");
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}

		return reserveds;
	}

	/**
	 * Uses the MyFileIO to add new reserveds
	 * 
	 * @param reserved
	 *            a new reserved to the list
	 */
	public void addReserved(Reserved reserved) {
		try {
			ReservedList list = getAllReserveds();
			list.add(reserved);
			mfio.writeToFile(fileName, list);
		} catch (FileNotFoundException e) {
			System.out.println("Not found");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("IO error");
		}
	}

	/**
	 * Use the MyFileIO class to save some reserveds.
	 * 
	 * @param reserveds
	 *            the list of reserveds that will be saved
	 */
	public void saveReserveds(ReservedList reserveds) {
		try {
			mfio.writeToFile(fileName, reserveds);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Error writing to file");
			e.printStackTrace();
		}
	}

	/**
	 * A method checking if the place for reserving is available
	 * 
	 * @param pickUpPlace
	 *            the pick up place of the vehicle
	 * @param returnPlace
	 *            the return place of the vehicle
	 * @return "is available" if the pick up place and return place are
	 *         available
	 */
	public String placeIsAvailable(String pickUpPlace, String returnPlace) {
		ReservedList reserveds = getAllReserveds();
		for (int i = 0; i < reserveds.size(); i++) {
			Reserved reserved = reserveds.get(i);

			if (reserved.getPickUpPlace().equals(pickUpPlace) && reserved.getReturnPlace().equals(returnPlace)) {
				return "ok place";
			}

			if ((reserved.getPickUpPlace().equals(pickUpPlace) && !(reserved.getReturnPlace().equals(returnPlace)))) {
				return "choose another return place";
			}

			if (!(reserved.getPickUpPlace().equals(pickUpPlace)) && (reserved.getReturnTime().equals(returnPlace))) {
				return "choose another pick up place";
			}
		}
		return "is available";
	}

	/**
	 * Gets all the reserveds of the vehicles
	 * 
	 * @param vehicle
	 *            a specific vehicle by the registration number
	 * @return temp a list of all reserveds for selected vehicle
	 */
	public ReservedList getAllReservedsForVehicle(Vehicle vehicle) {
		ReservedList list = new ReservedList();
		ReservedList temp = new ReservedList();
		String RegNo = vehicle.getRegNo();

		list = getAllReserveds();

		for (int i = 0; i < list.size(); i++) {
			if (RegNo.equals(list.get(i).getVehicle().getRegNo())) {
				temp.add(list.get(i));
			}
		}

		if (temp.size() == 0) {
			return null;
		}

		return temp;
	}

}
