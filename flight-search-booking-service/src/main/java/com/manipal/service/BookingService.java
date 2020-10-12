package com.manipal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Booking;
import com.manipal.model.Location;
import com.manipal.model.Fare;
import com.manipal.model.Flight;
import com.manipal.model.FlightStatus;
import com.manipal.proxy.IAdminProxy;
import com.manipal.repository.IBookingRepository;

@Service
public class BookingService implements IBookingService {
	@Autowired
	IBookingRepository repository;
	
	@Autowired
	private IAdminProxy proxy;
	
	@Override
	public List<Booking> getall() {
		return repository.findAll();
	}
 	
	@Override
	public Booking addBooking(Booking booking) {
		// Ticket booking logic
		
		if(booking.getNoOftickets()==0) return null;
		Flight flight=proxy.getFlightDetailsById(booking.getFlightNo());
		if(flight==null)return null;
		if(!booking.getDateOfTravel().equals(flight.getDate()))return null;
		
		Location l1=proxy.getLocationDetailsById(flight.getArrivalLocationId());
		if(!l1.getName().equals(booking.getArrivalLocation()))return null;
		Location l2=proxy.getLocationDetailsById(flight.getDepartureLocationId());
		if(!l2.getName().equals(booking.getDepartureLocation()))return null;
		
		Fare fare=proxy.getFareDetailsById(flight.getFareId());
		FlightStatus status=proxy.getStatusDetailsById(flight.getFlightStatusId());
		
		
		if(booking.getSeatType().equals("Business")) {
			
			if(booking.getNoOftickets()>status.getRemainingBusinessSeats())return null;
			
			booking.setTotalFare(booking.getNoOftickets()*fare.getBusinessFare());
			status.setRemainingBusinessSeats(status.getRemainingBusinessSeats()-booking.getNoOftickets());
			String st=proxy.updateflightStatus(status);
			booking.setBookingStatus("Confirmed");
			return repository.save(booking);
					}
		
		
		if(booking.getSeatType().equals("Economy")) {
			
			if(booking.getNoOftickets()>status.getRemainingEconomySeats())return null;
			
			booking.setTotalFare(booking.getNoOftickets()*fare.getEconomyFare());
			status.setRemainingEconomySeats(status.getRemainingEconomySeats()-booking.getNoOftickets());
			String st=proxy.updateflightStatus(status);
			booking.setBookingStatus("Confirmed");
			return repository.save(booking);
			
		}
		
		if(booking.getSeatType().equals("Premium")) {
			
			if(booking.getNoOftickets()>status.getRemainingPremiunSeats())return null;
			
			booking.setTotalFare(booking.getNoOftickets()*fare.getPremiumfare());
			status.setRemainingPremiunSeats(status.getRemainingPremiunSeats()-booking.getNoOftickets());
			String st=proxy.updateflightStatus(status);
			booking.setBookingStatus("Confirmed");
			return repository.save(booking);
			
		}
	
		return null;
	}


	@Override
	public boolean deleteBooking(int bookingId) {
		Booking booking=getBooking2ById(bookingId);
		Flight flight=proxy.getFlightDetailsById(booking.getFlightNo());
		FlightStatus status=proxy.getStatusDetailsById(flight.getFlightStatusId());
		if(booking!=null) {
			if(booking.getSeatType().equals("Business")) {
				
				status.setRemainingBusinessSeats(status.getRemainingBusinessSeats()+booking.getNoOftickets());
				booking.setBookingStatus("Cancelled");
			}
			if(booking.getSeatType().equals("Economy")) {
				status.setRemainingEconomySeats(status.getRemainingEconomySeats()+booking.getNoOftickets());
				booking.setBookingStatus("Cancelled");
			}
			if(booking.getSeatType().equals("Premium")) {
				status.setRemainingPremiunSeats(status.getRemainingPremiunSeats()+booking.getNoOftickets());
				booking.setBookingStatus("Cancelled");
			}
			repository.save(booking);
		
			
			return true;
			
			}
		else {
		return false;
		}
	} 
	
	public double getFare(Booking booking) {
		Flight flight=proxy.getFlightDetailsById(booking.getFlightNo());
		Fare fare=proxy.getFareDetailsById(flight.getFareId());
		if(booking.getSeatType().equals("Economy")) {
			return fare.getEconomyFare()*booking.getNoOftickets();
		}
		if(booking.getSeatType().equals("Business")) {
			return fare.getBusinessFare()*booking.getNoOftickets();
		}
		if(booking.getSeatType().equals("Premium")) {
			return fare.getPremiumfare()*booking.getNoOftickets();
		}
		else return 0.0;
		
	}
	
	@Override
	public List<Booking> getBookingById(int personId) {
		return repository.findByPersonId(personId);
	}
  
	@Override
	public Booking getBooking2ById(int bookingId)
	{
	return repository.findById(bookingId).orElse(null);
		}
	
	@Override
	public List<Booking> getbystatus(String status) {
		return repository.findByBookingStatus(status);
	}

	}

	



