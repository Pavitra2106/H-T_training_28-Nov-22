package com.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.user.filter.JwtFilter;
import com.user.service.UserDataService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDataService userDataService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDataService);
		authProvider.setPasswordEncoder(encoder);
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userService);
		auth.authenticationProvider(authProvider());
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/signup")
		.permitAll()
		.antMatchers("/signin")
		.permitAll()
		.antMatchers("/getusersbyid/{id}")
		.permitAll()
		.antMatchers("/delete/{id}")
		.permitAll()
		.antMatchers("/update/{id}")
		.permitAll()
		.antMatchers("/allusers")
		.permitAll()
		.antMatchers("/getemp/{id}")
		.permitAll()
		.antMatchers("/getallemp")
		.permitAll()
		.antMatchers("/createjobs")
		.permitAll()
		.antMatchers("/available/jobs")
		.permitAll()
		.antMatchers("/updatejob/{id}")
		.permitAll()
		.antMatchers("/available/jobs/{role}")
		.permitAll()
		.antMatchers("/updateJobAndSalary/user/{userid}")
		.permitAll()
		.antMatchers("/update/{id}/{firstname}/{lastname}/{email}")
		.permitAll()
		.antMatchers("/updatejob/{id}/{jobname}/{startingtime}/{endtime}/{profitvalue}/{applicablerole}/{status}")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and() 
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		http.cors();
	}

}
