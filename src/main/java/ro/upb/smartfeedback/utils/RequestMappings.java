package ro.upb.smartfeedback.utils;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 * Interfata in care se vor tine toate request mapping-urile
 */
public interface RequestMappings {

    public static final String GET_GEEDBACK = "/getFeedback/{userId}/{feedbackId}";
    public static final String SAVE_FEEDBACK = "/saveFeedback";
    public static final String GET_DETALII_FEEDBACK_BY_ID = "/getFeedbackDetailById/{id}";
    public static final String GET_MATERII_UTILIZATOR = "/getMateriiUtilizator";
    public static final String GET_LOGIN_PARAMS = "/login/username/{username}/password/{password}";
    public static final String LOGOUT = "/logout";
    public static final String GET_COMMENTS_FOR_FEEDBACK = "/getCommentsForFeedback/{feedbackId}";
}
