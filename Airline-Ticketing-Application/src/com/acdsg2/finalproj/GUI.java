package com.acdsg2.finalproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Enumeration;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends JFrame {
	
	JFrame prompt = new JFrame();

	private Image img_logo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(552,143,Image.SCALE_SMOOTH);
	private Image img_minilogo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(92,24,Image.SCALE_SMOOTH);
	private JTextField textField_NumPassengers;
	private JTable table_AirplaneAvailable;
	private JTextField textField_Name;
	private JTextField textField_Age;
	private JTextField textField_AmountPaid;
	
	int maxIndexPassenger;
	int currentIndexPassenger=0;
	String tempPassengerDetails[][];
	//0-name
	//1-age
	//2-insurance
	Passenger [] passengers;
	private JTable table_regular;
	private JTable table_discounted;
	private JTable table_Total;
	float grandTotal=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public GUI() {
		
		setUndecorated(true);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 500);
		getContentPane().add(mainPanel);
		CardLayout cl = new CardLayout(0, 0);
		mainPanel.setLayout(cl);
		
		JPanel startingPanel = new JPanel();
		startingPanel.setLayout(null);
		mainPanel.add(startingPanel, "start");
		
		JLabel startPanel_Title = new JLabel("<html><center>MERC AIRLINE TICKETING SYSTEM<center><html>");
		startPanel_Title.setFont(new Font("Play", Font.BOLD, 50));
		startPanel_Title.setBounds(146, 234, 507, 118);
		startingPanel.add(startPanel_Title);
		
		JLabel logo = new JLabel("");
		logo.setBounds(124, 57, 552, 166);
		logo.setIcon(new ImageIcon(img_logo));
		startingPanel.add(logo);
		
		JButton btnSelect = new JButton("Let's Fly");
		btnSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(mainPanel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSelect.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSelect.setForeground(Color.BLACK);
			}
		});
		btnSelect.setForeground(Color.BLACK);
		btnSelect.setFont(new Font("Play", Font.PLAIN, 20));
		btnSelect.setBorderPainted(false);
		btnSelect.setBackground(new Color(70, 130, 180));
		btnSelect.setBounds(325, 375, 150, 40);
		startingPanel.add(btnSelect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setForeground(Color.WHITE);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Play", Font.PLAIN, 13));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(Color.BLACK);
		btnExit.setBounds(355, 426, 89, 23);
		startingPanel.add(btnExit);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(null);
		mainPanel.add(selectionPanel, "select");
		
		JLabel lblNewLabel = new JLabel("Select Operation:");
		lblNewLabel.setFont(new Font("Play", Font.PLAIN, 33));
		lblNewLabel.setBounds(270, 125, 260, 45);
		selectionPanel.add(lblNewLabel);
		
		JButton btnBook = new JButton("Book a Flight");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(mainPanel);
			}
		});
		btnBook.setBounds(332, 226, 135, 45);
		selectionPanel.add(btnBook);
		
		JLabel lblExit = new JLabel("\uF072");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblExit.setBounds(751, 11, 25, 30);
		selectionPanel.add(lblExit);
		
		JLabel lblMinimize = new JLabel("\uF030");
		lblMinimize.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblMinimize.setBounds(716, 11, 25, 30);
		selectionPanel.add(lblMinimize);
		
		JLabel logo_select = new JLabel("  MERC AIRLINE");
		logo_select.setFont(new Font("Play", Font.PLAIN, 25));
		logo_select.setBounds(257, 11, 286, 48);
		logo_select.setIcon(new ImageIcon(img_minilogo));
		selectionPanel.add(logo_select);
		
		JLabel lblReturnSelect = new JLabel("\uF033");		
		lblReturnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.previous(mainPanel);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblReturnSelect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblReturnSelect.setForeground(new Color(0, 51, 153));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblReturnSelect.setForeground(new Color(0, 0, 0));
			}
		});
		lblReturnSelect.setFont(new Font("Marlett", Font.PLAIN, 36));
		lblReturnSelect.setBounds(10, 15, 36, 39);
		selectionPanel.add(lblReturnSelect);
		
		CardLayout clInformationInputPanel = new CardLayout(0, 0);
		JPanel informationInput_panel = new JPanel();
		JPanel bookingPanel = new JPanel();
		bookingPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				clInformationInputPanel.show(informationInput_panel, "destination");
			}
		});
		bookingPanel.setLayout(null);
		mainPanel.add(bookingPanel, "booking");
		
		JButton btnDestinationProgress = new JButton("Destination");
		btnDestinationProgress.setEnabled(false);
		btnDestinationProgress.setBackground(new Color(255, 255, 255));
		btnDestinationProgress.setForeground(new Color(0, 0, 0));
		btnDestinationProgress.setBounds(92, 70, 110, 40);
		bookingPanel.add(btnDestinationProgress);
		
		JButton btnPassengerProgress = new JButton("Passenger");
		btnPassengerProgress.setEnabled(false);
		btnPassengerProgress.setBackground(new Color(255, 255, 255));
		btnPassengerProgress.setForeground(new Color(0, 0, 0));
		btnPassengerProgress.setBounds(254, 70, 110, 40);
		bookingPanel.add(btnPassengerProgress);
		
		JButton btnBreakdownProgress = new JButton("Summary");
		btnBreakdownProgress.setEnabled(false);
		btnBreakdownProgress.setBackground(new Color(255, 255, 255));
		btnBreakdownProgress.setForeground(new Color(0, 0, 0));
		btnBreakdownProgress.setBounds(416, 70, 110, 40);
		bookingPanel.add(btnBreakdownProgress);
		
		JButton btnPaymentProgress = new JButton("Payment");
		btnPaymentProgress.setEnabled(false);
		btnPaymentProgress.setBackground(new Color(255, 255, 255));
		btnPaymentProgress.setForeground(new Color(0, 0, 0));
		btnPaymentProgress.setBounds(578, 70, 110, 40);
		bookingPanel.add(btnPaymentProgress);
		
		JProgressBar progressBarFillup = new JProgressBar();
		progressBarFillup.setBounds(132, 84, 514, 14);
		bookingPanel.add(progressBarFillup);
		progressBarFillup.setForeground(new Color(0, 0, 102));
		
		
		
		
		//Create Destinations Objects
				Destination[] destination = new Destination[10];
				//Local
				for (int i=0; i<4;i++) {
					destination[i] = new Local();
					String temp = ((Local) destination[i]).get_location(i);
					String dest[] = temp.split(",");
					destination[i].setDestination(dest[0],dest[1]);
				}
				//International
				for(int i=4;i<10;i++) {
					destination[i] = new International();
					String temp = ((International) destination[i]).get_location(i-4);
					String dest[] = temp.split(",");
					destination[i].setDestination(dest[0],dest[1]);
				}
				
				//Create Airplane Objects (for loops dedicated for 5 airplane per destination per type thus sum of 150)
				AirplaneType[] airplane = new AirplaneType[150];
				int tempNumofAirplane = 0;
				
				for(int i=0; i<destination.length;i++) {
					String[] tempDest = destination[i].getDestination().split(",");
					for (int j = 0;j<5;j++) {
						airplane[tempNumofAirplane++] = new Regular(tempDest[0],tempDest[1],tempNumofAirplane);
						airplane[tempNumofAirplane++] = new Private(tempDest[0],tempDest[1],tempNumofAirplane);
						airplane[tempNumofAirplane++] = new Business(tempDest[0],tempDest[1],tempNumofAirplane);
					}
				}
				
				
		
		JLabel lblExit_book = new JLabel("\uF072");
		lblExit_book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit_book.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblExit_book.setBounds(765, 11, 25, 30);
		bookingPanel.add(lblExit_book);
		
		JLabel lblMinimize_book = new JLabel("\uF030");
		lblMinimize_book.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblMinimize_book.setBounds(730, 11, 25, 30);
		bookingPanel.add(lblMinimize_book);
		
		JLabel logo_book = new JLabel("  MERC AIRLINE");
		logo_book.setFont(new Font("Play", Font.PLAIN, 25));
		logo_book.setBounds(257, 11, 286, 48);
		logo_book.setIcon(new ImageIcon(img_minilogo));
		bookingPanel.add(logo_book);
		
		
		informationInput_panel.setBounds(25, 121, 742, 355);
		bookingPanel.add(informationInput_panel);		
		informationInput_panel.setLayout(clInformationInputPanel);
		
		JPanel DestinationPanel = new JPanel();
		
		
		informationInput_panel.add(DestinationPanel, "destination");
		DestinationPanel.setLayout(null);
		
		JComboBox comboBox_AirplaneList = new JComboBox();
		comboBox_AirplaneList.setBounds(365, 227, 135, 22);
		DestinationPanel.add(comboBox_AirplaneList);
		
		DefaultTableModel myTablemodel = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
		        return false;
		      }
		};
		JScrollPane scrollPane_Table = new JScrollPane();
		scrollPane_Table.setBounds(241, 122, 259, 94);
		DestinationPanel.add(scrollPane_Table);
		table_AirplaneAvailable = new JTable(myTablemodel);
		scrollPane_Table.setViewportView(table_AirplaneAvailable);
		table_AirplaneAvailable.getTableHeader().setReorderingAllowed(false);
		myTablemodel.addColumn("Airplane #");
		myTablemodel.addColumn("Available Seats");
		table_AirplaneAvailable.setRowSelectionAllowed(false);
		table_AirplaneAvailable.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JComboBox comboBox_To = new JComboBox();
		Destination list = new Destination();
		JComboBox comboBox_From = new JComboBox(list.listFrom);
		
		
		JRadioButton rdbtn_Regular = new JRadioButton("Regular");
		JRadioButton rdbtn_Business = new JRadioButton("Business");
		JRadioButton rdbtn_Private = new JRadioButton("Private");
		ButtonGroup planeRadioButton = new ButtonGroup();
		comboBox_To.setBounds(116, 65, 127, 22);
		DestinationPanel.add(comboBox_To);
		
		
		String [] withoutManila = list.listWithoutManila;
		
		comboBox_From.setBounds(116, 32, 127, 22);
		DestinationPanel.add(comboBox_From);
		
		
		
		rdbtn_Regular.setBounds(261, 60, 86, 23);
		rdbtn_Regular.setSelected(true);
		DestinationPanel.add(rdbtn_Regular);
		
		
		
		rdbtn_Business.setBounds(349, 60, 86, 23);
		DestinationPanel.add(rdbtn_Business);
		
			
		rdbtn_Private.setBounds(437, 60, 86, 23);		
		DestinationPanel.add(rdbtn_Private);
		
		
		
		
		planeRadioButton.add(rdbtn_Regular);
		planeRadioButton.add(rdbtn_Business);
		planeRadioButton.add(rdbtn_Private);
		
		comboBox_From.setSelectedIndex(-1);
		comboBox_From.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				comboBox_To.removeAllItems();
				String temp = comboBox_From.getSelectedItem().toString();
				if(temp.equals("Manila")) {
					for (String str:withoutManila) {
						comboBox_To.addItem(str);
					}
					
				}else {
					comboBox_To.addItem("Manila");
				}
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);				
			}
		});
		
		comboBox_To.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
			}
				
			
		});
		
		comboBox_To.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!(comboBox_To.getItemCount()==0)) {
					fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
				}				
			}
		});
		
