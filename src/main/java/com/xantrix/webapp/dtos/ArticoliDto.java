package com.xantrix.webapp.dtos;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ArticoliDto {
    private String titolo;
    private String codart;
    private String testo;
    private String descrizione;
    private String immagine;
    private Date datacreazione;
}
