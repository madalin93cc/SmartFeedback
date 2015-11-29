package ro.upb.smartfeedback.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.utils.RequestMappings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@RestController
public class MenuController {
    @RequestMapping(value = RequestMappings.GET_MATERII_UTILIZATOR, method = RequestMethod.GET, produces = "application/json")
    public List<String> getMateriiUtilizator(){
        List<String> materii = new ArrayList<>();
        materii.add("Interactiunea om - calculator");
        materii.add("Compilatoare");
        materii.add("Proiectarea retelelor");
        return materii;
    }
}
