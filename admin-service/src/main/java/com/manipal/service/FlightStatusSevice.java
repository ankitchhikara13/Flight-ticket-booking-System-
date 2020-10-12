package com.manipal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.FlightStatus;
import com.manipal.model.Location;
import com.manipal.repository.IFlightStatusRepository;


@Service
public class FlightStatusSevice implements IFlightStatusService{

	@Autowired
	IFlightStatusRepository repository;

	@Override
	public List<FlightStatus> getAllFlightStatus() {
		List<FlightStatus> flightStatusList= repository.findAll();
		return flightStatusList;
	}

	@Override
	public FlightStatus getFlightStatusById(int id) {
		FlightStatus flightStatus= repository.findById(id).orElse(null);
		return flightStatus;
	}

	@Override
	public void UpdateFlightstatus(FlightStatus status) {
		repository.save(status);
	}

	@Override
	public void addFlightStatus(FlightStatus status) {
		repository.save(status);
	}
}
