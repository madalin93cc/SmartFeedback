package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.entity.User;

/**
 * Created by George on 12/6/2015.
 */
public interface RaspunsService {
    public Boolean saveIntrebare(long idFeedback, User utilizator, long idIntrebare, Integer raspuns);

    public Boolean saveComentariu(long idFeedback, User utilizator, String raspuns);
}
