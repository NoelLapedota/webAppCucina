package com.xantrix.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration 
{
	
    private UserDetailsService userDetailsService;
	
	public SecurityConfiguration(UserDetailsService userDetailsService)
	{
		this.userDetailsService = userDetailsService;
	}
	
	@Autowired
	@SneakyThrows
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	{
	    	auth
	    		.userDetailsService(userDetailsService)
	    		.passwordEncoder(new BCryptPasswordEncoder());
	}
	@Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	@SneakyThrows
	SecurityFilterChain securityFilterChain(HttpSecurity http) 
	{
		http
		//vengono definite le autorizzazioni per le diverse richieste HTTP.
		.authorizeHttpRequests(authz -> 
        {
        	authz.requestMatchers(
        			//consentite 
        			new AntPathRequestMatcher("/login/**"),
        			new AntPathRequestMatcher("/WEB-INF/jsp/login.jsp"),
        			new AntPathRequestMatcher("/static/**")
        			).permitAll();
        	
			authz.requestMatchers(
					//sono consentite solo agli utenti con il ruolo ADMIN
			    		new AntPathRequestMatcher("/articoli/aggiungi/**"), 
			    		new AntPathRequestMatcher("/articoli/modifica/**"),
			    		new AntPathRequestMatcher("/articoli/elimina/**")).hasRole("ADMIN");
			//solo con authenticated
			authz.anyRequest().authenticated();
		})
		.formLogin(form -> form
				.loginPage("/login")
	            .loginProcessingUrl("/login")
	            .usernameParameter("name")
	            .successHandler(authenticationSuccessHandler())
	            .failureHandler(authenticationFailureHandler())
	            .permitAll())
		.exceptionHandling(ex -> ex 
				.accessDeniedHandler(accessDeniedHandler()));
		
		return http.build();
	}
	
	@Bean
	AuthenticationSuccessHandler authenticationSuccessHandler() 
	{
	   return new CustomSuccessHandler();
	}
	
	@Bean
	AuthenticationFailureHandler authenticationFailureHandler() 
	{
		return new CustomAuthenticationFailureHandler();
	}
	
	@Bean
	AccessDeniedHandler accessDeniedHandler() 
	{
	   return new CustomAccessDeniedHandler();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
