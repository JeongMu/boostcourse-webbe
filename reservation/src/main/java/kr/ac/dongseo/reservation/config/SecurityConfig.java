//package kr.ac.dongseo.reservation.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//import kr.ac.dongseo.reservation.service.security.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/webjars/**");
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(customUserDetailsService);
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//		filter.setEncoding("UTF-8");
//		filter.setForceEncoding(true);
//		
//		http
//			.addFilterBefore(filter, CsrfFilter.class)
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/", "/api/categories", "/api/displayinfos", "/api/promotions", "/api/displayinfos/{displayId}", "/api/userComments").permitAll()
//			.antMatchers("/api/reservationInfos").hasRole("USER")
//			.anyRequest().authenticated()
//			.and()
//				.formLogin()
//				.loginPage("/members/loginform")
//				.usernameParameter("userId")
//				.passwordParameter("password")
//				.loginProcessingUrl("/authenticate")
//				.failureForwardUrl("/members/loginerror?login_error=1")
//				.defaultSuccessUrl("/", true)
//				.permitAll()
//			.and()
//				.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/");
//	}
//	
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
