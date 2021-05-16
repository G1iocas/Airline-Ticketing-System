package com.acdsg2.finalproj;


public class Destination {

	String From;
	String To;
		
		
		
	public void Local(String F, String T) {
		From = F;
		To = T; 
	}
			
  
}

class Local extends Destination{
	
	String [][] location = {	{"Manila","Batanes"},
								{"Batanes", "Manila"},
								{"Manila", "Palawan"},
								{"Palawan", "Manila"}};		
	
}

class International extends Destination{
	
	String [][] location = {	{"Manila","South Korea"},
								{"South Korea","Manila"},
								{"Manila","Japan"},
								{"Japan","Manila"},
								{"Manila","Vietnam"},
								{"Vietnam","Manila"}};	
	
}