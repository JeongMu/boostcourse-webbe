package kr.ac.dongseo.reservation.dao.security;

import static kr.ac.dongseo.reservation.dao.security.sqls.MemberRoleDaoSqls.INSERT_MEMBER_ROLE;
import static kr.ac.dongseo.reservation.dao.security.sqls.MemberRoleDaoSqls.SELECT_ALL_BY_EMAIL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.reservation.service.impl.MemberRole;

@Repository
public class MemberRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);
	
	public MemberRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<MemberRole> getRoleByEmail(String email){
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		
		return jdbc.query(SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
	
	public int addRole(MemberRole memberRole) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("roleName", memberRole.getRoleName());
		paramMap.put("memberId", memberRole.getMemberId());
		
		return jdbc.update(INSERT_MEMBER_ROLE, paramMap);
	}
}
