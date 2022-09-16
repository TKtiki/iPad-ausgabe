/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author karahtqc
 */
@Entity
@Table(name = "Schueler")
public class Schueler {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String vorname;
    private String nachname;
    
    private Date rueckgabeDatum;
    private Date ausgabeDatum;
    
    
    @ManyToOne
    private Klasse klasse;
    
    @OneToOne
    private Geraet geraet;

    public Schueler(){
        
    }
    
    public Schueler(String vorname, String nachname, Klasse klasse, Date rueckgabeDatum, Date ausgabeDatum, Geraet geraet) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.klasse = klasse;
        this.rueckgabeDatum = rueckgabeDatum;
        this.ausgabeDatum = ausgabeDatum;
        this.geraet = geraet;
    
    }

    public Date getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(Date rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }

    public Date getAusgabeDatum() {
        return ausgabeDatum;
    }

    public void setAusgabeDatum(Date AusgabeDatum) {
        this.ausgabeDatum = AusgabeDatum;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public Geraet getGeraet() {
        return geraet;
    }

    public void setGeraet(Geraet geraet) {
        this.geraet = geraet;
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

    public int getId() {
        return id;
    }
     
    
    
    
    
    
}
