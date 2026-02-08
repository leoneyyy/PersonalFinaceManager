package com.projekt.personalfinacemanager.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Transaktion {
    private BigDecimal betrag;
    private String kategorie;
    private LocalDate datum;
    private String typ;
    private Long id;


    public Transaktion(BigDecimal betrag, String kategorie, LocalDate datum, String typ, Long id) {
        this.betrag = betrag;
        this.kategorie = kategorie;
        this.datum = datum;
        this.typ = typ;
        this.id = id;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public void setKategorie(String kategorie) {
        String[] splitKategorie = kategorie.split(" ");
        this.kategorie = splitKategorie[0];
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public String getKategorie() {
        String[] splitKategorie = kategorie.split(" ");
        return splitKategorie[0];
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return "Transaktion" +
                "betrag=" + betrag + '\n'+
                "kategorie='" + kategorie + '\n' +
                "datum=" + datum + '\n'+
                "typ=" + typ + '\n' +
                "id=" + id ;
    }
}
