package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Passenger;
import com.manipal.model.Payment;
import com.manipal.repository.IPassengerRepository;
import com.manipal.repository.IPaymentRepository;



	@Service
	public class PassengerService implements IPassengerService {
		@Autowired
		IPassengerRepository repository;
		
		@Override
		public void adddetails(Passenger passenger) {
			repository.save(passenger);
		}

		
	}
		
	
