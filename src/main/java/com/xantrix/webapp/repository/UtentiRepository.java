package com.xantrix.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xantrix.webapp.entities.Utenti;

public interface UtentiRepository extends JpaRepository<Utenti, String>
{
	//Query Method

	Utenti findByUsername(String username);
}
