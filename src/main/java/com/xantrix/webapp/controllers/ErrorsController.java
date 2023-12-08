package com.xantrix.webapp.controllers;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
@Controller
public class ErrorsController implements ErrorController 
{
	@GetMapping("/error")
	@SneakyThrows
    public String handleError(
    		HttpServletRequest httpRequest, 
    		HttpServletResponse httpResponse) 
	{
		String errorMsg = "";
		int httpErrorCode = (httpResponse).getStatus();
	
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Codice Errore 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Codice Errore 401. Non Autorizzato";
                break;
            }
            case 404: {
                errorMsg = "Codice Errore 404. Risorsa Non Trovata";
                return "error404";
                 
            }
            case 500: {
                errorMsg = "Codice Errore 500. Errore Interno del Server";
                break;
            }
        }
        
        log.warning(errorMsg);
        
        return "errorPage";
	}
}
