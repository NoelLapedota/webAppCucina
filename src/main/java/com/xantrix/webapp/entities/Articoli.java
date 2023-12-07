package com.xantrix.webapp.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articoli")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Articoli {

    @Id
    @Column(name = "codart")
    private String codart;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "testo")
    private String testo;

    @Column(name = "immagine")
    private String immagine;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacreazione")
    private Date datacreazione;



}

