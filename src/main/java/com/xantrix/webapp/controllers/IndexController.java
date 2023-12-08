package com.xantrix.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.java.Log;

@Log
@Controller
public class IndexController 
{
	private String saluti = "Saluti, sono la tua prima applicazione web creata in Spring Boot 3";
	
	@GetMapping(value="/")
	public String getRoot()
	{
		return "redirect:/index";
	}
	
	@GetMapping(value="index/{name}")
	public String getWelcome2(Model model,  @PathVariable("name") String name)
	{
		model.addAttribute("userName", name);
		model.addAttribute("intestazione", String.format("Benvenuto %s nella index pagedi Cucina Italiana", name));
		model.addAttribute("saluti", saluti);
		
		return "index";
	}
	
	
	@GetMapping(value="index")
	public String getWelcome(Model model, @CookieValue(name = "user-id") String name)
	{
		log.info("Valore del Cookie: " + name);
		model.addAttribute("userName", name);
		model.addAttribute("intestazione", String.format("Benvenuto %s nella index pagedi Cucina Italiana", name));
		model.addAttribute("saluti", saluti);
		
		return "index";
	}
}
