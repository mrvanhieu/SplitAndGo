package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.mum.validation.EmptyOrSize;

@Entity
public class Credential {

	@Id
	@EmptyOrSize(min = 4, max = 20, message = "{size.name.validation}")
	private String username;
	
	@EmptyOrSize(min = 4, max = 100, message = "{size.password.validation}")
	private String password;
	
	private Boolean enabled = Boolean.TRUE;

	@OneToOne(mappedBy = "credential", cascade = CascadeType.PERSIST)
	private Member member;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "username")
	private List<Authority> authorities = new ArrayList<Authority>();
	
	@Transient
	private List<String> authorityList = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		this.password = bcryptEncoder.encode(password);
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public void addAuthority(Authority authority) {
		authorities.add(authority);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<String> getAuthorityList() {
		return authorityList;
	}

	public void setAuthorityList(List<String> authorityList) {
		this.authorityList = authorityList;
	}
}
