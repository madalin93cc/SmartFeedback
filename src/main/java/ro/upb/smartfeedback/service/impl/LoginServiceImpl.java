package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
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
        if(userRepository.getByUsernameAndPassword(username, password) == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
