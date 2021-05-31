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
	public void set_tax(float tax) {
		this.tax = tax;
	}
	public void set_baggage_fee(float baggage_fee) {
		this.baggage_fee = baggage_fee;
	}
	public void set_insurance_fee(float insurance_fee) {
		this.insurance_fee = insurance_fee;
	}
	public void set_fare(float fare) {
		this.fare = fare;
	}
	public String get_name() {
		return this.name;
	}
	public String get_age() {
		return (String.valueOf(this.age));
	}
	public float get_fare() {
		return this.fare;
	}
	public float get_baggageFee() {
		return this.baggage_fee;
	}
	public float get_insurance() {
		return this.insurance_fee;
	}
	public float get_tax() {
		return this.tax;
	}
	public float get_total() {
		return total;
	}
	public void compute() {
		this.total = fare + baggage_fee + insurance_fee + tax; 
	}
}

class Child extends Passenger{
	Child(String name, int age, float fare, float tax, float baggagefee, float insurancefee, boolean confirmInsurance){
		this.set_name(name);
		this.set_age(age);
		this.set_fare(fare);
		this.set_tax(tax);
		this.set_baggage_fee(baggagefee);		
		if(confirmInsurance) {
			this.set_insurance_fee(insurancefee);
		}else {
			this.set_insurance_fee(0);
		}
		this.compute();
	}
}
class Adult extends Passenger{
	Adult(String name, int age, float fare, float tax, float baggagefee, float insurancefee, boolean confirmInsurance){
		this.set_name(name);
		this.set_age(age);
		this.set_fare(fare);
		this.set_tax(tax);
		this.set_baggage_fee(baggagefee);
		if(confirmInsurance) {
			this.set_insurance_fee(insurancefee);
		}else {
			this.set_insurance_fee(0);
		}
		this.compute();
	}
}
class Senior extends Passenger{
	float discount20percent;
	float discountRate = .2f;
	float totalDiscountedPrice;
	Senior(String name, int age, float fare, float tax, float baggagefee, float insurancefee, boolean confirmInsurance){
		this.set_name(name);
		this.set_age(age);
		this.set_fare(fare);
		this.set_tax(0);
		this.set_baggage_fee(baggagefee);
		if(confirmInsurance) {
			this.set_insurance_fee(insurancefee);
		}else {
			this.set_insurance_fee(0);
		}
		this.compute();
		this.computeDiscounted();
	}

	public void computeDiscounted() {
		compute20percent();
		computeTotalDiscountedPrice();
	}

	public void compute20percent() {
		discount20percent = total*discountRate;
	}
	public void computeTotalDiscountedPrice() {
		totalDiscountedPrice = total - discount20percent;
	}
	public float get_discount20percent() {
		return this.discount20percent;
	}
	public float get_totalDiscountedPrice() {
		return this.totalDiscountedPrice;
	}
}
