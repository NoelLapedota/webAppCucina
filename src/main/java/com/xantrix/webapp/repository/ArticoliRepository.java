package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xantrix.webapp.entities.Articoli;

public interface ArticoliRepository extends JpaRepository<Articoli, String> {

	//Query method
	Articoli findByTitolo(String titolo);
	
	List<Articoli> findAll();
	
	List<Articoli> findByTitoloContaining(String titolo);
	
	List<Articoli> findByDescrizioneLike(String descrizione, Pageable pageAndRecords);

	List<Articoli>  findByDescrizione(String lowerCase);
	
	//Query Method
	Articoli findByCodart(String codart);
}
