package ro.upb.smartfeedback.entity;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_comentariu_comentariu"),name = "idParinte", unique = false, nullable = true, updatable = true)
    private Comentariu idParinte;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_comentariu_utilizator"),name = "idUtilizator", unique = false, nullable = false, updatable = true)
    private User idUtilizator;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Comentariu getIdParinte() {
        return idParinte;
    }

    public void setIdParinte(Comentariu idParinte) {
        this.idParinte = idParinte;
    }

    public User getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(User idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comentariu that = (Comentariu) o;

        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idParinte != null ? !idParinte.equals(that.idParinte) : that.idParinte != null) return false;
        if (idUtilizator != null ? !idUtilizator.equals(that.idUtilizator) : that.idUtilizator != null)
            return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (idParinte != null ? idParinte.hashCode() : 0);
        result = 31 * result + (idUtilizator != null ? idUtilizator.hashCode() : 0);
        return result;
    }
}
