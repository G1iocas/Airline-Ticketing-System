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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
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

public class GUI extends JFrame {

	private Image img_logo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(552,143,Image.SCALE_SMOOTH);
	private Image img_minilogo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(92,24,Image.SCALE_SMOOTH);
	private JTextField textField;
	private JTable table_AirplaneAvailable;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 700, 500);
		getContentPane().add(mainPanel);
		CardLayout cl = new CardLayout(0, 0);
		mainPanel.setLayout(cl);
		
		JPanel startingPanel = new JPanel();
		startingPanel.setLayout(null);
		mainPanel.add(startingPanel, "start");
		
		JLabel startPanel_Title = new JLabel("<html><center>MERC AIRLINE TICKETING SYSTEM<center><html>");
		startPanel_Title.setFont(new Font("Play", Font.BOLD, 50));
		startPanel_Title.setBounds(96, 234, 507, 118);
		startingPanel.add(startPanel_Title);
		
		JLabel logo = new JLabel("");
		logo.setBounds(74, 57, 552, 166);
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
		btnSelect.setBounds(275, 375, 150, 40);
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
		btnExit.setBounds(305, 426, 89, 23);
		startingPanel.add(btnExit);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(null);
		mainPanel.add(selectionPanel, "select");
		
		JLabel lblNewLabel = new JLabel("Select Operation:");
		lblNewLabel.setFont(new Font("Play", Font.PLAIN, 33));
		lblNewLabel.setBounds(220, 125, 260, 45);
		selectionPanel.add(lblNewLabel);
		
		JButton btnBook = new JButton("Book a Flight");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(mainPanel);
			}
		});
		btnBook.setBounds(282, 226, 135, 45);
		selectionPanel.add(btnBook);
		
		JButton btnAdmin = new JButton("Admin Control");
		btnAdmin.setBounds(282, 296, 135, 45);
		selectionPanel.add(btnAdmin);
		
		JLabel lblExit = new JLabel("\uF072");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblExit.setBounds(665, 11, 25, 30);
		selectionPanel.add(lblExit);
		
		JLabel lblMinimize = new JLabel("\uF030");
		lblMinimize.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblMinimize.setBounds(630, 11, 25, 30);
		selectionPanel.add(lblMinimize);
		
		JLabel logo_select = new JLabel("  MERC AIRLINE");
		logo_select.setFont(new Font("Play", Font.PLAIN, 25));
		logo_select.setBounds(207, 11, 286, 48);
		logo_select.setIcon(new ImageIcon(img_minilogo));
		selectionPanel.add(logo_select);
		
		JLabel lblReturnSelect = new JLabel("\uF033");
		lblReturnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.previous(mainPanel);
			}
		});
		lblReturnSelect.setFont(new Font("Marlett", Font.PLAIN, 36));
		lblReturnSelect.setBounds(10, 15, 36, 39);
		selectionPanel.add(lblReturnSelect);
		
		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(null);
		mainPanel.add(bookingPanel, "booking");
		
		JLabel lblExit_book = new JLabel("\uF072");
		lblExit_book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit_book.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblExit_book.setBounds(665, 11, 25, 30);
		bookingPanel.add(lblExit_book);
		
		JLabel lblMinimize_book = new JLabel("\uF030");
		lblMinimize_book.setFont(new Font("Marlett", Font.PLAIN, 25));
		lblMinimize_book.setBounds(630, 11, 25, 30);
		bookingPanel.add(lblMinimize_book);
		
		JLabel logo_book = new JLabel("  MERC AIRLINE");
		logo_book.setFont(new Font("Play", Font.PLAIN, 25));
		logo_book.setBounds(207, 11, 286, 48);
		logo_book.setIcon(new ImageIcon(img_minilogo));
		bookingPanel.add(logo_book);
		
		JPanel informationInput_panel = new JPanel();
		informationInput_panel.setBounds(25, 121, 650, 355);
		bookingPanel.add(informationInput_panel);
		informationInput_panel.setLayout(new CardLayout(0, 0));
		
		JPanel DestinationPanel = new JPanel();
		informationInput_panel.add(DestinationPanel, "destination");
		DestinationPanel.setLayout(null);
		
		JComboBox comboBox_From = new JComboBox();
		comboBox_From.setBounds(74, 32, 127, 22);
		DestinationPanel.add(comboBox_From);
		
		JComboBox comboBox_To = new JComboBox();
		comboBox_To.setBounds(74, 65, 127, 22);
		DestinationPanel.add(comboBox_To);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setBounds(38, 36, 46, 14);
		DestinationPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setBounds(38, 69, 46, 14);
		DestinationPanel.add(lblNewLabel_2);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setBounds(219, 60, 63, 23);
		DestinationPanel.add(rdbtnRegular);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Airplane Type");
		lblNewLabel_3.setBounds(292, 36, 114, 14);
		DestinationPanel.add(lblNewLabel_3);
		
		JRadioButton rdbtn_Business = new JRadioButton("Business");
		rdbtn_Business.setBounds(307, 60, 67, 23);
		DestinationPanel.add(rdbtn_Business);
		
		JRadioButton rdbtn_Private = new JRadioButton("Private");
		rdbtn_Private.setBounds(395, 60, 63, 23);
		DestinationPanel.add(rdbtn_Private);
		
		JButton btnDestinationNext = new JButton("Confirm");
		btnDestinationNext.setBounds(551, 321, 89, 23);
		DestinationPanel.add(btnDestinationNext);
		
		JLabel lblNewLabel_4 = new JLabel("<html><center>Enter # of Passenger for this transaction<center><html>");
		lblNewLabel_4.setBounds(483, 26, 127, 29);
		DestinationPanel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(503, 67, 86, 20);
		DestinationPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDestinationPicture = new JLabel("Picture of destination");
		lblDestinationPicture.setBounds(91, 195, 114, 14);
		DestinationPanel.add(lblDestinationPicture);
		
		table_AirplaneAvailable = new JTable();
		table_AirplaneAvailable.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		table_AirplaneAvailable.setBounds(281, 120, 321, 94);
		DestinationPanel.add(table_AirplaneAvailable);
		
		JLabel lblNewLabel_5 = new JLabel("Choose an Airplane");
		lblNewLabel_5.setBounds(292, 242, 114, 14);
		DestinationPanel.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(416, 238, 133, 22);
		DestinationPanel.add(comboBox);
		
		JPanel PassengerPanel = new JPanel();
		informationInput_panel.add(PassengerPanel, "name_313588846459700");
		PassengerPanel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setBounds(156, 86, 46, 14);
		PassengerPanel.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 116, 86, 20);
		PassengerPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Age");
		lblNewLabel_7.setBounds(156, 150, 46, 14);
		PassengerPanel.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(156, 178, 86, 20);
		PassengerPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Travel Insurance");
		chckbxNewCheckBox.setBounds(156, 220, 130, 23);
		PassengerPanel.add(chckbxNewCheckBox);
		
		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.setBounds(531, 295, 89, 23);
		PassengerPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_12 = new JLabel("\uF034");
		lblNewLabel_12.setFont(new Font("Marlett", Font.PLAIN, 33));
		lblNewLabel_12.setBounds(580, 25, 39, 41);
		PassengerPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("\uF033");
		lblNewLabel_12_1.setFont(new Font("Marlett", Font.PLAIN, 33));
		lblNewLabel_12_1.setBounds(531, 25, 39, 41);
		PassengerPanel.add(lblNewLabel_12_1);
		
		JPanel BreakdownPanel = new JPanel();
		informationInput_panel.add(BreakdownPanel, "name_314668628873400");
		BreakdownPanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Summary of Transaction");
		lblNewLabel_8.setBounds(265, 24, 123, 14);
		BreakdownPanel.add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 65, 559, 210);
		BreakdownPanel.add(scrollPane);
		
		JEditorPane Breakdown_editor = new JEditorPane();
		Breakdown_editor.setContentType("text/html");
		Breakdown_editor.setEditable(false);
		scrollPane.setViewportView(Breakdown_editor);
		
		JButton btnNewButton_3 = new JButton("Confirm");
		btnNewButton_3.setBounds(551, 321, 89, 23);
		BreakdownPanel.add(btnNewButton_3);
		
		JPanel PaymentPanel = new JPanel();
		informationInput_panel.add(PaymentPanel, "name_316155436885600");
		PaymentPanel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Transaction Total:");
		lblNewLabel_9.setBounds(275, 56, 99, 14);
		PaymentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Chaching");
		lblNewLabel_10.setBounds(297, 97, 46, 14);
		PaymentPanel.add(lblNewLabel_10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(254, 157, 144, 20);
		PaymentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Amount:");
		lblNewLabel_11.setBounds(153, 160, 91, 14);
		PaymentPanel.add(lblNewLabel_11);
		
		JButton btnNewButton_4 = new JButton("Print Transaction Summary");
		btnNewButton_4.setBounds(422, 305, 191, 23);
		PaymentPanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pay");
		btnNewButton_5.setBounds(274, 202, 89, 23);
		PaymentPanel.add(btnNewButton_5);
		
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
		
		JButton btnDestinationProgress = new JButton("Destination");
		btnDestinationProgress.setEnabled(false);
		btnDestinationProgress.setBounds(52, 70, 110, 40);
		bookingPanel.add(btnDestinationProgress);
		
		JButton btnPassengerProgress = new JButton("Passenger");
		btnPassengerProgress.setEnabled(false);
		btnPassengerProgress.setBounds(214, 70, 110, 40);
		bookingPanel.add(btnPassengerProgress);
		
		JButton btnBreakdownProgress = new JButton("Breakdown");
		btnBreakdownProgress.setEnabled(false);
		btnBreakdownProgress.setBounds(376, 70, 110, 40);
		bookingPanel.add(btnBreakdownProgress);
		
		JButton btnPaymentProgress = new JButton("Payment");
		btnPaymentProgress.setEnabled(false);
		btnPaymentProgress.setBounds(538, 70, 110, 40);
		bookingPanel.add(btnPaymentProgress);
		
		JProgressBar progressBarFillup = new JProgressBar();
		progressBarFillup.setBounds(92, 84, 514, 14);
		bookingPanel.add(progressBarFillup);
	}	
}
