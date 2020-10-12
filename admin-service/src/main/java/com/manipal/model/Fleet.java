package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fleet")
public class Fleet {

	@Id
	private int id;
	private String code;
	private String model;
	@Column(name="total_economy_seats")
	private int totalEconomySeats;
	@Column(name="total_premium_seats")
	private int totalPremiumSeats;
	@Column(name="total_business_seats")
	private int totalBusinessSeats;
	private String status;
	public Fleet() { }
	
	public Fleet(int id, String code, String model, int totalEconomySeats, int totalPremiumSeats,
			int totalBusinessSeats, String status) {
		super();
		this.id = id;
		this.code = code;
		this.model = model;
		this.totalEconomySeats = totalEconomySeats;
		this.totalPremiumSeats = totalPremiumSeats;
		this.totalBusinessSeats = totalBusinessSeats;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalEconomySeats() {
		return totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() {
		return totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public int getTotalBusinessSeats() {
		return totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
	}

	@Override
	public String toString() {
		return "Fleet [id=" + id + ", code=" + code + ", model=" + model + ", totalEconomySeats=" + totalEconomySeats
				+ ", totalPremiumSeats=" + totalPremiumSeats + ", totalBusinessSeats=" + totalBusinessSeats + "]";
	}
	
}
