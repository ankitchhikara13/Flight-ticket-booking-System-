package com.manipal.model;


public class Fare {
	private int id;
	private double economyFare;
	private double premiumfare;
	private double businessFare;
	
	public Fare() { }
	
	public Fare(int id, double economyFare, double premiumfare, double businessFare) {
		super();
		this.id = id;
		this.economyFare = economyFare;
		this.premiumfare = premiumfare;
		this.businessFare = businessFare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEconomyFare() {
		return economyFare;
	}

	public void setEconomyFare(double economyFare) {
		this.economyFare = economyFare;
	}

	public double getPremiumfare() {
		return premiumfare;
	}

	public void setPremiumfare(double premiumfare) {
		this.premiumfare = premiumfare;
	}

	public double getBusinessFare() {
		return businessFare;
	}

	public void setBusinessFare(double businessFare) {
		this.businessFare = businessFare;
	}

	@Override
	public String toString() {
		return "Fare [id=" + id + ", economyFare=" + economyFare + ", premiumfare=" + premiumfare + ", businessFare="
				+ businessFare + "]";
	}
	 
	

}
