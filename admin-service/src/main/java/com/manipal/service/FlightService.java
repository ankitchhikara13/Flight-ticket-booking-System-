package com.manipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Flight;
import com.manipal.repository.IFlightRepository;


@Service
public class FlightService implements IFlightService{
	@Autowired
	private IFlightRepository repository;
	@Override
	public void saveFlight(Flight flight) 
	{
		 repository.save(flight);
	}
	@Override
	public List<Flight> getAllFlight() {
		List<Flight> flight = repository.findAll();
		return flight;
	}
	
	@Override
	public void UpdateFlight(Flight flight) {
		repository.save(flight);
	}
	@Override
	public void deleteFlight(int flightid) {
		repository.deleteById(flightid);
	}
	@Override
	public Flight getFlightById(int flightid) {

		return repository.findById(flightid).orElse(null);
	}
}
