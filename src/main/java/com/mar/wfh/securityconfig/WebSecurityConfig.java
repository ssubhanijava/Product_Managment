package com.mar.wfh.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mar.wfh.custometrSecuritDetails.CustomerDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService customerDetails() {
		return new CustomerDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authentication = new DaoAuthenticationProvider();

		authentication.setPasswordEncoder(passwordEncoder());
		authentication.setUserDetailsService(customerDetails());

		return authentication;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		
		 http.csrf().disable();
	        http.authorizeRequests()
	                .antMatchers("/indexLogin").hasAnyRole("USER")
	                .antMatchers("/proced").hasRole("USER")
	                .anyRequest().permitAll()
	                .and()
	                .formLogin().defaultSuccessUrl("/login1")
	                .and().logout().logoutSuccessUrl("/")
	                .permitAll();*/

		http.csrf().disable(); 
		 http
		.authorizeRequests()
		.antMatchers("/indexLogin")
		.hasAuthority("USER")
		.antMatchers("/proced")
		.hasAuthority("USER")
		.antMatchers("/home")
		.hasAuthority("ADMIN")
		.antMatchers("/","/home", "/cust/customer", "/**","/one/**","../css/**","../js/**",
					"../webjars/**")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll()
	//	.loginPage("/login")
		.usernameParameter("email")
		.passwordParameter("motdepass")
		//.loginProcessingUrl("/doLogin")
		//.successHandler(successHandler)
	    //.defaultSuccessUrl("/indexLogin")
	    
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.permitAll();

		

		/*
		 * 
		 * 
		 * authorizeRequests() .antMatchers("/").permitAll()
		 * .antMatchers("/login").permitAll() .antMatchers("/registration").permitAll()
		 * .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
		 * .authenticated().and().csrf().disable().formLogin()
		 * .loginPage("/login").failureUrl("/login?error=true")
		 * .defaultSuccessUrl("/admin/home") .usernameParameter("user_name")
		 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout"))
		 * .logoutSuccessUrl("/login").and().exceptionHandling()
		 * .accessDeniedPage("/access-denied");
		 */

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("../resources/**", "../static/**", "../css/**", "../js/**", "../images/**");
	}

}
