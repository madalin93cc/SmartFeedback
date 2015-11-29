package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.Serie;

/**
 * Created by colez on 29/11/2015.
 */
@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer>{
}
