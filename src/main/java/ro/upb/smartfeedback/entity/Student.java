package ro.upb.smartfeedback.entity;

import javax.persistence.*;

/**
 * Created by colez on 23/11/2015.
 */
@Entity
@Table(name = "STUDENT")
public class Student {
    @Column(name = "an_studiu", nullable = true)
    private Integer anStudiu;

    @ManyToOne
    @JoinColumn(name = "specializare_id", unique = false, nullable = false, updatable = true)
    private Specializare fkspecializare;
}
