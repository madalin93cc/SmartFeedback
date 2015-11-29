package ro.upb.smartfeedback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.upb.smartfeedback.entity.Sectie;
import ro.upb.smartfeedback.entity.TipActivitate;
import ro.upb.smartfeedback.repository.SectieRepository;
import ro.upb.smartfeedback.repository.TipActivitateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartFeedback.class)
@WebAppConfiguration
public class SmartFeedbackTests {
	@Autowired
	TipActivitateRepository tipActivitateRepository;
    SectieRepository sectieRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void add_tip_activitate(){
		TipActivitate ta = new TipActivitate("curs");
		tipActivitateRepository.save(ta);
		ta = new TipActivitate("seminar");
		tipActivitateRepository.save(ta);
		ta = new TipActivitate("laborator");
		tipActivitateRepository.save(ta);
	}

    public void add_sectie(){
        Sectie s = new Sectie("Calculatoare si Tehnologia Informatiei", "CTI");
        sectieRepository.save(s);
        s = new Sectie("Ingineria sistemelor", "IS");
        sectieRepository.save(s);
    }

}
