package com.dev.loja.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CupkatUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		 .and()
		 .formLogin()
		 	.loginPage("/login")
		 	.usernameParameter("email")
		 	.permitAll()
			.and().logout().permitAll()
			.and()
		 	.rememberMe()
		 		.key("Abcdefghijklmnopqrs_1234567890")
		 		.tokenValiditySeconds(7 * 24 * 60 * 60);
		 return http.build();
	 }
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web
	      .ignoring()
	      .antMatchers("/image/**",
	      		 "/js/**", "/css/**", "/webjars/**", "/fonts/**");
	}
	 
	 
}
