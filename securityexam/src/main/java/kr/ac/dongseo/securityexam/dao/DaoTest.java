package kr.ac.dongseo.securityexam.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.dongseo.securityexam.config.ApplicationConfig;
import kr.ac.dongseo.securityexam.dto.Member;
import kr.ac.dongseo.securityexam.dto.MemberRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class DaoTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberRoleDao memberRoleDao;
	
	@Test
	public void configTest() throws Exception{
		// configuration 테스트
	}
	
	@Test
	public void connectionTest() throws Exception{
		Connection connection = dataSource.getConnection();
		Assert.assertNotNull(connection);
	}
	
	@Test
	public void getUser() throws Exception{
		Member member = memberDao.getMemberByEmail("carami@example.com");
		Assert.assertNotNull(member);
		Assert.assertEquals("강경미", member.getName());
	}
	
	@Test
	public void addMember() throws Exception{
		Member member = new Member("강정무", "$2a$10$USbExG2YOZJqu5rR9eWAqO3NqwjS6c8uI0c695cnURA2gxqRnx41O", "kang815595@gmail.com");
		memberDao.addMember(member);
		
		Long memberId = memberDao.getMemberByEmail("kang815595@gmail.com").getId();
		MemberRole memberRole = new MemberRole(memberId, "ROLE_USER");
		memberRoleDao.addRole(memberRole);
	}
	
	
	
}
