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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DigitalisierungApplication implements CommandLineRunner {

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
        // create();
        User lehrer = new User("lehrerID", "VornameLehrer", "NachnameLehrer", "lehrer");

        List<Klasse> test = klasse_reposetory.findeAlleKlasseVonLehrer(lehrer);

        System.out.println("test: " + test.get(0).getBezeichnug());

        User klassenlehrerID = lehrer;
        Klasse klasse1 = new Klasse(klassenlehrerID, "IT");

        Klasse klasse = test.get(0);

        List<Schueler> test2 = schueler_reposetory.findeAlleSchuelerVonKlasse(klasse);
        System.out.println("test2: " + test2.get(0).getVorname());
        test2.get(0).setVorname("vorname");
        schueler_reposetory.save(test2.get(0));
        test2 = schueler_reposetory.findeAlleSchuelerVonKlasse(klasse);
        System.out.println("test2.2: " + test2.get(0).getVorname());

        String seriennummer = "00100212";

        Schueler test3 = schueler_reposetory.findeSchuelerMitGeraet(geraet_reposetory.findById(seriennummer).get());
        System.out.println("test3: " + test3.getKlasse().getBezeichnug());

        List<Historie> test4 = historie_reposetory.findeMitGeraet(geraet_reposetory.findById(seriennummer).get());
        System.out.println("test4: " + test4.get(0).getZustand());

        // Anzahl von geräte welche im lager sind
        List<Geraet> test5 = geraet_reposetory.findeMitSeriennummerUndStatus("lager");
        System.out.println(test5.size());

    }

    public void create() {
        User admin = new User("admin1ID", "VornameAdmin", "Nachnameadmin", "admin");

        user_reposetory.save(admin);

        User lehrer = new User("lehrerID", "VornameLehrer", "NachnameLehrer", "lehrer");

        user_reposetory.save(lehrer);

        User klassenlehrerID = lehrer;
        Klasse klasse1 = new Klasse(klassenlehrerID, "ITO 2022");

        klasse_reposetory.save(klasse1);

        Klasse tofinde = klasse_reposetory.findAll().get(0);

        System.out.println(tofinde.getBezeichnug() + " :  " + tofinde.getKlassenlehrer().getVorname() + " "
                + tofinde.getKlassenlehrer().getNachname());

        String seriennummer = "00100212";
        Geraet geraet = new Geraet(seriennummer, "01", "vergeben");
        Geraet geraet2 = new Geraet(seriennummer + "2", "01", "vergeben");
        Geraet geraet3 = new Geraet(seriennummer + "1", "01", "lager");

        geraet_reposetory.save(geraet);
        geraet_reposetory.save(geraet2);
        geraet_reposetory.save(geraet3);

        Date rueckgabeDatum = new Date();
        Date ausgabeDatum = new Date();
        Schueler schueler = new Schueler("vorname", "nachname", klasse1, rueckgabeDatum, ausgabeDatum, geraet);
        Schueler schueler2 = new Schueler("vorname2", "nachname2", klasse1, rueckgabeDatum, ausgabeDatum, geraet2);

        schueler_reposetory.save(schueler);
        schueler_reposetory.save(schueler2);
        System.out.println(
                schueler.getVorname() + " " + schueler.getNachname() + " : " + schueler.getKlasse().getBezeichnug());

        seriennummer = schueler.getGeraet().getSeriennummer();

        System.out.println(seriennummer);

        geraet = geraet_reposetory.findById(seriennummer).get();

        Historie historie = new Historie(geraet, rueckgabeDatum, "historievorname", "historienachname", "gut",
                "alles gut");

        historie_reposetory.save(historie);
    }
}
