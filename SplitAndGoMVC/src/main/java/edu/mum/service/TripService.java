package edu.mum.service;

import java.util.List;

import edu.mum.domain.Trip;

public interface TripService {

	public void save(Trip trip);

	public List<Trip> findAll();

	public Trip findOne(Long id);

}
