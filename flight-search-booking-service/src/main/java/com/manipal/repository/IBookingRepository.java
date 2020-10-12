package com.manipal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.model.Booking;




@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer>{
	public List<Booking> findByPersonId(int personId);
	public List<Booking> findByBookingStatus(String status);
}
