package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.AdaugareFeedbackDetailsDTO;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.Feedback;

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
}
