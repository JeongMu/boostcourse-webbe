package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDao;
import kr.or.connect.daoexam.dto.Role;

public class JDBCTest {
	private static ApplicationContext ac;

	public static void main(String[] args) {
		ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(201);
		role.setDescription("Programmer");
		
//		int count = roleDao.insert(role);
//		System.out.println(count + "건 입력하였습니다.");
		
		int count = roleDao.update(role);
		System.out.println(count + "건 수정하였습니다.");
		
		Role resultRole = roleDao.selectById(201);
		System.out.println(resultRole);
		
		int delCount = roleDao.deleteById(500);
		System.out.println(delCount + "건 삭제하였습니다.");
		
		Role resultRole2 = roleDao.selectById(500);
		System.out.println(resultRole2);
	}
}
