/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author karahtqc
 */
@Entity
@Table(name = "Geraet")
public class Geraet {
    
    @Id
    private String seriennummer;
    
    private String generation;
    
    private String status;
    
    public Geraet(){
        
    }

    public Geraet(String seriennummer, String generation, String status) {
        this.seriennummer = seriennummer;
        this.generation = generation;
        this.status = status;
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

   

    public String getSeriennummer() {
        return seriennummer;
    }


    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }
    
    
    
    
    
}
