package com.manipal.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.manipal.model.Fleet;

@Repository
public interface IFleet extends JpaRepositoryImplementation<Fleet, Integer> 
{
	
}


