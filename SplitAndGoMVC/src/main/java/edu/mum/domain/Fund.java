package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.mum.validation.NullMinNumber;

@Entity
public class Fund {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Double remainingAmount;
	
	@NullMinNumber(value = 0, message = "{nullminnumber}")
	private Double totalAmount;

	@OneToOne(fetch = FetchType.LAZY)
	private Trip trip;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
