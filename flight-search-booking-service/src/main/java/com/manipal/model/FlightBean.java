package com.manipal.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightBean {
	private int flightId;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private LocalDate date;
	private Location arrivalLocation;
	private Location departureLocation;
	private Fleet fleet;
	private Fare fare;
	private FlightStatus flightStatus;
	
	public FlightBean() {}

	

	public FlightBean(int flightId, LocalTime arrivalTime, LocalTime departureTime, LocalDate date,
			Location arrivalLocation, Location departureLocation, Fleet fleet, Fare fare, FlightStatus flightStatus) {
		super();
		this.flightId = flightId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
		this.arrivalLocation = arrivalLocation;
		this.departureLocation = departureLocation;
		this.fleet = fleet;
		this.fare = fare;
		this.flightStatus = flightStatus;
	}



	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public Location getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(Location arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Location getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(Location departureLocation) {
		this.departureLocation = departureLocation;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "FlightBean [flightId=" + flightId + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", date=" + date + ", arrivalLocation=" + arrivalLocation + ", departureLocation=" + departureLocation
				+ ", fleet=" + fleet + ", fare=" + fare + ", flightStatus=" + flightStatus + "]";
	}

	
	

	
}
