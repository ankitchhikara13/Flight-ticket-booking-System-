package com.manipal.controller;

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
import com.manipal.model.Location;
import com.manipal.service.ILocationService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value= "/flight/location")
public class LocationController {


	@Autowired
	private ILocationService service;

	@PostMapping
	public String savedetails(@RequestBody Location location) {
		System.out.println(location);
		service.saveLocation(location);
		return "Location added successfully";
	}
	@GetMapping("all")
	public List<Location> getAllMovie(){
		List<Location> telephone = (List<Location>) service.getAllLocation();
		return telephone;
	}

	@PutMapping("update")
	public String updateMovie(@RequestBody Location location) {
			service.UpdateLocation(location);
		return "Location updated successfully";
	}
	
	@GetMapping("/find/id/{id}")
	public Location getFareById(@PathVariable int id) throws FlightdetailsNotFoundException{
		Location location =  service.getId(id);
		if(location==null) {
			throw new FlightdetailsNotFoundException("Enter a Valid Location Id");
		}
		return location;
	}
	
	/*task5-delete telephone details by id*/
	@DeleteMapping("delete/id/{id}")
	public String deleteTelephone(@PathVariable int id) throws FlightdetailsNotFoundException{
		Location location=service.getId(id);
		if(location==null)			
			throw new FlightdetailsNotFoundException("Location ID is invalid. Please enter correct Location ID.");
		else {
			service.deleteLoaction(id);
			return "Location details deleted Successfully";}
	}
}
