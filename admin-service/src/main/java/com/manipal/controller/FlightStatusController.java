package com.manipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.exception.FlightdetailsNotFoundException;
import com.manipal.model.FlightStatus;
import com.manipal.model.Location;
import com.manipal.service.FlightStatusSevice;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value= "/flight/status")
public class FlightStatusController {
	
	@Autowired
	private FlightStatusSevice flightStatusService;
	
	@PostMapping
	public String addFlightStatus(@RequestBody FlightStatus status) {
		flightStatusService.addFlightStatus(status);
		return "Flight Status Added successfully";
	}
	
	@GetMapping("find/id/{id}")
	public FlightStatus getFareById(@PathVariable int id) throws FlightdetailsNotFoundException{
		FlightStatus flightStatus =  flightStatusService.getFlightStatusById(id);
		if(flightStatus==null) {
			throw new FlightdetailsNotFoundException("Enter a Valid FlightStatus Id");
		}
		return flightStatus;
	}
	
	
	@GetMapping("all")
	public List<FlightStatus> getAllFlightStatus(){
		List<FlightStatus> flig = (List<FlightStatus>) flightStatusService.getAllFlightStatus();
		return flig;
	}
	
	@PutMapping("update")
	public String updateMovie(@RequestBody FlightStatus status) {
		flightStatusService.UpdateFlightstatus(status);
		return "FlightStatus updated successfully";
	}
	
}
