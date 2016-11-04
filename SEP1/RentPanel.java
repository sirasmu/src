package SEP1;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.peer.KeyboardFocusManagerPeer;

import javax.print.event.PrintEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

/**
 * A GUI panel containing all the information from the booking list that can be
 * changed
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class RentPanel extends JPanel
{
   private RentFileAdapter rentAdapter;
   private MyButtonListener buttonListener;

   private JPanel boxPanel;
   private JPanel headerPanel;
   private JPanel box1;
   private JPanel box2;
   private JPanel mainPanel;
   private JPanel footerPanel;
   private JPanel clientPanel;
   private JPanel carPanel;
   private JPanel buttonsPanel;

   private JLabel headerLabel;

   private JLabel reservationNoLabel;
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel driverLicenceLabel;
   private JLabel phoneNoLabel;

   private JLabel regNoLabel;
   private JLabel typeLabel;
   private JLabel makeLabel;
   private JLabel modelLabel;
   private JLabel yearLabel;
   private JLabel colorLabel;
   private JLabel seatsLabel;
   private JLabel drivenKmLabel;
   private JLabel loadLabel;

   private JTextField reservationNoField;
   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField driverLicenceField;
   private JTextField phoneNoField;

   private JTextField regNoField;
   private JTextField typeField;
   private JTextField makeField;
   private JTextField modelField;
   private JTextField yearField;
   private JTextField colorField;
   private JTextField seatsField;
   private JTextField drivenKmField;
   private JTextField loadField;

   private JButton saveButton;
   private JButton cancelButton;

   private ImageIcon logoIcon;
   private JLabel logoLabel;

   /**
    * Constructor initializing the GUI components
    * 
    * @param adapter
    *           RentFileAdapter object used for storing vehicles information
    */
   public RentPanel(RentFileAdapter adapter)
   {
      this.rentAdapter = adapter;
      buttonListener = new MyButtonListener();

      boxPanel = new JPanel();
      boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

      // Header
      headerPanel = new JPanel();
      headerLabel = new JLabel("Renting the car");
      Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
            26);
      headerLabel.setFont(headerFont);
      headerPanel.add(headerLabel);

      // Creating the mainPanel that contains all the information
      mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(1, 2, 50, 50));

      // Creating the first column of the GUI which includes the information
      // about the client
      box1 = new JPanel();
      box1.setBorder(new TitledBorder("Client information"));

      clientPanel = new JPanel();
      clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));

      reservationNoLabel = new JLabel("Reservation number:");
      reservationNoField = new JTextField(25);

      firstNameLabel = new JLabel("First name:");
      firstNameField = new JTextField(25);
      firstNameField.setEditable(false);

      lastNameLabel = new JLabel("Last name:");
      lastNameField = new JTextField(25);
      lastNameField.setEditable(false);

      driverLicenceLabel = new JLabel("Driver licence number:");
      driverLicenceField = new JTextField(25);

      phoneNoLabel = new JLabel("Phone number:");
      phoneNoField = new JTextField(25);

      saveButton = new JButton("Save");
      saveButton.addActionListener(buttonListener);

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

      box1.setPreferredSize(new Dimension(300, 350));

      // Add the columns to the mainPanel
      mainPanel.add(box1, BorderLayout.WEST);
      mainPanel.add(box2, BorderLayout.EAST);

      // Create the footerPanel and add the buttons and logo image to it
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

      // Add all the panels to the boxPanel
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
            RentList rents = adapter.getAllRents();
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
                     firstNameField.setText(rents.get(i).getFirstName());
                     lastNameField.setText(rents.get(i).getLastName());
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
    * Inner action listener class
    * 
    * @author Group 1 
    * @version 2.0 
    * @date 30-05-2016
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == saveButton)
         {
            int resNo = Integer.parseInt(reservationNoField.getText());
            String driversLicense = driverLicenceField.getText();
            String phoneNo = phoneNoField.getText();

            if (driversLicense.equals("") || phoneNo.equals(""))
            {
               JOptionPane
                     .showMessageDialog(
                           null,
                           "Please make sure all required fields are filled out correctly!",
                           "Error", JOptionPane.ERROR_MESSAGE);
            }

            rentAdapter.changeRent(resNo, driversLicense, phoneNo);

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
