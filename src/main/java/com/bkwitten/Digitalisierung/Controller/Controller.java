/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkwitten.Digitalisierung.Controller;

import com.bkwitten.Digitalisierung.Repository.GeraetRepository;
import com.bkwitten.Digitalisierung.Repository.HistorieRepository;
import com.bkwitten.Digitalisierung.Repository.KlasseRepository;
import com.bkwitten.Digitalisierung.Repository.SchuelerRepository;
import com.bkwitten.Digitalisierung.Repository.UserRepository;
import com.bkwitten.Digitalisierung.model.Geraet;
import com.bkwitten.Digitalisierung.model.Klasse;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karahtqc
 */

@RestController
public class Controller {
    
    @Autowired
    private GeraetRepository geraet_reposetory;
     
    @Autowired
    private HistorieRepository historie_reposetory;
    
    @Autowired
    private KlasseRepository klasse_reposetory;
    
    @Autowired
    private SchuelerRepository schueler_reposetory;
    
    @Autowired
    private UserRepository user_reposetory;
    
    @GetMapping("/devicesWithStatus")
    public List<Geraet> getDevicesWithStatus(@RequestParam(value = "status", defaultValue = "lager") String status){
        
        List<Geraet> devices = geraet_reposetory.findeMitSeriennummerUndStatus(status);
        return devices;
    }
    
    @GetMapping("/numberWithStatus")
    public int getNumberWithStatus(@RequestParam(value = "status", defaultValue = "lager") String status){
        
        List<Geraet> devices = geraet_reposetory.findeMitSeriennummerUndStatus(status);
        return devices.size();
    }
    

    
    
  
    
    
}
