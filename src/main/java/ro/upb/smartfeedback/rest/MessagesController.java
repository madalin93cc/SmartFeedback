package ro.upb.smartfeedback.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upb.smartfeedback.dto.MessageDTO;
import ro.upb.smartfeedback.dto.SendMessageDTO;
import ro.upb.smartfeedback.dto.UserDTO;
import ro.upb.smartfeedback.service.MessagesService;
import ro.upb.smartfeedback.utils.RequestMappings;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
@RestController
public class MessagesController {
    @Inject
    private MessagesService messagesService;

    @RequestMapping(value = RequestMappings.GET_USERS_FOR_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getUsersForMessages(@PathVariable("userId") Long userId){
        return messagesService.getUsersForMessages(userId);
    }

    @RequestMapping(value = RequestMappings.GET_INBOX, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<MessageDTO> getInbox(@PathVariable("userId") Long userId){
        return messagesService.getInbox(userId);
    }

    @RequestMapping(value = RequestMappings.GET_OUTBOX, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<MessageDTO> getOutbox(@PathVariable("userId") Long userId){
        return messagesService.getOutbox(userId);
    }

    @RequestMapping(value = RequestMappings.SEND_MESSAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    private Boolean sendMessage(@RequestBody SendMessageDTO sendMessageDTO, @PathVariable("userId") Long userId){
        return messagesService.sendMessage(sendMessageDTO, userId);
    }

    @RequestMapping(value = RequestMappings.CHANGE_SEEN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private Boolean changeSeen(@PathVariable("messageId") Long messageId, @PathVariable("change") Boolean change){
        return messagesService.changeSeen(messageId, change);
    }
}
