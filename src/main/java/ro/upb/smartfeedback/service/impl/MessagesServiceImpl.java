package ro.upb.smartfeedback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.MessageDTO;
import ro.upb.smartfeedback.dto.SendMessageDTO;
import ro.upb.smartfeedback.dto.UserDTO;
import ro.upb.smartfeedback.entity.Mesaj;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.MesajRepository;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.MessagesService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MesajRepository mesajRepository;

    @Override
    public List<UserDTO> getUsersForMessages() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for (User u : users){
            if (u.getId() != SmartFeedback.loggedUser.getId()){
                userDTOs.add(new UserDTO(u));
            }
        }
        return userDTOs;
    }

    @Override
    public List<MessageDTO> getInbox() {
        List<Mesaj> mesajList = mesajRepository.findByIdUserRecv(SmartFeedback.loggedUser);
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Mesaj m : mesajList){
            MessageDTO messageDTO = new MessageDTO(m);
            messageDTO.setUser(m.getIdUserSend().getNume() + " " + m.getIdUserSend().getPrenume());
            messageDTOs.add(messageDTO);
        }
        return messageDTOs;
    }

    @Override
    public List<MessageDTO> getOutbox() {
        List<Mesaj> mesajList = mesajRepository.findByIdUserSend(SmartFeedback.loggedUser);
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Mesaj m : mesajList){
            MessageDTO messageDTO = new MessageDTO(m);
            messageDTO.setUser(m.getIdUserRecv().getNume() + " " + m.getIdUserRecv().getPrenume());
            messageDTOs.add(messageDTO);
        }
        return messageDTOs;
    }

    @Override
    public Boolean sendMessage(SendMessageDTO sendMessageDTO) {
        User u = userRepository.findById(sendMessageDTO.getUserId());
        Mesaj mesaj = new Mesaj();
        mesaj.setCreatedAt(new Date());
        mesaj.setIdUserSend(SmartFeedback.loggedUser);
        mesaj.setIdUserRecv(u);
        mesaj.setSeen(false);
        mesaj.setUpdatedAt(mesaj.getCreatedAt());
        mesaj.setText(sendMessageDTO.getMessage());
        return mesajRepository.save(mesaj) != null;
    }
}
