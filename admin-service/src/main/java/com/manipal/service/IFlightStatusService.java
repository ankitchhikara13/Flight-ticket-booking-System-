package com.manipal.service;



import java.util.List;

import com.manipal.model.Fare;
import com.manipal.model.FlightStatus;
import com.manipal.model.Location;



public interface IFlightStatusService {
		
		public void addFlightStatus(FlightStatus status);
		public FlightStatus getFlightStatusById(int id);
		public List<FlightStatus> getAllFlightStatus();
		
		void UpdateFlightstatus(FlightStatus status);
		
		
}
