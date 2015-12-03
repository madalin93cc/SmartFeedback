package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.utils.TipActivitateEnum;

/**
 * Created by colez on 03/12/2015.
 */
public class FeedbackMenuDTO {
    private long id;
    private TipActivitateEnum tipActivitate;
    private Integer saptamana;
    private String nume;

    public FeedbackMenuDTO() {
    }

    public FeedbackMenuDTO(long id, TipActivitateEnum tipActivitate, Integer saptamana, String nume) {
        this.id = id;
        this.tipActivitate = tipActivitate;
        this.saptamana = saptamana;
        this.nume = nume;
    }

    public FeedbackMenuDTO(Feedback feedback){
        this.id = feedback.getId();
        this.saptamana = feedback.getSaptamana();
        this.tipActivitate = TipActivitateEnum.getByActivitate(feedback.getIdActivitate());
        this.nume = feedback.getNume();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipActivitateEnum getTipActivitate() {
        return tipActivitate;
    }

    public void setTipActivitate(TipActivitateEnum tipActivitate) {
        this.tipActivitate = tipActivitate;
    }

    public Integer getSaptamana() {
        return saptamana;
    }

    public void setSaptamana(Integer saptamana) {
        this.saptamana = saptamana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackMenuDTO that = (FeedbackMenuDTO) o;

        if (id != that.id) return false;
        if (tipActivitate != that.tipActivitate) return false;
        return !(saptamana != null ? !saptamana.equals(that.saptamana) : that.saptamana != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tipActivitate != null ? tipActivitate.hashCode() : 0);
        result = 31 * result + (saptamana != null ? saptamana.hashCode() : 0);
        return result;
    }
}
