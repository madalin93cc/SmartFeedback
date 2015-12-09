package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.*;
import ro.upb.smartfeedback.repository.*;
import ro.upb.smartfeedback.service.FeedbackService;

import javax.transaction.Transactional;
import java.util.Date;
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

    @Autowired
    ActivitateRepository activitateRepository;

    @Autowired
    IntrebariRepository intrebariRepository;

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

    @Override
    public Feedback addFeeeback(Long idActivitate, Integer saptamana) {
        Feedback f = new Feedback();
        Activitate activitate = activitateRepository.findById(idActivitate);
        Date currentDate = new Date();
        f.setIdActivitate(activitate);
        f.setIntrebari(intrebariRepository.findAll());
        f.setSaptamana(saptamana);
        f.setNume(activitate.getNume() + " Saptamana " + saptamana);
        f.setFromDate(currentDate);
        f.setToDate(new Date(currentDate.getTime() + 7 * 60 * 60 * 24 * 1000));
        f.setStatus(1);
        return feedbackRepository.save(f);
    }
}
