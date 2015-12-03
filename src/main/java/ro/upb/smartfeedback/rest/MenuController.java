package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.dto.ActivitateMenuDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.repository.ActivitateRepository;
import ro.upb.smartfeedback.service.ActivitatiService;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.utils.RequestMappings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@RestController
public class MenuController {
    @Autowired
    ActivitatiService activitatiService;

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    ActivitateRepository activitateRepository;

    @RequestMapping(value = RequestMappings.GET_MATERII_UTILIZATOR, method = RequestMethod.GET, produces = "application/json")
    public List<ActivitateMenuDTO> getMateriiUtilizator(){
        List<ActivitateMenuDTO> materii = activitatiService.getMateriiUtilizator();
        for (ActivitateMenuDTO activitate: materii){
            List<Feedback> feedbacks = feedbackService.getAllFeedbacksForActivity(activitate.getId());
            List<FeedbackMenuDTO> feedbackMenuDTOs = new ArrayList<>();
            for (Feedback f: feedbacks){
                feedbackMenuDTOs.add(new FeedbackMenuDTO(f));
            }
            activitate.setFeedbacks(feedbackMenuDTOs);
        }
        return materii;
    }
}
