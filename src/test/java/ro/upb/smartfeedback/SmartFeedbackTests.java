package ro.upb.smartfeedback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.upb.smartfeedback.entity.TipActivitate;
import ro.upb.smartfeedback.repository.TipActivitateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartFeedback.class)
@WebAppConfiguration
public class SmartFeedbackTests {
	@Autowired
	TipActivitateRepository tipActivitateRepository;

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

}
