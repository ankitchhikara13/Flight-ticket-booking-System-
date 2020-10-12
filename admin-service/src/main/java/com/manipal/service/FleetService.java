package com.manipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Fleet;
import com.manipal.repository.IFleet;


@Service
public class FleetService implements IFleetService{
	@Autowired
	private IFleet repository;
	@Override
	public void saveFleet(Fleet fleet) 
	{
		 repository.save(fleet);
	}
	@Override
	public List<Fleet> getAllFleet() {
		List<Fleet> fleet = repository.findAll();
		return fleet;
	}
	
	@Override
	public void UpdateFleet(Fleet fleet) {
		repository.save(fleet);
	}
	@Override
	public void deleteFleet(int fleet) {
		repository.deleteById(fleet);
	}
	@Override
	public Fleet getId(int fleet) {

		return repository.findById(fleet).orElse(null);
	}
}
