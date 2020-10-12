package com.manipal.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.manipal.model.Flight;
import com.manipal.model.FlightStatus;

@Repository
public interface IFlightStatusRepository extends JpaRepositoryImplementation<FlightStatus, Integer> 
{
	
}


