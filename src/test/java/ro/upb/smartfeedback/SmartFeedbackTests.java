package ro.upb.smartfeedback;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.upb.smartfeedback.entity.Sectie;
import ro.upb.smartfeedback.entity.Serie;
import ro.upb.smartfeedback.entity.TipActivitate;
import ro.upb.smartfeedback.repository.SectieRepository;
import ro.upb.smartfeedback.repository.SerieRepository;
import ro.upb.smartfeedback.repository.TipActivitateRepository;

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

}
