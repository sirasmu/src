package SEP1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.Vehicle;
import sdj2.model.date.TheTime;
import sdj2.model.utility.RentFileAdapter;

/**
 * A class representing pop-up window for confirming booking.
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 14.0
 * @date 01-06-2016
 */
public class BookConfirm extends JFrame {
	private JFrame ConfirmFrame;
	private RentFileAdapter rentAdapter;
	private MyButtonListener buttonListener;


	private JPanel MainBox;

	private ImageIcon carPicture;
	private JLabel PictureBox;

	private JPanel BasicInfoBox;
	private JPanel BasicInfoBox1;

	private JPanel BasicInfoBox1Left;
	private JLabel makeLabel;
	private JLabel modelLabel;
	private JLabel yearLabel;

	private JPanel BasicInfoBox1Right;
	private JLabel colorLabel;
	private JLabel seatsLabel;
	private JLabel loadLabel;

	private JPanel BasicInfoBox2; // holds regNo dates place and priceKm

	private JLabel RegNoLabel;
	private JLabel EmptyLabel;
	private JLabel DatesLabel;
	private JLabel PlaceLabel;
	private JLabel PriceKmLabel;
	private JLabel ResNoLabel;

	private JLabel firstNameLabel;
	private JTextField firstNameText;
	private JLabel firstNameSpace;
	private JPanel firstNameBox;

	private JLabel lastNameLabel;
	private JTextField lastNameText;
	private JLabel lastNameSpace;
	private JPanel lastNameBox;

	private JPanel BasicInfoBox3; // holds name and buttons

	private JPanel ButtonBox;
	private JLabel spaceBetween1;
	private JButton confirmButton;
	private JLabel spaceBetween2;
	private JButton exitButton;

	private Vehicle vehicle;
	private TheTime SDate;
	private TheTime EDate;
	private String PickUpPlace;
	private String DropPlace;
	private int estimateKm;
	private double estimatePrice;
	private int resNo;

