package ro.upb.smartfeedback.service.impl;

import org.springframework.stereotype.Service;
import ro.upb.smartfeedback.dto.PersonDTO;
import ro.upb.smartfeedback.entity.Person;
import ro.upb.smartfeedback.repository.PersonRepository;
import ro.upb.smartfeedback.service.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Inject
    PersonRepository personRepository;

    @Override
    public Person getPersonByFirstName(String firstName) {
        List<Person> personList = personRepository.findByFirstName(firstName);
        return (personList.size()!=0? personList.get(0): null);
    }

    @Override
    public Person addPerson(PersonDTO personDTO) {
        Person person = personDTO.toEntity(new Person());
        return personRepository.save(person);
    }
}
