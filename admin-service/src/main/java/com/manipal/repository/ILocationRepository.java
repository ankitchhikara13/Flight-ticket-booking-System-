package com.manipal.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.manipal.model.Location;

@Repository
public interface ILocationRepository extends JpaRepositoryImplementation<Location, Integer> 
{
	
}


