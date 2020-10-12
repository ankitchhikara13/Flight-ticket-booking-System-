package com.manipal.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.manipal.model.Flight;

@Repository
public interface IFlightRepository extends JpaRepositoryImplementation<Flight, Integer> 
{
	
}


