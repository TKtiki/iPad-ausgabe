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
import com.bkwitten.Digitalisierung.model.Schueler;
import com.bkwitten.Digitalisierung.model.User;
import java.util.ArrayList;
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
    
    //Admin
    @GetMapping("/devicesWithStatus")
    public List<Geraet> getDevicesWithStatus(@RequestParam(value = "status", defaultValue = "lager") String status){
        
        List<Geraet> devices = geraet_reposetory.findeMitSeriennummerUndStatus(status);
        return devices;
    }
    //Admin
    @GetMapping("/numberWithStatus")
    public int getNumberWithStatus(@RequestParam(value = "status", defaultValue = "lager") String status){
        
        List<Geraet> devices = geraet_reposetory.findeMitSeriennummerUndStatus(status);
        return devices.size();
        
    }
    
    //Admin
    //http://localhost:8080/allClasses
    @GetMapping("/allClasses")
    public List<Klasse> getAllClasses(){
        
        List<Klasse> klassen = klasse_reposetory.findAll();
        return klassen;
        
    }
    
    //Lehrer
    //http://localhost:8080/allClassesFromLehrer?klassenLehrer=lehrerID
    @GetMapping("/allClassesFromLehrer")
    public List<Klasse> allClassesFromLehrer(@RequestParam(value = "klassenLehrer") String klassenLehrer){
        User user = user_reposetory.findById(klassenLehrer).get();
        List<Klasse> klassen = klasse_reposetory.findeAlleKlasseVonLehrer(user);
        return klassen;
        
    }
    
    //Admin und Lehrer
    //http://localhost:8080/allStudentsFromClasse?klassenID=1
    @GetMapping("/allStudentsFromClasse")
    public List<Schueler> allClassesFromLehrer(@RequestParam(value = "klassenID") int klassenID){
        Klasse klasse = klasse_reposetory.findById(klassenID).get();
        List<Schueler> schueler = schueler_reposetory.findeAlleSchuelerVonKlasse(klasse);
        
        return schueler;
        
    }
    
    //Admin und Lehrer
    //http://localhost:8080/getStudentInfos?schuelerID=2
    @GetMapping("/getStudentInfos")
    public Schueler getStudentInfos(@RequestParam(value = "schuelerID") int schuelerID){
        Schueler schueler = schueler_reposetory.findById(schuelerID).get();
        
        return schueler;
    }
    
    //Admin und Lehrer
    //http://localhost:8080/getStudentDevice?schuelerID=2
    @GetMapping("/getStudentDevice")
    public Geraet getStudentDevice(@RequestParam(value = "schuelerID") int schuelerID){
        return getStudentInfos(schuelerID).getGeraet();
    }
    
    //Admin
    //http://localhost:8080/findeSeriennummerLike?seriennummer=12
    @GetMapping("/findeSeriennummerLike")
    public List<Geraet> findeSeriennummerLike(@RequestParam(value = "seriennummer") String seriennummer){
        List<Geraet> geraet = geraet_reposetory.findeSeriennummerLike(seriennummer);
        return geraet;
    }
    
    
    
    

    
    
    //Admin
    //http://localhost:8080/studentsWithTimedOut
    @GetMapping("/studentsWithTimedOut")
    public List<Schueler> getDevicesWithStatus(){
        
        Date heute = new Date();
        List<Geraet> devices = geraet_reposetory.findeMitSeriennummerUndStatus("vergeben");
        
        List<Schueler> studentsTimeOut = new ArrayList<>();
        
        for (int i = 0; i <= devices.size()-1; i++){
            
            Schueler schueler = schueler_reposetory.findeSchuelerMitGeraet(devices.get(i));
            Date rueckgabe = schueler.getRueckgabeDatum();
            if (rueckgabe.before(heute)){
                studentsTimeOut.add(schueler);
                System.out.println("seriennummer: " + schueler.getRueckgabeDatum() + " unde " + heute);
            }
        }
        return studentsTimeOut;
    }
    
    
  
    
    
}
