package com.manipal.service;



import java.util.List;

import com.manipal.model.Fare;



public interface IFareService {
		

		void UpdateFare(Fare fare);
				
		public List<Fare> getAllFare();
		public Fare getById(int id);

		void addfare(Fare fare);
		
		
}
