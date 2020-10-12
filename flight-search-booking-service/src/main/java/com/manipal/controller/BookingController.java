package com.manipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Booking;
import com.manipal.service.IBookingService;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	IBookingService service;
	
	
	@GetMapping("/getall")
	public List<Booking> getall() {
		return service.getall();
	}
 	
	@PostMapping("/addBooking")
	public Booking addBookingDetails(@RequestBody Booking booking) {
		return service.addBooking(booking);
		
	}
 @GetMapping("/getFare") 
		public double getFare(@RequestBody Booking booking) {
		double fare=service.getFare(booking);
		return fare;
	}
	
	
	@GetMapping("/getdetailsbyid/{personId}")
	public List<Booking> getBookingDetails(@PathVariable int personId) {
		return service.getBookingById(personId);
		
	}
	
	@GetMapping("/getbookingbyid/{bookingId}") 
	public Booking getBookingById(@PathVariable int bookingId) {
		return service.getBooking2ById(bookingId);
	}
	

	
	@PutMapping("/cancelbooking/{bookingId}")
	public boolean deleteBooking(@PathVariable int bookingId){
		boolean request=service.deleteBooking(bookingId);
		if(request==true) {
			return true;
		}
		return false;
		
	}
	@GetMapping("/getdetailsbystatus/{bookingStatus}") 
	public List<Booking> getByStatus(@PathVariable String status) {
		return service.getbystatus(status);
	}
		
	

	
}
