package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.dto.AdaugareFeedbackDetailsDTO;
import ro.upb.smartfeedback.dto.CompletareFeedbackDTO;
import ro.upb.smartfeedback.dto.FeedbackMenuDTO;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.ActivitateRepository;
import ro.upb.smartfeedback.repository.FeedbackRepository;
import ro.upb.smartfeedback.repository.RaspunsIntrebareRepository;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.entity.*;
import ro.upb.smartfeedback.repository.*;
import ro.upb.smartfeedback.service.FeedbackService;
import ro.upb.smartfeedback.utils.TipNotificareEnum;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Autowired
    NotificareRepository notificareRepository;

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
    public AdaugareFeedbackDetailsDTO getAdaugareFeedbackDetails(Long idActivitate) {
        Activitate activitate = activitateRepository.findOne(idActivitate);
        AdaugareFeedbackDetailsDTO detailsDTO = new AdaugareFeedbackDetailsDTO();
        detailsDTO.setNume(activitate.getNume());
        List<Feedback> feedbacks = feedbackRepository.getAllFeedbackForActivity(idActivitate);
        List<Integer> weeks = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            boolean ok = true;
            for (Feedback f: feedbacks){
                if (f.getSaptamana() == i){
                    ok = false;
                    break;
                }
            }
            if (ok) {
                weeks.add(i);
            }
        }
        detailsDTO.setAvailableWeeks(weeks);
        return detailsDTO;
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

    @Override
    public Notificare requestFeedback(Long idActivitate, Integer saptamana) {
        Notificare notificare = new Notificare();
        Activitate activitate = activitateRepository.findById(idActivitate);
        Profesor titulat = activitate.getProfesors().get(0);
        User user = titulat.getUser();

        notificare.setActivitate(activitate);
        notificare.setUser(user);
        notificare.setTipNotificare(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getId());
        notificare.setUrl(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getBaseUrl() + activitate.getId());
        notificare.setMessage(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getMessage());
        notificare.setStatus(false);
        notificare.setSaptamana(saptamana);
        notificare = notificareRepository.save(notificare);

        return notificare;
    }
}
