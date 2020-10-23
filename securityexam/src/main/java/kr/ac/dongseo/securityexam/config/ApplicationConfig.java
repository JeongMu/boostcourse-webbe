package kr.ac.dongseo.securityexam.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan(basePackages = {"kr.ac.dongseo.securityexam.dao", "kr.ac.dongseo.securityexam.service"})
@EnableTransactionManagement
public class ApplicationConfig implements TransactionManagementConfigurer {
	
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8"
			+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	private String userName = "connectuser";
	private String password = "connect123!@#";
	
	/**
	 * 커넥션 풀과 관련된 Bean 생성
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	/**
	 * 트랜잭션 관리자 생성
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	
}
