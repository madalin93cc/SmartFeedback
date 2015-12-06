package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.RaspunsIntrebare;

/**
 * Created by George on 12/6/2015.
 */

@Repository
public interface RaspunsIntrebareRepository extends JpaRepository<RaspunsIntrebare, Long> {

}
