package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Passenger;
import com.manipal.service.IPassengerService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/Passenger")
public class PassengerController {
	@Autowired
	IPassengerService service;
	
	@PostMapping("/adddetails")
	public String addpassenger(@RequestBody Passenger passenger ) {
		service.adddetails(passenger);
		return "passenger Added successfully";
	}

}