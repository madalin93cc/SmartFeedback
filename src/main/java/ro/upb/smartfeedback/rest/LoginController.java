package ro.upb.smartfeedback.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.service.impl.LoginServiceImpl;
import ro.upb.smartfeedback.utils.RequestMappings;

/**
 * Created by George on 11/29/2015.
 */

@RestController
public class LoginController {
    @RequestMapping(value = RequestMappings.GET_LOGIN_PARAMS, method = RequestMethod.GET, produces = "application/json")
    public Boolean getSuccessLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        LoginServiceImpl loginService = new LoginServiceImpl();
        return loginService.login(username, password);
    }

}
