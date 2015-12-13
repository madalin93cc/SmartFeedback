package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 13/12/2015.
 */
@Entity
@Table(name = "notificare")
public class Notificare implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_notificare_user"), name = "id_user", unique = false, nullable = false, updatable = true)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_notificare_activitate"), name = "id_activitate", unique = false, nullable = false, updatable = true)
    private Activitate activitate;

    /*
    0 - cerere activare feedback
     */
    @Column(name = "tip_notificare", nullable = false)
    private Integer tipNotificare;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "saptamana", nullable = true)
    private Integer saptamana;

    public Notificare() {
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

    public Activitate getActivitate() {
        return activitate;
    }

    public void setActivitate(Activitate activitate) {
        this.activitate = activitate;
    }

    public Integer getTipNotificare() {
        return tipNotificare;
    }

    public void setTipNotificare(Integer tipNotificare) {
        this.tipNotificare = tipNotificare;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getSaptamana() {
        return saptamana;
    }

    public void setSaptamana(Integer saptamana) {
        this.saptamana = saptamana;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notificare that = (Notificare) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (activitate != null ? !activitate.equals(that.activitate) : that.activitate != null) return false;
        if (tipNotificare != null ? !tipNotificare.equals(that.tipNotificare) : that.tipNotificare != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return !(status != null ? !status.equals(that.status) : that.status != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (activitate != null ? activitate.hashCode() : 0);
        result = 31 * result + (tipNotificare != null ? tipNotificare.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (saptamana != null ? saptamana.hashCode() : 0);
        return result;
    }
}
