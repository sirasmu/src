package SEP1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A JFrama containing all the necessary fields for adding a new vehicle to the
 * list
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 9.0
 * @date 01-06-2016
 */
public class AddVehicle extends JFrame
{
   private JFrame addVehicleFrame;
   private VehicleFileAdapter vehicleAdapter;
   private Vehicle vehicle;
   private MyButtonListener buttonListener;

   private JPanel headerPanel;
   private JPanel mainPanel;
   private JPanel centerPanel;
   private JPanel infoPanel;
   private JPanel infoPanel2;
   private JPanel footerPanel;

   private ImageIcon vehicleIcon;
   private JLabel vehicleLabel;

   private JLabel headerLabel;
   private JLabel regNoLabel;
   private JLabel typeLabel;
   private JLabel makeLabel;
   private JLabel modelLabel;
   private JLabel yearLabel;
   private JLabel colorLabel;
   private JLabel seatsLabel;
   private JLabel drivenKmLabel;
   private JLabel loadLabel;

   private JTextField regNoField;
   private JTextField typeField;
   private JTextField makeField;
   private JTextField modelField;
   private JTextField yearField;
   private JTextField colorField;
   private JTextField seatsField;
   private JTextField drivenKmField;
   private JTextField loadField;

   private JButton cancelButton;
   private JButton saveButton;

   /**
    * Constructor initializing the JFrame
    * 
    * @param vehicleAdapter
    *           VehicleFileAdapter object used for storing information about the
    *           new vehicle
    */
   public AddVehicle(VehicleFileAdapter vehicleAdapter)
   {
      this.vehicleAdapter = vehicleAdapter;
      buttonListener = new MyButtonListener();

      // Window layout
      addVehicleFrame = new JFrame("Add new vehicle");
      addVehicleFrame.setSize(500, 500);
      addVehicleFrame.setVisible(true);
      addVehicleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      addVehicleFrame.setLocationRelativeTo(null);
      addVehicleFrame.setResizable(false);

      // The header
      headerPanel = new JPanel();
      headerLabel = new JLabel("Adding a new vehicle");
      Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
            26);
      headerLabel.setFont(headerFont);
      headerPanel.add(headerLabel);

      // The main panel
      mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(2, 2, 10, 10));

      // New car picture
      vehicleIcon = new ImageIcon("img/soon.jpg");
      vehicleLabel = new JLabel();
      vehicleLabel.setIcon(vehicleIcon);
      vehicleLabel.setPreferredSize(new Dimension(750, 300));

      // Information panel divided in two columns
      centerPanel = new JPanel();
      centerPanel.setLayout(new GridLayout(1, 2, 10, 10));

      infoPanel = new JPanel();
      infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

      regNoLabel = new JLabel("Registration number: ");
      regNoField = new JTextField(25);

      typeLabel = new JLabel("Type: ");
      typeField = new JTextField(25);

      makeLabel = new JLabel("Make: ");
      makeField = new JTextField(25);

      modelLabel = new JLabel("Model: ");
      modelField = new JTextField(25);

      yearLabel = new JLabel("Year: ");
      yearField = new JTextField(25);

      infoPanel.add(regNoLabel);
      infoPanel.add(regNoField);
      infoPanel.add(typeLabel);
      infoPanel.add(typeField);
      infoPanel.add(makeLabel);
      infoPanel.add(makeField);
      infoPanel.add(modelLabel);
      infoPanel.add(modelField);
      infoPanel.add(yearLabel);
      infoPanel.add(yearField);

      infoPanel2 = new JPanel();
      infoPanel2.setLayout(new BoxLayout(infoPanel2, BoxLayout.Y_AXIS));

      colorLabel = new JLabel("Color: ");
      colorField = new JTextField(25);

      seatsLabel = new JLabel("Seats: ");
      seatsField = new JTextField(25);

      drivenKmLabel = new JLabel("Driven km: ");
      drivenKmField = new JTextField(25);

      loadLabel = new JLabel("Load size: ");
      loadField = new JTextField(25);

      infoPanel2.add(colorLabel);
      infoPanel2.add(colorField);
      infoPanel2.add(seatsLabel);
      infoPanel2.add(seatsField);
      infoPanel2.add(drivenKmLabel);
      infoPanel2.add(drivenKmField);
      infoPanel2.add(loadLabel);
      infoPanel2.add(loadField);

      centerPanel.add(infoPanel);
      centerPanel.add(infoPanel2);

      // Adding the picture and the information to the main panel
      mainPanel.add(vehicleLabel);
      mainPanel.add(centerPanel);

      // Adding the save and cancel buttons
      saveButton = new JButton("Save");
      saveButton.addActionListener(buttonListener);

      cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(buttonListener);

      footerPanel = new JPanel();
      footerPanel.add(saveButton);
      footerPanel.add(cancelButton);

      // Adding all three panels to the frame
      addVehicleFrame.add(headerPanel, BorderLayout.NORTH);
      addVehicleFrame.add(mainPanel, BorderLayout.CENTER);
      addVehicleFrame.add(footerPanel, BorderLayout.SOUTH);

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
            String regNo = regNoField.getText();
            String type = typeField.getText();
            String make = makeField.getText();
            String model = modelField.getText();
            String year = yearField.getText();
            String color = colorField.getText();
            String seats = seatsField.getText();
            String drivenKm = drivenKmField.getText();
            String load = loadField.getText();
            boolean service = false;

            if (regNo.equals("") || type.equals("") || make.equals("")
                  || model.equals("") || year.equals("") || color.equals("")
                  || seats.equals("") || drivenKm.equals("") || load.equals(""))
            {
               JOptionPane
                     .showMessageDialog(
                           null,
                           "Please make sure all the fields are filled out correctly!",
                           "Warning message", JOptionPane.WARNING_MESSAGE);
               return;
            }

            int yearInt = Integer.parseInt(year);
            int seatsInt = Integer.parseInt(seats);
            int drivenKmInt = Integer.parseInt(drivenKm);
            int loadInt = Integer.parseInt(load);

            Vehicle vehicle = new Vehicle(regNo, type, make, model, yearInt,
                  color, seatsInt, drivenKmInt, loadInt, service);
            vehicleAdapter.addVehicle(vehicle);

            System.out.println(vehicleAdapter.getAllVehicles().toString());

            addVehicleFrame.dispatchEvent(new WindowEvent(addVehicleFrame,
                  WindowEvent.WINDOW_CLOSING));
            return;

         }

         if (e.getSource() == cancelButton)
         {
            addVehicleFrame.dispatchEvent(new WindowEvent(addVehicleFrame,
                  WindowEvent.WINDOW_CLOSING));
         }
      }
   }

}
