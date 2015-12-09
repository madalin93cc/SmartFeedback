package ro.upb.smartfeedback.dto;

import java.util.List;

/**
 * Created by colez on 09/12/2015.
 */
public class AdaugareFeedbackDetailsDTO {
    private String nume;
    private List<Integer> availableWeeks;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Integer> getAvailableWeeks() {
        return availableWeeks;
    }

    public void setAvailableWeeks(List<Integer> availableWeeks) {
        this.availableWeeks = availableWeeks;
    }

    public AdaugareFeedbackDetailsDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdaugareFeedbackDetailsDTO that = (AdaugareFeedbackDetailsDTO) o;

        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        return !(availableWeeks != null ? !availableWeeks.equals(that.availableWeeks) : that.availableWeeks != null);

    }

    @Override
    public int hashCode() {
        int result = nume != null ? nume.hashCode() : 0;
        result = 31 * result + (availableWeeks != null ? availableWeeks.hashCode() : 0);
        return result;
    }
}
