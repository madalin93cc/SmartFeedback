package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.Activitate;

import java.util.List;

/**
 * Created by George on 12/16/2015.
 */
public class FeedbackPeSaptamanaDTO {
    private Integer saptamana;
    private ActivitateMenuDTO materie;
    private Integer feedbacks;

    public FeedbackPeSaptamanaDTO(Integer saptamana, ActivitateMenuDTO materie, Integer feedbacks) {
        this.saptamana = saptamana;
        this.materie = materie;
        this.feedbacks = feedbacks;
    }

    public Integer getSaptamana() {
        return saptamana;
    }

    public void setSaptamana(Integer saptamana) {
        this.saptamana = saptamana;
    }

    public ActivitateMenuDTO getMaterie() {
        return materie;
    }

    public void setMaterie(ActivitateMenuDTO materie) {
        this.materie = materie;
    }

    public Integer getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Integer feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackPeSaptamanaDTO that = (FeedbackPeSaptamanaDTO) o;

        if (saptamana != null ? !saptamana.equals(that.saptamana) : that.saptamana != null) return false;
        if (materie != null ? !materie.equals(that.materie) : that.materie != null) return false;
        return !(feedbacks != null ? !feedbacks.equals(that.feedbacks) : that.feedbacks != null);

    }

    @Override
    public int hashCode() {
        int result = saptamana != null ? saptamana.hashCode() : 0;
        result = 31 * result + (materie != null ? materie.hashCode() : 0);
        result = 31 * result + (feedbacks != null ? feedbacks.hashCode() : 0);
        return result;
    }
}
