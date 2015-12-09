package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.ComentariiDTO;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.service.RaspunsService;
import ro.upb.smartfeedback.utils.RequestMappings;
import ro.upb.smartfeedback.utils.TipIntrebareEnum;

import java.util.List;

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
    public boolean saveFeedback(@RequestBody CompletareFeedbackDTO completareFeedbackDTO){
        if(!completareFeedbackDTO.getComentariu().isEmpty()) {
            raspunsService.saveComentariu(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, completareFeedbackDTO.getComentariu());
        }
        if (!completareFeedbackDTO.getCompleted()) {
            raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, TipIntrebareEnum.NOTA_GENERALA.getId(), completareFeedbackDTO.getNotaGenerala());
            raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, TipIntrebareEnum.INTERACTIUNE.getId(), completareFeedbackDTO.getInteractiune());
            raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, TipIntrebareEnum.GRAD_INTELEGERE.getId(), completareFeedbackDTO.getGradIntelegere());
            raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, TipIntrebareEnum.ORGANIZARE.getId(), completareFeedbackDTO.getOrganizare());
            raspunsService.saveIntrebare(completareFeedbackDTO.getIdFeedback(), SmartFeedback.loggedUser, TipIntrebareEnum.EXPUNERE.getId(), completareFeedbackDTO.getExpunere());
        }
        return true;
    }

    @RequestMapping(value = RequestMappings.GET_GEEDBACK, method = RequestMethod.GET, produces = "application/json")
    public CompletareFeedbackDTO getFeedbackByUserAndFeedbackId(@PathVariable("userId") Long userId, @PathVariable("feedbackId") Long feedbackId){
        return feedbackService.getFeedbackByUserAndFeedbackId(userId, feedbackId);
    }

    @RequestMapping(value = RequestMappings.GET_COMMENTS_FOR_FEEDBACK, method = RequestMethod.GET, produces = "application/json")
    public List<ComentariiDTO> getCommentsByFeedbackId(@PathVariable("feedbackId") Long feedbackId){
        return raspunsService.getComentariiFeedback(feedbackId);

    }
}
