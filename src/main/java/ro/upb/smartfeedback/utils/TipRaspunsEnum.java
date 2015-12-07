package ro.upb.smartfeedback.utils;

/**
 * Created by colez on 07/12/2015.
 */
public enum TipRaspunsEnum {
    OBSERVATIE(1), INTREBARE(2);

    private Integer id;

    TipRaspunsEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
