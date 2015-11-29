package ro.upb.smartfeedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.upb.smartfeedback.entity.User;

@SpringBootApplication
public class SmartFeedback {
    public static User loggedUser;
    public static void main(String[] args) {
        SpringApplication.run(SmartFeedback.class, args);
    }
}
