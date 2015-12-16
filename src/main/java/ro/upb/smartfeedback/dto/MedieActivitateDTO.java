package ro.upb.smartfeedback.dto;

/**
 * Created by George on 12/16/2015.
 */
public class MedieActivitateDTO {
    private ActivitateMenuDTO materie;
    private Double medieNote;

    public MedieActivitateDTO(ActivitateMenuDTO materie, Double medieNote) {
        this.materie = materie;
        this.medieNote = medieNote;
    }

    public ActivitateMenuDTO getMaterie() {
        return materie;
    }

    public void setMaterie(ActivitateMenuDTO materie) {
        this.materie = materie;
    }

    public Double getMedieNote() {
        return medieNote;
    }

    public void setMedieNote(Double medieNote) {
        this.medieNote = medieNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedieActivitateDTO that = (MedieActivitateDTO) o;

        if (materie != null ? !materie.equals(that.materie) : that.materie != null) return false;
        return !(medieNote != null ? !medieNote.equals(that.medieNote) : that.medieNote != null);

    }

    @Override
    public int hashCode() {
        int result = materie != null ? materie.hashCode() : 0;
        result = 31 * result + (medieNote != null ? medieNote.hashCode() : 0);
        return result;
    }
}
