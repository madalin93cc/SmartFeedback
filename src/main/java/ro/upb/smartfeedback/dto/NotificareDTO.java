package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.Notificare;

/**
 * Created by colez on 13/12/2015.
 */
public class NotificareDTO {
    private Long id;
    private String message;
    private String url;
    private Boolean status;
    private Integer saptamana;

    public NotificareDTO(Notificare notificare){
        this.id = notificare.getId();
        this.message = notificare.getMessage();
        this.url = notificare.getUrl();
        this.status = notificare.getStatus();
        this.saptamana = notificare.getSaptamana();
    }

    public NotificareDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        NotificareDTO that = (NotificareDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return !(saptamana != null ? !saptamana.equals(that.saptamana) : that.saptamana != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (saptamana != null ? saptamana.hashCode() : 0);
        return result;
    }
}
