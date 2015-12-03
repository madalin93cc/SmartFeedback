package ro.upb.smartfeedback.utils;

import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.TipActivitate;

/**
 * Created by colez on 03/12/2015.
 */
public enum TipActivitateEnum {
    CURS(1l, "curs"), SEM(2l, "seminar"), LAB(3l, "laborator");
    private Long id;
    private String nume;

    TipActivitateEnum(Long id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public static TipActivitateEnum getByActivitate(Activitate activitate) {
        for (TipActivitateEnum t : TipActivitateEnum.values()){
            if (activitate.getIdTipActivitate().getId() == t.getId()){
                return t;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
