package WIP.data.file;

import java.io.FileNotFoundException;
import java.io.IOException;

import WIP.data.Reserved;
import WIP.data.ReservedList;
import WIP.data.Vehicle;
import WIP.data.VehicleList;
import WIP.data.utility.TheTime;

/**
 * A simple program used for importing data. It reads a text file with vehicle
 * information, creates a VehicleList object with all vehicles read from the
 * file, and saves it as a binary file. The text file must have information of
 * one vehicle on each line, and each line should be in the format: make, model,
 * year, color, registration number.
 *
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class LoadInitialData {

	public static void main(String[] args) {
		VehicleList vehicles = new VehicleList();
		ReservedList reservedList = new ReservedList();

		MyTextFileIO mtfio = new MyTextFileIO();
		String[] vehicleArray = null;
		try {
			vehicleArray = mtfio.readArrayFromFile("all_vehicles_file.txt");

			for (int i = 0; i < vehicleArray.length; i++) {
				String temp = vehicleArray[i];
				String[] tempArr = temp.split(",");

				String regNo = tempArr[0];
				String type = tempArr[1];
				String make = tempArr[2];
				String model = tempArr[3];
				int year = Integer.parseInt(tempArr[4]);
				String color = tempArr[5];
				int seats = Integer.parseInt(tempArr[6]);
				int drivenKm = Integer.parseInt(tempArr[7]);
				int load = Integer.parseInt(tempArr[8]);
				boolean service = Boolean.parseBoolean(tempArr[9]);

				Vehicle vehicle = new Vehicle(regNo, type, make, model, year, color, seats, drivenKm, load, service);
				vehicles.add(vehicle);
				Reserved reserved = new Reserved(vehicle, i, new TheTime(16, 3, 2016), new TheTime(17, 3, 2016),
						"horsens", "aarhus", "maria", "chifor", 100, 1000);
				reservedList.add(reserved);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File was not found, or could not be opened");
		}

		MyFileIO mfio = new MyFileIO();
		MyFileIO mfio1 = new MyFileIO();

		try {
			mfio.writeToFile("vehicles.bin", vehicles);
			mfio1.writeToFile("reservedList.bin", reservedList);
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file ");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Error writing to file ");
		}

		System.out.println("Done");
	}
}