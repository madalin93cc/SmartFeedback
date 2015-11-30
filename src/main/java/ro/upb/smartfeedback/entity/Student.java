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
@Table(name = "student")
public class Student implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "an_studiu", nullable = true)
    private Integer anStudiu;

    @OneToOne(optional = false, mappedBy = "idStudent")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_student_serie"),name = "id_serie", unique = false, nullable = false, updatable = true)
    private Serie idSerie;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_student_grupa"), name = "id_grupa", unique = false, nullable = false, updatable = true)
    private Grupa idGrupa;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Fetch(value = FetchMode.SELECT)
    private Set<Activitate> activitati;

    public Student() {
    }

    public Student(Integer anStudiu, Serie idSerie, Grupa idGrupa) {
        this.anStudiu = anStudiu;
        this.idSerie = idSerie;
        this.idGrupa = idGrupa;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(Integer anStudiu) {
        this.anStudiu = anStudiu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Serie getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    public Grupa getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(Grupa idGrupa) {
        this.idGrupa = idGrupa;
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

        Student student = (Student) o;

        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        return !(anStudiu != null ? !anStudiu.equals(student.anStudiu) : student.anStudiu != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (anStudiu != null ? anStudiu.hashCode() : 0);
        return result;
    }
}
