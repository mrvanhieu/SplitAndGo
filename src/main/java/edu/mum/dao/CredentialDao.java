package edu.mum.dao;

import edu.mum.domain.Credential;

public interface CredentialDao extends GenericDao<Credential> {
  
	public Credential findByUserName(String userName);
}
