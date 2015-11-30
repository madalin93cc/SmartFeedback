package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.ActivitateMenuDTO;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Profesor;
import ro.upb.smartfeedback.entity.Student;
import ro.upb.smartfeedback.repository.ActivitateRepository;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.ActivitatiService;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by George on 11/30/2015.
 */
@Service
@Transactional
public class ActivitatiServiceImpl implements ActivitatiService{
    @Inject
    ActivitateRepository activitateRepository;

    @Override
    public List<ActivitateMenuDTO> getMateriiUtilizator() {
        List<ActivitateMenuDTO> activitateMenuDTOs = new ArrayList<>();
        if (SmartFeedback.loggedUser != null) {
            Set<Activitate> activitates = new HashSet<>();
            if (SmartFeedback.loggedUser.getTip() == 1) {
                activitates = SmartFeedback.loggedUser.getIdProfesor().getActivitati();
            } else if (SmartFeedback.loggedUser.getTip() == 2) {
                activitates = SmartFeedback.loggedUser.getIdStudent().getActivitati();
            }
            for (Activitate a : activitates){
                activitateMenuDTOs.add(new ActivitateMenuDTO(a));
            }
        }
        return activitateMenuDTOs;
    }
}
