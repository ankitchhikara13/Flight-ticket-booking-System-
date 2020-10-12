package com.manipal.service;

import java.util.List;

import com.manipal.model.Booking;


public interface IBookingService {

	Booking addBooking(Booking booking);
	List<Booking> getBookingById(int personId);
	double getFare(Booking booking);
	Booking getBooking2ById(int bookingId);
	boolean deleteBooking(int bookingId);
	List<Booking> getall();
	List<Booking> getbystatus(String status);
	
}
