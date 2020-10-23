package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;

public class JDBCExam2_1 {

	public static void main(String[] args) {
		Integer roleId = 500;
		
		RoleDao dao = new RoleDao();
		int deleteCount = dao.delRole(roleId);
		
		System.out.println(deleteCount);
	}

}
