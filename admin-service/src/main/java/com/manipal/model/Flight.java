package com.manipal.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="flight")
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flight_id")
	private int flightId;
	@Column(name="arrival_time")
	private LocalTime arrivalTime;
	@Column(name="departure_time")
	private LocalTime departureTime;
	@Column(name="date")
	private LocalDate date;
	@Column(name="arrival_location_id")
	private int arrivalLocationId;
	@Column(name="departure_location_id")
	private int departureLocationId;
	@Column(name="fleet_id")
	private int fleetId;
	@Column(name="fare_id")
	private int fareId;
	@Column(name="flight_status_id")
	private int flightStatusId;
	private String status;
	public Flight() {}

	public Flight(int flightId, LocalTime arrivalTime, LocalTime departureTime, LocalDate date, int arrivalLocationId,
			int departureLocationId, int fleetId, int fareId, int flightStatusId,  String status) {
		super();
		this.flightId = flightId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.date = date;
		this.arrivalLocationId = arrivalLocationId;
		this.departureLocationId = departureLocationId;
		this.fleetId = fleetId;
		this.fareId = fareId;
		this.flightStatusId = flightStatusId;
		this.status=  status;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getArrivalLocationId() {
		return arrivalLocationId;
	}

	public void setArrivalLocationId(int arrivalLocationId) {
		this.arrivalLocationId = arrivalLocationId;
	}

	public int getDepartureLocationId() {
		return departureLocationId;
	}

	public void setDepartureLocationId(int departureLocationId) {
		this.departureLocationId = departureLocationId;
	}

	public int getFleetId() {
		return fleetId;
	}

	public void setFleetId(int fleetId) {
		this.fleetId = fleetId;
	}

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	public int getFlightStatusId() {
		return flightStatusId;
	}

	public void setFlightStatusId(int flightStatusId) {
		this.flightStatusId = flightStatusId;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", date=" + date + ", arrivalLocationId=" + arrivalLocationId + ", departureLocationId="
				+ departureLocationId + ", fleetId=" + fleetId + ", fareId=" + fareId + ", flightStatusId="
				+ flightStatusId + "]";
	}

	
	
	
	
	
	
}
