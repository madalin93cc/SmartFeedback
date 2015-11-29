package ro.upb.smartfeedback.entity;

/**
 * Created by VladC on 29-Nov-15.
 */

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class Mesaj implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_mesaj"),name = "id_parinte", unique = false, nullable = false, updatable = true)
    private Mesaj id_parinte;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_utilizator"),name = "id_user_send", unique = false, nullable = false, updatable = true)
    private User id_user_send;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_mesaj_utilizator_2"),name = "id_user_recv", unique = false, nullable = false, updatable = true)
    private Comentariu id_user_recv;

    @Column(name = "seen", nullable = false)
    private Integer seen;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

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

    public Mesaj getId_parinte() {
        return id_parinte;
    }

    public void setId_parinte(Mesaj id_parinte) {
        this.id_parinte = id_parinte;
    }

    public User getId_user_send() {
        return id_user_send;
    }

    public void setId_user_send(User id_user_send) {
        this.id_user_send = id_user_send;
    }

    public Comentariu getId_user_recv() {
        return id_user_recv;
    }

    public void setId_user_recv(Comentariu id_user_recv) {
        this.id_user_recv = id_user_recv;
    }

    public Integer getSeen() {
        return seen;
    }

    public void setSeen(Integer seen) {
        this.seen = seen;
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

        if (created_at != null ? !created_at.equals(mesaj.created_at) : mesaj.created_at != null) return false;
        if (id != null ? !id.equals(mesaj.id) : mesaj.id != null) return false;
        if (id_parinte != null ? !id_parinte.equals(mesaj.id_parinte) : mesaj.id_parinte != null) return false;
        if (id_user_recv != null ? !id_user_recv.equals(mesaj.id_user_recv) : mesaj.id_user_recv != null) return false;
        if (id_user_send != null ? !id_user_send.equals(mesaj.id_user_send) : mesaj.id_user_send != null) return false;
        if (seen != null ? !seen.equals(mesaj.seen) : mesaj.seen != null) return false;
        if (text != null ? !text.equals(mesaj.text) : mesaj.text != null) return false;
        if (updated_at != null ? !updated_at.equals(mesaj.updated_at) : mesaj.updated_at != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (id_parinte != null ? id_parinte.hashCode() : 0);
        result = 31 * result + (id_user_send != null ? id_user_send.hashCode() : 0);
        result = 31 * result + (id_user_recv != null ? id_user_recv.hashCode() : 0);
        result = 31 * result + (seen != null ? seen.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
