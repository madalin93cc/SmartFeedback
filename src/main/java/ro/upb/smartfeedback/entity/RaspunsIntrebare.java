package ro.upb.smartfeedback.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.swing.text.Utilities;

/**
 * Created by George on 12/3/2015.
 */
@Entity
@Table(name = "raspuns_intrebare")
public class RaspunsIntrebare implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tip_raspuns", nullable = false)
    private Integer tipRaspuns;

    @Column(name = "raspuns", nullable = false)
    private String raspuns;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_feedback_raspuns"),name = "id_feedback", unique = false, nullable = false, updatable = true)
    private Feedback idFeedback;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_raspuns_intrebare_utilizator"),name = "id_utilizator", unique = false, nullable = false, updatable = true)
    private User idUser;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_raspuns_intrebare_intrebari"),name = "id_intrebare", unique = false, nullable = true, updatable = true)
    private Intrebari idIntrebare;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    public Integer getTipRaspuns() {
        return tipRaspuns;
    }

    public String getRaspuns() {
        return raspuns;
    }

    public Feedback getIdFeedback() {
        return idFeedback;
    }

    public User getIdUser() {
        return idUser;
    }

    public Intrebari getIdIntrebare() {
        return idIntrebare;
    }

    public void setTipRaspuns(Integer tipRaspuns) {
        this.tipRaspuns = tipRaspuns;
    }

    public void setRaspuns(String raspuns) {
        this.raspuns = raspuns;
    }

    public void setIdFeedback(Feedback idFeedback) {
        this.idFeedback = idFeedback;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public void setIdIntrebare(Intrebari idIntrebare) {
        this.idIntrebare = idIntrebare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaspunsIntrebare that = (RaspunsIntrebare) o;

        if (!id.equals(that.id)) return false;
        if (!tipRaspuns.equals(that.tipRaspuns)) return false;
        if (raspuns != null ? !raspuns.equals(that.raspuns) : that.raspuns != null) return false;
        if (!idFeedback.equals(that.idFeedback)) return false;
        if (!idUser.equals(that.idUser)) return false;
        return !(idIntrebare != null ? !idIntrebare.equals(that.idIntrebare) : that.idIntrebare != null);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tipRaspuns.hashCode();
        result = 31 * result + (raspuns != null ? raspuns.hashCode() : 0);
        result = 31 * result + idFeedback.hashCode();
        result = 31 * result + idUser.hashCode();
        result = 31 * result + (idIntrebare != null ? idIntrebare.hashCode() : 0);
        return result;
    }
}