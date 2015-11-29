package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.dto.UserDTO;

/**
 * Created by George on 11/29/2015.
 */
public interface LoginService {
    public UserDTO login(String username, String password);
}
