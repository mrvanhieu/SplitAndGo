package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.service.CredentialService;
import edu.mum.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	CredentialService credentialsService;

	public void save(Member member) {
		memberDao.save(member);
	}

	@Override
	public void saveFull(Member member) {
		credentialsService.save(member.getCredential());
		memberDao.save(member);
	}

	public List<Member> findAll() {
		return (List<Member>) memberDao.findAll();
	}

	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}

}
