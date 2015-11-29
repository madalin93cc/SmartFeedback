package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.entity.User;
import ro.upb.smartfeedback.repository.UserRepository;
import ro.upb.smartfeedback.service.LoginService;

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
    public Boolean login(String username, String password) {
        User loggedUser = userRepository.getByUsernameAndPassword(username, password);
        if(loggedUser == null) {
            return Boolean.FALSE;
        } else {
            SmartFeedback.loggedUser = loggedUser;
            return Boolean.TRUE;
        }
    }
}
