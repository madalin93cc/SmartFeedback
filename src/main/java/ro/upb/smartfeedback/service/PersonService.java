package ro.upb.smartfeedback.service;

import ro.upb.smartfeedback.entity.Person;
import ro.upb.smartfeedback.dto.PersonDTO;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 */
public interface PersonService {
    public Person getPersonByFirstName(String firstName);

    public Person addPerson(PersonDTO personDTO);
}
