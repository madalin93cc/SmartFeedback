package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Activitate;
import ro.upb.smartfeedback.entity.Comentariu;
import ro.upb.smartfeedback.entity.Profesor;
import ro.upb.smartfeedback.entity.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by colez on 29/11/2015.
 */
@Repository
public interface ActivitateRepository extends JpaRepository<Activitate, Long> {
    Activitate findById(Long id);
}
