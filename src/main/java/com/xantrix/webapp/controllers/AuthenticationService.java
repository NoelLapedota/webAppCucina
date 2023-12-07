package com.xantrix.webapp.controllers;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService 
{
	public boolean auth(String username, String password) 
	{
		
		boolean isValidUserName = username.equalsIgnoreCase("Nicola");
		boolean isValidPassword = password.equalsIgnoreCase("123_Stella");
		
		return isValidUserName && isValidPassword;
	}
}
