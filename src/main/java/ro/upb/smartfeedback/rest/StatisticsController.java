package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.dto.FeedbackPeMaterieDTO;
import ro.upb.smartfeedback.dto.MedieActivitateDTO;
import ro.upb.smartfeedback.service.ActivitatiService;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.utils.RequestMappings;

import java.util.List;

/**
 * Created by colez on 13/12/2015.
 */
@RestController
public class StatisticsController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    ActivitatiService activitatiService;

    @RequestMapping(value = RequestMappings.GET_NO_FEEDBACKS_PER_PROFESOR, method = RequestMethod.GET, produces = "application/json")
    public List<FeedbackPeMaterieDTO> getNoFeedbacks() {
        return feedbackService.getFeedbacksPerProfesor();
    }

    @RequestMapping(value = RequestMappings.GET_MEDII_ACTIVITATI, method = RequestMethod.GET, produces = "application/json")
    public List<MedieActivitateDTO> getMediiActivitati() {
        return activitatiService.getMediiActivitati();
    }

}
