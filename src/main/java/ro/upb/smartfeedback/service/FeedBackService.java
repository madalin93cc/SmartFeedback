package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.entity.Feedback;

import java.util.List;

/**
 * Created by colez on 03/12/2015.
 */
public interface FeedbackService {
    List<Feedback> getAllFeedbacksForActivity(Long activityId);
}
