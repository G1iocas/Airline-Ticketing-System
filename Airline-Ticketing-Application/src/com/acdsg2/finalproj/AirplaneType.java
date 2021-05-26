package com.acdsg2.finalproj;

public class AirplaneType {
	
	int tax;
	int seats_available;
	int max_seats;
	int seats_reserved;
	int airplaneNumber;
	String destinationFrom;
	String destinationTo;
	
		
	public void set_tax(int tax) {
		this.tax = tax;
	}
	
	public void set_seats_available(int seats_available) {
		this.seats_available = seats_available;
	}
	public void set_max_seats(int max_seats) {
		this.max_seats = max_seats;
	}
	
	public void set_seats_reserved(int seats_reserved) {
		this.seats_reserved = seats_reserved;
	}
	
	public void set_destinationFrom(String destination) {
		this.destinationFrom = destination;
	}
	
	public void set_destinationTo(String destination) {
		this.destinationTo = destination;
	}
	
	public void set_airplaneNumber(int airplaneNumber){
		this.airplaneNumber = airplaneNumber;
	}
	
	public int get_tax(){
		return this.tax;
	}
	
	public int get_seats_available() {
		return this.seats_available;
	}
	public int get_max_seats() {
		return this.max_seats;
	}
	public int get_seats_reserved() {
		return this.seats_reserved;
	}
	public String get_destination() {
		return destinationFrom + "," + destinationTo;
	}
	
	public int get_airplaneNumber() {
		return airplaneNumber;
	}
}

class Regular extends AirplaneType{
	
	Regular(String to, String From, int num){
		this.set_tax(2500);
		this.set_seats_available(52);
		this.set_max_seats(100);
		this.set_seats_reserved(48);
		this.destinationTo = to;
		this.destinationFrom = From;
		this.airplaneNumber = num;
	}
		
}

class Private extends AirplaneType{
	Private(String to, String From, int num){
		this.set_tax(2500);
		this.set_seats_available(52);
		this.set_max_seats(100);
		this.set_seats_reserved(48);
		this.destinationTo = to;
		this.destinationFrom = From;
		this.airplaneNumber = num;
	}
	
}
class Business extends AirplaneType{
	Business(String to, String From, int num){
		this.set_tax(2500);
		this.set_seats_available(52);
		this.set_max_seats(100);
		this.set_seats_reserved(48);
		this.destinationTo = to;
		this.destinationFrom = From;
		this.airplaneNumber = num;
	}
	
}