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
import com.bkwitten.Digitalisierung.model.Schueler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karahtqc
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AngularController {
    
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
    
    @PostMapping("/registerSchüler")
    public Schueler registerSchüler(@RequestBody Schueler schueler) {
        return schueler_reposetory.save(schueler);
    }
    
    @GetMapping("/getSchüler")
    public List<Schueler> getStudents() {
        return schueler_reposetory.findAll();
    }
    
    @DeleteMapping("/deleteSchüler")
    public void deleteStudent(@RequestParam(value = "id") int id) {
        Schueler schueler = schueler_reposetory.findById(id).get();
        schueler_reposetory.delete(schueler);
    }
    
    
    @PutMapping("/updateSchüler")
    public Schueler updateStudents(@RequestBody Schueler schueler) {
        return schueler_reposetory.save(schueler);
    }
}
