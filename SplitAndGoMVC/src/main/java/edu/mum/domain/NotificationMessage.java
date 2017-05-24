package edu.mum.domain;



import java.io.Serializable;
import java.util.Date;


public class NotificationMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long id;
	

	private String userName;
	

	private String action;
	

	private String description;
	
	private Date date;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
