package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.ComentariiDTO;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;

import java.util.List;

/**
 * Created by George on 12/6/2015.
 */
public interface RaspunsService {
    public RaspunsIntrebare saveIntrebare(Long idFeedback, User utilizator, Long idIntrebare, Integer raspuns);

    public RaspunsIntrebare saveComentariu(Long idFeedback, User utilizator, String raspuns);

    public List<ComentariiDTO> getComentariiFeedback(Long id);
}
