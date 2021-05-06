package com.acdsg2.finalproj;

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
		
		
			
  
}

