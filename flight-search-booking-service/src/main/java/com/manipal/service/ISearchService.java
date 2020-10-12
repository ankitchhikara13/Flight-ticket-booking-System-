package com.manipal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.manipal.model.AdvanceSearchBean;
import com.manipal.model.FlightBean;

public interface ISearchService {
	public List<FlightBean> searchByDateAndCities(LocalDate date,String city1,String city2);
	public Map<String,List<FlightBean>> advSearch(AdvanceSearchBean parameters);
}
