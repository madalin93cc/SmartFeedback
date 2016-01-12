package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.MessageDTO;
import ro.upb.smartfeedback.dto.SendMessageDTO;
import ro.upb.smartfeedback.dto.UserDTO;

import java.util.List;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
public interface MessagesService {
    List<UserDTO> getUsersForMessages(Long userId);

    List<MessageDTO> getInbox(Long userId);

    List<MessageDTO> getOutbox(Long userId);

    Boolean sendMessage(SendMessageDTO sendMessageDTO, Long userId);

    Boolean changeSeen(Long messageId, Boolean change);
}
