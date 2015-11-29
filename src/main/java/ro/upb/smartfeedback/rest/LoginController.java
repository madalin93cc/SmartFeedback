package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.upb.smartfeedback.SmartFeedback;
import ro.upb.smartfeedback.dto.UserDTO;
import ro.upb.smartfeedback.service.LoginService;
import ro.upb.smartfeedback.service.impl.LoginServiceImpl;
import ro.upb.smartfeedback.utils.RequestMappings;

/**
 * Created by George on 11/29/2015.
 */

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = RequestMappings.GET_LOGIN_PARAMS, method = RequestMethod.GET, produces = "application/json")
    public UserDTO getSuccessLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
        return loginService.login(username, password);
    }

    @RequestMapping(value = RequestMappings.LOGOUT, method = RequestMethod.GET, produces = "application/json")
    public Boolean logout(){
        SmartFeedback.loggedUser = null;
        return true;
    }

}
