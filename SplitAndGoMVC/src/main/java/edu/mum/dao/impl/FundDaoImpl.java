package edu.mum.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.dao.FundDao;
import edu.mum.domain.Fund;

@SuppressWarnings("unchecked")
@Repository
public class FundDaoImpl extends GenericDaoImpl<Fund> implements FundDao {

	public FundDaoImpl() {
		super.setDaoType(Fund.class);
	}

}