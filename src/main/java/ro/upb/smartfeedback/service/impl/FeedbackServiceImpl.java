package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.FeedbackRepository;
import ro.upb.smartfeedback.repository.RaspunsIntrebareRepository;
import ro.upb.smartfeedback.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Autowired
    RaspunsIntrebareRepository raspunsIntrebareRepository;

    @Override
    public List<Feedback> getAllFeedbacksForActivity(Long activityId) {
        return feedbackRepository.getAllFeedbackForActivity(activityId);
    }

    @Override
    public FeedbackMenuDTO getFeedbackDetailsById(Long id) {
        Feedback feedback = feedbackRepository.getOne(id);
        return new FeedbackMenuDTO(feedback);
    }

    @Override
    public CompletareFeedbackDTO getFeedbackByUserAndFeedbackId(Long userId, Long feedbackId) {
        User user = userRepository.findById(userId);
        Feedback feedback = feedbackRepository.findOne(feedbackId);
        List<RaspunsIntrebare> raspunsIntrebares = raspunsIntrebareRepository.getAllByIdUserAndIdFeedback(user, feedback);
        CompletareFeedbackDTO completareFeedbackDTO = new CompletareFeedbackDTO();
        return completareFeedbackDTO.setResponses(raspunsIntrebares);
    }
}
