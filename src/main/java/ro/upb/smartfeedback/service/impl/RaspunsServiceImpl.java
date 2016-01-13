package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.upb.smartfeedback.dto.ComentariiDTO;
import ro.upb.smartfeedback.dto.MediiNoteDTO;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.Intrebari;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.FeedbackRepository;
import ro.upb.smartfeedback.repository.IntrebariRepository;
import ro.upb.smartfeedback.repository.RaspunsIntrebareRepository;
import ro.upb.smartfeedback.service.RaspunsService;
import ro.upb.smartfeedback.utils.TipIntrebareEnum;
import ro.upb.smartfeedback.utils.TipRaspunsEnum;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public RaspunsIntrebare saveIntrebare(Long idFeedback, User utilizator, Long idIntrebare, Integer raspuns) {
        Feedback feedback = feedbackRepository.getOne(idFeedback);
        Intrebari intrebare = intrebariRepository.getOne(idIntrebare);

        RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare();
        raspunsIntrebare.setIdFeedback(feedback);
        raspunsIntrebare.setIdUser(utilizator);
        raspunsIntrebare.setIdIntrebare(intrebare);
        raspunsIntrebare.setRaspuns(Integer.toString(raspuns));
        raspunsIntrebare.setTipRaspuns(TipRaspunsEnum.INTREBARE.getId());
        raspunsIntrebare.setCreatedAt(new Date());
        return raspunsIntrebareRepository.save(raspunsIntrebare);
    }

    @Override
    public RaspunsIntrebare saveComentariu(Long idFeedback, User utilizator, String raspuns) {
        Feedback feedback = feedbackRepository.getOne(idFeedback);
        RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare();
        raspunsIntrebare.setIdFeedback(feedback);
        raspunsIntrebare.setIdUser(utilizator);
        raspunsIntrebare.setRaspuns(raspuns);
        raspunsIntrebare.setTipRaspuns(TipRaspunsEnum.OBSERVATIE.getId());
        raspunsIntrebare.setCreatedAt(new Date());
        return raspunsIntrebareRepository.saveAndFlush(raspunsIntrebare);
    }

    public List<ComentariiDTO> getComentariiFeedback(Long id) {
        List<RaspunsIntrebare> raspunsuri = raspunsIntrebareRepository.getComentariiByFeedbackId(id);
        List<ComentariiDTO> comentariiDto = new ArrayList<>();
        for(RaspunsIntrebare i : raspunsuri) {
            comentariiDto.add(new ComentariiDTO(i));
        }
        return comentariiDto;
    }


    public MediiNoteDTO getMediiByFeedbackId(Long feedbackId) {

        Feedback f = feedbackRepository.findById(feedbackId);

        Double notaGeneralaMedie = raspunsIntrebareRepository.getMedieNotaByFeedbackIdAndIntrebare(feedbackId, TipIntrebareEnum.NOTA_GENERALA.getId());
        Double interactiuneMedie = raspunsIntrebareRepository.getMedieNotaByFeedbackIdAndIntrebare(feedbackId, TipIntrebareEnum.INTERACTIUNE.getId());
        Double gradIntelegereMedie = raspunsIntrebareRepository.getMedieNotaByFeedbackIdAndIntrebare(feedbackId, TipIntrebareEnum.GRAD_INTELEGERE.getId());
        Double organizareMedie = raspunsIntrebareRepository.getMedieNotaByFeedbackIdAndIntrebare(feedbackId, TipIntrebareEnum.ORGANIZARE.getId());
        Double expunereMedie = raspunsIntrebareRepository.getMedieNotaByFeedbackIdAndIntrebare(feedbackId, TipIntrebareEnum.EXPUNERE.getId());
        Integer numarFeedbackuri = raspunsIntrebareRepository.getNumarFeedbackuri(feedbackId, TipIntrebareEnum.NOTA_GENERALA.getId());
        Integer numarStudenti = f.getIdActivitate().getStudents().size();

        if (notaGeneralaMedie == null) return new MediiNoteDTO(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, numarStudenti);
        return new MediiNoteDTO(notaGeneralaMedie, interactiuneMedie, gradIntelegereMedie, organizareMedie, expunereMedie, numarFeedbackuri, numarStudenti);
    }
}
