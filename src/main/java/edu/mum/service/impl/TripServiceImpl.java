package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.TripDao;
import edu.mum.domain.Trip;
import edu.mum.service.TripService;

@Service
@Transactional
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDao tripDao;

	public void save(Trip trip) {
		tripDao.save(trip);
	}

	public List<Trip> findAll() {
		return (List<Trip>) tripDao.findAll();
	}

	public Trip findOne(Long id) {
		return tripDao.findOne(id);
	}

}
