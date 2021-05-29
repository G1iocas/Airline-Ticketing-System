package com.acdsg2.finalproj;

public class Transaction {
	//first [] is row
	// for 2nd []
	// 0=from
	// 1=to
	// 2=Private
	// 3=Business
	// 4=Regular
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
	
}
