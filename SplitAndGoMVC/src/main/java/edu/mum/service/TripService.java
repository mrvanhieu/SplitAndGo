package edu.mum.service;

import java.util.List;

import edu.mum.domain.Trip;

public interface TripService {

	public void save(Trip trip);
	
	public Trip update(Trip trip);
	
	public void delete(Long id);

	public List<Trip> findAll();

	public Trip findOne(Long id);

}
