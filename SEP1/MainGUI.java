package SEP1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;

import ClientConsole.RemoteObserver;

/**
 * A user interface that allows displaying and modifying information about vehicles
 * 
 * @author Group 1 (Ana Iulia Chifor, Andreea Carst, Filip Hudec, Signe
 *         Rasmussen)
 * @version 8.0
 * @date 31-05-2016
 */
public class MainGUI extends JFrame 
{
   private VehicleFileAdapter vehicleAdapter;
   private RentFileAdapter rentAdapter;
   private RentFileAdapter returnAdapter;

   private JTabbedPane tabPane;

   private BookPanel bookPanel;
   private RentPanel rentPanel;
   private ReturnPanel returnPanel;
   private DataPanel dataPanel;

   private MyButtonListener buttonListener;

   private JMenuBar menuBar;

   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;

   private JMenuItem exitMenuItem;
   private JMenuItem aboutMenuItem;

   private JCheckBoxMenuItem editRentFieldsMenuItem;
   private JCheckBoxMenuItem editReturnFieldsMenuItem;

   
   /**
    * No-argument constructor initializing the GUI components
    */
   public MainGUI()
   {
      super("V-Rent");

      vehicleAdapter = new VehicleFileAdapter("resources/vehicles.bin");
      rentAdapter = new RentFileAdapter("resources/rentals.bin");
      returnAdapter = new RentFileAdapter("resources/rentals.bin");

      buttonListener = new MyButtonListener();

      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.addActionListener(buttonListener);

      editRentFieldsMenuItem = new JCheckBoxMenuItem("Edit rent fiels", false);
      editRentFieldsMenuItem.addActionListener(buttonListener);

      editReturnFieldsMenuItem = new JCheckBoxMenuItem("Edit return fields",
            false);
      editReturnFieldsMenuItem.addActionListener(buttonListener);

      fileMenu = new JMenu("File");
      editMenu = new JMenu("Edit");
      aboutMenu = new JMenu("About");

      fileMenu.add(exitMenuItem);

      editMenu.add(editRentFieldsMenuItem);
      editMenu.add(editReturnFieldsMenuItem);

      aboutMenu.add(aboutMenuItem);

      menuBar = new JMenuBar();

      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);

      setJMenuBar(menuBar);

      bookPanel = new BookPanel(vehicleAdapter, rentAdapter);
      rentPanel = new RentPanel(rentAdapter);
      returnPanel = new ReturnPanel(returnAdapter, vehicleAdapter);
      dataPanel = new DataPanel(vehicleAdapter, rentAdapter);

      tabPane = new JTabbedPane();

      tabPane.addTab("Book", bookPanel);
      tabPane.addTab("Rent", rentPanel);
      tabPane.addTab("Return", returnPanel);
      tabPane.addTab("Data", dataPanel);

      add(tabPane);
      setSize(1200, 700);
      setVisible(true);
      setResizable(false);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
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
         if (e.getSource() == exitMenuItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }

         if (e.getSource() == editRentFieldsMenuItem)
         {
            if (editRentFieldsMenuItem.isSelected())
            {
               rentPanel.changeEditableState(true);
            }
            else
            {
               rentPanel.changeEditableState(false);
            }
         }

         if (e.getSource() == editReturnFieldsMenuItem)
         {
            if (editReturnFieldsMenuItem.isSelected())
            {
               returnPanel.changeEditableState(true);
            }
            else
            {
               returnPanel.changeEditableState(false);
            }
         }

         if (e.getSource() == aboutMenuItem)
         {
            JOptionPane.showMessageDialog(null,
                  "V-Rent is a Car Rental Company located in Horsens. " + '\n'
                        + "It is owned by Van Motor who started the rental of "
                        + '\n'
                        + "cars three years ago. And since then, it has "
                        + '\n' + "become a rising company!", "About",
                  JOptionPane.PLAIN_MESSAGE);
         }
      }
   }


   public static void main(String[] args)
   {
      MainGUI vehicleGUI = new MainGUI();
   }




}