/**
 * Created by VladC on 29-Nov-15.
 */
package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Profesor;
import ro.upb.smartfeedback.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsernameAndPassword(String username, String password);
    User findById(Long id);
    User findByIdProfesor(Profesor profesor);
}