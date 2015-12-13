package ro.upb.smartfeedback.utils;

/**
 * Created by colez on 13/12/2015.
 */
public enum TipNotificareEnum {
    CERERE_ACTIVARE_FEEDBACK(1, "Cerere activare feedback", "/add_feedback/"),
    STATISTICI_DISPONIBILE(2, "Statistici disponibile", ""),
    COMENTARIU_NOU(3, "Comentariu nou", "/completare_feedback/");

    private Integer id;
    private String message;
    private String baseUrl;

    TipNotificareEnum(Integer id, String message, String baseUrl) {
        this.id = id;
        this.message = message;
        this.baseUrl = baseUrl;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
