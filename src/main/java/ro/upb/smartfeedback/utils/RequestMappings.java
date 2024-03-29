package ro.upb.smartfeedback.utils;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 * Interfata in care se vor tine toate request mapping-urile
 */
public interface RequestMappings {
    public static final String GET_ADAUGARE_FEEDBACK_DETAILS = "/getAdaugareFeedbackDetails/{idActivitate}";
    public static final String GET_FEEDBACK = "/getFeedback/{userId}/{feedbackId}";
    public static final String SAVE_FEEDBACK = "/saveFeedback/{userId}";
    public static final String GET_DETALII_FEEDBACK_BY_ID = "/getFeedbackDetailById/{id}";
    public static final String GET_MATERII_UTILIZATOR = "/getMateriiUtilizator/{userId}";
    public static final String GET_LOGIN_PARAMS = "/login/username/{username}/password/{password}";
    public static final String LOGOUT = "/logout";
    public static final String GET_COMMENTS_FOR_FEEDBACK = "/getCommentsForFeedback/{feedbackId}";
    public static final String GET_STATISTICS = "/getStatistics/{feedbackId}";
    public static final String ADD_FEEDBACK = "/addFeedback/{idActivitate}/{saptamana}";
    public static final String REQUEST_FEEDBACK = "/requestFeedback/{idActivitate}/{saptamana}";
    public static final String GET_MAIN_PAGE_OVERVIEW = "/getOverview";
    public static final String GET_ACTIVE_NOTIFICATIONS = "/getActiveNotifications/{userId}";
    public static final String SET_NOTIFICATION_STATUS = "/setNotificationStatus/{notifId}";
    public static final String GET_USERS_FOR_MESSAGES = "/getUsersFormMessages/{userId}";
    public static final String GET_INBOX = "/getInbox/{userId}";
    public static final String GET_OUTBOX = "/getOutbox/{userId}";
    public static final String SEND_MESSAGE = "/sendMessage/{userId}";
    public static final String GET_NO_FEEDBACKS_PER_PROFESOR = "/getNoFeedbacks/{userId}";
    public static final String GET_MEDII_ACTIVITATI = "/getMediiActivitati/{userId}";
    public static final String CHANGE_SEEN = "/changeSeen/{messageId}/{change}";
}
