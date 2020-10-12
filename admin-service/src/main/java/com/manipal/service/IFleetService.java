package com.manipal.service;



import java.util.List;

import com.manipal.model.Fleet;



public interface IFleetService {
		
		public void saveFleet(Fleet fleet);

		public void deleteFleet(int fleet);

		void UpdateFleet(Fleet fleet);
		
		public Fleet getId(int fleet);
		
		public List<Fleet> getAllFleet();
		
		
}
