package ro.upb.smartfeedback.entity;

/**
 * Created by VladC on 29-Nov-15.
 */

import javax.persistence.*;
import java.util.Date;

public class Mesaj implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_mesaj"),name = "idParinte", unique = false, nullable = false, updatable = true)
    private Mesaj idParinte;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_utilizator"),name = "idUserSend", unique = false, nullable = false, updatable = true)
    private User idUserSend;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_utilizator_2"),name = "idUserRecv", unique = false, nullable = false, updatable = true)
    private Comentariu idUserRecv;

    @Column(name = "seen", nullable = false)
    private Integer seen;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

    @Column(name = "text", nullable = false)
    private String text;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Mesaj getIdParinte() {
        return idParinte;
    }

    public void setIdParinte(Mesaj idParinte) {
        this.idParinte = idParinte;
    }

    public User getIdUserSend() {
        return idUserSend;
    }

    public void setIdUserSend(User idUserSend) {
        this.idUserSend = idUserSend;
    }

    public Comentariu getIdUserRecv() {
        return idUserRecv;
    }

    public void setIdUserRecv(Comentariu idUserRecv) {
        this.idUserRecv = idUserRecv;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer seen) {
        this.seen = seen;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesaj mesaj = (Mesaj) o;

        if (createdAt != null ? !createdAt.equals(mesaj.createdAt) : mesaj.createdAt != null) return false;
        if (id != null ? !id.equals(mesaj.id) : mesaj.id != null) return false;
        if (idParinte != null ? !idParinte.equals(mesaj.idParinte) : mesaj.idParinte != null) return false;
        if (idUserRecv != null ? !idUserRecv.equals(mesaj.idUserRecv) : mesaj.idUserRecv != null) return false;
        if (idUserSend != null ? !idUserSend.equals(mesaj.idUserSend) : mesaj.idUserSend != null) return false;
        if (seen != null ? !seen.equals(mesaj.seen) : mesaj.seen != null) return false;
        if (text != null ? !text.equals(mesaj.text) : mesaj.text != null) return false;
        if (updatedAt != null ? !updatedAt.equals(mesaj.updatedAt) : mesaj.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idParinte != null ? idParinte.hashCode() : 0);
        result = 31 * result + (idUserSend != null ? idUserSend.hashCode() : 0);
        result = 31 * result + (idUserRecv != null ? idUserRecv.hashCode() : 0);
        result = 31 * result + (seen != null ? seen.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
