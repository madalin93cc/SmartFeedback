package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.NotificareDTO;

import java.util.List;

/**
 * Created by colez on 13/12/2015.
 */
public interface NotificationService {
    List<NotificareDTO> getActiveNotification();
    Boolean setNotificationStatus(Long notifId);
}
