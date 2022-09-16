/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author karahtqc
 */

@Entity
@Table(name = "Historie")
public class Historie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    
    @ManyToOne
    private Geraet geraet;
    
    private Date rueckgabeDatum;
    
    private String vorname;
    
    private String nachname;
    
    private String zustand;
    
    private String zustandbeschreibung;
    
    public Historie (){
        
    }

    public Historie(Geraet geraet, Date rueckgabeDatum, String vorname, String nachname, String zustand, String zustandbeschreibung) {
        this.geraet = geraet;
        this.vorname = vorname;
        this.nachname = nachname;
        this.rueckgabeDatum = rueckgabeDatum;
        this.zustand = zustand;
        this.zustandbeschreibung = zustandbeschreibung;
    }

 

    public Geraet getGeraet() {
        return geraet;
    }

    public void setGeraet(Geraet geraet) {
        this.geraet = geraet;
    }

    public Date getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(Date rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getZustand() {
        return zustand;
    }

    public void setZustand(String zustand) {
        this.zustand = zustand;
    }

    public String getZustandbeschreibung() {
        return zustandbeschreibung;
    }

    public void setZustandbeschreibung(String zustandbeschreibung) {
        this.zustandbeschreibung = zustandbeschreibung;
    }
    
    
    
}
    