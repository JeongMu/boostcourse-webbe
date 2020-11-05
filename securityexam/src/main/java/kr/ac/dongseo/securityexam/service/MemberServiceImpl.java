package kr.ac.dongseo.securityexam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.dongseo.securityexam.dao.MemberDao;
import kr.ac.dongseo.securityexam.dao.MemberRoleDao;
import kr.ac.dongseo.securityexam.dto.Member;
import kr.ac.dongseo.securityexam.dto.MemberRole;
import kr.ac.dongseo.securityexam.service.security.MemberService;
import kr.ac.dongseo.securityexam.service.security.UserEntity;
import kr.ac.dongseo.securityexam.service.security.UserRoleEntity;

@Service
public class MemberServiceImpl implements MemberService {

	private final MemberDao memberDao;
	private final MemberRoleDao memberRoleDao;

	public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao) {
		this.memberDao = memberDao;
		this.memberRoleDao = memberRoleDao;
	}

	@Override
	@Transactional
	public UserEntity getUser(String loginUserId) {
		Member member;

		try {
			member = memberDao.getMemberByEmail(loginUserId);
		} catch (Exception e) {
			return null;
		}

		return new UserEntity(member.getEmail(), member.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<MemberRole> memberRoles = memberRoleDao.getRoleByEmail(loginUserId);
		List<UserRoleEntity> list = new ArrayList<>();

		for (MemberRole memberRole : memberRoles) {
			list.add(new UserRoleEntity(loginUserId, memberRole.getRoleName()));
		}

		return list;
	}

	@Override
	@Transactional
	public void addMember(Member member, boolean isAdmin) {
		memberDao.addMember(member);

		Long memberId = memberDao.getMemberByEmail(member.getEmail()).getId();

		MemberRole memberRole = new MemberRole(memberId, "ROLE_USER");
		memberRoleDao.addRole(memberRole);

		if (isAdmin) {
			memberRole.setRoleName("ROLE_ADMIN");
			memberRoleDao.addRole(memberRole);
		}
	}

	@Override
	@Transactional
	public Member getMemberByEmail(String email) {
		return memberDao.getMemberByEmail(email);
	}

}
