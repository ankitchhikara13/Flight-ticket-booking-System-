package com.manipal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Payment;
import com.manipal.repository.IPaymentRepository;

@Service
public class PaymentService implements IPaymentService {
	@Autowired
	IPaymentRepository repository;
	
	public void addcard(Payment payment) {
		repository.save(payment);
	}
	
}
