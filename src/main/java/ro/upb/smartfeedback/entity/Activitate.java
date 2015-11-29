//package ro.upb.smartfeedback.entity;
//
//import javax.persistence.*;
//
///**
// * Created by George on 11/23/2015.
// */
//@Entity
//@Table(name = "activitate")
//public class Activitate implements BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "nume", length = 50, nullable = false)
//    private String nume;
//
//    @Column(name = "code", length = 50, nullable = false)
//    private String code;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "id_specializare", unique = false, nullable = false, updatable = true)
//    private Serie idSerie;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "id_profesor", unique = false, nullable = false, updatable = true)
//    private Profesor idProfesor;
//
//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
//}
