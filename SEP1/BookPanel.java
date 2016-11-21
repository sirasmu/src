package SEP1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.LineBorder;

import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.Vehicle;
import sdj2.model.VehicleList;
import sdj2.model.date.TheTime;
import sdj2.model.utility.RentFileAdapter;

/**
 * A class representing a tab for booking a vehicle. It is a GUI panel
 * containing components for displaying a list of vehicles available for
 * booking. The BookPanel contains sections for selecting the required
 * parameters of the vehicles to display.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 14.0
 * @date 01-06-2016
 */
public class BookPanel extends JPanel {

	// ########### methods variables #########
	String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

	String[] months = { "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };

	String[] years = { "2016", "2017" };

	String[] locations = { "Horsens", "Aarhus" };

	private String NoneSelector;
	private TheTime SDate;
	private TheTime EDate;
	private Rent toSave;
	private double estimatePriceDouble;
	
   private int thisDay;
   private int thisMonth;
   private int thisYear;
   private boolean preventDoubleConfing;
   
	// ########### GUI variables #############

	private VehicleFileAdapter vehicleAdapter;
	private RentFileAdapter rentAdapter;
	private MyButtonListener buttonListener;

	// private JTextArea allVehicleArea;
	private JScrollPane allVehicleScrollPane;

	private RentList rents;
	private VehicleList vehicles;

	private JPanel box1;
	private JPanel box2;
	private JPanel box3;
	private JPanel box4;
	private JPanel box4Line1;
	private JPanel box4Line2;
	private JPanel box4Line3;
	private JPanel box45;
	private JPanel box5;
	private JPanel TopBookPanel;
	private JPanel typePanel;
	private JPanel timePanel;
	private JPanel dropPanel;
	private JPanel pickPanel;

	private JLabel pickLine;
	private JLabel dropLine;

	private JLabel pickPlaceLine;
	private JLabel dropPlaceLine;

	private JLabel estimateKmLine;
	private JLabel estimatePrice;
	private JLabel spaceBetweenEst1;
	private JLabel spaceBetweenEst2;
	private JButton searchButton1;
	private JTextField estimateKmText;
	private JTextField estimatePriceText;

	private JLabel Filter;

	private JRadioButton rType1;
	private JRadioButton rType2;
	private JRadioButton rType3;
	private JRadioButton rType4;

	private JLabel makeLabel;
	private JLabel modelLabel;
	private JLabel yearLabel;
	private JLabel colorLabel;
	private JLabel seatsLabel;
	private JLabel loadLabel;

	JComboBox<String> dayBox1;
	JComboBox<String> monthBox1;
	JComboBox<String> yearBox1;
	JComboBox<String> locationBox1;

	JComboBox<String> dayBox2;
	JComboBox<String> monthBox2;
	JComboBox<String> yearBox2;
	JComboBox<String> locationBox2;
	int dateBoxBorder = 2;

	JComboBox<String> makeBox;
	JComboBox<String> modelBox;
	JComboBox<String> yearBox;
	JComboBox<String> colorBox;
	JComboBox<String> seatsBox;
	JComboBox<String> loadBox;

	private JButton searchButton2;
	private JLabel box4Line3Space;

	private JLabel spaceBox45;

	private JButton finalConfirm;
	private JLabel spaceBox5;
	private JLabel space2Box5;

	private JList listArea;
	private DefaultListModel listModel;
	private JScrollPane scrollPane;

	private JOptionPane input;

	String pickUpDate = "Pick up date: ";
	String returnDate = "Return date:  ";
	String space = "                                      ";
	String dash = "--------------------------";

	/**
	 * Two-argument constructor initializing the GUI components.
	 * 
	 * @param vehicleAdapter
	 *            VehicleFileAdapter object used for retrieving and storing
	 *            vehicle information
	 * @param rentAdapter
	 *            RentFileAdapter object for retrieving and rent information
	 */
	public BookPanel(VehicleFileAdapter vehicleAdapter,
			RentFileAdapter rentAdapter) {
	   
      // ############## create current date
      GregorianCalendar now = new GregorianCalendar(); // importing the
      // Gregorian Calendar for
      // today's date
	   
	   thisDay = now.get(GregorianCalendar.DATE);
	   thisMonth = now.get(GregorianCalendar.MONTH) + 1;
	   thisYear = now.get(GregorianCalendar.YEAR);
	   preventDoubleConfing = true;
	   
		this.rentAdapter = rentAdapter;
		this.vehicleAdapter = vehicleAdapter;
		buttonListener = new MyButtonListener();
		pickUpDate = space + pickUpDate;
		returnDate = space + returnDate;

		// ################ Colors ################################
		Color col1 = new Color(100, 100, 255);
		Color grey = new Color(238, 238, 238);
		Color white = new Color(255, 255, 255);
		col1 = grey;

		// ################ Box 1 #################################
		box1 = new JPanel();
		box1.setLayout(new BoxLayout(box1, BoxLayout.X_AXIS));

		// ################ Box 2 #################################
		box2 = new JPanel();
		box2.setLayout(new BoxLayout(box2, BoxLayout.X_AXIS));
		box2.setBorder(new LineBorder(col1, 10));

		// ################ Box 3 #################################
		box3 = new JPanel();
		box3.setLayout(new BoxLayout(box3, BoxLayout.X_AXIS));
		box3.setBorder(new LineBorder(col1, 10));

		// ################ Box 4 #################################
		box4 = new JPanel();
		box4.setLayout(new BoxLayout(box4, BoxLayout.Y_AXIS));

		box4Line1 = new JPanel();
		box4Line1.setLayout(new BoxLayout(box4Line1, BoxLayout.X_AXIS));

		box4Line2 = new JPanel();
		box4Line2.setLayout(new BoxLayout(box4Line2, BoxLayout.X_AXIS));

		box4Line3 = new JPanel();
		box4Line3.setLayout(new BoxLayout(box4Line3, BoxLayout.X_AXIS));

		// ############# Box4Line1 #############################
		makeLabel = new JLabel("  Make:");
		makeBox = new JComboBox<String>();
		makeBox.setBorder(new LineBorder(col1, 5));
		makeBox.addActionListener(buttonListener);

		modelLabel = new JLabel(space + "Model:");
		modelBox = new JComboBox<String>();
		modelBox.setBorder(new LineBorder(col1, 5));
		modelBox.addActionListener(buttonListener);

		yearLabel = new JLabel(space + "Year:");
		yearBox = new JComboBox<String>();
		yearBox.setBorder(new LineBorder(col1, 5));
		yearBox.addActionListener(buttonListener);

		box4Line1.add(makeLabel);
		box4Line1.add(makeBox);
		box4Line1.add(modelLabel);
		box4Line1.add(modelBox);
		box4Line1.add(yearLabel);
		box4Line1.add(yearBox);

		// ############# Box4Line2 #############################
		colorLabel = new JLabel("  Color:");
		colorBox = new JComboBox<String>();
		colorBox.setBorder(new LineBorder(col1, 5));
		colorBox.addActionListener(buttonListener);

		seatsLabel = new JLabel(space + "Seats: ");
		seatsBox = new JComboBox<String>();
		seatsBox.setBorder(new LineBorder(col1, 5));
		seatsBox.addActionListener(buttonListener);

		loadLabel = new JLabel(space + "Load:");
		loadBox = new JComboBox<String>();
		loadBox.setBorder(new LineBorder(col1, 5));
		loadBox.addActionListener(buttonListener);

		box4Line2.add(colorLabel);
		box4Line2.add(colorBox);
		box4Line2.add(seatsLabel);
		box4Line2.add(seatsBox);
		box4Line2.add(loadLabel);
		box4Line2.add(loadBox);

		// ############# Box4Line3 #############################
		box4Line3Space = new JLabel(space + space + space + space + space);
		box4Line3Space.setBorder(new LineBorder(col1, 11));
		searchButton2 = new JButton("Search");
		searchButton2.addActionListener(buttonListener);

		box4Line3.add(box4Line3Space);
		box4Line3.add(searchButton2);
		spaceBox5 = new JLabel(space);

		// ################ Box 4.5 ##############################
		box45 = new JPanel();
		box45.setLayout(new BoxLayout(box45, BoxLayout.X_AXIS));
		spaceBox45 = new JLabel(space + space + space + space);

		box45.add(spaceBox45);

		// ################ Box 5 #################################
		box5 = new JPanel();
		box5.setLayout(new BoxLayout(box5, BoxLayout.X_AXIS));

		finalConfirm = new JButton("Confirm");
		spaceBox5 = new JLabel(space + space + space + space + space + "   ");
		space2Box5 = new JLabel("   ");
		finalConfirm.addActionListener(buttonListener);

		box5.add(spaceBox5);
		box5.add(space2Box5);
		box5.add(finalConfirm);

		// ############## topBookPanel ############################
		TopBookPanel = new JPanel();
		TopBookPanel.setLayout(new BoxLayout(TopBookPanel, BoxLayout.Y_AXIS));

		// ################ Time & Place Panel Pick #########################
		pickPanel = new JPanel();
		pickPanel.setLayout(new BoxLayout(pickPanel, BoxLayout.X_AXIS));
		pickPanel.setBorder(new LineBorder(col1, 6));

		pickLine = new JLabel(pickUpDate);
		dayBox1 = new JComboBox<String>(days);
		dayBox1.setBorder(new LineBorder(col1, dateBoxBorder));
		monthBox1 = new JComboBox<String>(months);
		monthBox1.setBorder(new LineBorder(col1, dateBoxBorder));
		yearBox1 = new JComboBox<String>(years);
		yearBox1.setBorder(new LineBorder(col1, dateBoxBorder));

		pickPanel.add(pickLine);
		pickPanel.add(dayBox1);
		pickPanel.add(monthBox1);
		pickPanel.add(yearBox1);

		pickPlaceLine = new JLabel("Pick up place: ");
		pickPlaceLine.setBorder(new LineBorder(col1, dateBoxBorder));
		locationBox1 = new JComboBox<String>(locations);

		pickPanel.add(pickPlaceLine);
		pickPanel.add(locationBox1);
		// ################ Time & Place Panel Drop #########################
		dropPanel = new JPanel();
		dropPanel.setLayout(new BoxLayout(dropPanel, BoxLayout.X_AXIS));
		dropPanel.setBorder(new LineBorder(col1, 6));

		dropLine = new JLabel(returnDate);
		dayBox2 = new JComboBox<String>(days);
		dayBox2.setBorder(new LineBorder(col1, dateBoxBorder));
		monthBox2 = new JComboBox<String>(months);
		monthBox2.setBorder(new LineBorder(col1, dateBoxBorder));
		yearBox2 = new JComboBox<String>(years);
		yearBox2.setBorder(new LineBorder(col1, dateBoxBorder));

		dropPanel.add(dropLine);
		dropPanel.add(dayBox2);
		dropPanel.add(monthBox2);
		dropPanel.add(yearBox2);

		dropPlaceLine = new JLabel("Drop place:     ");
		dropPlaceLine.setBorder(new LineBorder(col1, dateBoxBorder));
		locationBox2 = new JComboBox<String>(locations);

		dropPanel.add(dropPlaceLine);
		dropPanel.add(locationBox2);

		// ################ Time Panel ##############################
		timePanel = new JPanel();
		timePanel.setBorder(new LineBorder(col1, 5));
		timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));

