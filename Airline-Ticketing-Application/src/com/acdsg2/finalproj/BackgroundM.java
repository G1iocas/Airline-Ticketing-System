package com.acdsg2.finalproj;

import java.awt.Font;
import java.awt.Window;
import javax.swing.*;


public class BackgroundM {
	
	  public static void main(String args[]) {	
			
	//Main Menu
		//JFrame, Label, Button.
		JFrame main= new JFrame();  
	  	 main.setSize(800,600);
	  	 main.setLayout(null);  
	  	 main.setVisible(true); 
	  	 main.setResizable(false); 
	  	JLabel mainL1, mainL2, mainL3;  
	     mainL1=new JLabel("Welcome to", JLabel.CENTER);  
	  	 mainL1.setBounds(235,120, 300,30);
	  	 mainL1.setFont(new Font("Arial", Font.PLAIN, 35));
	  	 mainL2=new JLabel("MERC AIRLINE TICKETING SYSTEM", JLabel.CENTER);  
	  	 mainL2.setBounds(-10, 130, 800, 100);  
	  	 mainL2.setFont(new Font("Arial", Font.PLAIN, 38));
	  	 mainL3=new JLabel("Happy to Serve You!", JLabel.CENTER);  
	  	 mainL3.setBounds(145,210, 500,30);
	  	 mainL3.setFont(new Font("Arial", Font.PLAIN, 35));
	     main.add(mainL1); main.add(mainL2); main.add(mainL3);  
	 	JButton mainB1=new JButton("Book Now");  
	     mainB1.setBounds(285,350,200,50);  
	     mainB1.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton mainB2=new JButton("Exit");
	     mainB2.setBounds(312,420,150,30);
	     mainB2.setFont(new Font("Arial", Font.PLAIN, 20));
	     mainB2.addActionListener(e ->{ main.dispose(); });
	     main.add(mainB1); main.add(mainB2);

	     JFrame travelType= new JFrame();  
	  	 travelType.setSize(800,600);
	  	 travelType.setLayout(null);  
	  	 travelType.setVisible(true);
	  	 travelType.setResizable(false);   
	  	JLabel travelTypeL1;
	  	 travelTypeL1=new JLabel("Choose Travel Type", JLabel.CENTER);  
	  	 travelTypeL1.setBounds(225,100, 320,30);
	  	 travelTypeL1.setFont(new Font("Arial", Font.PLAIN, 35));
	     travelType.add(travelTypeL1);
	    JButton travelTypeB1=new JButton("Local");  
	     travelTypeB1.setBounds(285,180,200,60);  
	     travelTypeB1.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton travelTypeB2=new JButton("International");
	     travelTypeB2.setBounds(285,280,200,60);
	     travelTypeB2.setFont(new Font("Arial", Font.PLAIN, 30));
	    JButton travelTypeB3=new JButton("Back");
	     travelTypeB3.setBounds(312,380,150,30);
	     travelTypeB3.setFont(new Font("Arial", Font.PLAIN, 20));
	     travelTypeB3.addActionListener(e ->{ main.setVisible(true);; travelType.dispose();; });
	     travelType.add(travelTypeB1); travelType.add(travelTypeB2); travelType.add(travelTypeB3);
	}
}