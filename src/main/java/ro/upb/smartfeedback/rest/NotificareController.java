package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.dto.NotificareDTO;
import ro.upb.smartfeedback.service.NotificationService;
import ro.upb.smartfeedback.utils.RequestMappings;

import java.util.List;

/**
 * Created by colez on 13/12/2015.
 */
@RestController
public class NotificareController {
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = RequestMappings.GET_ACTIVE_NOTIFICATIONS, method = RequestMethod.GET, produces = "application/json")
    public List<NotificareDTO> getActiveNotifications(@PathVariable("userId") Long userId){
        return notificationService.getActiveNotification(userId);
    }

    @RequestMapping(value = RequestMappings.SET_NOTIFICATION_STATUS, method = RequestMethod.GET, produces = "application/json")
    public Boolean setNotificationStatus(@PathVariable("notifId") Long notifId){
        return notificationService.setNotificationStatus(notifId);
    }
}
