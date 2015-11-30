package ro.upb.smartfeedback;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ro.upb.smartfeedback.entity.*;
import ro.upb.smartfeedback.repository.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartFeedback.class)
@WebAppConfiguration
public class SmartFeedbackTests {
	@Autowired
	TipActivitateRepository tipActivitateRepository;

	@Autowired
	SectieRepository sectieRepository;

	@Autowired
	SerieRepository serieRepository;

    @Autowired
    ActivitateRepository activitateRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    UserRepository userRepository;

	@Autowired
	GrupaRepository grupaRepository;

	@Autowired
	StudentRepository studentRepository;

	@Test
	@Ignore
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void add_tip_activitate(){
		TipActivitate ta = new TipActivitate("curs");
		tipActivitateRepository.save(ta);
		ta = new TipActivitate("seminar");
		tipActivitateRepository.save(ta);
		ta = new TipActivitate("laborator");
		tipActivitateRepository.save(ta);
	}

	@Test
	@Ignore
	public void add_sectie(){
		Sectie s = new Sectie("Calculatoare si Tehnologia Informatiei", "CTI");
		sectieRepository.save(s);
		s = new Sectie("Ingineria sistemelor", "IS");
		sectieRepository.save(s);
	}

	@Test
	@Ignore
	public void add_serie() {
		Sectie is = sectieRepository.findByCode("IS");
		Sectie cti = sectieRepository.findByCode("CTI");
		Serie s = new Serie("CA", "CA", cti);
		serieRepository.save(s);
		s = new Serie("CB", "CB", cti);
		serieRepository.save(s);
		s = new Serie("CC", "CC", cti);
		serieRepository.save(s);
		s = new Serie("Arhitectura Sistemelor de Calcul", "C1", cti);
		serieRepository.save(s);
		s = new Serie("Sisteme embedded", "C2", cti);
		serieRepository.save(s);
		s = new Serie("Compilatoare", "C3", cti);
		serieRepository.save(s);
		s = new Serie("Inteligenta artificiala", "C4", cti);
		serieRepository.save(s);
		s = new Serie("Programare web", "C5", cti);
		serieRepository.save(s);
		s = new Serie("AA", "AA", is);
		serieRepository.save(s);
		s = new Serie("AB", "AB", is);
		serieRepository.save(s);
		s = new Serie("AC", "AC", is);
		serieRepository.save(s);
	}

    @Test
    @Ignore
    public void add_activitate() {
        Serie s = serieRepository.getByCode("CC");
        TipActivitate ta = tipActivitateRepository.getByNume("curs");
        Activitate a = new Activitate(1, "Utilizarea sistemelor de operare", "USO", ta, s, null);
        activitateRepository.save(a);
        a = new Activitate(3, "Sisteme de operare", "SO", ta, s, null);
        activitateRepository.save(a);
    }

    @Test
	@Ignore
    public void add_user() {
        Profesor p = profesorRepository.getById(1l);
        // voiam sa ii iau id-ul
        User u = new User("Deaconescu", "Razvan", "rdeaconescu", "razvan", "razvan.deaconescu@cs.pub.ro", 1, null, p);
        userRepository.save(u);
    }


    @Test
    @Ignore
    public void add_profesor() {
        //List<Activitate> activitati = new ArrayList<Activitate>();
        // bagate activitatile
        //User u = userRepository.getByNume("Deaconescu");
        // aici trebuia luat user-ul
        Profesor p = new Profesor();
        profesorRepository.save(p);
    }

	@Test
	@Ignore
	public void add_grupa() {
		Grupa g = new Grupa("334CC", 2015);
		grupaRepository.save(g);
		g = new Grupa("333CC", 2015);
		grupaRepository.save(g);
		g = new Grupa("332CC", 2015);
		grupaRepository.save(g);
	}

	@Test
	@Ignore
	public void add_student() {
		Grupa g = grupaRepository.findOne(1l);
		Serie s = serieRepository.getByCode("CC");
		Student student = new Student(2015, s, g);
		studentRepository.save(student);
		User u = new User("Colezea", "Madalin", "colezea", "madalin", "madalin.colezea@cs.pub.ro", 2, student, null);
		userRepository.save(u);
	}

}
