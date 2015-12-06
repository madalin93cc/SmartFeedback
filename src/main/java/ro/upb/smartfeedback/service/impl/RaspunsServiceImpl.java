package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.Intrebari;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.FeedbackRepository;
import ro.upb.smartfeedback.repository.IntrebariRepository;
import ro.upb.smartfeedback.repository.RaspunsIntrebareRepository;
import ro.upb.smartfeedback.service.RaspunsService;

import javax.inject.Inject;

/**
 * Created by George on 12/6/2015.
 */

@Service
@Transactional
public class RaspunsServiceImpl implements RaspunsService{

    @Inject
    RaspunsIntrebareRepository raspunsIntrebareRepository;

    @Inject
    FeedbackRepository feedbackRepository;

    @Inject
    IntrebariRepository intrebariRepository;

    @Override
    public Boolean saveIntrebare(long idFeedback, User utilizator, long idIntrebare, Integer raspuns) {
        Feedback feedback = feedbackRepository.getOne(idFeedback);
        Intrebari intrebare = intrebariRepository.getOne(idIntrebare);

        RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare();
        raspunsIntrebare.setIdFeedback(feedback);
        raspunsIntrebare.setIdUser(utilizator);
        raspunsIntrebare.setIdIntrebare(intrebare);
        raspunsIntrebare.setRaspuns(Integer.toString(raspuns));
        raspunsIntrebare.setTipRaspuns(2);
        raspunsIntrebareRepository.saveAndFlush(raspunsIntrebare);
        return Boolean.TRUE;
    }

    @Override
    public Boolean saveComentariu(long idFeedback, User utilizator, String raspuns) {
        Feedback feedback = feedbackRepository.getOne(idFeedback);

        RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare();
        raspunsIntrebare.setIdFeedback(feedback);
        raspunsIntrebare.setIdUser(utilizator);
        raspunsIntrebare.setRaspuns(raspuns);
        raspunsIntrebare.setTipRaspuns(1);
        raspunsIntrebareRepository.saveAndFlush(raspunsIntrebare);
        return Boolean.TRUE;
    }
}
