package com.acdsg2.finalproj;

public class Passenger {
	
	String name;
	int age;
	
	float tax;
	float baggage_fee;
	float insurance_fee;
	float fare;
	float total;
	
	public void set_name(String name) {
		this.name = name;
	}
	public void set_age(int age) {
		this.age = age;
	}
	public void set_tax(int tax) {
		
	}
	public void set_baggage_fee(int baggage_fee) {
		this.baggage_fee = baggage_fee;
	}
	public void set_insurance_fee(int insurance_fee) {
		this.insurance_fee = insurance_fee;
	}
}

class Child extends Passenger{
	
}
class Adult extends Passenger{
	
}
class Senior extends Passenger{
	float discountTax;
	float discountTotal;
	float discountRate;
}
