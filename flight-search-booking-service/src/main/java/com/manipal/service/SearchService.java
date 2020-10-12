package com.manipal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.exception.FlightsNotFoundException;
import com.manipal.model.AdvanceSearchBean;
import com.manipal.model.Fare;
import com.manipal.model.Fleet;
import com.manipal.model.Flight;
import com.manipal.model.Location;
import com.manipal.model.FlightBean;
import com.manipal.proxy.IAdminProxy;


@Service
public class SearchService implements ISearchService {

	
	@Autowired
	IAdminProxy proxy; //This parameter is for connecting to admin-service through proxy
	
	/*
	 Function: getActiveFlights Parameters: flights
	 This function return flights which are active
	 */
	public List<Flight> getActiveFlights(List<Flight> flights){
		List<Flight> result=new ArrayList<Flight>();
		for(Flight f:flights) {
			if(f.getStatus()!=null&&f.getStatus().equals("active")) {
				result.add(f);
			}
		}
		if(result.size()==0)return null;
		return result;
	}
	
	/*
	 Function: searchByDateAndCities   Parameters: LocalDate,String,String
	 Description: This function is suppose to return list of flights based on date,arrival(city2),departure(city1) parameters
	 */
	@Override
	public List<FlightBean> searchByDateAndCities(LocalDate date, String city1, String city2) {
		List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
		if(flights==null)throw new FlightsNotFoundException("1No Flights Found for this route on specified Date");
		List<Location> locations=proxy.getAllLocationsDetails();
		if(locations==null)throw new FlightsNotFoundException("2No Flights Found for this route on specified Date");
		int city1Id=findIdOfLocation(locations,city1);
		int city2Id=findIdOfLocation(locations,city2);
		List<Flight> filteredFlights=new ArrayList<Flight>();
		for(Flight f:flights) {
			if((f.getDate().equals(date))&&(f.getDepartureLocationId()==city1Id)&&(f.getArrivalLocationId()==city2Id)) {
				filteredFlights.add(f);
			}
		}
		System.out.println("outside" + date +"----" + city1Id  + "-----" + city2Id);
		
		List<FlightBean> result=new ArrayList<FlightBean>();
		for(Flight f:filteredFlights) {
			FlightBean fb=makeFlightBean(f);
			System.out.println(f + "-------------ff--------------");
			System.out.println(fb + "-------------bfbbbbbbbbbbbb--------------");
			result.add(fb);
			}
	
		if(result.size()==0)throw new FlightsNotFoundException("3No Flights Found for this route on specified Date");
		
		return result;
	}
	
	/*
	 Function: findIdOfLocation Parameters: List<Location,String
	 Description: This function will return location id of city 
	 */
	public int findIdOfLocation(List<Location> locs,String city) {
		for(Location l:locs) {
			if(l.getName().equals(city))return l.getId();
		}
		return -1;
	}
	
	
	/*
	 Function: makeFlightBean Parameters: Flight
	 Description: This function will build FlightBean object from Flight object 
	 */
	public FlightBean makeFlightBean(Flight f) {
		
		FlightBean fb=new FlightBean();
		fb.setArrivalTime(f.getArrivalTime());
		fb.setDate(f.getDate());
		fb.setDepartureTime(f.getDepartureTime());
		fb.setFlightId(f.getFlightId());
		
		fb.setArrivalLocation(proxy.getLocationDetailsById(f.getArrivalLocationId()));
		fb.setDepartureLocation(proxy.getLocationDetailsById(f.getDepartureLocationId()));
		fb.setFare(proxy.getFareDetailsById(f.getFareId()));
		fb.setFleet(proxy.getFleetDetailsById(f.getFleetId()));
		fb.setFlightStatus(proxy.getStatusDetailsById(f.getFlightStatusId()));
		return fb;
	}
	
	/*
	 Function: getAllLocations 
	 Description: This function will return all the locations which are present in our database
	 */
	public List<String> getAllLocations(){
		List<Location> locations=proxy.getAllLocationsDetails();
		List<String> list=new ArrayList<String>();
		for(Location l:locations) {
			list.add(l.getName());
		}
		if(list.size()==0)return null;
		return list;
		
	}
	
