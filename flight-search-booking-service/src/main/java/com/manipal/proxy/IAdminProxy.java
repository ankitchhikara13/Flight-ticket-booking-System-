package com.manipal.proxy;

import java.util.List;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manipal.model.Fare;
import com.manipal.model.Fleet;
import com.manipal.model.Flight;
import com.manipal.model.FlightStatus;
import com.manipal.model.Location;


@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="admin-service")
public interface IAdminProxy {
    @GetMapping("admin-service/flight/all")
    public List<Flight> getAllFlightDetails();
   
    @GetMapping("admin-service/flight/find/id/{id}")
    public Flight getFlightDetailsById(@PathVariable int id);
   
    @GetMapping("admin-service/flight/location/all")
    public List<Location> getAllLocationsDetails();
   
    @GetMapping("admin-service/flight/location/find/id/{id}")
    public Location getLocationDetailsById(@PathVariable int id);
   
    @GetMapping("admin-service/flight/fleet/all")
    public List<Fleet> getAllFleetsDetails();
   
    @GetMapping("admin-service/flight/fleet/find/id/{id}")
    public Fleet getFleetDetailsById(@PathVariable int id);
   
    @GetMapping("admin-service/flight/fare/all")
    public List<Fare> getAllFaresDetails();
   
    @GetMapping("admin-service/flight/fare/find/id/{id}")
    public Fare getFareDetailsById(@PathVariable int id);
   
    @GetMapping("admin-service/flight/status/all")
    public List<FlightStatus> getAllStatusDetails();
   
    @GetMapping("admin-service/flight/status/find/id/{id}")
    public FlightStatus getStatusDetailsById(@PathVariable int id);
   
    @PutMapping("admin-service/flight/status/update")
    public String updateflightStatus(@RequestBody FlightStatus status);
   
}
/*
//@FeignClient(name="Admin-service")


//@RibbonClient(name= "admin-service")
//@FeignClient(name="admin-service" ,url="localhost:9001")
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="admin-service")
public interface IAdminProxy {
	@GetMapping("admin-service/flight/alldetails")
	public List<Flight> getAllFlightDetails();
	
	@GetMapping("admin-service/flight/find/{id}")
	public Flight getFlightDetailsById(@PathVariable int id);
	
	@GetMapping("admin-service/flight/location/alldetails")
	public List<Location> getAllLocationsDetails();
	
	@GetMapping("admin-service/flight/location/find/{id}")
	public Location getLocationDetailsById(@PathVariable int id);
	
	@GetMapping("admin-service/flight/fleet/alldetails")
	public List<Fleet> getAllFleetsDetails();
	
	@GetMapping("admin-service/flight/fleet/find/{id}")
	public Fleet getFleetDetailsById(@PathVariable int id);
	
	@GetMapping("admin-service/flight/fare/alldetails")
	public List<Fare> getAllFaresDetails();
	
	@GetMapping("admin-service/flight/fare/find/{id}")
	public Fare getFareDetailsById(@PathVariable int id);
	
	@GetMapping("admin-service/flight/status/alldetails")
	public List<FlightStatus> getAllStatusDetails();
	
	@GetMapping("admin-service/flight/status/find/{id}")
	public FlightStatus getStatusDetailsById(@PathVariable int id);
	
	@PutMapping("admin-service/flight/status/update")
	public String updateflightStatus(@RequestBody FlightStatus status);
	
}
*/