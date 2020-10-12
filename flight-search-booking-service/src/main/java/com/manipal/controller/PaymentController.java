package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.Payment;
import com.manipal.service.IPaymentService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	IPaymentService service;
	
	@PostMapping("/addpayment")
	public String addpayment(@RequestBody Payment payment ) {
		service.addcard(payment);
		return "payment Added successfully";
	}

}
