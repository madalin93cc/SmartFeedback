package ro.upb.smartfeedback.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.service.ActivitatiService;
import ro.upb.smartfeedback.utils.RequestMappings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@RestController
public class MenuController {
    @Autowired
    ActivitatiService activitatiService;

    @RequestMapping(value = RequestMappings.GET_MATERII_UTILIZATOR, method = RequestMethod.GET, produces = "application/json")
    public List<Activitate> getMateriiUtilizator(){
        List<Activitate> materii = activitatiService.getMateriiUtilizator();
        return materii;
    }
}
