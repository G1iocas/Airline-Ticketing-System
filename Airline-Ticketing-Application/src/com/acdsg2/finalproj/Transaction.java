package com.acdsg2.finalproj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComboBox;

public class Transaction {
	//first [] is row
	// for 2nd []
	// 0=from
	// 1=to
	// 2=Private
	// 3=Business
	// 4=Regular
	ArrayList<Integer> controlNumberList = new ArrayList<Integer>();
	int currentControlNumber;
	int amountPaid;
	float change;
	Transaction(){
		controlNumberList.add(0);
	}
	
	String [][] travel_fare = {	{"Manila","Batanes","8000","12500","3500"},
								{"Batanes", "Manila","9800","12950","3900"},
								{"Manila", "Palawan","9100","10500","3200"},
								{"Palawan", "Manila","9850","10975","3575"},
								{"Manila","South Korea","27450","37390","12055"},
								{"South Korea","Manila","30890","39650","13100"},
								{"Manila","Japan","40450","45355","27800"},
								{"Japan","Manila","43855","49780","29400"},
								{"Manila","Vietnam","8505","12345","3200"},
								{"Vietnam","Manila","14300","16320","4600"}};
	
	public int get_indexofDestination(String location) {
		
		String destination[] = location.split(",");
		
		int nyarf = 0;
		for(int i=0;i<travel_fare.length;i++) {
			if(destination[0].equals(travel_fare[i][0]) && destination[1].equals(travel_fare[i][1])) {
				nyarf = i;
			}
		}		
		return nyarf;		
	}
	
	public int get_regularFare(int i) {
		return Integer.parseInt(travel_fare[i][4]);
	}
	public int get_businessFare(int i) {
		return Integer.parseInt(travel_fare[i][3]);
	}
	public int get_privateFare(int i) {
		return Integer.parseInt(travel_fare[i][2]);
	}
	public void createControlNum() {
		int maxControlNum = Collections.max(controlNumberList);		
		currentControlNumber =  maxControlNum+1;
		controlNumberList.add(currentControlNumber);
	}
	public void set_amountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public void generate_Receipt(Passenger[] passengers,AirplaneType[] airplane, JComboBox comboBox_AirplaneList) {
		
		int selectedPlane = Integer.parseInt(comboBox_AirplaneList.getSelectedItem().toString());
		
		float total_fare=0;
		float total_tax=0;
		float total_baggage=0;
		float total_insurance=0;
		float total_Discounts=0;
		float total_subtotal=0;
		
		String desktopPath = System.getProperty("user.home").replace("\\", "/") + "/Desktop";
		desktopPath = desktopPath.replace("-", ":");
		desktopPath = desktopPath.replace("/", "\\");
		System.out.println(desktopPath);
		String desktopPathWithFile = desktopPath.substring(2)+"\\MERC - "+currentControlNumber+java.time.LocalTime.now()+".txt";
		desktopPathWithFile = desktopPathWithFile.replace(":", "-");
		desktopPathWithFile = "C:"+desktopPathWithFile;
		System.out.println(desktopPathWithFile);
		try {
		      File myObj = new File(desktopPathWithFile);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		try {
			FileWriter myWriter = new FileWriter(desktopPathWithFile);
			//Header
			myWriter.write("\tMERC AIRLINES");
			myWriter.write("\tLET'S FLY");
			myWriter.write("\n\n*THIS WILL SERVE AS AN OFFICIAL RECEIPT*\n\n");
			myWriter.write("\n\nControl Number : "+currentControlNumber+"\n\n");
			myWriter.write("Plane Number : "+selectedPlane+"\n\n");
			
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
					
					myWriter.write("\n\n\nName:\t\t\t"+data[1]);
					myWriter.write("\nAge:\t\t\t"+data[2]);
					myWriter.write("\nFare:\t\t\t"+data[3]);
					myWriter.write("\nTax:\t\t\t"+data[4]);
					myWriter.write("\nBaggage:\t\t"+data[5]);
					myWriter.write("\nInsurance:\t\t"+data[6]);
					myWriter.write("\n\nSub-total:\t\t"+data[7]);
					
					
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
					
					myWriter.write("\n\n\nName:\t\t\t"+data[1]);
					myWriter.write("\nAge:\t\t\t"+data[2]);
					myWriter.write("\nFare:\t\t\t"+data[3]);
					myWriter.write("\nTax:\t\t\t"+data[4]);
					myWriter.write("\nBaggage:\t\t"+data[5]);
					myWriter.write("\nInsurance:\t\t"+data[6]);
					myWriter.write("\nDiscount:\t\t"+data[7]);
					myWriter.write("\n\nSub-total:\t\t"+data[8]);
				}
				
			}
			String [] numdata = {String.valueOf(total_fare),String.valueOf(total_tax),String.valueOf(total_baggage),
					String.valueOf(total_insurance),String.valueOf(total_Discounts),String.valueOf(total_subtotal)};
			
			myWriter.write("\n\nTotal Fare:\t\t"+numdata[0]);
			myWriter.write("\nTota Tax:\t\t"+numdata[1]);
			myWriter.write("\nTotal Baggage:\t\t"+numdata[2]);
			myWriter.write("\nTotal Insurance:\t"+numdata[3]);
			myWriter.write("\nTotal Discount:\t\t"+numdata[4]);
			myWriter.write("\n\nTotal Amount:\t\t"+numdata[5]);
			myWriter.write("\n\nAmount Paid:\t\t"+amountPaid);
			change = amountPaid - Float.parseFloat(numdata[5]);
			myWriter.write("\n\nChange:\t\t\t"+change);
			myWriter.write("\n\n\nTHANK YOU FOR FLYING WITH US");
			myWriter.close();
			
			airplane[selectedPlane-1].set_transactedPassenger(passengers.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
