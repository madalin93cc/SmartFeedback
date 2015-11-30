/**
 * Created by VladC on 29-Nov-15.
 */
package ro.upb.smartfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.upb.smartfeedback.entity.TipActivitate;
import java.util.List;

@Repository
public interface TipActivitateRepository extends JpaRepository<TipActivitate, Long> {
    public TipActivitate getByNume(String nume);
}
