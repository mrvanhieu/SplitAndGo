package edu.mum.service;

import java.util.List;

import edu.mum.domain.Fund;

public interface FundService {

	public void save(Fund fund);

	public List<Fund> findAll();

	public Fund findOne(Long id);

}
