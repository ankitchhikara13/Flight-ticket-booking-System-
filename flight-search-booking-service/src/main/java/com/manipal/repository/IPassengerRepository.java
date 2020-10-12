package com.manipal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.model.Passenger;

@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Integer>{

}
