package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.ActivitateMenuDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.dto.MedieActivitateDTO;
import ro.upb.smartfeedback.dto.MediiNoteDTO;
import ro.upb.smartfeedback.entity.*;
import ro.upb.smartfeedback.repository.ActivitateRepository;
import ro.upb.smartfeedback.repository.RaspunsIntrebareRepository;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.ActivitatiService;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.service.RaspunsService;

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

    @Autowired
    RaspunsService raspunsService;

    @Autowired
    RaspunsIntrebareRepository raspunsIntrebareRepository;

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<ActivitateMenuDTO> getMateriiUtilizator(Long userId) {
        User user = userRepository.findById(userId);
        List<ActivitateMenuDTO> activitateMenuDTOs = new ArrayList<>();
        if (user != null) {
            Set<Activitate> activitates = new HashSet<>();
            if (user.getTip() == 1) {
                activitates = user.getIdProfesor().getActivitati();
            } else if (user.getTip() == 2) {
                activitates = user.getIdStudent().getActivitati();
            }
            for (Activitate a : activitates){
                activitateMenuDTOs.add(new ActivitateMenuDTO(a));
            }
        }
        return activitateMenuDTOs;
    }

    @Override
    public List<MedieActivitateDTO> getMediiActivitati(Long userId) {
        List<ActivitateMenuDTO> materiiUtilizator = this.getMateriiUtilizator(userId);
        List<MedieActivitateDTO> rezultate = new ArrayList<>();

        for (ActivitateMenuDTO activitate: materiiUtilizator){
            List<Feedback> feedbacks = feedbackService.getAllFeedbacksForActivity(activitate.getId());
            List<FeedbackMenuDTO> feedbackMenuDTOs = new ArrayList<>();
            for (Feedback f: feedbacks){
                feedbackMenuDTOs.add(new FeedbackMenuDTO(f));
            }
            activitate.setFeedbacks(feedbackMenuDTOs);
        }

        for(ActivitateMenuDTO activitate : materiiUtilizator) {
            List<Double> mediiPeFeedback = new ArrayList<>();

            if(activitate.getFeedbacks() != null) {
                for (FeedbackMenuDTO f : activitate.getFeedbacks()) {
                    MediiNoteDTO medii = raspunsService.getMediiByFeedbackId(f.getId());
                    if (medii != null) {
                        mediiPeFeedback.add((medii.getExpunereMedie() + medii.getGradIntelegereMedie() + medii.getInteractiuneMedie() +
                                medii.getOrganizareMedie() + medii.getNotaGeneralaMedie()) / 5);
                    }
                }
            }
            Double sum = 0.;
            if(!mediiPeFeedback.isEmpty()) {
                for(Double x : mediiPeFeedback) {
                    sum += x;
                }
                rezultate.add(new MedieActivitateDTO(activitate, sum / mediiPeFeedback.size()));
            }
        }
        return rezultate;
    }
}