//		fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
		
		
		comboBox_From.setSelectedIndex(0);
		
		
		rdbtn_Regular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
			}
		});
		rdbtn_Private.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
			}
		});
		rdbtn_Business.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setBounds(80, 36, 46, 14);
		DestinationPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setBounds(80, 69, 46, 14);
		DestinationPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Airplane Type");
		lblNewLabel_3.setBounds(323, 36, 133, 14);
		DestinationPanel.add(lblNewLabel_3);
		
		
		
		JButton btnDestinationNext = new JButton("Confirm");
		btnDestinationNext.setBounds(593, 321, 89, 23);
		DestinationPanel.add(btnDestinationNext);
		
		
		JLabel lblNewLabel_4 = new JLabel("<html><center>Enter # of Passenger for this transaction<center><html>");
		lblNewLabel_4.setBounds(525, 26, 127, 29);
		DestinationPanel.add(lblNewLabel_4);
		
		textField_NumPassengers = new JTextField();
		textField_NumPassengers.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_NumPassengers.getText().length()==0) {
					if(e.getKeyChar() == KeyEvent.VK_0) {
						e.consume();
					}
				}
				if(textField_NumPassengers.getText().length()==2) {
					e.consume();					
				}
				if (!(Character.isDigit(e.getKeyChar()))) {
		               e.consume();
		        }
				
			}
		});
		textField_NumPassengers.setBounds(545, 67, 86, 20);
		DestinationPanel.add(textField_NumPassengers);
		textField_NumPassengers.setColumns(10);
		
		
		JLabel lblPassNum = new JLabel("Passenger Number");
		btnDestinationNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean numPass = checkInputNumPassengers(textField_NumPassengers,comboBox_AirplaneList,airplane);
				if(numPass) {
					clInformationInputPanel.next(informationInput_panel);
					numOfPassengerObj(textField_NumPassengers);
					currentIndexPassenger = 0;
					lblPassNum.setText(lblPassNum.getText().substring(0,16)+" "+(currentIndexPassenger+1));
					tempPassengerDetails = new String [maxIndexPassenger][3];					
				}else {
					if(textField_NumPassengers.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(prompt,"Sorry! You have to input number of Passenger","Alert",JOptionPane.WARNING_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(prompt,"Sorry! You have exceeded the number of \r\n"
								+ "passengers required","Alert",JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Choose an Airplane");
		lblNewLabel_5.setBounds(241, 231, 259, 14);
		DestinationPanel.add(lblNewLabel_5);
		
		JButton btnNextPassenger = new JButton("Next Passenger");
		JButton btnPreviousPassenger = new JButton("Prev. Passenger");
		JCheckBox chckbxInsurance = new JCheckBox("Travel Insurance");
		
		btnPreviousPassenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnPreviousPassenger.isEnabled()) {
					setPassengerDet(textField_Name,textField_Age,chckbxInsurance,currentIndexPassenger);
					chckbxInsurance.setSelected(false);
					currentIndexPassenger--;
					lblPassNum.setText(lblPassNum.getText().substring(0,16)+" "+(currentIndexPassenger+1));
					if(currentIndexPassenger==0) {					
						btnPreviousPassenger.setEnabled(false);
					}
					btnNextPassenger.setEnabled(true);
					fillPassengerDet(textField_Name,textField_Age,chckbxInsurance,currentIndexPassenger);
				}				
			}
		});
		btnNextPassenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnNextPassenger.isEnabled()) {
					btnPreviousPassenger.setEnabled(true);
					setPassengerDet(textField_Name,textField_Age,chckbxInsurance,currentIndexPassenger);
					chckbxInsurance.setSelected(false);
					currentIndexPassenger++;
					lblPassNum.setText(lblPassNum.getText().substring(0,16)+" "+(currentIndexPassenger+1));
					if ((currentIndexPassenger+1)==(maxIndexPassenger)) {
						btnNextPassenger.setEnabled(false);
					}
					fillPassengerDet(textField_Name,textField_Age,chckbxInsurance,currentIndexPassenger);
				}						
			}
		});
		JPanel PassengerPanel = new JPanel();
		PassengerPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				currentIndexPassenger=0;
				lblPassNum.setText(lblPassNum.getText().substring(0,16)+" "+(currentIndexPassenger+1));
				btnPreviousPassenger.setEnabled(false);
				if ((currentIndexPassenger+1)==(maxIndexPassenger)) {
					btnNextPassenger.setEnabled(false);
				}else {
					btnNextPassenger.setEnabled(true);
				}

				progressBarFillup.setValue(30);
				nyarf(btnDestinationProgress, btnPassengerProgress, btnBreakdownProgress, btnPaymentProgress);
				btnDestinationProgress.setBackground(new Color(0, 0, 102));
				btnDestinationProgress.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				textField_Name.setText(null);
				textField_Age.setText(null);
				btnPassengerProgress.setBackground(new Color(250,250,250));
				btnPassengerProgress.setForeground(new Color(0,0,0));
				
			}
		});
		informationInput_panel.add(PassengerPanel, "PassengerPanel");
		PassengerPanel.setLayout(null);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setBounds(288, 86, 46, 14);
		PassengerPanel.add(lblNewLabel_6);
		
		textField_Name = new JTextField();
		textField_Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if ((Character.isDigit(e.getKeyChar()))) {
		               e.consume();
		        }
			}
		});
		textField_Name.setBounds(288, 111, 170, 20);
		PassengerPanel.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setBounds(288, 150, 46, 14);
		PassengerPanel.add(lblNewLabel_7);
		
		textField_Age = new JTextField();
		textField_Age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_Age.getText().length()==0) {
					if(e.getKeyChar() == KeyEvent.VK_0) {
						e.consume();
					}
				}
				if(textField_Age.getText().length()==2) {
					e.consume();					
				}
				if (!(Character.isDigit(e.getKeyChar()))) {
		               e.consume();
		        }
			}
		});
		textField_Age.setBounds(288, 170, 86, 20);
		PassengerPanel.add(textField_Age);
		textField_Age.setColumns(10);
		
		
		chckbxInsurance.setBounds(288, 210, 130, 23);
		PassengerPanel.add(chckbxInsurance);
		
		JButton btnPassengerDetailsConfirm = new JButton("Confirm");
		btnPassengerDetailsConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if((textField_Name.getText().toString()).isBlank()||(textField_Age.getText().toString()).isBlank()) {
					JOptionPane.showMessageDialog(prompt,"Input Necessary Details","Alert",JOptionPane.WARNING_MESSAGE);
				}else {
					setPassengerDet(textField_Name,textField_Age,chckbxInsurance,currentIndexPassenger);
					if(checkTempDetails()) {
						clInformationInputPanel.next(informationInput_panel);
					}else {
						JOptionPane.showMessageDialog(prompt,"Cannot travel alone and must be accompanied by at least one \r\n"
								+ "(1) Adult and/or Senior Citizen","Alert",JOptionPane.WARNING_MESSAGE);
						
					}
				}
				
				
			}
		});
		btnPassengerDetailsConfirm.setBounds(617, 321, 89, 23);
		PassengerPanel.add(btnPassengerDetailsConfirm);
		
		
		lblPassNum.setBounds(201, 61, 140, 14);
		PassengerPanel.add(lblPassNum);
		
		JButton btnPassengerPanelBack = new JButton("Back to Destination");
		btnPassengerPanelBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clInformationInputPanel.previous(informationInput_panel);
				textField_Name.setText(null);
				textField_Age.setText(null);
				chckbxInsurance.setSelected(false);
				Arrays.fill(tempPassengerDetails, null);
				btnPassengerProgress.setBackground(new Color(255, 255, 255));
				btnPassengerProgress.setForeground(new Color(0, 0, 0));
			}
		});
		btnPassengerPanelBack.setBounds(10, 11, 201, 23);
		PassengerPanel.add(btnPassengerPanelBack);
		
		
		btnPreviousPassenger.setEnabled(false);
		btnPreviousPassenger.setBounds(175, 260, 130, 23);
		PassengerPanel.add(btnPreviousPassenger);
		
		
		btnNextPassenger.setBounds(415, 260, 130, 23);
		PassengerPanel.add(btnNextPassenger);
		
		
		Transaction fare = new Transaction();
		
		
		JPanel BreakdownPanel = new JPanel();
		informationInput_panel.add(BreakdownPanel, "Breakdown");
		BreakdownPanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Summary of Transaction");
		lblNewLabel_8.setBounds(315, 16, 150, 14);
		BreakdownPanel.add(lblNewLabel_8);
		
		JScrollPane scrollPane_Total = new JScrollPane();
		scrollPane_Total.setBounds(10, 261, 722, 40);
		BreakdownPanel.add(scrollPane_Total);
		
		
		DefaultTableModel myTablemodel_Total = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
		        return false;
		      }
		};
		table_Total = new JTable(myTablemodel_Total);
		scrollPane_Total.setViewportView(table_Total);
		table_Total.getTableHeader().setReorderingAllowed(false);
		table_Total.getTableHeader().setResizingAllowed(false);
		
		JScrollPane scrollPane_Regular = new JScrollPane();
		scrollPane_Regular.setBounds(10, 58, 722, 70);
		BreakdownPanel.add(scrollPane_Regular);
		
		myTablemodel_Total.addColumn("Fare");
		myTablemodel_Total.addColumn("Tax");
		myTablemodel_Total.addColumn("Baggage");
		myTablemodel_Total.addColumn("Insurance");
		myTablemodel_Total.addColumn("Discounts");
		myTablemodel_Total.addColumn("Transaction");
		myTablemodel_Total.addColumn("Total");
		
		DefaultTableModel myTablemodel_Regular = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
		        return false;
		      }
		};
		table_regular = new JTable(myTablemodel_Regular);
		scrollPane_Regular.setViewportView(table_regular);
		table_regular.getTableHeader().setReorderingAllowed(false);
		table_regular.getTableHeader().setResizingAllowed(false);
		
		myTablemodel_Regular.addColumn("Passenger #");
		myTablemodel_Regular.addColumn("Name");
		myTablemodel_Regular.addColumn("Age");
		myTablemodel_Regular.addColumn("Fare");
		myTablemodel_Regular.addColumn("Tax");
		myTablemodel_Regular.addColumn("Baggage");
		myTablemodel_Regular.addColumn("Insurance");
		myTablemodel_Regular.addColumn("Sub-Total");
		
		JScrollPane scrollPane_Discounted = new JScrollPane();
		scrollPane_Discounted.setBounds(10, 164, 722, 70);
		BreakdownPanel.add(scrollPane_Discounted);
		
		DefaultTableModel myTablemodel_Discounted = new DefaultTableModel(){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
		        return false;
		      }
		};
		table_discounted = new JTable(myTablemodel_Discounted);
		scrollPane_Discounted.setViewportView(table_discounted);
		table_discounted.getTableHeader().setReorderingAllowed(false);
		table_discounted.getTableHeader().setResizingAllowed(false);
		
		myTablemodel_Discounted.addColumn("Passenger #");
		myTablemodel_Discounted.addColumn("Name");
		myTablemodel_Discounted.addColumn("Age");
		myTablemodel_Discounted.addColumn("Fare");
		myTablemodel_Discounted.addColumn("Tax");
		myTablemodel_Discounted.addColumn("Baggage");
		myTablemodel_Discounted.addColumn("Insurance");
		myTablemodel_Discounted.addColumn("Discount");
		myTablemodel_Discounted.addColumn("Sub-Total");
		
		JButton btnSummaryConfirm = new JButton("Confirm");
		btnSummaryConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clInformationInputPanel.next(informationInput_panel);
			}
		});
		btnSummaryConfirm.setBounds(653, 332, 89, 23);
		BreakdownPanel.add(btnSummaryConfirm);
		
		JButton btnBackSummary = new JButton("Back to Passenger Details");
		btnBackSummary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clInformationInputPanel.previous(informationInput_panel);
				btnBreakdownProgress.setBackground(new Color(255, 255, 255));
				btnBreakdownProgress.setForeground(new Color(0, 0, 0));
			}
		});
		btnBackSummary.setBounds(0, 0, 188, 23);
		BreakdownPanel.add(btnBackSummary);
		
		JLabel lblNewLabel_12 = new JLabel("Regular");
		lblNewLabel_12.setBounds(356, 41, 68, 14);
		BreakdownPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Discounted");
		lblNewLabel_13.setBounds(348, 139, 76, 14);
		BreakdownPanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Total");
		lblNewLabel_14.setBounds(362, 245, 46, 14);
		BreakdownPanel.add(lblNewLabel_14);
		
		BreakdownPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				progressBarFillup.setValue(60);
				nyarf(btnDestinationProgress, btnPassengerProgress, btnBreakdownProgress, btnPaymentProgress);
				btnPassengerProgress.setBackground(new Color(0, 0, 102));
				btnPassengerProgress.setForeground(new Color(0,0,0));
				String destination = comboBox_From.getSelectedItem().toString()+","+comboBox_To.getSelectedItem().toString();
				int index_destination = fare.get_indexofDestination(destination);
				int index_selectedPlane = Integer.parseInt(comboBox_AirplaneList.getSelectedItem().toString()) - 1; 
				int travel_fare = 0;
				if(airplane[index_selectedPlane] instanceof Regular) {
					travel_fare = fare.get_regularFare(index_destination);
				}
				if(airplane[index_selectedPlane] instanceof Business) {
					travel_fare = fare.get_businessFare(index_destination);
				}
				if(airplane[index_selectedPlane] instanceof Private) {
					travel_fare = fare.get_privateFare(index_destination);
				}
				passengers = new Passenger[maxIndexPassenger];
				fillPassengers(passengers,index_selectedPlane, airplane, (float)travel_fare);
				fillTableModels(myTablemodel_Regular, myTablemodel_Discounted, myTablemodel_Total, passengers, airplane, comboBox_AirplaneList);
			}
			
		});
		
		JPanel PaymentPanel = new JPanel();
		
		informationInput_panel.add(PaymentPanel, "Payment");
		PaymentPanel.setLayout(null);
		
		
		JLabel lblNewLabel_9 = new JLabel("Transaction Total:");
		lblNewLabel_9.setBounds(321, 56, 122, 14);
		PaymentPanel.add(lblNewLabel_9);
		
		JLabel lblGrandTotal = new JLabel("\u20B1");
		lblGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandTotal.setBounds(139, 93, 455, 14);
		PaymentPanel.add(lblGrandTotal);
		
		textField_AmountPaid = new JTextField();
		textField_AmountPaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField_AmountPaid.getText().length()==0) {
					if(e.getKeyChar() == KeyEvent.VK_0) {
						e.consume();
					}
				}
				if(textField_AmountPaid.getText().length()==lblGrandTotal.getText().length()-2) {
					e.consume();					
				}
				if (!(Character.isDigit(e.getKeyChar()))) {
		               e.consume();
		        }
			}
		});
		textField_AmountPaid.setBounds(299, 157, 144, 20);
		PaymentPanel.add(textField_AmountPaid);
		textField_AmountPaid.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Amount:");
		lblNewLabel_11.setBounds(194, 160, 91, 14);
		PaymentPanel.add(lblNewLabel_11);
		
		JButton btnPrintReceipt = new JButton("Save Receipt");
		btnPrintReceipt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnPrintReceipt.isEnabled()) {
					fare.createControlNum();					
					fare.generate_Receipt(passengers,airplane,comboBox_AirplaneList);
					btnPrintReceipt.setEnabled(false);					
				}
			}
		});
		btnPrintReceipt.setEnabled(false);
		btnPrintReceipt.setBounds(275, 258, 191, 23);
		PaymentPanel.add(btnPrintReceipt);
		
		JButton btnPay = new JButton("Pay");
		
		btnPay.setBounds(326, 202, 89, 23);
		PaymentPanel.add(btnPay);
		
		JButton btnBackPayment = new JButton("Back to Summary");
		btnBackPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clInformationInputPanel.previous(informationInput_panel);
			}
		});
		btnBackPayment.setBounds(10, 11, 151, 23);
		PaymentPanel.add(btnBackPayment);
		
		JButton btnFinishTransaction = new JButton("Finish Transaction");
		btnFinishTransaction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnFinishTransaction.isEnabled()) {
					btnFinishTransaction.setEnabled(false);
					cl.previous(mainPanel);
				}				
			}
		});
		btnFinishTransaction.setEnabled(false);
		btnFinishTransaction.setBounds(563, 321, 169, 23);
		PaymentPanel.add(btnFinishTransaction);
		
		JLabel lblReturnBooking = new JLabel("\uF033");
		lblReturnBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.previous(mainPanel);
			}
		});
		lblReturnBooking.setFont(new Font("Marlett", Font.PLAIN, 36));
		lblReturnBooking.setBounds(10, 15, 36, 39);
		bookingPanel.add(lblReturnBooking);
		
		btnPrintReceipt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnFinishTransaction.setEnabled(true);
			}
		});
		
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnPay.isEnabled()) {
					int amountPaid = Integer.parseInt(textField_AmountPaid.getText());
					if(amountPaid<grandTotal) {
						JOptionPane.showMessageDialog(prompt,"Invalid Amount","Alert",JOptionPane.WARNING_MESSAGE);
					}else {
						lblReturnBooking.setVisible(false);
						btnBackPayment.setVisible(false);
						textField_AmountPaid.setEnabled(false);
						btnPay.setEnabled(false);
						btnPrintReceipt.setEnabled(true);
						btnPaymentProgress.setBackground(new Color(0, 0, 102));
						btnPaymentProgress.setForeground(new Color(255, 255, 255));
						fare.set_amountPaid(amountPaid);
					}
				}
			}
		});
		
		PaymentPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				progressBarFillup.setValue(100);
				nyarf(btnDestinationProgress, btnPassengerProgress, btnBreakdownProgress, btnPaymentProgress);
				btnBreakdownProgress.setBackground(new Color(0, 0, 102));
				btnBreakdownProgress.setForeground(new Color(0, 0, 0));
				
				lblGrandTotal.setText(lblGrandTotal.getText().substring(0,1)+grandTotal);		
				textField_AmountPaid.setEnabled(true);
				textField_AmountPaid.setText("");
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				btnBreakdownProgress.setBackground(new Color(250, 250, 250));
				btnBreakdownProgress.setForeground(new Color(0, 0, 0));
				btnPaymentProgress.setBackground(new Color(250, 250, 250));
				btnPaymentProgress.setForeground(new Color(0, 0, 0));
				btnPassengerProgress.setBackground(new Color(250, 250, 250));
				btnPassengerProgress.setForeground(new Color(0, 0, 0));				
				lblReturnBooking.setVisible(false);
				btnBackPayment.setVisible(true);
				btnPay.setEnabled(true);
				btnPrintReceipt.setEnabled(false);
				lblReturnBooking.setVisible(true);
				
			}
		});
		
		DestinationPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				textField_NumPassengers.setText("");
				progressBarFillup.setValue(0);
				nyarf(btnDestinationProgress, btnPassengerProgress, btnBreakdownProgress, btnPaymentProgress);
				btnDestinationProgress.setBackground(new Color(255, 255, 255));
				btnDestinationProgress.setForeground(new Color(0, 0, 0));
				fillTableCombo(myTablemodel,planeRadioButton,comboBox_From,comboBox_To,airplane,comboBox_AirplaneList);
			}
		});
		
	}	
	
	protected void nyarf(JButton button1, JButton button2, JButton button3, JButton button4) {
		button1.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(false);
		button1.setVisible(true);
		button2.setVisible(true);
		button3.setVisible(true);
		button4.setVisible(true);
	}

	public void fillTableModels(DefaultTableModel regular, DefaultTableModel discount, DefaultTableModel total, Passenger[] passengers,AirplaneType[] airplane, JComboBox comboBox_AirplaneList) {
		regular.getDataVector().removeAllElements();
		discount.getDataVector().removeAllElements();
		total.getDataVector().removeAllElements();

		float total_fare=0;
		float total_tax=0;
		float total_baggage=0;
		float total_insurance=0;
		float total_Discounts=0;
		float total_subtotal=0;
		int selectedPlane = Integer.parseInt(comboBox_AirplaneList.getSelectedItem().toString());
		float transaction_fee = airplane[selectedPlane-1].get_transactionfee();
		
		for(int i=0; i<passengers.length;i++) {
			if(passengers[i] instanceof Child||passengers[i] instanceof Adult) {
				String[] data = {String.valueOf(i+1),passengers[i].get_name(),passengers[i].get_age(),
									String.valueOf(passengers[i].get_fare()), String.valueOf(passengers[i].get_tax()), String.valueOf(passengers[i].get_baggageFee()),
									String.valueOf(passengers[i].get_insurance()), String.valueOf(passengers[i].get_total())};
				total_fare += passengers[i].get_fare();
				total_tax += passengers[i].get_tax();
				total_baggage +=passengers[i].get_baggageFee();
				total_insurance += passengers[i].get_insurance();
				total_subtotal += passengers[i].get_total();
				regular.addRow(data);;
			}else {

				String[] data = {String.valueOf(i+1),passengers[i].get_name(),passengers[i].get_age(),
						String.valueOf(passengers[i].get_fare()),String.valueOf(passengers[i].get_tax()), String.valueOf(passengers[i].get_baggageFee()),
						String.valueOf(passengers[i].get_insurance()), String.valueOf(((Senior) passengers[i]).get_discount20percent()),
						String.valueOf(((Senior) passengers[i]).get_totalDiscountedPrice())};
				total_fare += passengers[i].get_fare();
				total_tax += passengers[i].get_tax();
				total_baggage +=passengers[i].get_baggageFee();
				total_insurance += passengers[i].get_insurance();
				total_Discounts += ((Senior) passengers[i]).get_discount20percent();
				total_subtotal += ((Senior) passengers[i]).get_totalDiscountedPrice();
				discount.addRow(data);
			}
			
		}
		total_subtotal = total_subtotal + transaction_fee;
		String [] numdata = {String.valueOf(total_fare),String.valueOf(total_tax),String.valueOf(total_baggage),
				String.valueOf(total_insurance),String.valueOf(total_Discounts), String.valueOf(transaction_fee), String.valueOf(total_subtotal)};
		total.addRow(numdata);
		
		grandTotal = total_subtotal;
	}
	
	public void fillPassengers(Passenger[] passengers, int selectedPlane, AirplaneType[] airplane, float fare){
		for(int i=0; i<tempPassengerDetails.length;i++) {
			//0-name
			//1-age
			//2-insurance
			String name = tempPassengerDetails[i][0].toString();
			boolean IsInsured = checkInsuranceAvailed(tempPassengerDetails[i][2].toString());
//			System.out.println(IsInsured);
			int age = Integer.parseInt(tempPassengerDetails[i][1].toString());
			float tax = airplane[selectedPlane].get_tax();
			float baggageFee = airplane[selectedPlane].get_baggagefee();
			float insuranceFee = airplane[selectedPlane].get_travelInsurance();
				if(age<19) {
					passengers[i] = new Child(name, age, fare, tax, baggageFee, insuranceFee, IsInsured);
				}else if(age<60) {
					passengers[i] = new Adult(name, age, fare, tax, baggageFee, insuranceFee, IsInsured);
				}else {
					passengers[i] = new Senior(name, age, fare, tax, baggageFee, insuranceFee, IsInsured);
				}
			
		}
//		int child = 0;
//		int adult = 0;
//		int senior = 0;
//		
//		for(Passenger nyarf:passengers) {
//			if(nyarf instanceof Child) {
//				child++;
//			}
//			if(nyarf instanceof Adult) {
//				adult++;
//			}
//			if(nyarf instanceof Senior) {
//				senior++;
//			}
//			System.out.println(nyarf.get_insurance());
//		}
//		System.out.println("Child ="+child);
//		System.out.println("Adult ="+adult);
//		System.out.println("Senior ="+senior);
	}
	public boolean checkInsuranceAvailed(String insurance) {
		if(insurance.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean checkTempDetails() {
		
		int adultsenior=0;
		int kids=0;
		
		for (int i=0; i<tempPassengerDetails.length; i++) {
			if (tempPassengerDetails[i][0] == null ||tempPassengerDetails[i][1] == null) {
				return false;
			}
			if (tempPassengerDetails[i][0].isBlank() ||tempPassengerDetails[i][1].isBlank()) {
				return false;
			}
			if(Integer.parseInt(tempPassengerDetails[i][1].toString())>18) {
				adultsenior++;
			}else {
				kids++;
			}
			
		}
		
		if(adultsenior==0) {
			return false;
		}else {
			return true;
		}
			
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	private void setNumofPassengerObj(Passenger[] passengers, int maxIndexPassenger) {
		passengers = new Passenger[maxIndexPassenger];		
	}
	
	public void numOfPassengerObj(JTextField textfield) {
		maxIndexPassenger = Integer.parseInt(textfield.getText().toString());
	}
	
	public void fillPassengerDet(JTextField name, JTextField age,JCheckBox insurance, int index) {
		name.setText(tempPassengerDetails[index][0]);
		age.setText(tempPassengerDetails[index][1]);
		if(tempPassengerDetails[index][2] == null||"".equals(tempPassengerDetails[index][2])) {
			insurance.setSelected(false);
		}else {
			insurance.setSelected(true);
		}
	}
	
	public void setPassengerDet(JTextField name, JTextField age,JCheckBox insurance, int index) {
		tempPassengerDetails[index][0] = name.getText();
		tempPassengerDetails[index][1] = age.getText();
		if(insurance.isSelected()) {
			
			tempPassengerDetails[index][2] = "1";
		}else {
			tempPassengerDetails[index][2] = "";
		}
	}
	
	public boolean checkInputNumPassengers(JTextField textField, JComboBox comboBox, AirplaneType[] airplane) {
		int selectedPlane = Integer.parseInt(comboBox.getSelectedItem().toString());
		
		if(textField.getText().toString().length()==0) {
			return false;
		}
		
		int numPassengers = Integer.parseInt(textField.getText().toString());
		
		
		int availableSeats = airplane[selectedPlane-1].get_seats_available();
		System.out.println(availableSeats+" "+numPassengers);
		if(availableSeats>=numPassengers) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void fillTableCombo(DefaultTableModel tmodel, ButtonGroup bg, JComboBox from, JComboBox to, AirplaneType[] airplane,JComboBox<String> selection) {
		tmodel.getDataVector().removeAllElements();
		selection.removeAllItems();
		String selectedAirplane = getSelectedButtonText(bg);
		String[] selectedDestination = {(String) from.getSelectedItem(),(String) to.getSelectedItem()};
		for (int i=0; i<airplane.length; i++) {
			String[] tempPlanedest = airplane[i].get_destination().split(",");
			if(selectedDestination[0].equals(tempPlanedest[0])&&selectedDestination[1].equals(tempPlanedest[1])) {
				switch (selectedAirplane) {
					case "Regular":
						if(airplane[i] instanceof Regular) {
							System.out.println("Regular");
							System.out.println(airplane[i].get_airplaneNumber());
							String[] data = {String.valueOf(airplane[i].get_airplaneNumber()) , String.valueOf(airplane[i].get_seats_available()) };
							tmodel.addRow(data);
							selection.addItem(data[0]);
						}
						break;
					case "Business":
						if(airplane[i] instanceof Business) {
							System.out.println("Business");
							System.out.println(airplane[i].get_airplaneNumber());
							String[] data = {String.valueOf(airplane[i].get_airplaneNumber()) , String.valueOf(airplane[i].get_seats_available()) };
							tmodel.addRow(data);
							selection.addItem(data[0]);
						}
						break;
					case "Private":
						if(airplane[i] instanceof Private) {
							System.out.println("Private");
							System.out.println(airplane[i].get_airplaneNumber());
							String[] data = {String.valueOf(airplane[i].get_airplaneNumber()) , String.valueOf(airplane[i].get_seats_available()) };
							tmodel.addRow(data);
							selection.addItem(data[0]);
						}
						break;
					
				}
					
			}
		}
	}
}
