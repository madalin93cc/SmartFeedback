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

    @Query("select f from RaspunsIntrebare f where f.idFeedback.id = :feedbackId and f.tipRaspuns = 1 order by f.createdAt asc")
    List<RaspunsIntrebare> getComentariiByFeedbackId(@Param("feedbackId") Long feedbackId);

    @Query("select avg(f.raspuns) from RaspunsIntrebare f where f.idFeedback.id = :feedbackId and f.tipRaspuns = 2 and f.idIntrebare.id = :tipIntrebareId")
    Double getMedieNotaByFeedbackIdAndIntrebare(@Param("feedbackId") Long feedbackId, @Param("tipIntrebareId") Long tipIntrebareId);

    @Query("select count(f) from RaspunsIntrebare f where f.idFeedback.id = :feedbackId and f.tipRaspuns = 2 and f.idIntrebare.id = :tipIntrebareId")
    Integer getNumarFeedbackuri(@Param("feedbackId") Long feedbackId, @Param("tipIntrebareId") Long tipIntrebareId);
}

