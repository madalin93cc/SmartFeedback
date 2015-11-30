package ro.upb.smartfeedback.dto;

import ro.upb.smartfeedback.entity.Activitate;

/**
 * Created by colez on 30/11/2015.
 */
public class ActivitateMenuDTO {
    private Long id;
    private Integer an;
    private String nume;
    private String code;

    public ActivitateMenuDTO() {
    }

    public ActivitateMenuDTO(Long id, Integer an, String nume, String code) {
        this.id = id;
        this.an = an;
        this.nume = nume;
        this.code = code;
    }

    public ActivitateMenuDTO(Activitate a){
        this(a.getId(), a.getAn(), a.getNume(), a.getCode());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivitateMenuDTO that = (ActivitateMenuDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (an != null ? !an.equals(that.an) : that.an != null) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        return !(code != null ? !code.equals(that.code) : that.code != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (an != null ? an.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
