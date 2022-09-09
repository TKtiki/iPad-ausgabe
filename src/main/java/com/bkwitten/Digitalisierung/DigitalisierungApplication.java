package com.bkwitten.Digitalisierung;

import com.bkwitten.Digitalisierung.Repository.GeraetRepository;
import com.bkwitten.Digitalisierung.Repository.HistorieRepository;
import com.bkwitten.Digitalisierung.Repository.KlasseRepository;
import com.bkwitten.Digitalisierung.Repository.SchuelerRepository;
import com.bkwitten.Digitalisierung.Repository.UserRepository;
import com.bkwitten.Digitalisierung.model.Geraet;
import com.bkwitten.Digitalisierung.model.Historie;
import com.bkwitten.Digitalisierung.model.Klasse;
import com.bkwitten.Digitalisierung.model.Schueler;
import com.bkwitten.Digitalisierung.model.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalisierungApplication implements CommandLineRunner{
    
    
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

	public static void main(String[] args) {
		SpringApplication.run(DigitalisierungApplication.class, args);
	}




    
 
    
    
    
        
    @Override
    public void run(String... args) throws Exception {
        
        User admin = new User("admin1ID", "VornameAdmin", "Nachnameadmin", "admin");
        
        user_reposetory.save(admin);
        
        User lehrer = new User("lehrerID", "VornameLehrer", "NachnameLehrer", "lehrer");
        
        user_reposetory.save(lehrer);
        
        User klassenlehrerID = lehrer;
        Klasse klasse1 = new Klasse(klassenlehrerID, "IT");
        
        klasse_reposetory.save(klasse1);
        
        Klasse tofinde = klasse_reposetory.findAll().get(0);
        
        System.out.println(tofinde.getBezeichnug() + " :  " + tofinde.getKlassenlehrer().getVorname() + " " + tofinde.getKlassenlehrer().getNachname());
        
        
        String seriennummer = "00100212";
        Geraet geraet = new Geraet(seriennummer, "01", "lager");
        
        geraet_reposetory.save(geraet);
        
        Date rueckgabeDatum = new Date();
        Date ausgabeDatum = new Date();
        Schueler schueler = new Schueler("vorname", "nachname", klasse1, rueckgabeDatum, ausgabeDatum, geraet);
        
        
        schueler_reposetory.save(schueler);
        System.out.println(schueler.getVorname() + " " + schueler.getNachname() + " : " + schueler.getKlasse().getBezeichnug());
        
        seriennummer = schueler.getGeraet().getSeriennummer();
        
        System.out.println(seriennummer);
        
        geraet = geraet_reposetory.findById(seriennummer).get();
        
        Historie historie = new Historie(geraet, rueckgabeDatum, "historievorname", "historienachname", "gut", "alles gut");
        
        historie_reposetory.save(historie);
        System.out.println();
        
    }

}
