package com.xantrix.webapp.security;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.entities.Utenti;
import com.xantrix.webapp.repository.UtentiRepository;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import java.lang.String;

@Log
@Service
public class CustomUserDetailsService implements UserDetailsService
{
	private UtentiRepository utentiRepository; 
	
	public CustomUserDetailsService(UtentiRepository utentiRepository)
	{
		this.utentiRepository = utentiRepository;
	}
	
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username)  
	{
		String errMsg = "";
		
		if (username == null || username.length() < 5) 
		{
			errMsg = "Nome utente assente o non valido";
			
			log.warning(errMsg);
			
	    	throw new UsernameNotFoundException(errMsg); 
		}
		
		 
		Utenti utente = this.GetUtenti(username);
		if (utente == null)
		{
			errMsg = String.format("Utente %s non Trovato!!", username);
			
			log.warning(errMsg);
			
			throw new UsernameNotFoundException(errMsg);
		}

     
		UserBuilder builder = null;
		builder = org.springframework.security.core.userdetails.User.withUsername(utente.getId().trim());
		builder.password(utente.getPassword().trim());
		
		String[] profili = utente.getRoles().chars().mapToObj(c -> "ROLE_" + (char) c).toArray(String[]::new);
		builder.authorities(profili);
		

		
		return builder.build();
	}

	private Utenti GetUtenti(String username) 
	{
		Utenti utente = null;

		try 
		{
			utente = utentiRepository.findByUsername(username);
		} 
		catch (Exception e) 
		{
			String ErrMsg = String.format("E' occorso un errore nel tentativo di ricerca dell'utente");
			
			log.warning(ErrMsg);
			
		}
		log.info("Utente trovato: " + utente.getUsername());
		return utente;
	}
	
}
