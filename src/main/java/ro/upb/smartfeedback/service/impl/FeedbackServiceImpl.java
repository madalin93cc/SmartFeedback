package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.repository.FeedbackRepository;
import ro.upb.smartfeedback.service.FeedbackService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by colez on 03/12/2015.
 */
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedbacksForActivity(Long activityId) {
        return feedbackRepository.getAllFeedbackForActivity(activityId);
    }
}
