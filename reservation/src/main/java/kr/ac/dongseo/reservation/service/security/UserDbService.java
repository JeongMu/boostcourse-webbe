package kr.ac.dongseo.reservation.service.security;

import java.util.List;

import kr.ac.dongseo.reservation.dto.security.Member;

public interface UserDbService {

	public UserEntity getUser(String loginUserId);

	public List<UserRoleEntity> getUserRoles(String loginUserId);

	public void addMember(Member member, boolean isAdmin);

	public Member getMemberByEmail(String email);
}
