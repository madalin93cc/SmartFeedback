package ro.upb.smartfeedback.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.upb.smartfeedback.utils.RequestMappings;

/**
 * Created by colez on 13/12/2015.
 */
@RestController
public class StatisticsController {

    @RequestMapping(value = RequestMappings.GET_MAIN_PAGE_OVERVIEW, method = RequestMethod.GET, produces = "application/json")
    public void getOverview(){

    }
}
