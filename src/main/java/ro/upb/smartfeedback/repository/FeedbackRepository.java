package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Feedback;

import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("select f from Feedback f where f.idActivitate.id = :activitateId")
    List<Feedback> getAllFeedbackForActivity(@Param("activitateId") Long activitateId);

}
