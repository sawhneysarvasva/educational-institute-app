package com.sarvasva.educationalinstituteapp.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter   {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private ApplicationContext context;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests() 
		  .antMatchers("/student/**").hasAnyRole( "STUDENT")
		  .antMatchers("/faculty/**").hasAnyRole("FACULTY") 
		  .antMatchers("/css/**","/js/**", "/images/**","/login").permitAll()
		  .and().formLogin().loginPage("/login").successHandler(new MyAuthenticationSuccessHandler() ).failureUrl("/login-error")
		  .and().logout().logoutSuccessUrl("/login-logout-success");
		 
			/*
			 * http.authorizeRequests() .antMatchers("/student").hasRole("STUDENT")
			 * .antMatchers("/faculty").hasRole("FACULTY") .antMatchers("/").permitAll()
			 * .and().formLogin().successHandler(new MyAuthenticationSuccessHandler());
			 */
	}
	 @Bean
	 public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
	 @Bean
	 public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	     return new MyAuthenticationSuccessHandler();
	 }
}

