package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.Comentariu;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.service.RaspunsService;
import ro.upb.smartfeedback.utils.RequestMappings;

/**
 * Created by colez on 06/12/2015.
 */
@RestController
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @Autowired
    RaspunsService raspunsService;

    @RequestMapping(value = RequestMappings.GET_DETALII_FEEDBACK_BY_ID, method = RequestMethod.GET, produces = "application/json")
    public FeedbackMenuDTO getFeeedbackDetailById(@PathVariable("id") Long id) {
        return feedbackService.getFeedbackDetailsById(id);
    }

    @RequestMapping(value = RequestMappings.SAVE_FEEDBACK, method = RequestMethod.POST, produces = "application/json")
    public void saveFeedback(@RequestBody CompletareFeedbackDTO completareFeedbackDTO){
        if(!completareFeedbackDTO.getComentariu().isEmpty()) {
            raspunsService.saveComentariu(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, completareFeedbackDTO.getComentariu());
        }
        raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, 1l, completareFeedbackDTO.getNotaGenerala());
        raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, 2l, completareFeedbackDTO.getInteractiune());
        raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, 3l, completareFeedbackDTO.getGradIntelegere());
        raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, 4l, completareFeedbackDTO.getExpunere());

    }
}
