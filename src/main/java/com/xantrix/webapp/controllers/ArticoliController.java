package com.xantrix.webapp.controllers;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.services.ArticoliService;

import lombok.extern.java.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Log
@Controller
public class ArticoliController {
    private final ArticoliService articoliService;
    private final Logger logger = LoggerFactory.getLogger(ArticoliController.class);

    public ArticoliController(ArticoliService articoliService) {
        this.articoliService = articoliService;
    }

    @GetMapping(value = "/articoli")
    public String getArticoli(ModelMap model) {
        try {
//           
        List<ArticoliDto> articoli = articoliService.findAllArticle();
          model.addAttribute("articoli", articoli);

            logger.info("");
        } catch (Exception e) {
            logger.error("Errore durante la connessione al database", e);
        }
        return "articoli";
    }
    
	@GetMapping(value = "/elimina/{codart}")
	public String DelArticolo(@PathVariable("codart") String codart, ModelMap model)
	{
		try
		{
			if (codart.length() > 0)
			{
				articoliService.DelArticolo(codart);
			}
		} 
		catch (Exception ex)
		{
			throw new RuntimeException("Errore eliminazione articolo", ex);
		}

		return "redirect:/articoli/search?filtro=" + codart;
	}
    
    @GetMapping(value="/cerca/descrizione/{filter}")
	public String GetArticoli(@PathVariable("filter") String filter, ModelMap model)
	{
		List<ArticoliDto> articoli = articoliService.SelByDescrizione(filter,0,10);
		
		model.addAttribute("articoli", articoli);
		System.out.println(articoli );
		return "articoli";
		
	}


    @GetMapping(value = "articoli/search", produces = "text/html;charset=UTF-8")
    public String searchItem(@RequestParam("filtro") String filtro, @RequestParam(required = false, defaultValue = "10") String selected, ModelMap model) {
        try {
            // Decodifica il parametro filtro
            String filtroDecoded = URLDecoder.decode(filtro, StandardCharsets.UTF_8.toString());

         
            log.info(String.format("Ricerca articoli con filtro %s ", filtroDecoded));

            List<ArticoliDto> articoli = articoliService.findBySerch(filtroDecoded);

            System.out.println(articoli);

            if (articoli.isEmpty()) {
                articoli = articoliService.findByDescrizione(filtroDecoded);
                
            }

            model.addAttribute("articoli", articoli);
            return "articoli";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "errore";
        }
    }


}
