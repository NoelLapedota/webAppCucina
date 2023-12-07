package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xantrix.webapp.entities.Articoli;

public interface IndexRepository extends JpaRepository<Articoli, String> {

	//Query method
	
	List<Articoli> findAll();
	
	List<Articoli> findByDescrizioneLike(String descrizione, Pageable pageAndRecords);
}
