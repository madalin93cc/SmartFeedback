//package ro.upb.smartfeedback.rest;
//
//import org.springframework.web.bind.annotation.*;
//import ro.upb.smartfeedback.dto.PersonDTO;
//import ro.upb.smartfeedback.entity.Person;
//import ro.upb.smartfeedback.service.PersonService;
//import ro.upb.smartfeedback.utils.RequestMappings;
//
//import javax.inject.Inject;
//
///**
// * Created by Madalin.Colezea on 7/2/2015.
// */
//@RestController
//public class PersonResource {
//
//    @Inject
//    PersonService personService;
//
//    @RequestMapping(value = RequestMappings.EXAMPLE_MAPPING, method = RequestMethod.GET, produces = "application/json")
//    public Person getPersonByFirstName(@PathVariable("firstName") String firstName){
//        return personService.getPersonByFirstName(firstName);
//    }
//
//    @RequestMapping(value = RequestMappings.ADD_PERSON, method = RequestMethod.POST, produces = "application/json")
//    @ResponseBody
//    public Person addPerson(@RequestBody PersonDTO personDTO){
//        return personService.addPerson(personDTO);
//    }
//}
