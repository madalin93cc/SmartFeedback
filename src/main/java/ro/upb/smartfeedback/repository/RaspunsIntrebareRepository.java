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
    List<RaspunsIntrebare> getAllByIdUserAndIdFeedback(User user, Feedback feedback);
    RaspunsIntrebare findById(Long id);
}
