package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.*;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.Notificare;

import java.util.List;

/**
 * Created by colez on 03/12/2015.
 */
public interface FeedbackService {
    public List<Feedback> getAllFeedbacksForActivity(Long activityId);

    public FeedbackMenuDTO getFeedbackDetailsById(Long id);

    public CompletareFeedbackDTO getFeedbackByUserAndFeedbackId(Long userId, Long feedbackId);

    public AdaugareFeedbackDetailsDTO getAdaugareFeedbackDetails(Long idActivitate);

    public Feedback addFeeeback(Long idActivitate, Integer saptamana);

    public Notificare requestFeedback(Long idActivitate, Integer saptamana);

    public List<FeedbackPeSaptamanaDTO> getFeedbacksPerWeek(Long idActivitate);

    public FeedbackPeMaterieDTO getFeedbacksPerActivitate(Long idActivitate);

    public List<FeedbackPeMaterieDTO> getFeedbacksPerProfesor(Long userId);
}
