package kr.ac.dongseo.securityexam.dao;

public class MemberRoleDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT mr.id, mr.member_id, mr.role_name"
			+ " FROM member_role AS mr"
			+ " JOIN member AS m"
			+ " ON mr.member_id = m.id"
			+ " WHERE m.email = :email";
	
	public static final String INSERT_MEMBER_ROLE = "INSERT INTO member_role (member_id, role_name)"
			+ " VALUES (:memberId, :roleName)";
}
