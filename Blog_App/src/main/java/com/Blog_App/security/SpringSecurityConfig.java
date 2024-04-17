package com.Blog_App.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;



@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter authenticationFilter;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


		
	http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/user/**").permitAll()
				.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			
				.requestMatchers("/api/post/**").hasAnyRole("ADMIN","USER")
				.requestMatchers("/api/comment/**").hasAnyRole("ADMIN","USER")
				.anyRequest().hasRole("ADMIN"))
				.csrf(csrf -> csrf.disable())

		        .formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
	http.exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
	
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
		
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}