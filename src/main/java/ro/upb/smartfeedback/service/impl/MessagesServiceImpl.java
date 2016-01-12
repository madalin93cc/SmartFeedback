package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.MessageDTO;
import ro.upb.smartfeedback.dto.SendMessageDTO;
import ro.upb.smartfeedback.dto.UserDTO;
import ro.upb.smartfeedback.entity.Mesaj;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.MesajRepository;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.MessagesService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
@Service
@Transactional
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MesajRepository mesajRepository;

    @Override
    public List<UserDTO> getUsersForMessages(Long userId) {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User u : users){
            if (u.getId() != userRepository.findById(userId).getId()){
                userDTOs.add(new UserDTO(u));
            }
        }
        return userDTOs;
    }

    @Override
    public List<MessageDTO> getInbox(Long userId) {
        List<Mesaj> mesajList = mesajRepository.findByIdUserRecv(userRepository.findById(userId));
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Mesaj m : mesajList){
            MessageDTO messageDTO = new MessageDTO(m);
            messageDTO.setUser(m.getIdUserSend().getNume() + " " + m.getIdUserSend().getPrenume());
            messageDTOs.add(messageDTO);
        }
        return messageDTOs;
    }

    @Override
    public List<MessageDTO> getOutbox(Long userId) {
        List<Mesaj> mesajList = mesajRepository.findByIdUserSend(userRepository.findById(userId));
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Mesaj m : mesajList){
            MessageDTO messageDTO = new MessageDTO(m);
            messageDTO.setUser(m.getIdUserRecv().getNume() + " " + m.getIdUserRecv().getPrenume());
            messageDTOs.add(messageDTO);
        }
        return messageDTOs;
    }

    @Override
    public Boolean sendMessage(SendMessageDTO sendMessageDTO, Long userId) {
        User u = userRepository.findById(sendMessageDTO.getUserId());
        Mesaj mesaj = new Mesaj();
        mesaj.setCreatedAt(new Date());
        mesaj.setIdUserSend(userRepository.findById(userId));
        mesaj.setIdUserRecv(u);
        mesaj.setSeen(false);
        mesaj.setUpdatedAt(mesaj.getCreatedAt());
        mesaj.setText(sendMessageDTO.getMessage());
        return mesajRepository.save(mesaj) != null;
    }

    @Override
    public Boolean changeSeen(Long messageId, Boolean change) {
        Mesaj m = mesajRepository.findById(messageId);
        m.setSeen(change);
        mesajRepository.save(m);
        return true;
    }
}
