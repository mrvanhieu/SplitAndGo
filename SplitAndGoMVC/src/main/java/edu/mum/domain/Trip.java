package edu.mum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.validation.EmptyOrSize;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 20)
	@EmptyOrSize(min = 2, max = 20, message = "{size.name.validation}")
	private String name;

	@Column(length = 200)
	@EmptyOrSize(min = 4, max = 200, message = "{size.name.validation}")
	private String description;

	private Double duration;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date startDate;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date endDate;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "trip_member", joinColumns = { @JoinColumn(name = "trip_id") }, inverseJoinColumns = {
			@JoinColumn(name = "member_id") })
	List<Member> members = new ArrayList<>();

	@OneToOne(mappedBy="trip", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	Fund fund;
	
	@OneToMany(mappedBy = "trip", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	List<Payment> payments = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
