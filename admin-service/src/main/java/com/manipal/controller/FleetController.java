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
import com.manipal.model.Fleet;
import com.manipal.service.IFleetService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value= "/flight/fleet")
public class FleetController {
	
	@Autowired
	private IFleetService service;

	@PostMapping
	public String savedetails(@RequestBody Fleet fleet) {
		System.out.println(fleet);
		service.saveFleet(fleet);
		return "Fleet added successfully";
	}
	@GetMapping("all")
	public List<Fleet> getAllFleet(){
		List<Fleet> telephone = (List<Fleet>) service.getAllFleet();
		return telephone;
	}
	@GetMapping("find/id/{id}")
	public Fleet getAllFleet(@PathVariable int id) throws FlightdetailsNotFoundException{
		Fleet fleet =  service.getId(id);
		if(fleet==null) {
			throw new FlightdetailsNotFoundException("Fleet ID is invalid. Please enter correct Fleet ID.");
		}
		return fleet;
	}

	@PutMapping("update")
	public String UpateFleet(@RequestBody Fleet fleet) {
			service.UpdateFleet(fleet);
		return "Fleet updated successfully";
	}
	
	/*task5-delete telephone details by id*/
	@DeleteMapping("delete/id/{id}")
	public String deleteFleet(@PathVariable int id) throws FlightdetailsNotFoundException{
		Fleet fleet=service.getId(id);
		if(fleet==null)			
			throw new FlightdetailsNotFoundException("Fleet ID is invalid. Please enter correct Fleet ID.");
		else {
			service.deleteFleet(id);
			return "Fleet details deleted Successfully";}
	}
}
