package SEP1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import sdj2.model.Rent;
import sdj2.model.RentList;
import sdj2.model.Vehicle;
import sdj2.model.VehicleList;
import sdj2.model.utility.RentFileAdapter;

/**
 * A GUI panel containing all the information about the bookings, rentals,
 * service and car condition
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class DataPanel extends JPanel
{
   private VehicleFileAdapter vehicleAdapter;
   private RentFileAdapter rentAdapter;
   private MyButtonListener buttonListener;

   private String lastButtonUpdate;

   private JPanel mainPanel;
   private JPanel headerPanel;
   private JPanel leftPanel;
   private JPanel rightPanel;
   private JPanel finalPanel;
   private JPanel footerPanel;
   private JPanel buttonsPanel;
   private JPanel boxPanel;
   private JPanel emptyPanel;
   private JPanel emptyPanel2;

   private JLabel headerLabel;

   private JButton allVehiclesButton;
   private JButton bookingsButton;
   private JButton rentsButton;
   private JButton availableButton;
   private JButton kmButton;
   private JButton inServiceButton;
   private JButton sendToServiceButton;
   private JButton takeOutOfServiceButton;

   private JButton addCarButton;
   private JButton sellCarButton;

   private JButton cancelButton;

   private ImageIcon logoIcon;
   private JLabel logoLabel;

   private JScrollPane scrollPane;
   private DefaultListModel listModel;
   private JList listArea;

   /**
    * Constructor initializing the GUI components
    * 
    * @param vehicleAdapter
    *           object used for retrieving and storing vehicle information
    * @param adapter
    *           rentAdapterFileAdapter object used for retrieving and storing
    *           renting information
    */
   public DataPanel(VehicleFileAdapter vehicleAdapter,
         RentFileAdapter rentAdapter)
   {
      this.vehicleAdapter = vehicleAdapter;
      this.rentAdapter = rentAdapter;
      buttonListener = new MyButtonListener();
      lastButtonUpdate = "";

      boxPanel = new JPanel();
      boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

      // The header containing the title
      headerPanel = new JPanel();
      headerLabel = new JLabel("Data information");
      Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
            26);
      headerLabel.setFont(headerFont);
      headerPanel.add(headerLabel);

      // Creating the mainPanel that will include everything
      mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(1, 5, 10, 10));
      Font mainFont = new Font(mainPanel.getFont().getFamily(), Font.PLAIN, 16);

      // Creating the left side that contains three buttons
      leftPanel = new JPanel();
      leftPanel.setLayout(new GridLayout(3, 5, 8, 8));

      allVehiclesButton = new JButton("All vehicles");
      allVehiclesButton.setFont(mainFont);
      allVehiclesButton.addActionListener(buttonListener);

      bookingsButton = new JButton("Bookings");
      bookingsButton.setFont(mainFont);
      bookingsButton.addActionListener(buttonListener);

      rentsButton = new JButton("Rentals");
      rentsButton.setFont(mainFont);
      rentsButton.addActionListener(buttonListener);

      leftPanel.add(allVehiclesButton);
      leftPanel.add(bookingsButton);
      leftPanel.add(rentsButton);

      leftPanel.setPreferredSize(new Dimension(150, 100));

      // Creating the right side that contains two buttons and the car condition
      // buttons group
      rightPanel = new JPanel();
      rightPanel.setLayout(new GridLayout(3, 5, 8, 8));

      availableButton = new JButton("Available");
      availableButton.setFont(mainFont);
      availableButton.addActionListener(buttonListener);

      inServiceButton = new JButton("In service");
      inServiceButton.setFont(mainFont);
      inServiceButton.addActionListener(buttonListener);

      kmButton = new JButton("Over 200.000 km");
      kmButton.setFont(mainFont);
      kmButton.addActionListener(buttonListener);

      rightPanel.add(availableButton);
      rightPanel.add(kmButton);
      rightPanel.add(inServiceButton);

      rightPanel.setPreferredSize(new Dimension(200, 150));
      emptyPanel = new JPanel();
      emptyPanel2 = new JPanel();

      finalPanel = new JPanel();
      finalPanel.setLayout(new GridLayout(2, 5, 8, 8));

      addCarButton = new JButton("Add new vehicle");
      addCarButton.setFont(mainFont);
      addCarButton.addActionListener(buttonListener);

      sellCarButton = new JButton("Sell vehicle");
      sellCarButton.setFont(mainFont);
      sellCarButton.addActionListener(buttonListener);

      finalPanel.add(addCarButton);
      finalPanel.add(sellCarButton);

      // Add both the left and right side to the mainPanel
      mainPanel.add(leftPanel, BorderLayout.WEST);
      mainPanel.add(emptyPanel, BorderLayout.CENTER);
      mainPanel.add(rightPanel, BorderLayout.CENTER);
      mainPanel.add(emptyPanel2, BorderLayout.EAST);
      mainPanel.add(finalPanel, BorderLayout.EAST);

      // Creating the scroll pane where it will show the selected criteria
      listModel = new DefaultListModel<Object>();
      listArea = new JList<Object>(listModel);
      listArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      listArea.setVisibleRowCount(10);
      scrollPane = new JScrollPane(listArea);
      scrollPane
            .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setPreferredSize(new Dimension(1000, 200));

      // Creating the footerPanel that contains the buttons and the logo icon
      footerPanel = new JPanel();
      footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
      footerPanel.setPreferredSize(new Dimension(1000, 200));

      // Creating the buttonsPanel
      buttonsPanel = new JPanel();

      sendToServiceButton = new JButton("Send to service");
      sendToServiceButton.addActionListener(buttonListener);

      takeOutOfServiceButton = new JButton("Take out from service");
      takeOutOfServiceButton.addActionListener(buttonListener);

      cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(buttonListener);

      buttonsPanel.add(sendToServiceButton);
      buttonsPanel.add(takeOutOfServiceButton);
      buttonsPanel.add(cancelButton);

      logoIcon = new ImageIcon("img/VRentLogo.gif");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);

      footerPanel.add(buttonsPanel);
      footerPanel.add(logoLabel);

      boxPanel.add(headerPanel);
      boxPanel.add(mainPanel);
      boxPanel.add(scrollPane);
      boxPanel.add(footerPanel);

      add(boxPanel);
      setSize(1200, 700);
      setVisible(true);
   }

   /**
    * Updates the list with all the vehicles that are in service
    */
   public void updateServiceList()
   {
      listModel.removeAllElements();
      VehicleList temp = vehicleAdapter.getVehiclesInService();

      for (int i = 0; i < temp.size(); i++)
      {
         listModel.addElement(temp.get(i));
      }
      listArea.setModel(listModel);

      lastButtonUpdate = "In service";
   }

   /**
    * Updates the list with all the bookings
    */
   public void updateBookList()
   {
      listModel.removeAllElements();
      RentList temp = rentAdapter.getRentListByTypeStatus("Book");

      for (int i = 0; i < temp.size(); i++)
      {
         listModel.addElement(temp.get(i));
      }
      listArea.setModel(listModel);

      lastButtonUpdate = "Bookings";
   }

   /**
    * Updates the list with all the rentals
    */
   public void updateRentList()
   {
      listModel.removeAllElements();
      RentList temp = rentAdapter.getRentListByTypeStatus("Rent");

      for (int i = 0; i < temp.size(); i++)
      {
         listModel.addElement(temp.get(i));
      }
      listArea.setModel(listModel);

      lastButtonUpdate = "Rents";
   }

   /**
    * Updates the list with all the vehicles that are available
    */
   public void updateAvailableList()
   {
      listModel.removeAllElements();
      RentList tempRents = rentAdapter.getAllRents();
      VehicleList tempVehicles = vehicleAdapter.getAvailable(tempRents);

      for (int i = 0; i < tempVehicles.size(); i++)
      {
         listModel.addElement(tempVehicles.get(i));
      }
      listArea.setModel(listModel);

      lastButtonUpdate = "Available";
   }

   /**
    * Updates the list with all the vehicles
    */
   public void allVehicles()
   {
      listModel.removeAllElements();
      VehicleList vehicles = vehicleAdapter.getAllVehicles();

      for (int i = 0; i < vehicles.size(); i++)
      {
         listModel.addElement(vehicles.get(i));
      }
      listArea.setModel(listModel);

      lastButtonUpdate = "All vehicles";
   }

   /**
    * calls the option to remove vehicle from 
    */
   public void sellingVehicle(Vehicle vehicle)
   {
      int choice = JOptionPane.showConfirmDialog(null,
            "Vehicle is available for sale, are you sure you want to sell it?",
            "Vehicle sell", JOptionPane.YES_NO_OPTION);
      if (choice == JOptionPane.YES_OPTION)
      {
         vehicleAdapter.removeVehicle(vehicle);

      }
   }

   /**
    * sell option will take selected vehicle from loaded vehicle list if the
    * vehicle has any Rents in future you will get warning if there are no rents
    * in future for that vehicle it can be sold
    */
   public void sellVehicle()
   {

      if (!(lastButtonUpdate.equals("All vehicles")))
      {
         JOptionPane.showMessageDialog(null,
               "Vehicle for sale should be selected from all vehicle list",
               "Warning message", JOptionPane.WARNING_MESSAGE);
         return;
      }

      Vehicle vehicle = (Vehicle) listArea.getSelectedValue();// saves selected
                                                              // vehicle

      if (vehicle == null)
      {
         JOptionPane.showMessageDialog(null, "You didn't select vehicle...",
               "Warning message", JOptionPane.WARNING_MESSAGE);
         return;
      }

      RentList rents = new RentList();
      rents = rentAdapter.getAllRentsForVehicle(vehicle);

      if (rents == null)
      {
         sellingVehicle(vehicle);
      }

      else
      {
         String message;
         String SDate;
         String EDate;
         String Name;

         GregorianCalendar now = new GregorianCalendar(); // importing the
         // Gregorian Calendar for
         // today's date

         int day = now.get(GregorianCalendar.DATE);
         int month = now.get(GregorianCalendar.MONTH) + 1;
         int year = now.get(GregorianCalendar.YEAR);
         TheTime thisDay = new TheTime(day, month, year);

         boolean isObsolete;

         message = "Sorry this vehicle is rented in future";

         for (int i = 0; i < rents.size(); i++)
         {
            if ((thisDay.isBefore(rents.get(i).getReturnTime())))
            {
               SDate = rents.get(i).getPickUpTime().toString();
               EDate = rents.get(i).getReturnTime().toString();
               Name = rents.get(i).getFirstName() + " "
                     + rents.get(i).getLastName();

               message += "\n";
               message += SDate + " - ";
               message += EDate + " by: ";
               message += Name;
            }

            else
            {
               // this rent was obsolete and already finished
            }
         }
         
         if (message.length() < 40)
         {
            sellingVehicle(vehicle);
            return;
         }

         JOptionPane.showMessageDialog(null, message, "Warning message",
               JOptionPane.WARNING_MESSAGE);
      }

   }

   /**
    * Updates the list with all the vehicles that had driven over 200000 km
    */
   public void updateKmList()
   {
      listModel.removeAllElements();
      
      VehicleList tempVehicles = vehicleAdapter.checkKm();

      for (int i = 0; i < tempVehicles.size(); i++)
      {
         listModel.addElement(tempVehicles.get(i));
      }
      listArea.setModel(listModel);
   }

   /**
    * Remove vehicles from service
    */
   public void takeOutOfService()
   {
      if (lastButtonUpdate.equals("Booking")
            || lastButtonUpdate.equals("Rents"))
      {
         Rent rent = (Rent) listArea.getSelectedValue();
         Vehicle vehicle = rent.getVehicle();
         vehicleAdapter.changeInService(vehicle, false);
      }
      else if (lastButtonUpdate.equals("In service")
            || lastButtonUpdate.equals("Available")
            || lastButtonUpdate.equals("Over 200.000 km")
            || lastButtonUpdate.equals("All vehicles"))
      {
         Vehicle vehicle = (Vehicle) listArea.getSelectedValue();
         vehicleAdapter.changeInService(vehicle, false);
      }
   }

   /**
    * Send vehicles to service
    */
   public void sendToService()
   {
      if (lastButtonUpdate.equals("Bookings")
            || lastButtonUpdate.equals("Rents"))
      {
         Rent rent = (Rent) listArea.getSelectedValue();
         Vehicle vehicle = rent.getVehicle();
         vehicleAdapter.changeInService(vehicle, true);
      }
      else if (lastButtonUpdate.equals("In service")
            || lastButtonUpdate.equals("Available")
            || lastButtonUpdate.equals("Over 200.000 km")
            || lastButtonUpdate.equals("All vehicles"))

      {
         Vehicle vehicle = (Vehicle) listArea.getSelectedValue();
         vehicleAdapter.changeInService(vehicle, true);
      }
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
         if (e.getSource() == allVehiclesButton)
         {
            allVehicles();
         }
         if (e.getSource() == inServiceButton)
         {
            updateServiceList();
         }
         if (e.getSource() == bookingsButton)
         {
            updateBookList();
         }
         if (e.getSource() == rentsButton)
         {
            updateRentList();
         }
         if (e.getSource() == availableButton)
         {
            updateAvailableList();
         }
         if (e.getSource() == kmButton)
         {
            updateKmList();
         }
         if (e.getSource() == addCarButton)
         {
            AddVehicle addVehicle = new AddVehicle(vehicleAdapter);
         }
         if (e.getSource() == sellCarButton)
         {
            sellVehicle();
         }

         if (e.getSource() == takeOutOfServiceButton)
         {
            takeOutOfService();
         }
         if (e.getSource() == sendToServiceButton)
         {
            sendToService();
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
