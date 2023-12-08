package com.xantrix.webapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utenti 
{
	@Id
	private String id;
	
	private String username;
	
	private String password;
	
	private String roles;
	
	
	
}
