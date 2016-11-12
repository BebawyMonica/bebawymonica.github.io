package Hotel.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import Hotel.common.Hotel;
import Hotel.common.Reservation;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Bebawy_Hotels extends JFrame {

	/*
	 * Declaring Variables
	 */
	private JPanel contentPane;
	private JLabel lblHotelsOptions;
	private JComboBox cbHotelsOptions;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JList lstReservation;


	// Component models
	DefaultComboBoxModel hotelsModel = new DefaultComboBoxModel();
	DefaultListModel reservationsModel = new DefaultListModel();
	private JLabel lblCheckIn;
	private JLabel lblInMonth;
	private JTextField txtInMonth;
	private JLabel lblInDay;
	private JTextField txtInDay;
	private JLabel lblCheckout;
	private JLabel lblOutMonth;
	private JTextField txtOutMonth;
	private JLabel lblOutDay;
	private JTextField txtOutDay;
	private JButton btnAdd;


	// Reservation Object
	Reservation r;
	// Hotel Object
	Hotel h;
	// ArrayList for Hotel and ArrayList for Reservation.
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	ArrayList<Reservation> reservation = new ArrayList<Reservation>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bebawy_Hotels frame = new Bebawy_Hotels();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor
	 * It calls two methods
	 * initComponent()
	 * createEvent()
	 */
	public Bebawy_Hotels() 
	{
		initComponent();
		createEvent();	
	}

	/**
	 * initComponent method
	 * in this method all the code of defining variables is coded
	 * all the layouts, and all the components are in the 
	 * initComponent
	 */
	private void initComponent() 
	{
		// Setting the frame bounds
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 366);
		// adding the content pane
		// and setting the empty border 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//Label Hotels Options 
		lblHotelsOptions = new JLabel("Hotels Options");
		// JComboBox Hotels Options displays the 5 different options 
		cbHotelsOptions = new JComboBox(hotelsModel);

		// Setting new panel for the reservation's list
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reservations:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// Declaring labels for certification 
		lblCheckIn = new JLabel("Check-In Info");
		lblCheckIn.setVisible(false);
		lblInMonth = new JLabel("Month:");
		lblInMonth.setVisible(false);
		lblInDay = new JLabel("Day:");
		lblInDay.setVisible(false);
		lblCheckout = new JLabel("Check-Out Info");
		lblCheckout.setVisible(false);
		lblOutMonth = new JLabel("Month:");
		lblOutMonth.setVisible(false);
		lblOutDay = new JLabel("Day:");
		lblOutDay.setVisible(false);
		// Declaring text fields to allow the user to write in them
		txtInMonth = new JTextField();
		txtInMonth.setVisible(false);
		txtInMonth.setColumns(10);
		txtInDay = new JTextField();
		txtInDay.setVisible(false);
		txtInDay.setColumns(10);
		txtOutMonth = new JTextField();
		txtOutMonth.setVisible(false);
		txtOutMonth.setColumns(10);
		txtOutDay = new JTextField();
		txtOutDay.setVisible(false);
		txtOutDay.setColumns(10);
		// Declaring the add button
		btnAdd = new JButton(">>");
		btnAdd.setVisible(false);

		// UGLY CODE
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addContainerGap()
														.addComponent(lblHotelsOptions)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(cbHotelsOptions, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
																		.addComponent(lblOutMonth)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txtOutMonth, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblOutDay)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txtOutDay, 0, 0, Short.MAX_VALUE))
																		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
																				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
																								.addComponent(lblInMonth)
																								.addPreferredGap(ComponentPlacement.RELATED)
																								.addComponent(txtInMonth, 0, 0, Short.MAX_VALUE))
																								.addComponent(lblCheckIn, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(ComponentPlacement.RELATED)
																								.addComponent(lblInDay)
																								.addPreferredGap(ComponentPlacement.RELATED)
																								.addComponent(txtInDay, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))))
																								.addGap(55))
																								.addGroup(gl_contentPane.createSequentialGroup()
																										.addComponent(lblCheckout, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
																										.addGap(18)
																										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
																										.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblHotelsOptions)
												.addComponent(cbHotelsOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(84)
												.addComponent(lblCheckIn)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblInMonth)
														.addComponent(txtInMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblInDay)
														.addComponent(txtInDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCheckout)
																.addComponent(btnAdd))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblOutMonth)
																		.addComponent(txtOutMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblOutDay)
																		.addComponent(txtOutDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																		.addContainerGap())
				);
		// Declaring the scroll Pane
		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addGap(1))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
						.addGap(1))
				);

		// Declaring the reservation's list in the scroll pane
		scrollPane.setViewportView(lstReservation);
		// Declaring the reservation's list
		lstReservation = new JList(reservationsModel);
		scrollPane.setViewportView(lstReservation);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		// Calling the initHotelsAndReservations method
		initHotelsAndReservations();
	}
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////CREATE EVENTS///////////////	
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////////////////////////////////
	private void createEvent() 
	{
		// When the user clicks on the add button
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//////////////////////////////////
				//////////////////////////////////
				//Adding Info To Reservation.txt//
				//////////////////////////////////
				//////////////////////////////////
				/**
				 * First i surround the whole with with try.. catch block
				 * First in the try block 
				 * i get the values of the check-in and check-out info
				 * i save them in strings 
				 * then cast them in integers 
				 * and finally add it to Reservation.txt
				 * then i close the file.
				 */
				try
				{
					Object HotelID = cbHotelsOptions.getSelectedItem();
					Hotel hotel;
					hotel = (Hotel) HotelID;
					long id = hotel.getUniqueId();
					//	System.out.println(id);
					String inmonth = txtInMonth.getText();
					int inMonth = Integer.valueOf(inmonth);
					String inday = txtInDay.getText();
					int inDay = Integer.parseInt(inday);
					String outmonth = txtOutMonth.getText();
					int outMonth = Integer.valueOf(outmonth);
					String outday = txtOutDay.getText();
					int OutDay = Integer.parseInt(outday);
					FileOutputStream fos = new FileOutputStream("Reservation.txt", true);
					PrintWriter pw = new PrintWriter(fos);

					/**
					 * i then check the canBook method and according to the canBook method 
					 * i check if they can book, and if yes i add the reservation
					 * otherwise it prints so the user may enter different values
					 */
					{
						if(h.canBook(new Reservation(id,inMonth, inDay, OutDay)) == true) 
						{
							reservation.add(new Reservation (id,inMonth, inDay, outMonth, OutDay));
							r = new Reservation (id,inMonth, inDay, OutDay);
							h.addResIfCanBook(new Reservation(id,inMonth, inDay, outMonth, OutDay));
							reservationsModel.addElement(r);
							pw.println( id + " - " + inMonth + "-"+ inDay+ " - " + outMonth +  "-" + OutDay);
							pw.close();
							txtInMonth.setText("");
							txtOutMonth.setText("");
							txtInDay.setText("");
							txtOutDay.setText("");
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "These dates are already reserved"
									+ "\nPlease try again!");	
							txtInMonth.setText("");
							txtOutMonth.setText("");
							txtInDay.setText("");
							txtOutDay.setText("");
						}
					}
				} 
				/**
				 * Then the catch Block checks for file not found exception
				 */
				catch (FileNotFoundException fnfe) 
				{
					System.err.println("File not found.");
				}
			}
		});

		// When the user selects a specific hotel 
		cbHotelsOptions.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				/**
				 * first i save selected hotel in a hotel object
				 * then i get reservations for the selected hotel
				 * then i make all the labels and text fields visible 
				 */
				Hotel selectedHotel = (Hotel)cbHotelsOptions.getSelectedItem();
				JOptionPane.showMessageDialog(null, "You selected the " + selectedHotel.getHotelName());
				selectedHotel.getReservations();
				lblCheckIn.setVisible(true);
				lblInMonth.setVisible(true);
				txtInMonth.setVisible(true);
				lblInDay.setVisible(true);
				txtInDay.setVisible(true);
				lblCheckout.setVisible(true);
				lblOutMonth.setVisible(true);
				txtOutMonth.setVisible(true);
				lblOutDay.setVisible(true);
				txtOutDay.setVisible(true);
				btnAdd.setVisible(true);
				reservationsModel.removeAllElements();

				/////////////////////////////////////
				/////////////////////////////////////
				//Reading Info From Reservation.txt//
				/////////////////////////////////////
				/////////////////////////////////////
				/**
				 * First i surround everything is a try.. catch blocks 
				 * then in the try block i declare the file input stream
				 * then a scanner 
				 * then in a while loop i check if the file has next line 
				 * and a user a delimiter "-"
				 * and it adds it to a new reservation
				 * then it adds it to the ArrayList reservation
				 * and it also adds it to the hotel object
				 * then it checks if it can book that hotel
				 * and if yes it adds it to the ReservationsModel
				 */
				try
				{
					FileInputStream fis = new FileInputStream("Reservation.txt");
					Scanner fscan = new Scanner (fis);
					int INMonth = 0;
					int INday = 0;
					int OUTmonth = 0;
					int OUTday = 0;
					long iD = 0;
					while (fscan.hasNextLine())
					{
						Scanner ls = new Scanner (fscan.nextLine());
						ls.useDelimiter("-");
						iD = Integer.parseInt(ls.next().trim());
						INMonth = Integer.parseInt(ls.next().trim());
						INday = Integer.parseInt(ls.next().trim()); 
						OUTmonth = Integer.parseInt(ls.next().trim());
						OUTday = Integer.parseInt(ls.next().trim()); 
						r = new Reservation (iD,INMonth, INday, OUTmonth, OUTday);
						h.addReservation(new Reservation(iD,INMonth, INday, OUTmonth, OUTday));
						Hotel hotel = (Hotel) cbHotelsOptions.getSelectedItem();
						long hotID = hotel.getUniqueId();
						if(iD == hotID)
						{
							reservationsModel.addElement((new Reservation(iD, INMonth, INday, OUTday)));
						}
					}
				}
				/**
				 * The catch block checks to make sure that the file is found
				 */
				catch( FileNotFoundException fnfe)
				{
					System.err.println("File not found!");
				}
			}
		});

		/**
		 * This is the setRenderer to make the hotel appear in the hotelsOptions 
		 * just the hotel name.
		 */
		cbHotelsOptions.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Hotel)
				{
					// Here value will be of the Type 'Hotel'
					((JLabel) renderer).setText(((Hotel) value).getHotelName());
				}
				return renderer;
			}
		});

		/**
		 * The setCallRenderer is for the reservation's list
		 * it only prints the check-in and check-out info
		 */
		lstReservation.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus)
			{
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Reservation)
				{
					// Here value will be of the Type 'Reservation'
					Hotel selectedHotel = (Hotel) cbHotelsOptions.getSelectedItem();
					((JLabel) renderer).setText(((Reservation) value).getFormattedDisplayString());
				}
				return renderer;
			}
		});	
	}

	private void initHotelsAndReservations() 
	{
		// Read in hotels and reservations from files
		///////////////////////////////
		///////////////////////////////
		//Reading Info From Hotel.txt//
		///////////////////////////////
		///////////////////////////////		
		/**
		 * First i surround everything is a try.. catch blocks 
		 * then in the try block i declare the file input stream
		 * then a scanner 
		 * then in a while loop i check if the file has next line 
		 * and a user a delimiter ","
		 * and it adds it to a new hotel
		 * then it adds it to the ArrayList hotels
		 */
		try
		{
			FileInputStream fis = new FileInputStream("Hotels.txt");
			Scanner fs = new Scanner(fis);
			while(fs.hasNextLine())
			{
				Scanner is = new Scanner(fs.nextLine());
				is.useDelimiter(",");
				int id = Integer.parseInt(is.next().trim());
				String name = is.next().trim();
				String address = is.next().trim();
				String city = is.next().trim();
				String state = is.next().trim();
				int pricePerNight = Integer.parseInt(is.next().trim());
				h = new Hotel (id, name, address, city, state, pricePerNight);
				hotels.add(h);
			}
		}
		/**
		 * The catch block checks to make sure that the file is found
		 */
		catch( FileNotFoundException fnfe)
		{
			System.err.println("File not found!");
		}

		/**
		 *  Binding hotel reservations to model/JComboBox
		 */
		for(Hotel h1: hotels)
			hotelsModel.addElement(h1);
		/**
		 *  Binding hotel reservations to model/JList
		 */
		Hotel selectedHotel = (Hotel)cbHotelsOptions.getSelectedItem();
		for(Reservation r1 : selectedHotel.getReservations())
			reservationsModel.addElement(r1);
	}
}
