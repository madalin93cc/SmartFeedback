package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Mesaj;
import ro.upb.smartfeedback.entity.User;

import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@Repository
public interface MesajRepository extends JpaRepository<Mesaj, Long>{
    Mesaj findById(Long id);

    List<Mesaj> findByIdUserRecv(User userRecv);

    List<Mesaj> findByIdUserSend(User userSend);
}
