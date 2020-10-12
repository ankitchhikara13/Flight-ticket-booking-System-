package com.manipal.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdvanceSearchBean {
	
	private boolean oneWay;
	private int goingFlightId;
	private int returnFlightId;
	private String depCity;
	private String arrCity;
	private LocalDate goingDate;
	private LocalDate returnDate;
	private LocalTime goingTime1;
	private LocalTime goingTime2;
	private LocalTime returnTime1;
	private LocalTime returnTime2;
	
	public AdvanceSearchBean() {}

	public AdvanceSearchBean(boolean oneWay, int goingFlightId, int returnFlightId, String depCity, String arrCity,
			LocalDate goingDate, LocalDate returnDate, LocalTime goingTime1, LocalTime goingTime2,
			LocalTime returnTime1, LocalTime returnTime2) {
		super();
		this.oneWay = oneWay;
		this.goingFlightId = goingFlightId;
		this.returnFlightId = returnFlightId;
		this.depCity = depCity;
		this.arrCity = arrCity;
		this.goingDate = goingDate;
		this.returnDate = returnDate;
		this.goingTime1 = goingTime1;
		this.goingTime2 = goingTime2;
		this.returnTime1 = returnTime1;
		this.returnTime2 = returnTime2;
	}

	public boolean isOneWay() {
		return oneWay;
	}

	public void setOneWay(boolean oneWay) {
		this.oneWay = oneWay;
	}

	public int getGoingFlightId() {
		return goingFlightId;
	}

	public void setGoingFlightId(int goingFlightId) {
		this.goingFlightId = goingFlightId;
	}

	public int getReturnFlightId() {
		return returnFlightId;
	}

	public void setReturnFlightId(int returnFlightId) {
		this.returnFlightId = returnFlightId;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public LocalDate getGoingDate() {
		return goingDate;
	}

	public void setGoingDate(LocalDate goingDate) {
		this.goingDate = goingDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalTime getGoingTime1() {
		return goingTime1;
	}

	public void setGoingTime1(LocalTime goingTime1) {
		this.goingTime1 = goingTime1;
	}

	public LocalTime getGoingTime2() {
		return goingTime2;
	}

	public void setGoingTime2(LocalTime goingTime2) {
		this.goingTime2 = goingTime2;
	}

	public LocalTime getReturnTime1() {
		return returnTime1;
	}

	public void setReturnTime1(LocalTime returnTime1) {
		this.returnTime1 = returnTime1;
	}

	public LocalTime getReturnTime2() {
		return returnTime2;
	}

	public void setReturnTime2(LocalTime returnTime2) {
		this.returnTime2 = returnTime2;
	}

	@Override
	public String toString() {
		return "AdvanceSearchBean [oneWay=" + oneWay + ", goingFlightId=" + goingFlightId + ", returnFlightId="
				+ returnFlightId + ", depCity=" + depCity + ", arrCity=" + arrCity + ", goingDate=" + goingDate
				+ ", returnDate=" + returnDate + ", goingTime1=" + goingTime1 + ", goingTime2=" + goingTime2
				+ ", returnTime1=" + returnTime1 + ", returnTime2=" + returnTime2 + "]";
	}
	
	
}
