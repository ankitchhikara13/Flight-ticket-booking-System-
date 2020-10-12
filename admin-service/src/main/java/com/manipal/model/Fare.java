package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fare")
public class Fare {
	@Id
	private int id;
	@Column(name="economy_fare")
	private double economyFare;
	@Column(name="premium_fare")
	private double premiumfare;
	@Column(name="business_fare")
	private double businessFare;
	private String status;
	public Fare() { }
	
	public Fare(int id, double economyFare, double premiumfare, double businessFare ,String status) {
		super();
		this.id = id;
		this.economyFare = economyFare;
		this.premiumfare = premiumfare;
		this.businessFare = businessFare;
		this.status= status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
