package com.manipal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
	
	@Column(name="person_id")
	private int personId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="flight_no")
	private int flightNo;
	
	@Column(name="date_of_travel")
	private LocalDate dateOfTravel;
	
	@Column(name="departure_location")
	private String departureLocation;
	
	@Column(name="arrival_location")
	private String arrivalLocation;
	
	@Column(name="no_of_tickets")
	private int noOftickets;
	
	@Column(name="seat_type")
	private String seatType;
	
	
	@Column(name="total_fare")
	private double totalFare;
	
	@Column(name="booking_status")
	private String bookingStatus;

	public Booking() {}

	public Booking(int personId, int bookingId, int flightNo, LocalDate dateOfTravel, String departureLocation,
			String arrivalLocation, int noOftickets, String seatType, double totalFare,String bookingStatus) {
		super();
		this.personId = personId;
		this.bookingId = bookingId;
		this.flightNo = flightNo;
		this.dateOfTravel = dateOfTravel;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.noOftickets = noOftickets;
		this.seatType = seatType;
		this.totalFare = totalFare;
		this.bookingStatus=bookingStatus;
	}
	 

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public int getNoOftickets() {
		return noOftickets;
	}

	public void setNoOftickets(int noOftickets) {
		this.noOftickets = noOftickets;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	@Override
	public String toString() {
		return "Booking [personId=" + personId + ", bookingId=" + bookingId + ", flightNo=" + flightNo
				+ ", dateOfTravel=" + dateOfTravel + ", departureLocation=" + departureLocation + ", arrivalLocation="
				+ arrivalLocation + ", noOftickets=" + noOftickets + ", seatType=" + seatType + ", totalFare="
				+ totalFare + "]";
	}

	
	

	}
