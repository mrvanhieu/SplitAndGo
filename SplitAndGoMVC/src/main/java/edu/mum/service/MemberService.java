package edu.mum.service;

import java.util.List;

import edu.mum.domain.Member;

public interface MemberService {

	public void save(Member member);

	public void saveFull(Member member);

	public Member update(Member member);
		
	public List<Member> findAll();

	public Member findOne(Long id);
	
	public void delete(Long id);

}