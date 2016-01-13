package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Notificare;
import ro.upb.smartfeedback.entity.User;

import java.util.List;

/**
 * Created by colez on 13/12/2015.
 */
@Repository
public interface NotificareRepository extends JpaRepository<Notificare, Long> {
    List<Notificare> findByUserAndStatus(User user, Boolean status);
    Notificare getById(Long id);
    List<Notificare> findByActivitateAndSaptamana(Activitate a, Integer saptamana);
}
