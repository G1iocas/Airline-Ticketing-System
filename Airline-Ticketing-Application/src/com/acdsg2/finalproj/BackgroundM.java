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
	     
	     JLabel availabledes;
			JFrame Destinations;    
			Destinations=new JFrame();
		    Destinations.setSize(800,600);
			Destinations.setResizable(false);
			Destinations.setLayout(null);
			Destinations.setVisible(true);
			availabledes = new JLabel("Available Destinations",JLabel.CENTER);
			availabledes.setBounds(250,30,300,30); 
			availabledes.setFont(new Font("Arial", Font.PLAIN, 30));
			Destinations.add(availabledes);
			JRadioButton optionA=new JRadioButton("Manila to Batanes");
			optionA.setBounds(75,80,300,30);  
			optionA.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionA);
			JRadioButton optionB=new JRadioButton("Batanes to Manila"); 
			optionB.setBounds(75,108,300,30);    
			optionB.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionB);
			JRadioButton optionC=new JRadioButton("Manila to Palawan"); 
			optionC.setBounds(75,136,300,30);  
			optionC.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionC);
			JRadioButton optionD=new JRadioButton("Palawan to Manila"); 
			optionD.setBounds(75,164,300,30);    
			optionD.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionD);
			JRadioButton optionE=new JRadioButton("Manila to South Korea"); 
			optionE.setBounds(75,192,300,30);  
			optionE.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionE);
			JRadioButton optionF=new JRadioButton("South Korea to Manila");
			optionF.setBounds(75,220,300,30);    
			optionF.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionF);
			JRadioButton optionG=new JRadioButton("Manila to Japan");    
			optionG.setBounds(75,248,300,30);  
			optionG.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionG);
			JRadioButton optionH=new JRadioButton("Japan to Manila");  
			optionH.setBounds(75,276,300,30);    
			optionH.setFont(new Font("Arial", Font.PLAIN, 25)); 
			Destinations.add(optionH);
			JRadioButton optionI=new JRadioButton("Manila to Vietnam");  
			optionI.setBounds(75,304,300,30);  
			optionI.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(optionI);
			JRadioButton optionJ=new JRadioButton("Vietnam to Manila");  
			optionJ.setBounds(75,332,300,30);    
			optionJ.setFont(new Font("Arial", Font.PLAIN, 25)); 
			Destinations.add(optionJ);
			JButton b=new JButton("Choose Airplane Type");
			b.setBounds(265,425,300,60);
			b.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(b);
			JButton c=new JButton("Back");
			c.setBounds(320,500,200,50);
			c.setFont(new Font("Arial", Font.PLAIN, 25));
			Destinations.add(c);
			ButtonGroup r=new ButtonGroup();    
			r.add(optionA);
			r.add(optionB);
			r.add(optionC);
			r.add(optionD);
			r.add(optionE);
			r.add(optionF);
			r.add(optionG);
			r.add(optionH);
			r.add(optionI);
			r.add(optionJ);
			
			
			
			
			 
			//Airplane Type 
			JLabel label1,label2;
			JFrame Airplanetype;    
			Airplanetype=new JFrame();
			Airplanetype.setSize(800,600);
			Airplanetype.setResizable(false);
			Airplanetype.setLayout(null);
			Airplanetype.setVisible(true);
			label1 = new JLabel("Choose an Airplane Type",JLabel.CENTER);
			label1.setBounds(175,30,500,45); 
			label1.setFont(new Font("Arial", Font.PLAIN, 40));
			Airplanetype.add(label1);
			label2 = new JLabel("Destinations",JLabel.CENTER);
			label2.setBounds(265,70,300,30); 
		    label2.setFont(new Font("Arial", Font.PLAIN, 40));
		    Airplanetype.add(label2);
		    JRadioButton privatetype=new JRadioButton("Private"); 
		    privatetype.setBounds(350,150,300,40);  
			privatetype.setFont(new Font("Arial", Font.PLAIN, 30));
			Airplanetype.add(privatetype);
			JRadioButton businesstype=new JRadioButton("Business"); 
			businesstype.setBounds(350,199,300,40);    
			businesstype.setFont(new Font("Arial", Font.PLAIN, 30));
			Airplanetype.add(businesstype);
			JRadioButton regulartype=new JRadioButton("Regular");
			regulartype.setBounds(350,250,300,40);  
			regulartype.setFont(new Font("Arial", Font.PLAIN, 30));
			Airplanetype.add(regulartype);
			JButton details=new JButton("Enter Customer Details");
			details.setBounds(265,425,300,60);
			details.setFont(new Font("Arial", Font.PLAIN, 25));
			Airplanetype.add(details);
			JButton Back=new JButton("Back");
			Back.setBounds(320,500,200,50);
			Back.setFont(new Font("Arial", Font.PLAIN, 25));
			Airplanetype.add(Back);
			Airplanetype.add(details);
			ButtonGroup airtype=new ButtonGroup();    
			airtype.add(privatetype);
			airtype.add(businesstype);
			airtype.add(regulartype);
			
	     
	     
	}
}