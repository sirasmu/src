package SEP1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/**
 * A GUI panel containing all the information from the booking and rent panels
 * with extra information about the car condition and return time and date
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */

public class ReturnPanel extends JPanel
{
   private RentFileAdapter returnAdapter;
   private VehicleFileAdapter vehicleAdapter;
   private MyButtonListener buttonListener;
   public Rent LastFoundRent;

   private JPanel boxPanel;
   private JPanel headerPanel;
   private JPanel box1;
   private JPanel box2;
   private JPanel box3;

   private JPanel mainPanel;

   private JPanel clientPanel;
   private JPanel carPanel;
   private JPanel updatePanel;
   private JPanel realDatePanel;
   private JPanel realDrivenKmPanel;
   private JPanel realPricePanel;
   private JPanel middlePanel;

   private JPanel footerPanel;
   private JPanel buttonsPanel;

   private JLabel headerLabel;

   private JLabel reservationNoLabel;
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel driverLicenceLabel;
   private JLabel phoneNoLabel;
   private JLabel estimatePriceLabel; 

   private JLabel regNoLabel;
   private JLabel typeLabel;
   private JLabel makeLabel;
   private JLabel modelLabel;
   private JLabel yearLabel;
   private JLabel colorLabel;
   private JLabel seatsLabel;
   private JLabel drivenKmLabel;
   private JLabel loadLabel;

   private JLabel realDateLabel;
   private JLabel realDrivenKmLabel;
   private JLabel realPriceLabel;
   private JLabel carConditionLabel;

   private JTextField reservationNoField;
   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField driverLicenceField;
   private JTextField phoneNoField;
   private JTextField estimatePriceField; 

   private JTextField regNoField;
   private JTextField typeField;
   private JTextField makeField;
   private JTextField modelField;
   private JTextField yearField;
   private JTextField colorField;
   private JTextField seatsField;
   private JTextField drivenKmField;
   private JTextField loadField;

   private JTextField realDrivenKmField;
   private JTextField realPriceField;

   private JButton cancelButton;
   private JButton saveButton;

   private ImageIcon logoIcon;
   private JLabel logoLabel;

   JComboBox<String> dayBox;
   JComboBox<String> monthBox;
   JComboBox<String> yearBox;

   private JRadioButton damagedRadioButton;
   private JRadioButton goodRadioButton;
   private ButtonGroup carConditionGroup;

   private JPanel comboPanel;
   private JComboBox<Rent> returnBox;

   /**
    * Constructor initializing the GUI components
    * 
    * @param returnAdapter
    *           RentFileAdapter object used for displaying and storing rentals
    *           information
    * @param vehicleAdapter
    *           VehicleFileAdapter object used for retrieving information about
    *           the vehicles and updates them where is necessary
    */
   public ReturnPanel(RentFileAdapter returnAdapter,
         VehicleFileAdapter vehicleAdapter)
   {
      this.returnAdapter = returnAdapter;
      this.vehicleAdapter = vehicleAdapter;
      buttonListener = new MyButtonListener();

      //importing the Gregorian Calendar for today's date
      GregorianCalendar now = new GregorianCalendar(); 

      comboPanel = new JPanel();
      returnBox = new JComboBox<Rent>();
      returnBox.addActionListener(buttonListener);
      comboPanel.add(returnBox);

      String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09",
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

      String[] months = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };

      String[] years = { "2016", "2017" };

      boxPanel = new JPanel();
      boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

