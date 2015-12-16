package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.MessageDTO;
import ro.upb.smartfeedback.dto.SendMessageDTO;
import ro.upb.smartfeedback.dto.UserDTO;

import java.util.List;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
public interface MessagesService {
    List<UserDTO> getUsersForMessages();

    List<MessageDTO> getInbox();

    List<MessageDTO> getOutbox();

    Boolean sendMessage(SendMessageDTO sendMessageDTO);
}
