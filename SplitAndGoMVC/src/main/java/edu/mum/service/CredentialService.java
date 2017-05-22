package edu.mum.service;

import java.util.List;

import edu.mum.domain.Credential;
 
public interface CredentialService {

	public void save(Credential userCredentials);
	public void update(Credential userCredentials);
	public List<Credential> findAll();
	public Credential findOne(Long id);
	public Credential findByUserName(String userName);
 }
