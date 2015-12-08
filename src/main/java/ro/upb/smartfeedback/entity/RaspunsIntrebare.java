package ro.upb.smartfeedback.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.swing.text.Utilities;
import java.util.Date;

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

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_feedback_raspuns"),name = "id_feedback", unique = false, nullable = false, updatable = true)
    private Feedback idFeedback;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_raspuns_intrebare_utilizator"),name = "id_utilizator", unique = false, nullable = false, updatable = true)
    private User idUser;

    @ManyToOne(optional = false)
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipRaspuns != null ? !tipRaspuns.equals(that.tipRaspuns) : that.tipRaspuns != null) return false;
        if (raspuns != null ? !raspuns.equals(that.raspuns) : that.raspuns != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (idFeedback != null ? !idFeedback.equals(that.idFeedback) : that.idFeedback != null) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        return !(idIntrebare != null ? !idIntrebare.equals(that.idIntrebare) : that.idIntrebare != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipRaspuns != null ? tipRaspuns.hashCode() : 0);
        result = 31 * result + (raspuns != null ? raspuns.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (idFeedback != null ? idFeedback.hashCode() : 0);
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (idIntrebare != null ? idIntrebare.hashCode() : 0);
        return result;
    }
}