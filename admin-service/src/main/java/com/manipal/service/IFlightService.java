package com.manipal.service;

import java.util.List;

import com.manipal.model.Flight;



public interface IFlightService {
		
		public void saveFlight(Flight flight);

		public List<Flight> getAllFlight();
		
		public void deleteFlight(int Flightid);

		void UpdateFlight(Flight flight);
		
		public Flight getFlightById(int locationid);
		
		
}
