package assignment_java_Springboot;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import assignment_java_Springboot.service.Emp_personalDataService;
import assignment_java_Springboot.service.EmployeeService;


@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private EmployeeService empservice;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(empservice);
	}
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	
	private Emp_personalDataService Emp_personalDataService;
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf()
//		.disable()
//		.authorizeRequests()
//		.antMatchers("/authenticate")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
//		
//		
//	}
}
