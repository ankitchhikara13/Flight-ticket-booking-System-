package com.manipal.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.model.AdvanceSearchBean;
import com.manipal.model.FlightBean;
import com.manipal.service.SearchService;

@RestController
@RequestMapping("/search")
@CrossOrigin(origins="http://localhost:3000")
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	@GetMapping("date/{date}/dep/{dep}/arr/{arr}")
	public List<FlightBean> search1(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,@PathVariable String dep,@PathVariable String arr){
		return service.searchByDateAndCities(date, dep, arr);
	}
	
	@PostMapping
	public Map<String,List<FlightBean>> search2(@RequestBody AdvanceSearchBean srch){
		return service.advSearch(srch);
	}
}
