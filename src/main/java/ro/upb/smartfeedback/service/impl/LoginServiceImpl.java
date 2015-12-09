package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.UserDTO;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.LoginService;
import ro.upb.smartfeedback.utils.UserTypeEnum;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

/**
 * Created by George on 11/29/2015.
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
    @Inject
    UserRepository userRepository;

    @Override
    public UserDTO login(String username, String password) {
        User loggedUser = userRepository.getByUsernameAndPassword(username, password);
        UserDTO userDTO = null;
        if(loggedUser == null) {
            return userDTO;
        } else {
            SmartFeedback.loggedUser = loggedUser;
            userDTO = new UserDTO(loggedUser.getId(), loggedUser.getNume(), loggedUser.getPrenume(), loggedUser.getUsername(), null);
            if (SmartFeedback.loggedUser.getIdProfesor() != null){
                userDTO.setUserType(UserTypeEnum.PROFESOR);
            } else if (SmartFeedback.loggedUser.getIdStudent() != null){
                userDTO.setUserType(UserTypeEnum.STUDENT);
            }
            return userDTO;
        }
    }
}
