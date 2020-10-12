package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flightstatus")
public class FlightStatus {
	
	@Id
	private int id;
	@Column(name="remaining_economy_seats")
	private int remainingEconomySeats;
	@Column(name="remaining_premium_seats")
	private int remainingPremiunSeats;
	@Column(name="remaining_business_seats")
	private int remainingBusinessSeats;
	
	public FlightStatus() { } 
	
	public FlightStatus(int id, int remainingEconomySeats, int remainingPremiunSeats, int remainingBusinessSeats) {
		super();
		this.id = id;
		this.remainingEconomySeats = remainingEconomySeats;
		this.remainingPremiunSeats = remainingPremiunSeats;
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRemainingEconomySeats() {
		return remainingEconomySeats;
	}
	public void setRemainingEconomySeats(int remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}
	public int getRemainingPremiunSeats() {
		return remainingPremiunSeats;
	}
	public void setRemainingPremiunSeats(int remainingPremiunSeats) {
		this.remainingPremiunSeats = remainingPremiunSeats;
	}
	public int getRemainingBusinessSeats() {
		return remainingBusinessSeats;
	}
	public void setRemainingBusinessSeats(int remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}

	@Override
	public String toString() {
		return "FlightStatus [id=" + id + ", remainingEconomySeats=" + remainingEconomySeats
				+ ", remainingPremiunSeats=" + remainingPremiunSeats + ", remainingBusinessSeats="
				+ remainingBusinessSeats + "]";
	}
	
	

}
