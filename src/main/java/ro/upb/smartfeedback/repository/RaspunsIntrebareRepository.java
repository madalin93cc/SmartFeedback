package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Feedback;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;
import ro.upb.smartfeedback.entity.User;

import java.util.List;

/**
 * Created by George on 12/6/2015.
 */

@Repository
public interface RaspunsIntrebareRepository extends JpaRepository<RaspunsIntrebare, Long> {

    @Query("select f from RaspunsIntrebare f where f.idUser.id = :user and f.idIntrebare.id = :intrebare and f.idFeedback.id = :feedback")
    List<RaspunsIntrebare> getRaspunsForSpecificUserFeedbackIntrebare(@Param("user") Long user, @Param("intrebare") Long intrebare, @Param("feedback") Long feedback);
}
