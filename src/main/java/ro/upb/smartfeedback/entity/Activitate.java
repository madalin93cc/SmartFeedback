package ro.upb.smartfeedback.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by George on 11/23/2015.
 */
@Entity
@Table(name = "activitate")
public class Activitate implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "an")
    private Integer an;

    @Column(name = "nume", length = 50, nullable = false)
    private String nume;

    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_activitate_tip_activitate"), name = "tip_activitate_id", unique = false, nullable = false, updatable = true)
    private TipActivitate idTipActivitate;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_activitate_serie"), name = "id_serie", unique = false, nullable = false, updatable = true)
    private Serie idSerie;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_activitate_grupa"), name = "id_grupa", unique = false, nullable = false, updatable = true)
    private Grupa idGrupa;

    @ManyToMany
    @JoinTable(name = "student_activitate",
            joinColumns = @JoinColumn(name = "id_student", foreignKey = @ForeignKey(name = "FK__student")),
            inverseJoinColumns = @JoinColumn(name = "id_activitate", foreignKey = @ForeignKey(name = "FK_student_activitate_activitate")))
    private List<Student> students;

    @ManyToMany
    @JoinTable(name = "profesor_activitate",
            joinColumns = @JoinColumn(name = "id_profesor", foreignKey = @ForeignKey(name = "FK_profesor_activitate_profesor")),
            inverseJoinColumns = @JoinColumn(name = "id_activitate", foreignKey = @ForeignKey(name = "FK_profesor_activitate_activitate")))
    private List<Profesor> profesors;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TipActivitate getIdTipActivitate() {
        return idTipActivitate;
    }

    public void setIdTipActivitate(TipActivitate idTipActivitate) {
        this.idTipActivitate = idTipActivitate;
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

    public Integer getAn() {
        return an;
    }

    public void setIdGrupa(Grupa idGrupa) {
        this.idGrupa = idGrupa;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Profesor> getProfesors() {
        return profesors;
    }

    public void setProfesors(List<Profesor> profesors) {
        this.profesors = profesors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activitate that = (Activitate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (an != null ? !an.equals(that.an) : that.an != null) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (idTipActivitate != null ? !idTipActivitate.equals(that.idTipActivitate) : that.idTipActivitate != null)
            return false;
        if (idSerie != null ? !idSerie.equals(that.idSerie) : that.idSerie != null) return false;
        return !(idGrupa != null ? !idGrupa.equals(that.idGrupa) : that.idGrupa != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (an != null ? an.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (idTipActivitate != null ? idTipActivitate.hashCode() : 0);
        result = 31 * result + (idSerie != null ? idSerie.hashCode() : 0);
        result = 31 * result + (idGrupa != null ? idGrupa.hashCode() : 0);
        return result;
    }

    public void setAn(Integer an) {
        this.an = an;
    }
}
