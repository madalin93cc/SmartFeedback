package ro.upb.smartfeedback.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by VladC on 29-Nov-15.
 */
@Entity
@Table(name = "comentariu")
public class Comentariu implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_comentariu_comentariu"),name = "id_parinte", unique = false, nullable = true, updatable = true)
    private Comentariu id_parinte;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_comentariu_utilizator"),name = "id_utilizator", unique = false, nullable = false, updatable = true)
    private User id_utilizator;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Comentariu getId_parinte() {
        return id_parinte;
    }

    public void setId_parinte(Comentariu id_parinte) {
        this.id_parinte = id_parinte;
    }

    public User getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(User id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comentariu that = (Comentariu) o;

        if (created_at != null ? !created_at.equals(that.created_at) : that.created_at != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (id_parinte != null ? !id_parinte.equals(that.id_parinte) : that.id_parinte != null) return false;
        if (id_utilizator != null ? !id_utilizator.equals(that.id_utilizator) : that.id_utilizator != null)
            return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (updated_at != null ? !updated_at.equals(that.updated_at) : that.updated_at != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        result = 31 * result + (id_parinte != null ? id_parinte.hashCode() : 0);
        result = 31 * result + (id_utilizator != null ? id_utilizator.hashCode() : 0);
        return result;
    }
}
