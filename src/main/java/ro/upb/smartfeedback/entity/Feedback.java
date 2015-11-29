package ro.upb.smartfeedback.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nume", length = 50, nullable = false, unique = true)
    private String nume;

    @Column(name = "status", nullable = false, length = 11)
    private Integer status;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_feedback_activitate"), name = "id_activitate", unique = true, nullable = false, updatable = true)
    private Activitate idActivitate;

    @Column(name = "from_date", nullable = true)
    private Date fromDate;

    @Column(name = "to_date", nullable = true)
    private Date toDate;

    @ManyToMany
    @JoinTable(name = "feedback_intrebari",
            joinColumns = @JoinColumn(name = "id_feedback", foreignKey = @ForeignKey(name = "FK__feedback")),
            inverseJoinColumns = @JoinColumn(name = "id_intrebare", foreignKey = @ForeignKey(name = "FK_feedback_intrebari_intrebari")))
    private List<Intrebari> intrebari;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Activitate getIdActivitate() {
        return idActivitate;
    }

    public void setIdActivitate(Activitate idActivitate) {
        this.idActivitate = idActivitate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<Intrebari> getIntrebari() {
        return intrebari;
    }

    public void setIntrebari(List<Intrebari> intrebari) {
        this.intrebari = intrebari;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feedback feedback = (Feedback) o;

        if (id != null ? !id.equals(feedback.id) : feedback.id != null) return false;
        if (nume != null ? !nume.equals(feedback.nume) : feedback.nume != null) return false;
        if (status != null ? !status.equals(feedback.status) : feedback.status != null) return false;
        if (idActivitate != null ? !idActivitate.equals(feedback.idActivitate) : feedback.idActivitate != null)
            return false;
        if (fromDate != null ? !fromDate.equals(feedback.fromDate) : feedback.fromDate != null) return false;
        if (toDate != null ? !toDate.equals(feedback.toDate) : feedback.toDate != null) return false;
        return !(intrebari != null ? !intrebari.equals(feedback.intrebari) : feedback.intrebari != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (idActivitate != null ? idActivitate.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        result = 31 * result + (intrebari != null ? intrebari.hashCode() : 0);
        return result;
    }
}
