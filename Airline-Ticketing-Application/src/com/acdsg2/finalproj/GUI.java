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

public class GUI extends JFrame {

	private Image img_logo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(552,143,Image.SCALE_SMOOTH);
	private Image img_minilogo = new ImageIcon(GUI.class.getResource("/res/Logo.png"))
			.getImage().getScaledInstance(92,24,Image.SCALE_SMOOTH);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(mainPanel);
			}
		});
		btnSelect.setForeground(Color.BLACK);
		btnSelect.setFont(new Font("Play", Font.PLAIN, 20));
		btnSelect.setBorderPainted(false);
		btnSelect.setBackground(new Color(70, 130, 180));
		btnSelect.setBounds(275, 375, 150, 40);
		startingPanel.add(btnSelect);
		
		JButton btnExit = new JButton("Exit");
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
		mainPanel.add(bookingPanel, "name_44019102984900");
		
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
		informationInput_panel.setBounds(25, 121, 651, 341);
		bookingPanel.add(informationInput_panel);
		informationInput_panel.setLayout(new CardLayout(0, 0));
		
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
	}	
}
