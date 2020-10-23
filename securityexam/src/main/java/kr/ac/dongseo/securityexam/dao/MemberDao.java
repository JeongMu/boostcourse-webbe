package kr.ac.dongseo.securityexam.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.dongseo.securityexam.dto.Member;

@Repository
public class MemberDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
	
	public MemberDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Member getMemberByEmail(String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		System.out.println("email : " + email);
		System.out.println("map : " + map);
		
		return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}

	public int addMember(Member member) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", member.getName());
		paramMap.put("password", member.getPassword());
		paramMap.put("email", member.getEmail());
		paramMap.put("createDate", member.getCreateDate());
		paramMap.put("modifyDate", member.getModifyDate());
		
		return jdbc.update(MemberDaoSqls.INSERT_MEMBER, paramMap);
	}
}
