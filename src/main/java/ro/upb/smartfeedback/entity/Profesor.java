package ro.upb.smartfeedback.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by colez on 23/11/2015.
 */
@Entity
@Table(name = "profesor")
public class Profesor implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false, mappedBy = "idProfesor")
    private User user;

    @ManyToMany(mappedBy = "profesors", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Fetch(value = FetchMode.SELECT)
    private Set<Activitate> activitati;

    public Profesor(User user, Set<Activitate> activitati) {
        this.user = user;
        this.activitati = activitati;
    }

    public Profesor() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Activitate> getActivitati() {
        return activitati;
    }

    public void setActivitati(Set<Activitate> activitati) {
        this.activitati = activitati;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor profesor = (Profesor) o;

        return !(id != null ? !id.equals(profesor.id) : profesor.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