	/*
	 Function: advSearch Parameters: AdvanceSearchBean
	 Description: This function will return Map which will have either have "going" ,or "going" and "return" key
		 Its value will be list of flights which will be filled on the basis of search parameters.
		 Parameters which are null i.e not specified by user will not be taken for search
		 Result returned will be AND Operation of all searches done efficiently.
	 */
	@Override
	public  Map<String,List<FlightBean>> advSearch(AdvanceSearchBean parameters) {
		// TODO Auto-generated method stub
		 Map<String,List<FlightBean>> map=new  LinkedHashMap<String,List<FlightBean>>();
		 
		
		 //If Flight Id is given than only that parameter will be taken to search for 'going' trip rest all parameters will be ignored 
		 //because user has  directly specified the flight in which he/she wants to travel
		if(parameters.getGoingFlightId()!=0) {
			Flight f=proxy.getFlightDetailsById(parameters.getGoingFlightId());
			if(f==null)throw new FlightsNotFoundException("Flights not Available for specified Id");
			FlightBean fb=makeFlightBean(f);
			List<FlightBean> list=new ArrayList<FlightBean>();
			list.add(fb);
			map.put("going", list);
			
		}
		else {
			// This if block will search on the basis of locations if specified
			if(parameters.getDepCity()!=null&&parameters.getArrCity()!=null) {
				List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
				if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
				List<Location> locations=proxy.getAllLocationsDetails();
				if(locations==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
				int city1Id=findIdOfLocation(locations,parameters.getDepCity());
				int city2Id=findIdOfLocation(locations,parameters.getArrCity());
				List<Flight> filteredFlights=new ArrayList<Flight>();
				for(Flight f:flights) {
					if((f.getDepartureLocationId()==city1Id)&&(f.getArrivalLocationId()==city2Id)) {
						filteredFlights.add(f);
					}
				}
				
				List<FlightBean> result=new ArrayList<FlightBean>();
				for(Flight f:filteredFlights) {
					FlightBean fb=makeFlightBean(f);
					result.add(fb);
					}
				if(result!=null) {
					map.put("going", result);
				}
				if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Route"); 
			}
			
			
			// This if block will search for journey date if specified 
			if(parameters.getGoingDate()!=null) {
				if(map.containsKey("going")) {
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(FlightBean f:map.get("going")) {
						if(f.getDate().equals(parameters.getGoingDate())) {
							result.add(f);
						}
					}
					
					if(result.size()==0l)throw new FlightsNotFoundException("Flights not Available for specified Journey Date"); 
					map.put("going", result);
				}
					
				else {
					List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
					if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(Flight f:flights) {
						if(f.getDate().equals(parameters.getGoingDate())) {
							result.add(makeFlightBean(f));
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Date"); 
					map.put("going", result);
				}
					
				}
			
			// This if block will search the flights which are avalilable between specified time intervals , if user has not given 
			// time intervals this block will be avoided
			if(parameters.getGoingTime1()!=null&&parameters.getGoingTime2()!=null) {
				if(map.containsKey("going")) {
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(FlightBean f:map.get("going")) {
						if(f.getDepartureTime().isAfter(parameters.getGoingTime1())&&f.getDepartureTime().isBefore(parameters.getGoingTime2())) {
							result.add(f);
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Time Slot"); 
					map.put("going", result);
				}
				
				else {
					List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
					if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(Flight f:flights) {
						if(f.getDepartureTime().isAfter(parameters.getGoingTime1())&&f.getDepartureTime().isBefore(parameters.getGoingTime2())) {
							result.add(makeFlightBean(f));
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Time Slot"); 
					map.put("going", result);
				}
			}
		}
		
		// If there are no flights found for 'going' trip than we will throw exception and search for return journey  will not be performed 
		if(map.containsKey("going")==false)throw new FlightsNotFoundException("No Flights Found");
		
		// Returning if it is one way search
		if(parameters.isOneWay())return map;
		
		// Return Journey Search Begins....
		
		// Everything is same as above only locations are interchanged and date and time intervals are taken for return attributes.(Provided in AdvanSearchBean)
		if(parameters.getReturnFlightId()!=0) {
			Flight f=proxy.getFlightDetailsById(parameters.getReturnFlightId());
			if(f==null)throw new FlightsNotFoundException("Flights not Available for specified Return Id");
			FlightBean fb=makeFlightBean(f);
			List<FlightBean> list=new ArrayList<FlightBean>();
			list.add(fb);
			map.put("return", list);
			
		}
		else {
			if(parameters.getDepCity()!=null&&parameters.getArrCity()!=null) {
				List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
				if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
				List<Location> locations=proxy.getAllLocationsDetails();
				if(locations==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
				int city1Id=findIdOfLocation(locations,parameters.getArrCity());
				int city2Id=findIdOfLocation(locations,parameters.getDepCity());
				List<Flight> filteredFlights=new ArrayList<Flight>();
				for(Flight f:flights) {
					if((f.getDepartureLocationId()==city1Id)&&(f.getArrivalLocationId()==city2Id)) {
						filteredFlights.add(f);
					}
				}
				
				List<FlightBean> result=new ArrayList<FlightBean>();
				for(Flight f:filteredFlights) {
					FlightBean fb=makeFlightBean(f);
					
					result.add(fb);
					
					
				}
				if(result!=null) {
					map.put("return", result);
				}
				if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Route"); 
			}
			
			if(parameters.getReturnDate()!=null) {
				if(map.containsKey("return")) {
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(FlightBean f:map.get("return")) {
						if(f.getDate().equals(parameters.getReturnDate())) {
							result.add(f);
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Date"); 
					map.put("return", result);
				}
					
				else {
					List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
					if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(Flight f:flights) {
						if(f.getDate().equals(parameters.getReturnDate())) {
							result.add(makeFlightBean(f));
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Date"); 
					map.put("return", result);
				}
					
				}
			if(parameters.getReturnTime1()!=null&&parameters.getReturnTime2()!=null) {
				if(map.containsKey("return")) {
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(FlightBean f:map.get("return")) {
						if(f.getDepartureTime().isAfter(parameters.getReturnTime1())&&f.getDepartureTime().isBefore(parameters.getReturnTime2())) {
							result.add(f);
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Time Slot"); 
					map.put("return", result);
				}
				
				else {
					List<Flight> flights=getActiveFlights(proxy.getAllFlightDetails());
					if(flights==null)throw new FlightsNotFoundException("No Flights Found for this route on specified Date");
					List<FlightBean> result=new ArrayList<FlightBean>();
					for(Flight f:flights) {
						if(f.getDepartureTime().isAfter(parameters.getReturnTime1())&&f.getDepartureTime().isBefore(parameters.getReturnTime2())) {
							result.add(makeFlightBean(f));
						}
					}
					
					if(result.size()==0)throw new FlightsNotFoundException("Flights not Available for specified Journey Time Slot"); 
					map.put("return", result);
				}
			}
		}
		
		//If there is no flight for return trip than we will throw exception
		
		if(map.containsKey("return")==false)throw new FlightsNotFoundException("No Flights Found for Return Journey");
		return map;
	}
}
