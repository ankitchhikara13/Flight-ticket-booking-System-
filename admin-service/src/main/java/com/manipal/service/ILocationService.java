package com.manipal.service;



import java.util.List;

import com.manipal.model.Location;



public interface ILocationService {
		
		public void saveLocation(Location location);

		public void deleteLoaction(int loactionId);

		void UpdateLocation(Location location);
		
		public Location getId(int locationid);
		
		public List<Location> getAllLocation();
		
		
}
