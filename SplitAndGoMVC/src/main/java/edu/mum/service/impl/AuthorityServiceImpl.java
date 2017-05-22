package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.AuthorityDao;
import edu.mum.domain.Authority;
import edu.mum.service.AuthorityService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;

	public void save(Authority member) {
		authorityDao.save(member);
	}

	public List<Authority> findAll() {
		return (List<Authority>) authorityDao.findAll();
	}

	public Authority findOne(Long id) {
		return authorityDao.findOne(id);
	}

}
