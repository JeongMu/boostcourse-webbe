package kr.ac.dongseo.securityexam.service.security;

import java.util.List;

import kr.ac.dongseo.securityexam.dto.Member;

public interface UserDbService {
	public UserEntity getUser(String loginUserId);
	public List<UserRoleEntity> getUserRoles(String loginUserId);
	public void addMember(Member member, boolean isAdmin);
	public Member getMemberByEmail(String email);
}
