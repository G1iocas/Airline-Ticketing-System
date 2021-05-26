package com.acdsg2.finalproj;

import java.util.ArrayList;
import java.util.Arrays;

public class Destination {

	String From;
	String To;
		
	String [] listFrom = {"Manila","Batanes","Palawan","South Korea","Japan","Vietnam"};
	ArrayList<String> listFromAL = new ArrayList<String>(Arrays.asList(listFrom));
	String [] listWithoutManila = {"Batanes","Palawan","South Korea","Japan","Vietnam"};
	
	public String[] fromList() {
		return this.listFrom;
	}
	
	public void setDestination(String F, String T) {
		From = F;
		To = T; 
	}
	public String getDestination() {
		return this.From +"," + this.To;
	}
		
	public String get_location;
	
	  
}

class Local extends Destination{
	
	String [][] location = {	{"Manila","Batanes"},
								{"Batanes", "Manila"},
								{"Manila", "Palawan"},
								{"Palawan", "Manila"}};		
	
	public String get_location(int i) {
		return location[i][0]+","+location[i][1];
	}
	
}

class International extends Destination{
	
	String [][] location = {	{"Manila","South Korea"},
								{"South Korea","Manila"},
								{"Manila","Japan"},
								{"Japan","Manila"},
								{"Manila","Vietnam"},
								{"Vietnam","Manila"}};	
	
	public String get_location(int i) {
		return location[i][0]+","+location[i][1];
	}
	
}


