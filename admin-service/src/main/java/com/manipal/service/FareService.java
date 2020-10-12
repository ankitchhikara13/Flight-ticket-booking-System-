package com.manipal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Fare;
import com.manipal.repository.IFareRepository;


@Service
public class FareService implements IFareService{
	@Autowired
	private IFareRepository repository;
	
	@Override
	public List<Fare> getAllFare() {
		List<Fare> flight = repository.findAll();
		return flight;
	}
	
	@Override
	public void UpdateFare(Fare fare) {
		repository.save(fare);
	}

	@Override
	public Fare getById(int id) {
		Fare fare= repository.findById(id).orElse(null);
		 return fare;
	}

	@Override
	public void addfare(Fare fare) {
		repository.save(fare);
		
	}
	
	
}
