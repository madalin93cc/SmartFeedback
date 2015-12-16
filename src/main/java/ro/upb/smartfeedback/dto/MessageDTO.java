package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.Mesaj;

import java.util.Date;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
public class MessageDTO {
    private Long id;
    private String text;
    private String user;
    private Boolean seen;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public MessageDTO() {
    }

    public MessageDTO(Mesaj m){
        this.id = m.getId();
        this.seen = m.getSeen();
        this.createdAt = m.getCreatedAt();
        this.text = m.getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageDTO)) return false;

        MessageDTO that = (MessageDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (seen != null ? !seen.equals(that.seen) : that.seen != null) return false;
        return !(createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (seen != null ? seen.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
