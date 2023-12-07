package com.xantrix.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController 
{
	private String titolo = "Accesso & Autenticazione";
	private String sottotitolo = "Procedi ad inserire la userid e la password";
	
	//@ResponseBody
	@GetMapping(value="/login")
	public String getLogin(ModelMap model)
	{
		model.addAttribute("Titolo", titolo);
		model.addAttribute("SottoTitolo", sottotitolo);
		
		return "login";
	}
}