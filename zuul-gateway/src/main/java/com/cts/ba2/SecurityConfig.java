package com.cts.ba2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
//
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Value("${app.security.user}")
	private String userName;
	
	@Value("${app.security.password}")	
	private String password;
	
	@Value("${app.security.role}")	
	private String role;
//	@Autowired
//	private SecurityEntryPoint authenticationEntryPoint;
	
	@Bean
	public BCryptPasswordEncoder bCypt() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.inMemoryAuthentication().withUser(userName).password(password).roles(role).and()
		.withUser("debu").password(password).roles("USER", "ADMIN");
		
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(authenticationEntryPoint);
		
		http.httpBasic().and().authorizeRequests()
		.antMatchers("/employee-service/admin").hasRole("ADMIN")
		.antMatchers("/employee-service/user").hasRole("USER")
		.antMatchers("/project-service/user").hasRole("USER")
		.antMatchers("/project-service/admin").hasRole("ADMIN")
		.antMatchers("/composite-service/user").hasRole("USER")
		.and().csrf().disable().headers()
		.frameOptions().disable();
	
	
	}
	
	
}
