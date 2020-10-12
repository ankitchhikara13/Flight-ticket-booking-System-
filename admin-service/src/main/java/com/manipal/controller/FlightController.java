package com.manipal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.exception.FlightdetailsNotFoundException;
import com.manipal.model.Flight;
import com.manipal.service.IFlightService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value= "/flight")
public class FlightController {
	
	@Autowired
	private IFlightService flightService;
	
	@PostMapping
	public String savedetails(@RequestBody Flight flight) {
		flightService.saveFlight(flight);
		return "Flight added successfully";
	}
	
	/*task2-get all details */
	@GetMapping("all")
	public List<Flight> getAllFlight(){
		List<Flight> flig = (List<Flight>) flightService.getAllFlight();
		return flig;
	}
	@GetMapping("find/id/{id}")
	public Flight getAllFlight(@PathVariable int id) throws FlightdetailsNotFoundException{
		Flight flight = flightService.getFlightById(id);
		if(flight == null)
			throw new FlightdetailsNotFoundException("Flight ID is invalid. Please enter correct Flight ID.");
		return flight;
	}

	@PutMapping("update")
	public String updateMovie(@RequestBody Flight flight) {
		flightService.UpdateFlight(flight);
		return "Flight updated successfully";
	}
	
	/*task5-delete telephone details by id*/
	@DeleteMapping("delete/id/{id}")
	public String deleteFlight(@PathVariable int id) throws FlightdetailsNotFoundException{
		Flight flight=flightService.getFlightById(id);
		if(flight==null)			
			throw new FlightdetailsNotFoundException("Flight ID is invalid. Please enter correct Flight ID.");
		else {
			flightService.deleteFlight(id);
			return "Flight details deleted Successfully";}
	}

}
