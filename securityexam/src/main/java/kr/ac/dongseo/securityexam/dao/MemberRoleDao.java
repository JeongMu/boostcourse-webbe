package kr.ac.dongseo.securityexam.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.securityexam.dto.MemberRole;

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
		
		return jdbc.query(MemberRoleDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
	
	public int addRole(MemberRole memberRole) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("roleName", memberRole.getRoleName());
		paramMap.put("memberId", memberRole.getMemberId());
		
		return jdbc.update(MemberRoleDaoSqls.INSERT_MEMBER_ROLE, paramMap);
	}
}
