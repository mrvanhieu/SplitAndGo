package edu.mum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Authority;
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
		updateAuthorities(member.getCredential().getAuthorityList(), member.getCredential().getAuthorities());
		memberDao.save(member);
	}

	@Override
	public void saveFull(Member member) {
		credentialsService.save(member.getCredential());
		memberDao.save(member);
	}

	public Member update(Member member) {
		updateAuthorities(member.getCredential().getAuthorityList(), member.getCredential().getAuthorities());
		return memberDao.update(member);
	}

	private void updateAuthorities(List<String> authorityStrList, List<Authority> authorities) {
		if (authorities.size() > 0) {
			authorities.clear();
		}
		for (String authorityStr : authorityStrList) {
			if (!StringUtils.isEmpty(authorityStr)) {
				Authority authority = new Authority();
				authority.setAuthority(authorityStr);
				if (!authorities.contains(authority)) {
					authorities.add(authority);
				}
			}
		}
	}

	public List<Member> findAll() {
		return (List<Member>) memberDao.findAll();
	}

	public Member findOne(Long id) {
		Member member = memberDao.findOne(id);
		setAuthorityList(member);
		return member;
	}

	private void setAuthorityList(Member member) {
		List<String> authorityList = new ArrayList<>();
		for (Authority authority : member.getCredential().getAuthorities()) {
			authorityList.add(authority.getAuthority());
		}
		member.getCredential().setAuthorityList(authorityList);
	}
	
	public void delete(Long id) {
		memberDao.delete(id);
	}

}
