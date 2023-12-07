package com.xantrix.webapp.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomSuccessHandler  implements AuthenticationSuccessHandler
{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException 
	{
		ResponseCookie springCookie = ResponseCookie.from("user-id", authentication.getName())
			    .httpOnly(true)
			    .secure(false)
			    .path("/")
			    .maxAge(600)
			    //.domain("example.com")
			    .build();
		
		response.addHeader(HttpHeaders.SET_COOKIE, springCookie.toString());
		
		response.sendRedirect("/index/" + authentication.getName());
	}

}
