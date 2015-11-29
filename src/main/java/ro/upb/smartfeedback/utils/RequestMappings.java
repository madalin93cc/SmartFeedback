package ro.upb.smartfeedback.utils;

/**
 * Created by Madalin.Colezea on 7/2/2015.
 * Interfata in care se vor tine toate request mapping-urile
 */
public interface RequestMappings {

//    public static final String EXAMPLE_MAPPING = "/get/example/{firstName}";
//    public static final String ADD_PERSON = "/add/person";
    public static final String GET_MATERII_UTILIZATOR = "/getMateriiUtilizator";
    public static final String GET_LOGIN_PARAMS = "/login/username/{username}/password/{password}";
    public static final String LOGOUT = "/logout";
}
