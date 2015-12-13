package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.NotificareDTO;
import ro.upb.smartfeedback.entity.Notificare;
import ro.upb.smartfeedback.repository.NotificareRepository;
import ro.upb.smartfeedback.service.NotificationService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by colez on 13/12/2015.
 */
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    NotificareRepository notificareRepository;

    @Override
    public List<NotificareDTO> getActiveNotification() {
        List<NotificareDTO> notificationDTOs = new ArrayList<>();
        List<Notificare> notificares = notificareRepository.findByUserAndStatus(SmartFeedback.loggedUser, Boolean.FALSE);
        for(Notificare n : notificares){
            notificationDTOs.add(new NotificareDTO(n));
        }
        return notificationDTOs;
    }

    @Override
    public Boolean setNotificationStatus(Long notifId) {
        Notificare notificare = notificareRepository.getById(notifId);
        notificare.setStatus(true);
        return notificareRepository.save(notificare)!= null;
    }
}
