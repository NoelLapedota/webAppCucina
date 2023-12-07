package com.xantrix.webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;
import com.xantrix.webapp.repository.IndexRepository;


@Service
public class ArticoliServiceImpl implements ArticoliService
{
	private ArticoliRepository articoliRepository;
	private IndexRepository indexRepository;
	private ModelMapper modelMapper;
	
	public ArticoliServiceImpl(
			ArticoliRepository articoliRepository,
			IndexRepository indexRepositor,
			 ModelMapper modelMapper) 
	{
		this.articoliRepository = articoliRepository;
		this.modelMapper = modelMapper;
		this.indexRepository = indexRepositor;
	}
	
	@Override
	public void DelArticolo(String codart) 
	{
		articoliRepository.delete(articoliRepository.findByCodart(codart));
	}

	@Override
	public ArticoliDto findByTitolo(String titolo) 
	{
		return convertToDto( articoliRepository.findByTitolo(titolo));
	}
	
	@Override
	public List<ArticoliDto> findBySerch(String titolo) 
	{
		return convertToDto( articoliRepository.findByTitoloContaining (titolo.toLowerCase()));
	}
    
	@Override
	public List<ArticoliDto> findByDescrizione(String titolo) 
	{
		return convertToDto( articoliRepository.findByDescrizione (titolo.toLowerCase()));
	}
	

	@Override
	public List<ArticoliDto> SelByDescrizione(String filter, int page, int numrec) 
	{
		filter = "%".concat(filter.toUpperCase().concat("%"));
		
		Pageable pageAndRecords = PageRequest.of(page, numrec);
		
		return convertToDto(articoliRepository.findByDescrizioneLike(filter, pageAndRecords));
	}


	private ArticoliDto convertToDto(Articoli articoli)
	{
		ArticoliDto articoliDto = null;
		
		if (articoli != null)
		{
			articoliDto =  modelMapper.map(articoli, ArticoliDto.class);
		}
		
		return articoliDto;
	}
	
	private List<ArticoliDto> convertToDto(List<Articoli> articoli)
	{		
		List<ArticoliDto> articoliDto = articoli
		        .stream()
		        .map(source -> modelMapper.map(source, ArticoliDto.class))
		        .collect(Collectors.toList());
		
		return articoliDto;
	}

	@Override
	public List<ArticoliDto> findAll() {
	    List<Articoli> result = indexRepository.findAll();
	    return result.stream().map(this::convertToDto).collect(Collectors.toList());
	}



	@Override
	public List<ArticoliDto> findAllArticle()  {
	    List<Articoli> result = articoliRepository.findAll();
	    return convertToDto(result);
	}



	@Override
	public List<ArticoliDto> findByTitoloContaining(String titolo) {
		// TODO Auto-generated method stub
		return null;
	}

	


}

