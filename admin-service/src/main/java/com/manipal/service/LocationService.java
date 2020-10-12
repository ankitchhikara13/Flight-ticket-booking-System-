package com.manipal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Location;
import com.manipal.repository.ILocationRepository;


@Service
public class LocationService implements ILocationService{
	@Autowired
	private ILocationRepository repository;

	@Override
	public void saveLocation(Location location) {
		 repository.save(location);
		
	}

	@Override
	public void deleteLoaction(int loactionId) {
		repository.deleteById(loactionId);
		
	}

	@Override
	public void UpdateLocation(Location location) {
		repository.save(location);
	}

	@Override
	public Location getId(int locationid) {
		
		return repository.findById(locationid).orElse(null);
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> location = repository.findAll();
		return location;
	}
}