	/**
	 * Eight-arg constructor for initializing GUI components.
	 * 
	 * @param rentAdapter
	 *            RentFileAdapter object for retrieving and rent information
	 * @param vehicle the chosen vehicle
	 * @param SDate the pick-up date
	 * @param EDate the return date
	 * @param PickUpPlace the pick up place
	 * @param DropPlace the return place
	 * @param estimateKm the estimated kilometers the client will drive
	 * @param estimatePrice the estimated price of the rent
	 */
	public BookConfirm(RentFileAdapter rentAdapter, Vehicle vehicle,
			TheTime SDate, TheTime EDate, String PickUpPlace, String DropPlace,
			int estimateKm, double estimatePrice) {
		this.rentAdapter = rentAdapter;
		buttonListener = new MyButtonListener();

		this.vehicle = vehicle;
		this.SDate = SDate;
		this.EDate = EDate;
		this.PickUpPlace = PickUpPlace;
		this.DropPlace = DropPlace;
		this.estimateKm = estimateKm;
		this.estimatePrice = estimatePrice;

		// ################ Choose Picture ########################
		String carPictureLocation;
		carPictureLocation = "img/" + vehicle.getModel() + ".jpg";

		// ################ Colors ################################
		Color col1 = new Color(100, 100, 255);
		Color grey = new Color(238, 238, 238);
		Color white = new Color(255, 255, 255);
		col1 = grey;

		// ################ Window layout ##########################
		ConfirmFrame = new JFrame("Book Confirmation");
		ConfirmFrame.setSize(450, 630);
		ConfirmFrame.setVisible(true);
		ConfirmFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ConfirmFrame.setLocationRelativeTo(null);
		ConfirmFrame.setResizable(false);

		MainBox = new JPanel();
		MainBox.setLayout(new GridLayout(2, 2, 10, 10));

		// ################ Picture Box #############################
		carPicture = new ImageIcon(carPictureLocation);
		PictureBox = new JLabel(carPicture);
		PictureBox.setPreferredSize(new Dimension(400, 350));
		PictureBox.setBorder(new LineBorder(col1, 15));

		// ################ Basic Info ##############################
		BasicInfoBox = new JPanel();
		BasicInfoBox.setLayout(new GridLayout(3, 2, 0, 0));

		BasicInfoBox1 = new JPanel();
		BasicInfoBox1.setLayout(new BoxLayout(BasicInfoBox1, BoxLayout.X_AXIS));

		BasicInfoBox1Left = new JPanel();
		BasicInfoBox1Left.setLayout(new BoxLayout(BasicInfoBox1Left,
				BoxLayout.Y_AXIS));

		BasicInfoBox1Right = new JPanel();
		BasicInfoBox1Right.setLayout(new BoxLayout(BasicInfoBox1Right,
				BoxLayout.Y_AXIS));

		// ############# BasicInfoBox1Left #######################
		String make;
		String model;
		String year;
		String BInfSpace1 = "";

		make = BInfSpace1 + "Make: ";
		make += vehicle.getMake();

		model = BInfSpace1 + "Model: ";
		model += vehicle.getModel();

		year = BInfSpace1 + "Year: ";
		year += vehicle.getYear();

		makeLabel = new JLabel(make);
		BasicInfoBox1Left.add(makeLabel);
		modelLabel = new JLabel(model);
		BasicInfoBox1Left.add(modelLabel);
		yearLabel = new JLabel(year);
		BasicInfoBox1Left.add(yearLabel);
		BasicInfoBox1Left.setBorder(new LineBorder(col1, 10));

		BasicInfoBox1.add(BasicInfoBox1Left);
		// ############# BasicInfoBox1Right ######################
		String color;
		String seats;
		String load;
		String BInfSpace2 = "         ";
		String BInfSpace3 = "                                                           ";

		color = BInfSpace2 + "Color: ";
		color += vehicle.getColor();
		color += BInfSpace3;

		seats = BInfSpace2 + "Seats: ";
		seats += vehicle.getSeats();
		seats += BInfSpace3;

		if (vehicle.getLoad() != 0) {
			load = BInfSpace2 + "Load: ";
			load += vehicle.getLoad();
			load += BInfSpace3;
		} else {
			load = "    ";
		}

		colorLabel = new JLabel(color);
		BasicInfoBox1Right.add(colorLabel);
		seatsLabel = new JLabel(seats);
		BasicInfoBox1Right.add(seatsLabel);
		loadLabel = new JLabel(load);
		BasicInfoBox1Right.add(loadLabel);
		BasicInfoBox1Right.setBorder(new LineBorder(col1, 10));

		BasicInfoBox1.add(BasicInfoBox1Right);
		// ################ Registration No plus empty label
		// ########################
		String RegNo;
		RegNo = "   Car registration number:     ";
		RegNo += vehicle.getRegNo();

		RegNoLabel = new JLabel(RegNo);
		EmptyLabel = new JLabel("        ");

		// ################ Dates ###################################
		String Dates;
		Dates = "   Starting day: ";
		Dates += SDate.toString();
		Dates += "          Ending day: ";
		Dates += EDate.toString();

		DatesLabel = new JLabel(Dates);

		// ################ Places ###################################
		String Place;
		Place = "   Pick up place: ";
		Place += PickUpPlace;
		Place += "        Drop place: ";
		Place += DropPlace;

		PlaceLabel = new JLabel(Place);

		// ################ Estimated Km and Price
		// ###################################
		String EstKmAndPrice;
		estimateKm %= 20000;
		estimateKm = 20000 - estimateKm;

		EstKmAndPrice = "   Estimated price: ";
		EstKmAndPrice += estimatePrice;
		EstKmAndPrice += "         Km before service needed: ";
		EstKmAndPrice += estimateKm;

		PriceKmLabel = new JLabel(EstKmAndPrice);

		// ################ Reservation number
		// #####################################
		resNo = generateResNo();

		ResNoLabel = new JLabel("   Reservation number:  " + resNo);

		// ################ Basic InfoBox2 ##############################
		BasicInfoBox2 = new JPanel();
		BasicInfoBox2.setLayout(new GridLayout(6, 2, 0, 0));

		BasicInfoBox2.add(RegNoLabel);
		BasicInfoBox2.add(EmptyLabel);
		BasicInfoBox2.add(DatesLabel);
		BasicInfoBox2.add(PlaceLabel);
		BasicInfoBox2.add(PriceKmLabel);
		BasicInfoBox2.add(ResNoLabel);

		// ################ NameArea #####################################
		firstNameBox = new JPanel();
		firstNameBox.setLayout(new BoxLayout(firstNameBox, BoxLayout.X_AXIS));
		lastNameBox = new JPanel();
		lastNameBox.setLayout(new BoxLayout(lastNameBox, BoxLayout.X_AXIS));

		firstNameLabel = new JLabel("   First name: ");
		lastNameLabel = new JLabel("   Last name: ");

		firstNameText = new JTextField(3);
		firstNameText.setBorder(new LineBorder(col1, 4));
		lastNameText = new JTextField(3);
		lastNameText.setBorder(new LineBorder(col1, 4));

		firstNameSpace = new JLabel(
				"                                                              ");
		lastNameSpace = new JLabel(
				"                                                              ");

		firstNameBox.add(firstNameLabel);
		firstNameBox.add(firstNameText);
		firstNameBox.add(firstNameSpace);

		lastNameBox.add(lastNameLabel);
		lastNameBox.add(lastNameText);
		lastNameBox.add(lastNameSpace);

		// ################ Button Area #################################
		ButtonBox = new JPanel();
		ButtonBox.setLayout(new BoxLayout(ButtonBox, BoxLayout.X_AXIS));

		spaceBetween1 = new JLabel(
				"                                                  ");
		spaceBetween2 = new JLabel("   ");
		confirmButton = new JButton("Confirm Booking");
		exitButton = new JButton("Discard Booking");

		confirmButton.addActionListener(buttonListener);
		exitButton.addActionListener(buttonListener);

		ButtonBox.add(spaceBetween1);
		ButtonBox.add(exitButton);
		ButtonBox.add(spaceBetween2);
		ButtonBox.add(confirmButton);

		// ################ Basic InfoBox3 ##############################
		BasicInfoBox3 = new JPanel();
		BasicInfoBox3.setLayout(new GridLayout(3, 2, 0, 0));

		BasicInfoBox3.add(firstNameBox);
		BasicInfoBox3.add(lastNameBox);
		BasicInfoBox3.add(ButtonBox);

		// ################ Adders ################################ /resNo
		BasicInfoBox.add(BasicInfoBox1);
		BasicInfoBox.add(BasicInfoBox2);
		BasicInfoBox.add(BasicInfoBox3);

		MainBox.add(PictureBox);
		MainBox.add(BasicInfoBox);

		ConfirmFrame.add(MainBox);

		KeyListener listener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmAction();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		};
		exitButton.addKeyListener(listener);
		confirmButton.addKeyListener(listener);
		firstNameText.addKeyListener(listener);
		lastNameText.addKeyListener(listener);
	}
	
	/**
	 * Generate new reservation number-
	 * 
	 * @return the reservation number that the booking will be identified with
	 */
	public int generateResNo() {
		int resNo;
		RentList list = new RentList();

		list = rentAdapter.getAllRents();
		resNo = list.size();

		return resNo;
	}
	
	/**
	 * Method for confirming and saving the information of the booking.
	 */
	public void confirmAction()  {
		String firstName;
		String lastName;

		firstName = firstNameText.getText();
		lastName = lastNameText.getText();

		if (firstName.equals("")) {
			JOptionPane.showMessageDialog(null, "fill first name field",
					"Warning message", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (lastName.equals("")) {
			JOptionPane.showMessageDialog(null, "fill last name field",
					"Warning message", JOptionPane.WARNING_MESSAGE);
			return;
		}

		RentList listOfRents = rentAdapter.getAllRents();
		Rent rent = new Rent(vehicle, resNo, SDate, EDate, PickUpPlace,
				DropPlace, firstName, lastName, estimateKm, estimatePrice);

		if (listOfRents == null) {
			listOfRents = new RentList();
			listOfRents.addRent(rent);
			rentAdapter.saveRents(listOfRents);
			ConfirmFrame.dispatchEvent(new WindowEvent(ConfirmFrame,
					WindowEvent.WINDOW_CLOSING));
			return;
		}

		listOfRents.addRent(rent);
		rentAdapter.saveRents(listOfRents);
		ConfirmFrame.dispatchEvent(new WindowEvent(ConfirmFrame,
				WindowEvent.WINDOW_CLOSING));

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
			if (e.getSource() == confirmButton) {
				confirmAction();
			}

			if (e.getSource() == exitButton) {
				ConfirmFrame.dispatchEvent(new WindowEvent(ConfirmFrame,
						WindowEvent.WINDOW_CLOSING));

			}
		}
	}
}