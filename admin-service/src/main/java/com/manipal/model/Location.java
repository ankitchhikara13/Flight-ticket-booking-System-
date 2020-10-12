		package com.manipal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")

public class Location {
@Id
	
	private int id;
	
	private String name;

	private String code;
	@Column(name="airport_name")
	private String airportName;
	private String country;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Location() {}
	public Location(int id, String name, String code, String airportName, String country, String status) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.airportName = airportName;
		this.country = country;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", code=" + code + ", airportName=" + airportName
				+ ", country=" + country + ", status=" + status + "]";
	}
	
	
}
