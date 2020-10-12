package com.manipal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.model.Payment;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer>{
	
}
