package ro.upb.smartfeedback.dto;

/**
 * Created by Madalin.Colezea on 12/16/2015.
 */
public class SendMessageDTO {
    private Long userId;
    private String message;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendMessageDTO)) return false;

        SendMessageDTO that = (SendMessageDTO) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return !(message != null ? !message.equals(that.message) : that.message != null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
