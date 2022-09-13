/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author karahtqc
 */
@Entity
@Table(name = "Klasse")
public class Klasse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String bezeichnug;
    
    @ManyToOne
    private User klassenlehrer;
    
    public Klasse (){}

    public Klasse(User klassenlehrer, String bezeichnug) {
       this.klassenlehrer = klassenlehrer;
       this.bezeichnug = bezeichnug;
    }

    public int getId() {
        return id;
    }


    

    public User getKlassenlehrer() {
        return klassenlehrer;
    }

    public void setKlassenlehrer(User user) {
        this.klassenlehrer = klassenlehrer;
    }
    
    public Klasse(String bezeichnug){
        this.bezeichnug = bezeichnug;
        
    }
    /*
    public List<Schueler> getSchueler() {
        return schueler;
    }

    public void setSchueler(List<Schueler> schueler) {
        this.schueler = schueler;
    }
*/

    public String getBezeichnug() {
        return bezeichnug;
    }

    public void setBezeichnug(String bezeichnug) {
        this.bezeichnug = bezeichnug;
    }
    /*
    public User getKlassenlehrer() {
        return Klassenlehrer;
    }

    public void setKlassenlehrer(User Klassenlehrer) {
        this.Klassenlehrer = Klassenlehrer;
    }
    
    */
    
}
