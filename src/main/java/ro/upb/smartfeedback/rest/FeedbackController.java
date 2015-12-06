package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.utils.RequestMappings;

/**
 * Created by colez on 06/12/2015.
 */
@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = RequestMappings.GET_DETALII_FEEDBACK_BY_ID, method = RequestMethod.GET, produces = "application/json")
    public FeedbackMenuDTO getFeeedbackDetailById(@PathVariable("id") Long id) {
        return feedbackService.getFeedbackDetailsById(id);
    }

    @RequestMapping(value = RequestMappings.SAVE_FEEDBACK, method = RequestMethod.POST, produces = "application/json")
    public void saveFeedback(@RequestBody CompletareFeedbackDTO completareFeedbackDTO){
        System.out.println("da");
    }
}
