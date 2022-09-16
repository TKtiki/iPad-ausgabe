/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;





/**
 *
 * @author karahtqc
 */

@Entity
@Table(name = "user")
public class User {
    
   @Id
   private String loginID;
   
   private String vorname;
   
   private String nachname;
   
   private String rolle;
   
    public User (){}
   
   public User(String loginID, String vorname, String nachname, String rolle){
       this.loginID = loginID;
       this.vorname = vorname;
       this.nachname = nachname;
       this.rolle = rolle;
   }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
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

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
   
   
   
   
    
}