      // The header containing the title
      headerPanel = new JPanel();
      headerLabel = new JLabel("Returning the car");
      Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
            26);
      headerLabel.setFont(headerFont);
      headerPanel.add(headerLabel);

      // Creating the mainPanel that contains all the information
      mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(1, 3, 30, 30));

      // Creating the first column of the GUI which includes the information
      // about the client
      box1 = new JPanel();
      box1.setBorder(new TitledBorder("Client information"));

      clientPanel = new JPanel();
      clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));

      reservationNoLabel = new JLabel("Reservation number: ");
      reservationNoField = new JTextField(25);

      firstNameLabel = new JLabel("First name: ");
      firstNameField = new JTextField(25);
      firstNameField.setEditable(false);

      lastNameLabel = new JLabel("Last name: ");
      lastNameField = new JTextField(25);
      lastNameField.setEditable(false);

      driverLicenceLabel = new JLabel("Driver licence number: ");
      driverLicenceField = new JTextField(25);
      driverLicenceField.setEditable(false);

      phoneNoLabel = new JLabel("Phone number: ");
      phoneNoField = new JTextField(25);
      phoneNoField.setEditable(false);

      estimatePriceLabel = new JLabel("Estimate price: ");
      estimatePriceField = new JTextField(25);
      estimatePriceField.setEditable(false);

      clientPanel.add(reservationNoLabel);
      clientPanel.add(reservationNoField);
      clientPanel.add(firstNameLabel);
      clientPanel.add(firstNameField);
      clientPanel.add(lastNameLabel);
      clientPanel.add(lastNameField);
      clientPanel.add(driverLicenceLabel);
      clientPanel.add(driverLicenceField);
      clientPanel.add(phoneNoLabel);
      clientPanel.add(phoneNoField);
      clientPanel.add(estimatePriceLabel);
      clientPanel.add(estimatePriceField);

      box1.add(clientPanel);

      // Creating the second column of the GUI which includes the information
      // about the car
      box2 = new JPanel();
      box2.setBorder(new TitledBorder("Car details"));

      carPanel = new JPanel();
      carPanel.setLayout(new BoxLayout(carPanel, BoxLayout.Y_AXIS));

      regNoLabel = new JLabel("Registration number: ");
      regNoField = new JTextField(25);
      regNoField.setEditable(false);

      typeLabel = new JLabel("Type: ");
      typeField = new JTextField(25);
      typeField.setEditable(false);

      makeLabel = new JLabel("Make: ");
      makeField = new JTextField(25);
      makeField.setEditable(false);

      modelLabel = new JLabel("Model: ");
      modelField = new JTextField(25);
      modelField.setEditable(false);

      yearLabel = new JLabel("Year: ");
      yearField = new JTextField(25);
      yearField.setEditable(false);

      colorLabel = new JLabel("Color: ");
      colorField = new JTextField(25);
      colorField.setEditable(false);

      seatsLabel = new JLabel("Seats: ");
      seatsField = new JTextField(25);
      seatsField.setEditable(false);

      drivenKmLabel = new JLabel("Driven km: ");
      drivenKmField = new JTextField(25);
      drivenKmField.setEditable(false);

      loadLabel = new JLabel("Load size: ");
      loadField = new JTextField(25);
      loadField.setEditable(false);

      carPanel.add(regNoLabel);
      carPanel.add(regNoField);
      carPanel.add(typeLabel);
      carPanel.add(typeField);
      carPanel.add(makeLabel);
      carPanel.add(makeField);
      carPanel.add(modelLabel);
      carPanel.add(modelField);
      carPanel.add(yearLabel);
      carPanel.add(yearField);
      carPanel.add(colorLabel);
      carPanel.add(colorField);
      carPanel.add(seatsLabel);
      carPanel.add(seatsField);
      carPanel.add(drivenKmLabel);
      carPanel.add(drivenKmField);
      carPanel.add(loadLabel);
      carPanel.add(loadField);

      box2.add(carPanel);

      // Creating the first column of the GUI which includes the return
      // information
      box3 = new JPanel();
      box3.setBorder(new TitledBorder("Return information"));

      updatePanel = new JPanel();
      updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));

      realDrivenKmLabel = new JLabel("Driven km: ");
      realDrivenKmField = new JTextField(25);
      realDrivenKmPanel = new JPanel();
      realDrivenKmPanel.add(realDrivenKmLabel);
      realDrivenKmPanel.add(realDrivenKmField);
      realDrivenKmPanel.setLayout(new BoxLayout(realDrivenKmPanel,
            BoxLayout.Y_AXIS));

      
      // Setting the return date to today's date
      dayBox = new JComboBox<String>(days);
      monthBox = new JComboBox<String>(months);
      yearBox = new JComboBox<String>(years);
      int day = now.get(GregorianCalendar.DATE);
      int month = now.get(GregorianCalendar.MONTH) + 1;
      int year = now.get(GregorianCalendar.YEAR);

      dayBox.setSelectedIndex(day - 1);
      monthBox.setSelectedIndex(month - 1);
      yearBox.setSelectedIndex(year - 2016);
      realDatePanel = new JPanel();
      realDateLabel = new JLabel("Return date: ");
      realDatePanel.add(realDateLabel);
      realDatePanel.add(dayBox);
      realDatePanel.add(monthBox);
      realDatePanel.add(yearBox);

      carConditionLabel = new JLabel("Car condition: ");
      damagedRadioButton = new JRadioButton("Damaged");
      goodRadioButton = new JRadioButton("Good");
      carConditionGroup = new ButtonGroup();
      carConditionGroup.add(damagedRadioButton);
      carConditionGroup.add(goodRadioButton);

      realPriceLabel = new JLabel("Final price: ");
      realPriceField = new JTextField(25);
      realPricePanel = new JPanel();
      realPricePanel.add(realPriceLabel);
      realPricePanel.add(realPriceField);
      realPricePanel.setLayout(new BoxLayout(realPricePanel, BoxLayout.Y_AXIS));

      middlePanel = new JPanel();
      middlePanel.add(carConditionLabel);
      middlePanel.add(damagedRadioButton);
      middlePanel.add(goodRadioButton);

      box3.add(realDrivenKmPanel, BorderLayout.NORTH);
      box3.add(realDatePanel, BorderLayout.NORTH);
      box3.add(middlePanel, BorderLayout.CENTER);
      box3.add(realPricePanel, BorderLayout.SOUTH);

      box3.setPreferredSize(new Dimension(300, 350));
      box3.setLayout(new FlowLayout(FlowLayout.LEFT));

      box1.setPreferredSize(new Dimension(300, 350));

      mainPanel.add(box1, BorderLayout.WEST);
      mainPanel.add(box2, BorderLayout.CENTER);
      mainPanel.add(box3, BorderLayout.EAST);

      footerPanel = new JPanel();
      footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      footerPanel.setPreferredSize(new Dimension(1000, 400));

      buttonsPanel = new JPanel();
      saveButton = new JButton("Save");
      saveButton.addActionListener(buttonListener);
      cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(buttonListener);
      buttonsPanel.add(saveButton);
      buttonsPanel.add(cancelButton);

      logoIcon = new ImageIcon("img/VRentLogo.gif");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);

      footerPanel.add(buttonsPanel, BorderLayout.NORTH);
      footerPanel.add(logoLabel, BorderLayout.SOUTH);

      boxPanel.add(headerPanel);
      boxPanel.add(mainPanel);
      boxPanel.add(footerPanel);

      add(boxPanel);
      setSize(1200, 700);
      setVisible(true);

      /*
       * Reading information from the keyboard using the enter button. Checking
       * if the keycode exists in the database. Filling in the text fields with
       * the client and the vehicle information
       */
      KeyListener listener = new KeyListener()
      {
         public void keyPressed(KeyEvent e)
         {
            RentList rents = returnAdapter.getAllRents();
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
               try
               {
                  Integer.parseInt(reservationNoField.getText());
               }
               catch (NumberFormatException f)
               {
                  JOptionPane.showMessageDialog(null,
                        "Please enter reservation number as an integer",
                        "Warning message", JOptionPane.WARNING_MESSAGE);
                  return;
               }

               for (int i = 0; i < rents.size(); i++)
               {
                  if ((Integer.parseInt(reservationNoField.getText()) == rents
                        .get(i).getResNo()))
                  {
                     LastFoundRent = rents.get(i);
                     firstNameField.setText(rents.get(i).getFirstName());
                     lastNameField.setText(rents.get(i).getLastName());
                     driverLicenceField.setText(rents.get(i)
                           .getDriversLicense());
                     phoneNoField.setText(rents.get(i).getPhoneNo());
                     estimatePriceField.setText(""
                           + rents.get(i).getEstimatePrice());

                     rents.get(i).setVehicle(vehicleAdapter.updateVehicle(rents.get(i).getVehicle().getRegNo()));
                     
                     regNoField.setText(rents.get(i).getVehicle().getRegNo());
                     typeField.setText(rents.get(i).getVehicle().getType());
                     makeField.setText(rents.get(i).getVehicle().getMake());
                     modelField.setText(rents.get(i).getVehicle().getModel());
                     yearField
                           .setText("" + rents.get(i).getVehicle().getYear());
                     colorField.setText(rents.get(i).getVehicle().getColor());
                     seatsField.setText(""
                           + rents.get(i).getVehicle().getSeats());
                     drivenKmField.setText(""
                           + rents.get(i).getVehicle().getDrivenKm());
                     loadField
                           .setText("" + rents.get(i).getVehicle().getLoad());
                     return;
                  }
               }

               JOptionPane.showMessageDialog(null,
                     "Reservation number does not exist!", "Warning message",
                     JOptionPane.WARNING_MESSAGE);
            }
         }

         @Override
         public void keyTyped(KeyEvent e)
         {

         }

         @Override
         public void keyReleased(KeyEvent e)
         {

         }
      };

      reservationNoField.addKeyListener(listener);
   }

   /**
    * Enables or disables editing the fields
    * 
    * @param bool
    *           if true, the area will be editable
    */
   public void changeEditableState(boolean bool)
   {
      firstNameField.setEditable(bool);
      lastNameField.setEditable(bool);
      driverLicenceField.setEditable(bool);
      phoneNoField.setEditable(bool);
      estimatePriceField.setEditable(bool);
      regNoField.setEditable(bool);
      typeField.setEditable(bool);
      makeField.setEditable(bool);
      modelField.setEditable(bool);
      yearField.setEditable(bool);
      colorField.setEditable(bool);
      seatsField.setEditable(bool);
      drivenKmField.setEditable(bool);
      loadField.setEditable(bool);
   }

   /**
    * Updates the kilometers that the car has driven after it was rented and returned to
    * the office
    * 
    * @param rent
    *           Rent object used for finding the right vehicle
    * @param realKm
    *           for updating the right number of driven kilometers
    */
   public void setRealKm(Rent rent, int realKm)
   {
      VehicleList vehicleList;
      String regNo;

      regNo = rent.getVehicle().getRegNo();
      vehicleList = vehicleAdapter.getAllVehicles();
      VehicleList temp = new VehicleList();

      for (int i = 0; i < vehicleList.size(); i++)
      {

         if (regNo.equals(vehicleList.get(i).getRegNo()))
         {
            vehicleList.get(i).setDrivenKm(realKm);
            temp.add(vehicleList.get(i));
         }
         else
         {
            temp.add(vehicleList.get(i));
         }
      }
      vehicleAdapter.saveVehicles(temp);

      vehicleList = vehicleAdapter.getAllVehicles();
   }

   /**
    * Inner action listener class
    * 
    * @author Group One
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == saveButton)
         {
            int resNo = Integer.parseInt(reservationNoField.getText());
            String drivenKm2 = realDrivenKmField.getText();
            String originalDrivenKm = drivenKmField.getText();
            String returnDay = (String) dayBox.getSelectedItem();
            String returnMonth = (String) monthBox.getSelectedItem();
            String returnYear = (String) yearBox.getSelectedItem();
            String carCondition = "";
            String finalPrice = realPriceField.getText();

            if (damagedRadioButton.isSelected())
            {
               carCondition = "damaged";
               vehicleAdapter.changeInService(LastFoundRent.getVehicle(), true);
            }

            if (goodRadioButton.isSelected())
            {
               carCondition = "good";
            }

            if (drivenKm2.equals("") || returnDay.equals("")
                  || returnMonth.equals("") || returnYear.equals("")
                  || carCondition.equals("") || finalPrice.equals(""))
            {
               JOptionPane
                     .showMessageDialog(
                           null,
                           "Please make sure all required fields are filled out correctly!",
                           "Error", JOptionPane.ERROR_MESSAGE);
               return;
            }

            int drivenKm = Integer.parseInt(drivenKm2);
            int originalDrivenKmInt = Integer.parseInt(originalDrivenKm);

            int Moriginal;
            Moriginal = originalDrivenKmInt / 20000;

            int Mold;
            Mold = drivenKm / 20000;

            if (Moriginal != Mold)
            {
               JOptionPane.showMessageDialog(null, "Car has been sent to service",
                     "Warning message", JOptionPane.WARNING_MESSAGE);
               vehicleAdapter.changeInService(LastFoundRent.getVehicle(), true);

            }
            double price = Double.parseDouble(finalPrice);

            if (drivenKm < originalDrivenKmInt)
            {
               JOptionPane
                     .showMessageDialog(
                           null,
                           "Please make sure the driven km field is filled out correctly!",
                           "Warning message", JOptionPane.WARNING_MESSAGE);

            }

            TheTime realDate = new TheTime(returnDay, returnMonth, returnYear);
            setRealKm(LastFoundRent, drivenKm);
            returnAdapter.changeReturn(resNo, realDate, drivenKm, carCondition,
                  price);
         }

         if (e.getSource() == cancelButton)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }
      }
   }
}