		timePanel.add(pickPanel);
		timePanel.add(dropPanel);

		// ################ Type Panel ##############################
		typePanel = new JPanel();
		typePanel.setBorder(new LineBorder(col1, 2));
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));

		rType1 = new JRadioButton("Car", true);
		typePanel.add(rType1);

		rType2 = new JRadioButton("Van");
		typePanel.add(rType2);

		rType3 = new JRadioButton("Camper");
		typePanel.add(rType3);

		rType4 = new JRadioButton("Truck");
		typePanel.add(rType4);

		ButtonGroup group = new ButtonGroup();
		group.add(rType1);
		group.add(rType2);
		group.add(rType3);
		group.add(rType4);
		// ################ Box2 includes ####################
		estimateKmText = new JTextField(3);
		estimatePriceText = new JTextField(2);
		estimatePriceText.setEditable(false);
		spaceBetweenEst2 = new JLabel(space + space + "   ");
		spaceBetweenEst1 = new JLabel("    ");
		estimateKmLine = new JLabel("Estimate km: ");
		estimatePrice = new JLabel("Estimate price: ");
		searchButton1 = new JButton("Search");
		searchButton1.addActionListener(buttonListener);
		estimatePriceText.setBorder(new LineBorder(col1, 1));

		// ################ Filter label box #####################
		Filter = new JLabel("----------" + " Filters " + dash + dash + dash
				+ dash + dash + "--------------");
		// Filter.setBorder(new LineBorder(col1, 5));
		box3.add(Filter);

		// ################ Vehicle area ##########################
		listModel = new DefaultListModel<Vehicle>();
		listArea = new JList<Vehicle>(listModel);
		listArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listArea.setVisibleRowCount(15);
		scrollPane = new JScrollPane(listArea);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// ################ Adders ###########################
		box1.add(typePanel);
		box1.add(timePanel);

		box2.add(estimateKmLine);
		box2.add(estimateKmText);
		box2.add(spaceBetweenEst1);
		box2.add(estimatePrice);
		box2.add(estimatePriceText);
		box2.add(spaceBetweenEst2);

		box2.add(searchButton1);

		box4.add(box4Line1);
		box4.add(box4Line2);
		box4.add(box4Line3);

		TopBookPanel.add(box1);
		TopBookPanel.add(box2);
		TopBookPanel.add(box3);
		TopBookPanel.add(box4);
		TopBookPanel.add(scrollPane);
		TopBookPanel.add(box45);
		TopBookPanel.add(box5);

		NoneSelector = "   ";
		this.addNoneSelector(NoneSelector);

		add(TopBookPanel);
		
		//################## set boxes to current date
		if (preventDoubleConfing)
		{
		   dayBox1.setSelectedIndex(thisDay - 1);
		   monthBox1.setSelectedIndex(thisMonth - 1);
		   yearBox1.setSelectedIndex(thisYear - 2016);
      
		   dayBox2.setSelectedIndex(thisDay - 1);
		   monthBox2.setSelectedIndex(thisMonth - 1);
		   yearBox2.setSelectedIndex(thisYear - 2016);
		   
		   preventDoubleConfing = false;
		}
	}

	/**
	 * A method for updating the list area. The method takes a VehicleList
	 * object and updates the listArea JList so it contains the VehicleList
	 * objects.
	 * 
	 * @param list
	 *            a VehicleList object
	 */
	public void update(VehicleList list) {
		listModel.removeAllElements();

		for (int i = 0; i < list.size(); i++) {
			listModel.addElement(list.get(i));
		}
		listArea.setModel(listModel);

	}

	/**
	 * Adding none options for all filter drop boxes that are in second stage of
	 * vehicle filtering. Used for adding a default selector for selecting
	 * nothing.
	 * 
	 * @param nameOfNoneSelector
	 *            the name that the none selector will be given. The name should
	 *            either be blank or describe the drop box
	 */
	public void addNoneSelector(String nameOfNoneSelector) {
		makeBox.addItem(nameOfNoneSelector);
		modelBox.addItem(nameOfNoneSelector);
		yearBox.addItem(nameOfNoneSelector);
		colorBox.addItem(nameOfNoneSelector);
		seatsBox.addItem(nameOfNoneSelector);
		loadBox.addItem(nameOfNoneSelector);
	}

	/**
	 * Deletes all selectors in car filters options adds NoneSelector to every
	 * car filter menu
	 * 
	 * @param nameOfNoneSelector
	 *            the name that the none selector will be given. The name should
	 *            either be blank or describe the drop box
	 */
	public void resetsSelector(String nameOfNoneSelector) {
		makeBox.removeAllItems();
		modelBox.removeAllItems();
		yearBox.removeAllItems();
		colorBox.removeAllItems();
		seatsBox.removeAllItems();
		loadBox.removeAllItems();

		addNoneSelector(nameOfNoneSelector);
	}

	/**
	 * A method for checking if a String is already exists inside an ArrayList.
	 * Used for avoiding duplicates of items.
	 * 
	 * @param list
	 *            a ArrayList of Strings
	 * @param item
	 *            a String of a item in the drop box
	 * @return true if the list contains a String equal to the item String.
	 */
	public boolean isInside(ArrayList<String> list, String item) {
		if (list == null) {
			return false;
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(item)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Fills search filter drop box menus with updated options.
	 * 
	 * @param vehicles
	 *            the VehicleList of Vehicle objects to add to drop box
	 * @param nameOfNoneSelector
	 *            the name that the none selector will be given. The name should
	 *            either be blank or describe the drop box
	 */
	public void addItemToBoxes(VehicleList vehicles, String nameOfNoneSelector) {
		String[] vehicleItems;

		resetsSelector(nameOfNoneSelector); // remove all items from boxes and
											// add a selector for nothing to
											// each box

		if (vehicles.size() != 0) {

			ArrayList<String> modelArray = new ArrayList<String>();
			ArrayList<String> makeArray = new ArrayList<String>();
			ArrayList<String> yearArray = new ArrayList<String>();
			ArrayList<String> colorArray = new ArrayList<String>();
			ArrayList<String> seatsArray = new ArrayList<String>();
			ArrayList<String> loadArray = new ArrayList<String>();

			for (int i = 0; i < vehicles.size(); i++) {
				vehicleItems = vehicles.get(i).toString().split(",");

				if (!(isInside(modelArray, vehicleItems[3]))) {
					modelArray.add(vehicleItems[3]);
				}

				if (!(isInside(makeArray, vehicleItems[2]))) {
					makeArray.add(vehicleItems[2]);
				}

				if (!(isInside(yearArray, vehicleItems[4]))) {
					yearArray.add(vehicleItems[4]);
				}

				if (!(isInside(colorArray, vehicleItems[5]))) {
					colorArray.add(vehicleItems[5]);
				}

				if (!(isInside(seatsArray, vehicleItems[6]))) {
					seatsArray.add(vehicleItems[6]);
				}

				if (!(isInside(loadArray, vehicleItems[8]))) {
					loadArray.add(vehicleItems[8]);
				}

			}

			for (int a = 0; a < modelArray.size(); a++) {
				modelBox.addItem(modelArray.get(a));
			}

			for (int b = 0; b < makeArray.size(); b++) {
				makeBox.addItem(makeArray.get(b));
			}

			for (int c = 0; c < yearArray.size(); c++) {
				yearBox.addItem(yearArray.get(c));
			}

			for (int d = 0; d < colorArray.size(); d++) {
				colorBox.addItem(colorArray.get(d));
			}

			for (int e = 0; e < seatsArray.size(); e++) {
				seatsBox.addItem(seatsArray.get(e));
			}

			for (int f = 0; f < loadArray.size(); f++) {
				loadBox.addItem(loadArray.get(f));
			}

		} else {
			System.out.println("empty field");
		}
	}

	/**
	 * Get the String of the nameOfNoneSelector.
	 * 
	 * @return nameOfNoneSelector String
	 */
	public String getNoneSelector() {
		return NoneSelector;
	}

	/**
	 * Apply the selected filters to return a VehicleList of Vehicle objects
	 * fulfilling the selected parameters.
	 * 
	 * @param vehicles
	 *            the VehicleList object to apply the filters to
	 * @return VehicleList object containing vehicles that has been sorting
	 *         according to the applied filters.
	 */
	public VehicleList ApplyFilters(VehicleList vehicles) {
		vehicles = vehicleAdapter.filterByMake(vehicles,
				(String) makeBox.getSelectedItem(), getNoneSelector());
		vehicles = vehicleAdapter.filterByModel(vehicles,
				(String) modelBox.getSelectedItem(), getNoneSelector());
		vehicles = vehicleAdapter.filterByYear(vehicles,
				(String) yearBox.getSelectedItem(), getNoneSelector());
		vehicles = vehicleAdapter.filterByColor(vehicles,
				(String) colorBox.getSelectedItem(), getNoneSelector());
		vehicles = vehicleAdapter.filterBySeats(vehicles,
				(String) seatsBox.getSelectedItem(), getNoneSelector());
		vehicles = vehicleAdapter.filterByLoad(vehicles,
				(String) loadBox.getSelectedItem(), getNoneSelector());
		addItemToBoxes(vehicles, getNoneSelector());
		return vehicles;
	}

	/**
	 * A method for calculating the price of the rental, according to the
	 * renting period.
	 *
	 * @param estKm
	 *            the estimate amount of kilometers the client will drive
	 * @param pickUpTime
	 *            the time the vehicle will be picked up
	 * @param returnTime
	 *            the time the vehicle will be returned
	 * @return the calculated price for renting a vehicle
	 */
	public double discount(int estKm, TheTime pickUpTime, TheTime returnTime) {
		double oneday = 100; // price per day
		double discount = 0;

		if (estKm <= 100) {
			estKm = 0;
		}

		TheTime temp2 = pickUpTime.copy();

		int days = 1;
		while (!temp2.equals(returnTime)) {
			temp2.nextDay();
			days++;
		}
		discount = (oneday * 0.7) * (days - 1);
		discount += estKm;
		discount += oneday;
		return discount;
	}

	/*
	 * Inner action listener class
	 * 
	 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
	 * Rasmussen)
	 * 
	 * @version 14.0
	 */
	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == searchButton1) {
				String selectedSday = (String) dayBox1.getSelectedItem();
				String selectedEday = (String) dayBox2.getSelectedItem();

				String selectedSmonth = (String) monthBox1.getSelectedItem();
				String selectedEmonth = (String) monthBox2.getSelectedItem();

				String selectedSyear = (String) yearBox1.getSelectedItem();
				String selectedEyear = (String) yearBox2.getSelectedItem();

				String selectedEstKm = (String) estimateKmText.getText();
				int estimatedKmInt;
				double estimatePrice;

				try // exception handler for "bad" estimated Km input
				{
					if (selectedEstKm.equals("")) {
						estimatedKmInt = 0;
					} else {
						estimatedKmInt = Integer.parseInt(selectedEstKm);
					}
				} catch (NumberFormatException f) {
					JOptionPane.showMessageDialog(null,
							"Estimated km must be a number!",
							"Warning message", JOptionPane.WARNING_MESSAGE);
					return;
				}

				String type = "";

				if (rType1.isSelected()) {
					type = "Car";
				}

				else if (rType2.isSelected()) {
					type = "Van";
				}

				else if (rType3.isSelected()) {
					type = "Camper";
				}

				else if (rType4.isSelected()) {
					type = "Truck";
				}

				// ############### methods for search 1 ########################
				SDate = new TheTime(selectedSday, selectedSmonth, selectedSyear);
				EDate = new TheTime(selectedEday, selectedEmonth, selectedEyear);
				
				if (!(SDate.isBefore(EDate))) {
					JOptionPane.showMessageDialog(null,
							"Pick up date must be before return date",
							"Warning message", JOptionPane.WARNING_MESSAGE);
					return;
				} 

	         TheTime thisDate = new TheTime(thisDay, thisMonth, thisYear);
	         
	         if (!(thisDate.isBefore(SDate)) || !(thisDate.isBefore(EDate)))
	         {
	            JOptionPane.showMessageDialog(null,
	                  "Both pickup and return dates must be after current date",
	                  "Warning message", JOptionPane.WARNING_MESSAGE);
	            return;
	         }
	         
				estimatePriceDouble = discount(estimatedKmInt, SDate, EDate);
				estimatePriceText.setText(estimatePriceDouble + "");
	         
				vehicles = vehicleAdapter.getAllVehicles();
				vehicles = rentAdapter.timeIsAvailable(vehicles, SDate, EDate);
				vehicles = vehicleAdapter.filterByType(vehicles, type,
						NoneSelector);
				update(vehicles);
				addItemToBoxes(vehicles, getNoneSelector());
			}

			if (e.getSource() == searchButton2 && vehicles != null) {
				vehicles = ApplyFilters(vehicles);
				update(vehicles);

			}

			if (e.getSource() == finalConfirm) {
				String selectPickUp = (String) locationBox1.getSelectedItem();
				String selectDrop = (String) locationBox2.getSelectedItem();

				Vehicle selectedVehicle;
				selectedVehicle = (Vehicle) listArea.getSelectedValue();

				if (selectedVehicle == null) {
					return;
				}

				
				BookConfirm confirm = new BookConfirm(rentAdapter,
						selectedVehicle, SDate, EDate, selectPickUp,
						selectDrop, selectedVehicle.getDrivenKm(),
						estimatePriceDouble);
			}

		}
	}

}
