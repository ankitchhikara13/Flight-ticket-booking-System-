package com.manipal.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.manipal.model.Fare;

@Repository
public interface IFareRepository extends JpaRepositoryImplementation<Fare, Integer> 
{
	
}


