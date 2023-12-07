package com.xantrix.webapp.services;

import java.util.List;


import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;

public interface ArticoliService 
{
	
	public ArticoliDto findByTitolo(String titolo);
	
	public List<ArticoliDto>  findByDescrizione(String descrizione);

	public List<ArticoliDto> SelByDescrizione(String filter, int page, int numrec);

	public List<ArticoliDto> findAllArticle();

	public List<ArticoliDto> findByTitoloContaining(String titolo);
	
	public List<ArticoliDto> findAll();


	public List<ArticoliDto> findBySerch(String titolo);

	public void DelArticolo(String codart);

	
}
