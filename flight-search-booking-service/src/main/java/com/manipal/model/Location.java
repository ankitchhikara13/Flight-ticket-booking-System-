package com.manipal.model;



public class Location {

	private int id;
	private String name;
	private String code;
	private String airportName;
	private String country;
	
	public Location() {}
	public Location(int id, String name, String code, String airportName, String country) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.airportName = airportName;
		this.country = country;
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
				+ ", country=" + country + "]";
	}
	
	
}
