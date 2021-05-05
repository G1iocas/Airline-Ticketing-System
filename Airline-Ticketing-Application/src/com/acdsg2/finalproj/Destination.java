package com.acdsg2.finalproj;

import java.util.Scanner;
class Local{
	String From;
	String To;
	
	public Local(String F, String T) {
		From = F;
		To = T; 
	}
}
class International{
	String From;
	String To;
	public International(String F, String T) {
		From = F;
		To = T; 
	}
}

public class Destination {

	public static void main(String[] args) {
		Local OptionA = new Local("Manila","Batanes");
		Local OptionB = new Local("Batanes","Manila");
		Local OptionC = new Local("Manila","Palawan");
		Local OptionD = new Local("Palawan", "Manila");
		
		International OptionE = new International("Manila","South Korea");
	    International OptionF = new International("South Korea", "Manila");
	    International OptionG = new International("Manila","Japan");
	    International OptionH = new International("Japan", "Manila");
	    International OptionI = new International("Manila","Vietnam");
	    International OptionJ = new International("Vietnam", "Manila"); 
		
		Local[] local= {OptionA,OptionB,OptionC,OptionD};
		International[] international = {OptionE,OptionF,OptionG,OptionH,OptionI,OptionJ};
		
		
		Scanner scanner=new Scanner(System.in);
		

		
		System.out.println("1 = Local Flight \t 2 = International Flight");
		int Choice = scanner.nextInt();
			
			if (Choice==1) {
				System.out.println("Choose Travel Destination:");
				System.out.println("1 = Manila to Batanes");
				System.out.println("2 = Batanes to Manila");
				System.out.println("3 = Manila to Palawa");
				System.out.println("4 = Palawan to Manila");
				int localflight = scanner.nextInt();
		}
			
			
			
  }
}

