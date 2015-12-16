package ro.upb.smartfeedback.dto;


import java.util.List;

/**
 * Created by George on 12/16/2015.
 */
public class FeedbackPeMaterieDTO {
    private ActivitateMenuDTO materie;
    List<FeedbackPeSaptamanaDTO> feedbackPeSaptamanaDTOs;

    public FeedbackPeMaterieDTO(ActivitateMenuDTO materie, List<FeedbackPeSaptamanaDTO> feedbackPeSaptamanaDTOs) {
        this.materie = materie;
        this.feedbackPeSaptamanaDTOs = feedbackPeSaptamanaDTOs;
    }

    public ActivitateMenuDTO getMaterie() {
        return materie;
    }

    public void setMaterie(ActivitateMenuDTO materie) {
        this.materie = materie;
    }

    public List<FeedbackPeSaptamanaDTO> getFeedbackPeSaptamanaDTOs() {
        return feedbackPeSaptamanaDTOs;
    }

    public void setFeedbackPeSaptamanaDTOs(List<FeedbackPeSaptamanaDTO> feedbackPeSaptamanaDTOs) {
        this.feedbackPeSaptamanaDTOs = feedbackPeSaptamanaDTOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackPeMaterieDTO that = (FeedbackPeMaterieDTO) o;

        if (materie != null ? !materie.equals(that.materie) : that.materie != null) return false;
        return !(feedbackPeSaptamanaDTOs != null ? !feedbackPeSaptamanaDTOs.equals(that.feedbackPeSaptamanaDTOs) : that.feedbackPeSaptamanaDTOs != null);

    }

    @Override
    public int hashCode() {
        int result = materie != null ? materie.hashCode() : 0;
        result = 31 * result + (feedbackPeSaptamanaDTOs != null ? feedbackPeSaptamanaDTOs.hashCode() : 0);
        return result;
    }
}
