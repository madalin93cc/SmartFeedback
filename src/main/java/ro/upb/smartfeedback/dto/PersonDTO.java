package ro.upb.smartfeedback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.BeanUtils;
import ro.upb.smartfeedback.entity.Person;

import java.io.Serializable;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 */
public class PersonDTO implements Serializable {

    private Long id;

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "lastName")
    private String lastName;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(Person person){
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    public Person toEntity(Person person){
        BeanUtils.copyProperties(this, person);
        return person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDTO personDTO = (PersonDTO) o;

        if (id != null ? !id.equals(personDTO.id) : personDTO.id != null) return false;
        if (firstName != null ? !firstName.equals(personDTO.firstName) : personDTO.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(personDTO.lastName) : personDTO.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
