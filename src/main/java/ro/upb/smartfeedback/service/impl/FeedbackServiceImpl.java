package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.*;
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
import ro.upb.smartfeedback.utils.TipIntrebareEnum;
import ro.upb.smartfeedback.utils.TipNotificareEnum;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Autowired
    ProfesorRepository profesorRepository;

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
        for (int i = 1; i <= 14; i++) {
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
        List<Notificare> saptamaniExistente = notificareRepository.findByActivitateAndSaptamana(activitate, saptamana);
        notificare.setActivitate(activitate);
        notificare.setUser(user);
        notificare.setTipNotificare(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getId());
        notificare.setUrl(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getBaseUrl() + activitate.getId());
        notificare.setMessage(TipNotificareEnum.CERERE_ACTIVARE_FEEDBACK.getMessage());
        notificare.setStatus(false);
        notificare.setSaptamana(saptamana);
        if (saptamaniExistente.size() != 0){
            return notificare;
        }
        notificare = notificareRepository.save(notificare);
        return notificare;
    }


    @Override
    public List<FeedbackPeSaptamanaDTO> getFeedbacksPerWeek(Long idActivitate) {
        List<FeedbackPeSaptamanaDTO> rezultate = new ArrayList<>();
        List<Feedback> feedbacks = feedbackRepository.getAllFeedbackForActivity(idActivitate);
        Activitate a = activitateRepository.findById(idActivitate);

        for(Integer i = 1; i <= 14; i++) {
            rezultate.add(new FeedbackPeSaptamanaDTO(i, new ActivitateMenuDTO(a), 0));
        }

        for(Feedback f : feedbacks) {
            for(FeedbackPeSaptamanaDTO rez : rezultate) {
                if(f.getSaptamana().equals(rez.getSaptamana()))
                    rez.setFeedbacks(raspunsIntrebareRepository.getNumarFeedbackuri(f.getId(), TipIntrebareEnum.NOTA_GENERALA.getId()));
            }
        }
        return rezultate;
    }

    @Override
    public FeedbackPeMaterieDTO getFeedbacksPerActivitate(Long idActivitate) {
        return new FeedbackPeMaterieDTO(new ActivitateMenuDTO(activitateRepository.findById(idActivitate)), this.getFeedbacksPerWeek(idActivitate));
    }

    @Override
    public List<FeedbackPeMaterieDTO> getFeedbacksPerProfesor(Long userId) {
        Profesor p = userRepository.findById(userId).getIdProfesor();
        if (p != null){
        Set<Activitate> activitati = p.getActivitati();
        List<FeedbackPeMaterieDTO> rezultate = new ArrayList<>();

        for(Activitate a : activitati) {
            rezultate.add(this.getFeedbacksPerActivitate(a.getId()));
        }
        return rezultate;
        }
        return null;
    }
}
