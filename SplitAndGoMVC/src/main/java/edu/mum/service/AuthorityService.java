package edu.mum.service;

import java.util.List;

import edu.mum.domain.Authority;

public interface AuthorityService {

	public void save(Authority authority);

	public List<Authority> findAll();

	public Authority findOne(Long id);

}
