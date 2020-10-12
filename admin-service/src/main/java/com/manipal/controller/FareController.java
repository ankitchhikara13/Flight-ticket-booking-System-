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
import com.manipal.model.Fare;
import com.manipal.service.IFareService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value= "/flight/fare")
public class FareController {
	
	@Autowired
	private IFareService service;
	
	@PostMapping
	public String addFare(@RequestBody Fare fare) {
			service.addfare(fare);
		return "Fare Details Added successfully";
	}
	
	@GetMapping("all")
	public List<Fare> getAllFleet(){
		List<Fare> fare = (List<Fare>) service.getAllFare();
		return fare;
	}
	
	@GetMapping("/find/id/{id}")
	public Fare getFareById(@PathVariable int id) throws FlightdetailsNotFoundException{
		Fare fare =  service.getById(id);
		if(fare==null) {
			throw new FlightdetailsNotFoundException("Enter a Valid Fare Id");
		}
		return fare;
	}

	@PutMapping("update")
	public String UpdateFare(@RequestBody Fare fare) {
			service.UpdateFare(fare);
		return "Fare updated successfully";
	}

}
