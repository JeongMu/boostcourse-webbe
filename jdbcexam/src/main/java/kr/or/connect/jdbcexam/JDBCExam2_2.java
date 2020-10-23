package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2_2 {

	public static void main(String[] args) {
		Role role = new Role(300, "Accounter");
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		
		System.out.println(updateCount);
	}

}
