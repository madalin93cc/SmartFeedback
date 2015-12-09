package ro.upb.smartfeedback.dto;

/**
 * Created by George on 12/9/2015.
 */
public class MediiNoteDTO {
    private Double notaGeneralaMedie;
    private Double interactiuneMedie;
    private Double gradIntelegereMedie;
    private Double organizareMedie;
    private Double expunereMedie;
    private Integer numarFeedbackuri;

    public MediiNoteDTO(Double notaGeneralaMedie, Double interactiuneMedie, Double gradIntelegereMedie, Double organizareMedie, Double expunereMedie, Integer numarFeedbackuri) {
        this.notaGeneralaMedie = notaGeneralaMedie;
        this.interactiuneMedie = interactiuneMedie;
        this.gradIntelegereMedie = gradIntelegereMedie;
        this.organizareMedie = organizareMedie;
        this.expunereMedie = expunereMedie;
        this.numarFeedbackuri = numarFeedbackuri;
    }

    public Double getNotaGeneralaMedie() {
        return notaGeneralaMedie;
    }

    public void setNotaGeneralaMedie(Double notaGeneralaMedie) {
        this.notaGeneralaMedie = notaGeneralaMedie;
    }

    public Double getInteractiuneMedie() {
        return interactiuneMedie;
    }

    public void setInteractiuneMedie(Double interactiuneMedie) {
        this.interactiuneMedie = interactiuneMedie;
    }

    public Double getGradIntelegereMedie() {
        return gradIntelegereMedie;
    }

    public void setGradIntelegereMedie(Double gradIntelegereMedie) {
        this.gradIntelegereMedie = gradIntelegereMedie;
    }

    public Double getOrganizareMedie() {
        return organizareMedie;
    }

    public void setOrganizareMedie(Double organizareMedie) {
        this.organizareMedie = organizareMedie;
    }

    public Double getExpunereMedie() {
        return expunereMedie;
    }

    public void setExpunereMedie(Double expunereMedie) {
        this.expunereMedie = expunereMedie;
    }

    public Integer getNumarFeedbackuri() {
        return numarFeedbackuri;
    }

    public void setNumarFeedbackuri(Integer numarFeedbackuri) {
        this.numarFeedbackuri = numarFeedbackuri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediiNoteDTO that = (MediiNoteDTO) o;

        if (notaGeneralaMedie != null ? !notaGeneralaMedie.equals(that.notaGeneralaMedie) : that.notaGeneralaMedie != null)
            return false;
        if (interactiuneMedie != null ? !interactiuneMedie.equals(that.interactiuneMedie) : that.interactiuneMedie != null)
            return false;
        if (gradIntelegereMedie != null ? !gradIntelegereMedie.equals(that.gradIntelegereMedie) : that.gradIntelegereMedie != null)
            return false;
        if (organizareMedie != null ? !organizareMedie.equals(that.organizareMedie) : that.organizareMedie != null)
            return false;
        if (expunereMedie != null ? !expunereMedie.equals(that.expunereMedie) : that.expunereMedie != null)
            return false;
        return !(numarFeedbackuri != null ? !numarFeedbackuri.equals(that.numarFeedbackuri) : that.numarFeedbackuri != null);

    }

    @Override
    public int hashCode() {
        int result = notaGeneralaMedie != null ? notaGeneralaMedie.hashCode() : 0;
        result = 31 * result + (interactiuneMedie != null ? interactiuneMedie.hashCode() : 0);
        result = 31 * result + (gradIntelegereMedie != null ? gradIntelegereMedie.hashCode() : 0);
        result = 31 * result + (organizareMedie != null ? organizareMedie.hashCode() : 0);
        result = 31 * result + (expunereMedie != null ? expunereMedie.hashCode() : 0);
        result = 31 * result + (numarFeedbackuri != null ? numarFeedbackuri.hashCode() : 0);
        return result;
    }
}
