package edu.mum.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.validation.EmptyOrSize;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 20)
	@EmptyOrSize(min = 2, max = 20, message = "{size.name.validation}")
	private String firstName;

	@Column(length = 20)
	@EmptyOrSize(min = 2, max = 20, message = "{size.name.validation}")
	private String lastName;

	@Column(length = 20)
	private String nickName;

	private Gender gender;

	@Email
	private String email;

	@Pattern(regexp = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")
	private String phone;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date birthDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credential_id")
	@Valid
	Credential credential;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

}
