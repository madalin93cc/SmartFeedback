package ro.upb.smartfeedback.utils;

/**
 * Created by colez on 07/12/2015.
 */
public enum TipIntrebareEnum {
    NOTA_GENERALA(1l, "Nota generala"),
    INTERACTIUNE(2l, "Interactiunea cu studentii"),
    GRAD_INTELEGERE(3l, "Gradul de intelegere"),
    ORGANIZARE(4l, "Organizare"),
    EXPUNERE(5l, "Expunere");

    private final Long id;
    private final String intrebare;

    TipIntrebareEnum(Long id, String intrebare) {
        this.id = id;
        this.intrebare = intrebare;
    }

    public Long getId() {
        return id;
    }

    public String getIntrebare() {
        return intrebare;
    }
}
